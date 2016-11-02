package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки

Пример выходных данных:
длинное,короткое,аббревиатура
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader(args[0]));
        BufferedWriter bw = new BufferedWriter(new FileWriter(args[1]));
        String result = "";
        while(br.ready()){
            String s = br.readLine();
            String[] array = s.split(" ");
            for (int i = 0; i < array.length; i++) {
                if(array[i].length() > 6){
                        result += array[i] + ",";
                }
            }
        }
        bw.write(result.substring(0,result.length()-1));

        br.close();
        bw.close();
    }
}
