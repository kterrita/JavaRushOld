package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new FileReader(args[0]));
        TreeMap<String, Double> map = new TreeMap<String, Double>();
        Double zp = 0.0;
        while (br.ready())
        {
            String line = br.readLine();
            String[] array = line.split(" ");
            if (!map.containsKey(array[0]))
            {
                map.put(array[0], Double.parseDouble(array[1]));
            } else
            {
                double d = map.get(array[0]) + Double.parseDouble(array[1]);
                map.remove(array[0]);
                map.put(array[0], d);
            }
        }

        for (Map.Entry<String, Double> entry : map.entrySet())
        {
            if (entry.getValue() > zp)
            {
                zp = entry.getValue();
            }
        }
        for (Map.Entry<String, Double> entry : map.entrySet())
        {
            if(entry.getValue().equals(zp)){
                System.out.println(entry.getKey());
            }
        }
        br.close();
    }
}
