package my.com;

import my.com.math_operation.*;

import java.util.List;

public class MathTree {

    Node root;
    Node target;
    Node tempNode;
    int anInt = 0;


    public void insert(String data) {
        if (root == null) {
            root = getNewNode();
            target = root;
        }
        if (data.equals("(")) {
            if (target.getAction() != null) {
                getChild();
            }
            getChild();
        } else if (isNum(data) && target.getAction() == null) {
            setDataAndGoParent(data);
        } else if (isNum(data) && target.getAction() != null) {
            createChildAndGoToParent(data);
        } else if (data.equals("+") || data.equals("-") || data.equals("*") || data.equals("/")) {
            setData(data);
        } else if (data.equals(")")) {
            goToParent();
        }

    }


    private void upGreat() {
        Node nodeLastR = target.getRight();
        tempNode = getNewNode();
        tempNode.setParent(nodeLastR);
        tempNode.setAction(nodeLastR.getAction());
        tempNode.setValue(nodeLastR.getValue());
        nodeLastR.setLeft(tempNode);
        target = nodeLastR;

    }

    private void getChild() {
        tempNode = getNewNode();
        if (target.getLeft() == null) {
            tempNode.setParent(target);
            target.setLeft(tempNode);
            target = tempNode;
        } else if ((target.getRight() == null)) {
            tempNode.setParent(target);
            target.setRight(tempNode);
            target = tempNode;
        } else {
            System.out.println("R and L not null");
        }
    }

    private void getNewRoot() {
        tempNode = getNewNode();
        target.setParent(tempNode);
        tempNode.setLeft(target);
        root = tempNode;
        goToParent();
    }

    private void createParentOrChild(int targetActionPriority, String data) {
        int newActionPriority = 0;
        switch (data) {
            case "+":
            case "-":
                newActionPriority = MathPriority.ADD_AND_SUB.getMathPriority();
                break;
            case "*":
            case "/":
                newActionPriority = MathPriority.MUL_AND_DIV.getMathPriority();
                break;
        }


        if (targetActionPriority == MathPriority.ADD_AND_SUB.getMathPriority()) {
            if (newActionPriority == MathPriority.ADD_AND_SUB.getMathPriority()) {
                getNewRoot();
            } else if (newActionPriority == MathPriority.MUL_AND_DIV.getMathPriority()) {
                upGreat();
            } else System.out.println("error 88.1");

        } else if (targetActionPriority == MathPriority.MUL_AND_DIV.getMathPriority()) {
            if (target.getParent() != null) {
                if (target.getParent().getAction() != null) {
                    if (target.getParent().getAction().getMathPriority() == MathPriority.ADD_AND_SUB.getMathPriority()) {
                        goToParent();
                    }
                }
            }
            getNewRoot();
        } else {
            System.out.println("error 88");

        }


    }


    private Node getNewNode() {
        Node node = new Node();
        node.setAnInt(anInt++);
        return node;
    }

    private void setDataAndGoParent(String data) {
        setData(data);
        goToParent();

    }

    private void setData(String data) {

        if (isNum(data)) {
            target.setValue(Double.valueOf(data));
            setTargetAction(new ReturnValueAction(target));
            return;
        }
        if (target.getAction() == null) {
            switchAction(data);
        } else {
            int targetActionPriority = target.getAction().getMathPriority();
            createParentOrChild(targetActionPriority, data);
            switchAction(data);
        }

    }

    private void switchAction(String data) {
        switch (data) {
            case "+":
                setTargetAction(new AddAction(target));
                break;
            case "-":
                setTargetAction(new SubAction(target));
                break;
            case "*":
                setTargetAction(new MulAction(target));
                break;
            case "/":
                setTargetAction(new DivAction(target));
                break;
            default:
                try {
                    throw new Exception("unknown action..");
                } catch (Exception e) {
                    e.printStackTrace();
                }
        }
    }

    private void setTargetAction(Action action) {
        target.setAction(action);
    }

    private void createChildAndGoToParent(String data) {
        getChild();
        setData(data);
        goToParent();
    }

    private void goToParent() {
        if (target.getParent() != null) {
            target = target.getParent();
        }
    }

    public void addListStrings(List<String> strings) {
        for (String s : strings) {
            insert(s);
        }
    }


    private boolean isNum(String data) {
        try {
            Integer.parseInt(data);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void printAllTree() {
        System.out.println(root.getAnInt());
        System.out.println(root.getAction());
        print(root);
        System.out.println(root.getAction().getResult());
    }

    /**
     * Вывод всех элементов дерева методом асиметричного обхода
     **/
    private void print(Node startNode) {
        if (startNode != null) {//условие сработает, когда мы достигним конца дерева и потомков не останется
            print(startNode.getLeft());//рекурсивно вызываем левых потомков
            print(startNode.getRight());//вызов правых
            startNode.printNode();//вызов метода принт
        }
    }

}
