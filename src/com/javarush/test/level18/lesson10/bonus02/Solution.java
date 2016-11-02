package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id

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

public class Solution {
    public static void main(String[] args) throws Exception {
        if (args.length == 4) {
            if (args[0].equals("-c")) {
                String productName = String.format("%-30.30s",args[1]);
                String productPrice = String.format("%-8.8s",args[2]);
                String productQuantity = String.format("%-4.4s", args[3]);

                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                String fn = reader.readLine();
                BufferedReader fileReader = new BufferedReader(new FileReader(fn));
                String line;
                int max = 0;
                while ((line = fileReader.readLine()) != null) {
                    try {
                        int id = Integer.parseInt(line.substring(0, 8).trim());
                        if (max < id) max = id;
                    } catch (StringIndexOutOfBoundsException e) {}
                }
                fileReader.close();
                int newid = max + 1;
                String newidstr = String.format("%-8.8s", String.valueOf(newid));

                BufferedWriter fileWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fn, true),"cp1251"));
                if (newid != 1) fileWriter.newLine();
                newidstr = newidstr + productName + productPrice + productQuantity;
                fileWriter.append(newidstr);
                fileWriter.flush();
                fileWriter.close();
            }
        }
    }
}