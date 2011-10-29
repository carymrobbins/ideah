package ideah.tree.expr;

import com.google.common.collect.Iterables;
import ideah.tree.IRange;
import ideah.tree.LocalBinds;
import ideah.tree.Located;

import java.util.Arrays;

public final class LetExpr extends Expression {

    public final LocalBinds localBinds;
    public final Expression expression;

    public LetExpr(IRange location, LocalBinds localBinds, Expression expression) {
        super(location);
        this.localBinds = localBinds;
        this.expression = expression;
    }

    protected Iterable<Located> getChildren() {
        return Iterables.concat(localBinds.getChildren(), Arrays.asList(expression));
    }
}
