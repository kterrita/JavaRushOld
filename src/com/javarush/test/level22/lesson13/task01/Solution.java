package com.javarush.test.level22.lesson13.task01;

import java.util.ArrayList;
import java.util.StringTokenizer;

/* StringTokenizer
Используя StringTokenizer разделить query на части по разделителю delimiter.
Пример,
getTokens("level22.lesson13.task01", ".") == {"level22", "lesson13", "task01"}
*/
public class Solution {
   /* public static void main(String[] args)
    {
        String query = "level22.lesson13.task01";
        String delimiter = ".";
        String[] array = getTokens(query, delimiter);
        for(String lane : array) {
            System.out.println(lane);
        }
    }*/
    public static String [] getTokens(String query, String delimiter) {
        if(query == null || delimiter == null){
            return new String[0];
        }
        StringTokenizer tokenizer = new StringTokenizer(query, delimiter);
        ArrayList<String> list = new ArrayList<>();
        while(tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            list.add(token);
        }
        return list.toArray(new String[list.size()]);
    }
}
