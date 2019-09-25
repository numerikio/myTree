package my.com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {

    public static void main(String[] args) {

         String s = "( ( 14 + 15 ) / 18 * 111 ) * ( 6 / ( 8 / ( 10 + 7 ) ) )";
      //  String s = "( 20 - 13 / 5 ) * ( ( 20 + 3 ) * 3 )";  //  <<<===---- problem !!!
        //String s = "1 + 10 / 5 + 20 / 4";

        long x = System.currentTimeMillis();

        MathTree tree = new MathTree();
        tree.addListStrings(addBrackets(getStrings(s)));
        tree.printAllTree();

        System.out.println(System.currentTimeMillis() - x);
    }

    static List<String> getStrings(String targetString) {
        return new ArrayList<String>(Arrays.asList(targetString.split(" ")));
    }

    static List<String> addBrackets(List<String> strings) {
        strings.add(0, "(");
        strings.add(")");
        return strings;
    }


}
