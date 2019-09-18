package my.com;

public class MyNode {
    private String data;
    private MyNode parent;
    private MyNode l;
    private MyNode r;

    public MyNode (){

    }

    public void printNode(){
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "MyNode{" +
                "data='" + resultNullS(data) + '\'' +
                ", parent=" + resultNull(parent) +
                ", l=" + resultNull(l) +
                ", r=" + resultNull(r) +
                '}';
    }

    private String resultNull (MyNode node){
        if(node!=null){
            return node.getData();
        }
        return "NULL";
    }

    private String resultNullS (String data){
        if(data!=null){
            return data;
        }
        return "NULL";
    }



    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public MyNode getParent() {
        return parent;
    }

    public void setParent(MyNode parent) {
        this.parent = parent;
    }

    public MyNode getL() {
        return l;
    }

    public void setL(MyNode l) {
        this.l = l;
    }

    public MyNode getR() {
        return r;
    }

    public void setR(MyNode r) {
        this.r = r;
    }
}
