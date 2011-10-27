package ideah.tree;

import com.intellij.psi.tree.IElementType;
import ideah.util.IRange;

import java.util.Collections;

public final class Filler extends Located {

    public final IElementType type;
    public final String text;

    public Filler(IRange location, IElementType type, String text) {
        super(location);
        this.type = type;
        this.text = text;
    }

    protected Iterable<? extends Located> getChildren() {
        return Collections.emptyList();
    }
}
