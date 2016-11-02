package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть поток ввода.
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileInputStream inFile = new FileInputStream(reader.readLine());

        byte[] str = new byte[inFile.available()];
        inFile.read(str);
        String text = new String(str);

        Pattern pattern = Pattern.compile("\\b[wW]orld\\b");
        Matcher matcher = pattern.matcher(text);

        int count1 = 0;
        while(matcher.find()) {
            count1++;
        }

        System.out.println(count1);

        reader.close();
        inFile.close();

    }
}

