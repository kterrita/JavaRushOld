package com.javarush.test.level30.lesson02.task01;

/* Осваиваем методы класса Integer
Используя метод Integer.parseInt(String, int) реализуйте логику метода convertToDecimalSystem,
который должен переводить переданную строку в десятичное число и возвращать его в виде строки.
*/
public class Solution {

    public static void main(String[] args) {
        System.out.println(convertToDecimalSystem("0x16")); //22
        System.out.println(convertToDecimalSystem("012"));  //10
        System.out.println(convertToDecimalSystem("0b10")); //2
        System.out.println(convertToDecimalSystem("62"));   //62
    }

    public static String convertToDecimalSystem(String s) {
        String base = "";
        if (s.startsWith("0x")) {
            base = s.substring(2, s.length());
            return String.valueOf(Integer.parseInt(base, 16));
        } else if (s.startsWith("0b")) {
            base = s.substring(2, s.length());
            return String.valueOf(Integer.parseInt(base, 2));
        } else if (s.startsWith("0")) {
            base = s.substring(1, s.length());
            return String.valueOf(Integer.parseInt(base, 8));
        } else {
            base = s;
            return String.valueOf(Integer.parseInt(base, 10));
        }
    }
}
