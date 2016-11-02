package Own;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ilya on 31.07.14.
 */
public class Solution {

    public static void main(String[] args) {
        BigDecimal bigDecimal = new BigDecimal("170.00000");

        String money = roundCash(bigDecimal);

        System.out.println(money);

    }

    public static String roundCash(BigDecimal cash) {
        double money = cash.doubleValue();
        if (money * 100 % 100 == 0){
            return cash.setScale(0).toString();
        } else {
            return cash.setScale(2, RoundingMode.FLOOR).toString();
        }
    }

}

