package Own;

import java.util.Calendar;
import java.util.TimeZone;

/**
 * Created by ilya on 21.08.14.
 */
public class CalendarExample {
    public static void main(String[] args) {
        //Calendar calendar = Calendar.getInstance();
        //System.out.println(calendar.getTime());
        String[] array = TimeZone.getAvailableIDs();
        System.out.println(array.toString());
    }
}
