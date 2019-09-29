package my.com;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MathTreeTest {
    MathTree mathTree;
    String s;

    @Test
    public void test1() {
        s = "( ( 14 + 15 ) / 18 * 111 ) * ( 6 / ( 8 / ( 10 + 7 ) ) )";
        mathTree = new MathTree();
        mathTree.addListStrings(addBrackets(getStrings(s)));
        assertEquals(2280.125, mathTree.result(), 0);
    }
    @Test
    public void test2() {
        s = "( 20 - 13 / 5 ) + ( ( 20 + 3 ) * 4 )";
        mathTree = new MathTree();
        mathTree.addListStrings(addBrackets(getStrings(s)));
        assertEquals(109.4, mathTree.result(), 0);
    }
    @Test
    public void test2_1() {
        s = "( 20 - 13 / 5 ) * ( ( 20 + 3 ) * 4 )";
        mathTree = new MathTree();
        mathTree.addListStrings(addBrackets(getStrings(s)));
        assertEquals(1600.8, mathTree.result(), 0);
    }
    @Test
    public void test3() {
        s = "1 + 10 / 5 + 20 / 4";
        mathTree = new MathTree();
        mathTree.addListStrings(addBrackets(getStrings(s)));
        assertEquals(8.0, mathTree.result(), 0);
    }

    @Test
    public void test4() {
        s = "10 - 2 / 2 + 4";
        mathTree = new MathTree();
       mathTree.addListStrings(addBrackets(getStrings(s)));

        assertEquals(13.0, mathTree.result(), 0);
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
