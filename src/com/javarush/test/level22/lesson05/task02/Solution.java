package com.javarush.test.level22.lesson05.task02;

/* Между табуляциями
Метод getPartOfString должен возвращать подстроку между первой и второй табуляцией.
На некорректные данные бросить исключение TooShortStringException.
Класс TooShortStringException не менять.
*/
public class Solution
{

    /*public static void main(String[] args) throws TooShortStringException
    {
        String s = "\t123\t123\t";
        System.out.println(getPartOfString(s));
    }*/

    public static String getPartOfString(String string) throws TooShortStringException
    {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        if(string == null) {
            throw new TooShortStringException();
        }
        for (int i = 0; i < string.length(); i++)
        {
            if(string.charAt(i) == 9){
                count++;
            }
        }
        if(count < 2) {
            throw new TooShortStringException();
        }
        count = 0;
        for (int i = 0; i < string.length(); i++)
        {
            if(string.charAt(i) == 9){
                count++;
            }
            if(count < 2 && string.charAt(i) != 9 && count != 0) {
                sb.append(string.charAt(i));
            }
        }


        return sb.toString();
    }

    public static class TooShortStringException extends Exception
    {
    }
}
