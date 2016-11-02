package Own;


import java.util.ArrayList;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ilya on 25.09.14.
 */
public class toUpperCaseTest {
    public static void main(String[] args) {
        int a;
        int b;
        int c;
        int d;
        a = 1;
        b = 10;
        for (c = a; c < b; c++) {
            d = c*a;
            a = d;
            System.out.println(d);
        }
    }
}
