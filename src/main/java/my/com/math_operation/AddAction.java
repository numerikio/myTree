package my.com.math_operation;

import my.com.Node;

public class AddAction extends Action {
    public AddAction(Node node) {
        super(node);
        setMathPriority(MathPriority.ADD_AND_SUB.getMathPriority());
    }

    @Override
    public double getResult() {
        return getNode().getLeft().getAction().getResult() + getNode().getRight().getAction().getResult();
    }
}
