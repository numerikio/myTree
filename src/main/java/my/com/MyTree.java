package my.com;

import java.util.List;

public class MyTree {
    MyNode root;
    MyNode target;
    MyNode tempNode;

    public void insert(String data) {
        if (root == null) {
            root = getNewNode();
            target = root;
        }
        if (data.equals("(")) {
            if (target.getData() != null) {
                if (target.getData().equals("/") || (target.getData().equals("*"))) {
                    getChild();
                }
            }
            getChild();
        } else if (isNum(data) && target.getData() == null) {
            setDataAndGoParent(data);
        } else if (isNum(data) && target.getData() != null) {
            createChildAndGoToParent(data);
        } else if (data.equals("+") || data.equals("-")) {
            if (target.getR() == null || target.getL() == null) {
                setData(data);
            } else if (target.getR() != null && target.getL() != null) {
                if (target.getData().equals("/") || target.getData().equals("*")) {
                    goToParent();
                }
                getNewRoot();
                setData(data);
                getChild();
            }
        } else if (data.equals("/") || data.equals("*")) {
            if (target.getR() == null || target.getL() == null) {
                setData(data);
            } else if (target.getR() != null && target.getL() != null) {
                if (target.getData().equals("+") || target.getData().equals("-")) {
                    upGreat(data);
                } else {
                    getNewRoot();
                    setData(data);
                    getChild();
                }
            }
        } else if (data.equals(")")) {
            goToParent();
        }

    }

    private void getChild() {
        tempNode = getNewNode();
        if (target.getL() == null) {
            tempNode.setParent(target);
            target.setL(tempNode);
            target = tempNode;
        } else if ((target.getR() == null)) {
            tempNode.setParent(target);
            target.setR(tempNode);
            target = tempNode;
        } else {
            System.out.println("R and L not null");
        }
    }

    private void getNewRoot() {
        tempNode = getNewNode();
        target.setParent(tempNode);
        tempNode.setL(target);
        root = tempNode;
        goToParent();
    }

    private void upGreat(String data) {
        MyNode nodeLastR = target.getR();
        tempNode = getNewNode();
        tempNode.setParent(nodeLastR);
        nodeLastR.setL(tempNode);
        tempNode.setData(nodeLastR.getData());
        nodeLastR.setData(data);
        target = nodeLastR;

    }

    private MyNode getNewNode (){
        return new MyNode();
    }

    private void setDataAndGoParent(String data) {
        setData(data);
        goToParent();
    }

    private void setData(String data) {
        target.setData(data);
    }

    private void createChildAndGoToParent(String s) {
        getChild();
        setData(s);
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
    }

    /**
     * Вывод всех элементов дерева методом асиметричного обхода
     **/
    private void print(MyNode startNode) {
        if (startNode != null) {//условие сработает, когда мы достигним конца дерева и потомков не останется
            print(startNode.getL());//рекурсивно вызываем левых потомков
            print(startNode.getR());//вызов правых
            startNode.printNode();//вызов метода принт
        }
    }

}
