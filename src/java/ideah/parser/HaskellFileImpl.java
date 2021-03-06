package ideah.parser;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElementVisitor;
import ideah.HaskellFileType;
import org.jetbrains.annotations.NotNull;

public final class HaskellFileImpl extends PsiFileBase implements HaskellFile {

    public HaskellFileImpl(@NotNull FileViewProvider provider) {
        super(provider, HaskellFileType.HASKELL_LANGUAGE);
    }

    @NotNull
    public FileType getFileType() {
        return HaskellFileType.INSTANCE;
    }

    public void accept(@NotNull PsiElementVisitor visitor) {
        visitor.visitFile(this); // todo
    }
}
