package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки

Пример вывода:
, 19
- 7
f 361
*/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get(args[0]);
        byte[] tmp = Files.readAllBytes(path);

        TreeMap<Character, Integer> map = getMapFromArray(tmp);

        for (Map.Entry<Character, Integer> pair : map.entrySet()) {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }
    }

    public static TreeMap<Character, Integer> getMapFromArray(byte[] array) {
        TreeMap<Character, Integer> map = new TreeMap<Character, Integer>();
        Arrays.sort(array);
        ArrayList<Byte> list = new ArrayList<Byte>();

        for (int i = 0; i < array.length; i++) {
            int sum = 0;
            if (list.contains(array[i])) {
                continue;
            } else {
                list.add(array[i]);
            }
            for (int j = 0; j < array.length; j++) {
                if (array[i] == (array[j])) {
                    sum++;
                }
            }
            map.put((char)array[i], sum);
        }
        return map;
    }
}
