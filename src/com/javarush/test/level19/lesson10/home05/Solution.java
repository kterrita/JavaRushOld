package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит слова, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки
*/

import java.io.*;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader(args[0]));
        BufferedWriter bw = new BufferedWriter(new FileWriter(args[1]));

        while(br.ready()){
            String s = br.readLine();
            String[] array = s.split(" ");
            Pattern pattern = Pattern.compile(".*[0-9].*");
            for (int i = 0; i < array.length; i++) {
                if(pattern.matcher(array[i]).find()){
                    bw.write(array[i] + " ");
                }
            }
        }

        br.close();
        bw.close();
    }
}
