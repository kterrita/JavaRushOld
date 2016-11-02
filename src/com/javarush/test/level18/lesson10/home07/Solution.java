package com.javarush.test.level18.lesson10.home07;

/* Поиск данных внутри файла
Считать с консоли имя файла
Найти в файле информацию, которая относится к заданному id, и вывести ее на экран в виде, в котором она записана в файле.
Программа запускается с одним параметром: id (int)
Закрыть потоки

В файле данные разделены пробелом и хранятся в следующей последовательности:
id productName price quantity

где id - int
productName - название товара, может содержать пробелы, String
price - цена, double
quantity - количество, int
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException{

            BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in)); //Открываем потоки
            BufferedReader bfrfr = new BufferedReader(new FileReader(bfr.readLine()));
            List<String> list = new ArrayList<String>(); //лист, куда будем читать файл

            while (bfrfr.ready()) //читаем файл
                list.add(bfrfr.readLine());

            String str = "";
            for(int i = 0; i < list.size(); i++){ //этот цикл для поиска нужной строки по id
                String[] mssstr = list.get(i).split(" ");
                if (mssstr[0].equals(args[0])) {
                    str = list.get(i);
                    System.out.println(str);
                }
            }

        bfrfr.close();
        bfr.close();
    }
}
