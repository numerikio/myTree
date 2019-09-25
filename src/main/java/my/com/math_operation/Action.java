package my.com.math_operation;

import my.com.Node;

public abstract class Action {

    private Node node;
    private int mathPriority = 0;

    public Action(Node node) {
        this.node = node;
    }

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }

    public int getMathPriority() {
        return mathPriority;
    }

    public void setMathPriority(int mathPriority) {
        this.mathPriority = mathPriority;
    }

    public abstract double getResult();

}
