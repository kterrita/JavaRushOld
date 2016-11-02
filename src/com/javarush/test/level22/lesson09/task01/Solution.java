package com.javarush.test.level22.lesson09.task01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.*;

/* Обращенные слова
В методе main с консоли считать имя файла, который содержит слова, разделенные пробелами.
Найти в тексте все пары слов, которые являются обращением друг друга. Добавить их в result.
Порядок слов first/second не влияет на тестирование.
Использовать StringBuilder.
Пример, "мор"-"ром", "трос"-"сорт"
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        ArrayList<String> list = new ArrayList<>();
        StringBuilder sb;
        while (br.ready()) {
            String s = br.readLine();
            String[] array = s.split(" ");
            for(String lane : array) {
                 list.add(lane);
            }
        }

        for (int i = 0; i < list.size(); i++)
        {
            for (int j = 0; j < list.size(); j++)
            {
                sb = new StringBuilder(list.get(j));
                if(list.get(i).equals(sb.reverse().toString())) {
                    Pair pair = new Pair();
                    pair.first = list.get(i);
                    pair.second = list.get(j);
                    if(pair.first.equals(pair.second)){
                        continue;
                    }
                    result.add(pair);
                    list.remove(i);
                    list.remove(j - 1);
                    j -= 2;
                }
            }
        }
        for(Pair pair : result) {
            System.out.println(pair);
        }
    }

    public static class Pair {
        String first;
        String second;

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
