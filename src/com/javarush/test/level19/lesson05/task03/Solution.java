package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки ввода-вывода.

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String firstFile = reader.readLine();
        String secondFile = reader.readLine();

        BufferedReader br = new BufferedReader(new FileReader(firstFile));
        BufferedWriter bw = new BufferedWriter(new FileWriter(secondFile));

        String line = "";
        while(br.ready()){
            line = br.readLine();
            String[] array = line.split(" ");
            for (int i = 0; i < array.length; i++) {
                try{
                    int a = Integer.parseInt(array[i]);
                    bw.write(array[i] + " ");
                } catch (Exception e){

                }
            }
        }
        reader.close();
        br.close();
        bw.close();

    }
}
