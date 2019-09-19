package my.com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {

    public static void main(String[] args) {
        String s = "( ( 14 + 15 ) / 18 * 111 ) * ( 6 / ( 8 / ( 10 + 7 ) ) )";

      MyTree tree = new MyTree();
      tree.addListStrings(addSS(getLists(s)));

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