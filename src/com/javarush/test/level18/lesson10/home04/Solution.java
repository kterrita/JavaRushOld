package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String a = r.readLine();
        String b = r.readLine();
        RandomAccessFile file1 = new RandomAccessFile(a, "rw");
        RandomAccessFile file2 = new RandomAccessFile(b, "r");

        byte[] buffer1 = new byte[(int) file2.length()];
        byte[] buffer2 = new byte[(int) file1.length()];
        file2.read(buffer1);
        file1.read(buffer2);
        file1.seek(0);
        file1.write(buffer1);
        file1.write(buffer2);
        file1.close();
        file2.close();
        r.close();
    }
}
