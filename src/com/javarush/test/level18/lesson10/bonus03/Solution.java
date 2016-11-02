package com.javarush.test.level18.lesson10.bonus03;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        ArrayList<String> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        BufferedReader br = new BufferedReader(new FileReader(fileName));

        while (br.ready())
        {
            list.add(br.readLine());
        }

        reader.close();
        br.close();

        String id = String.format("%-8.8s", args[1]);


        if (args[0].equals("-u"))
        {
            String productName = String.format("%-30.30s", args[2]);
            String price = String.format("%-8.8s", args[3]);
            String quantity = String.format("%-4.4s", args[4]);
            for (String line : list)
            {
                if ((line.substring(0, 8).trim()).equals(id.trim()))
                {
                    int index = list.indexOf(line);
                    line = id + productName + price + quantity;
                    list.set(index, line);
                }
            }
        } else if (args[0].equals("-d"))
        {
            for (int i = 0; i<list.size();i++)
            {
                if ((list.get(i).substring(0, 8).trim()).equals(id.trim()))
                {
                    list.remove(i);
                    i--;
                }
            }
        }
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        for (String line : list)
        {
            bw.write(line + "\n");
        }
        bw.close();
    }
}
