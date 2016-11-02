package com.javarush.test.level19.lesson05.task01;

/* Четные байты
Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.
Пример: второй байт, четвертый байт, шестой байт и т.д.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String firstFile = br.readLine();
        String secondFile = br.readLine();

        FileInputStream fis = new FileInputStream(firstFile);
        FileWriter fw = new FileWriter(secondFile);

        while (fis.available() > 0) {
            byte[] b = new byte[fis.available()];
            fis.read(b);

            for (int i = 0; i < b.length; i++) {
                if (i % 2 != 0) {
                    fw.write(b[i]);
                }
            }
        }

        br.close();
        fis.close();
        fw.close();
    }
}
