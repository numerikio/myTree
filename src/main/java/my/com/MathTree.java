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


            getChild();


        } else if (isNum(data) && target.getAction()==null) {
            setDataAndGoParent(data);
        }else if (isNum(data) && target.getAction()!=null){
            createChildAndGoToParent(data);
        } else if (data.equals("+") || data.equals("-")) {

            setData(data);

        } else if (data.equals(")")) {
            goToParent();
        }

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

    private void upGreat(String data) {
        Node nodeLastR = target.getRight();
        tempNode = getNewNode();
        tempNode.setParent(nodeLastR);
        nodeLastR.setLeft(tempNode);
        tempNode.setValue(nodeLastR.getValue());
        if (isNum(data)) {
            nodeLastR.setValue(Double.valueOf(data));
        }
        target = nodeLastR;

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
