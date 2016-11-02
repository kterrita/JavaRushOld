package com.javarush.test.level19.lesson03.task04;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* И еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1978

Подсказка: воспользуйтесь классом Calendar
*/

public class Solution {
    public static class PersonScannerAdapter implements PersonScanner{
        private Scanner scanner;

        PersonScannerAdapter(Scanner scanner) {
            this.scanner = scanner;
        }

        @Override
        public Person read() throws IOException {
            String line = scanner.nextLine();
            String[] array = line.split(" ");
            Calendar calendar = new GregorianCalendar(Integer.parseInt(array[5]), Integer.parseInt(array[4]) - 1,
                    Integer.parseInt(array[3]));
            return new Person(array[1], array[2], array[0], calendar.getTime());
        }

        @Override
        public void close() throws IOException {
            scanner.close();
        }
    }
}
