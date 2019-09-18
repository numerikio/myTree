package my.com;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {

    public static void main(String[] args) {
        String s = "( 3 + 4 + 1 ) / (8 + 11) ";

      MyTree tree = new MyTree();
      tree.addListSrings(addSS(getLists(s)));

       tree.printAllTree();
    }

    static List<String> getLists(String targetString) {
        return new ArrayList<String>(Arrays.asList(targetString.split(" ")));
    }
    static List<String> addSS (List<String> strings){
        strings.add(0, "(");
        strings.add(")");
        return strings;
    }


}
