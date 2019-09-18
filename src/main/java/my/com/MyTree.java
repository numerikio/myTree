package my.com;

import java.util.List;

public class MyTree {
    MyNode root;
    MyNode target;

    public void insert(String data) {
        if (root == null) {
            root = new MyNode();
            target = root;
        }
        if (data.equals("(")) {
            createChild();
        } else if (isNum(data) && target.getData() == null) {
            setDataAndGoParent(data);
        } else if (isNum(data) && target.getData() != null) {
            createChildAndGoToParent(data);
        } else if (data.equals("+") || data.equals("/")) {
            if (target.getR() == null || target.getL() == null) {
                sedData(data);
            } else if(target.getR() != null && target.getL() != null) {
                setNewRoot();
                sedData(data);
                createChild();
            }
        } else if (data.equals(")")) {
            goToParent();
        }

    }

    private void createChild() {
        MyNode node = new MyNode();
        if (target.getL() == null) {
            node.setParent(target);
            target.setL(node);
            target = node;
        } else {
            node.setParent(target);
            target.setR(node);
            target = node;
        }
    }

    private void setNewRoot() {
        MyNode node = new MyNode();
        target.setParent(node);
        node.setL(target);
        root = node;
        target = target.getParent();


    }

    private void setDataAndGoParent(String data) {
        target.setData(data);
        target = target.getParent();
    }

    private void sedData(String data) {
        target.setData(data);
    }

    private void createChildAndGoToParent(String s) {
        MyNode node = new MyNode();
        if (target.getL() == null) {
            node.setParent(target);
            target.setL(node);
            target = node;
            target.setData(s);
            target = target.getParent();
        } else {
            node.setParent(target);
            target.setR(node);
            target = node;
            target.setData(s);
            target = target.getParent();
        }
    }

    private void goToParent() {
        if (target.getParent() != null) {
            target = target.getParent();
        }
    }

    public void addListSrings(List<String> strings) {
        for (String s : strings) {
            insert(s);
            System.out.println(s);
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
