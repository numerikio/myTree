package my.com.math_operation;

import my.com.Node;

public class MulAction extends Action {
    public MulAction(Node node) {
        super(node);
        setMathPriority(MathPriority.MUL_AND_DIV.getMathPriority());
    }

    @Override
    public double getResult() {
        return getNode().getLeft().getAction().getResult() * getNode().getRight().getAction().getResult();
    }
}
