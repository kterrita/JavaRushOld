package Own;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ilya on 09.10.14.
 */
public class PatternExample {

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("\\w[А-Яа-я]+");
        Matcher matcher = pattern.matcher("159ПРО");
        System.out.println(matcher.find());
    }
}
