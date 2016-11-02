package com.javarush.test.level19.lesson05.task04;

/* Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Заменить все точки "." на знак "!", вывести во второй файл.
Закрыть потоки ввода-вывода.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        BufferedReader br = new BufferedReader(new FileReader(reader.readLine()));
        BufferedWriter bw = new BufferedWriter(new FileWriter(reader.readLine()));

        while(br.ready()){
            String s = br.readLine();
            String result = s.replaceAll("\\.", "!");
            bw.write(result);
        }

        reader.close();
        br.close();
        bw.close();
    }
}
