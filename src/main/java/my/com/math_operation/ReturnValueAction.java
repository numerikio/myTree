package my.com.math_operation;

import my.com.Node;

public class ReturnValueAction extends Action {
    public ReturnValueAction(Node node) {
        super(node);
    }

    @Override
    public double getResult() {
        return getNode().getValue();
    }
}
