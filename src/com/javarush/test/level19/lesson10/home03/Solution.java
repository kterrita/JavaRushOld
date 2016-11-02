package com.javarush.test.level19.lesson10.home03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader(args[0]));

        while(br.ready())
        {
            String fullName = "";
            String name = "";
            String line = br.readLine();
            String[] array = line.split(" ");
            for (int i = 0; i < array.length; i++)
            {
                try{
                    Integer.parseInt(array[i]);
                }catch(Exception e){
                    name += array[i] + " ";
                    fullName = name.trim();
                }
            }
            int day = Integer.parseInt(array[array.length-3]);
            int month = Integer.parseInt(array[array.length-2]) - 1;
            int year = Integer.parseInt(array[array.length-1]);
            PEOPLE.add(new Person(fullName, new GregorianCalendar(year, month, day).getTime()));
        }
        br.close();

    }

}
