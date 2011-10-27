package ideah.formatter;

import com.intellij.formatting.Block;
import com.intellij.formatting.FormattingModel;
import com.intellij.formatting.FormattingModelBuilder;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.util.TextRange;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.intellij.psi.formatter.DocumentBasedFormattingModel;
import com.intellij.psi.tree.IElementType;
import ideah.lexer.HaskellLexer;
import ideah.lexer.HaskellTokenTypes;
import ideah.tree.Located;
import ideah.tree.ModuleTree;
import ideah.tree.NoMatchException;
import ideah.tree.TreeParser;
import ideah.util.*;
import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

public final class HaskellFormattingModelBuilder implements FormattingModelBuilder {

    private static final Logger LOG = Logger.getInstance("ideah.formatter.HaskellFormattingModelBuilder");

    @NotNull
    public FormattingModel createModel(PsiElement element, CodeStyleSettings settings) {
        Block root = null;
        try {
            root = doCreateModel(element);
        } catch (Exception ex) {
            LOG.error(ex);
        }
        PsiFile file = element.getContainingFile();
        if (root == null) {
            root = new FakeBlock(file.getTextRange());
        }
        return new DocumentBasedFormattingModel(root, file.getProject(), settings, file.getFileType(), file);
    }

    private static Block doCreateModel(PsiElement element) throws IOException, InterruptedException, NoMatchException {
        PsiFile file = element.getContainingFile();
        VirtualFile virtualFile = file.getVirtualFile();
        if (virtualFile == null)
            return null;
        Module module = DeclarationPosition.getModule(file);
        CompilerLocation compiler = CompilerLocation.get(module);
        if (compiler == null)
            return null;
        ProcessLauncher launcher = new ProcessLauncher(
            false, virtualFile.getInputStream(),
            compiler.exe,
            "-m", "ParseTree",
            "-g", compiler.libPath,
            virtualFile.getPath()
        );
        String stdOut = launcher.getStdOut();
        if (stdOut.trim().isEmpty())
            return null;
        TreeParser parser = new TreeParser(new BufferedReader(new StringReader(stdOut)));
        ModuleTree moduleTree = parser.readTree(LineColRange.fromTextRange(file, file.getTextRange()));

        SortedMap<LineCol, LineColRange> ranges = new TreeMap<LineCol, LineColRange>();
        String text = file.getText();
        HaskellLexer lexer = new HaskellLexer();
        lexer.start(text);
        while (true) {
            IElementType type = lexer.getTokenType();
            if (type == null)
                break;
            if (!HaskellTokenTypes.WHITESPACES.contains(type)) {
                TextRange textRange = new TextRange(lexer.getTokenStart(), lexer.getTokenEnd());
                LineColRange range = LineColRange.fromTextRange(file, textRange);
                ranges.put(range.start, range);
            }
            lexer.advance();
        }
        moduleTree.fillGaps(ranges);

        return toBlock(file, moduleTree);
    }

    private static HaskellBlock toBlock(PsiFile file, Located located) {
        List<Located> children = located.getBlocks();
        List<Block> subBlocks = new ArrayList<Block>();
        for (Located child : children) {
            subBlocks.add(toBlock(file, child));
        }
        return new HaskellBlock(located.location.getRange(file), subBlocks);
    }

    public TextRange getRangeAffectingIndent(PsiFile file, int offset, ASTNode elementAtOffset) {
        return null;
    }
}
