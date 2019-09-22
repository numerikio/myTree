package my.com;

import my.com.math_operation.Action;

public class Node {
    private Node parent;
    private Node left;
    private Node right;
    private double value;
    private Action action;



    private int anInt; // test only

    public Node() {
    }

    public void printNode() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "Node{" +
                "parent=" + resultNull(parent) +
                ", left=" + resultNull(left) +
                ", right=" + resultNull(right) +
                ", value=" + value +
                ", action=" + resultNullS(action.getClass().getSimpleName()) +
                ", number=" + anInt +
                '}';
    }

    private String resultNull(Node node) {
        if (node != null) {
            return String.valueOf(node.getAnInt());
        }
        return "NULL";
    }

    private String resultNullS(String data) {
        if (data != null) {
            return data;
        }
        return "NULL";
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }
    public int getAnInt() {
        return anInt;
    }

    public void setAnInt(int anInt) {
        this.anInt = anInt;
    }
}
