package com.javarush.test.level22.lesson05.task01;

/* Найти подстроку
Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова,
которое следует после 4-го пробела.
Пример: "JavaRush - лучший сервис обучения Java."
Результат: "- лучший сервис обучения"
На некорректные данные бросить исключение TooShortStringException (сделать исключением).
Сигнатуру метода getPartOfString не менять.
*/
public class Solution {

    public static void main(String[] args) throws TooShortStringException
    {
        String s = "JavaRush - лучший сервис обучения Java.";
        System.out.println(Solution.getPartOfString(s));
    }

    public static String getPartOfString(String string) throws TooShortStringException{
        if(string == null){
            throw new TooShortStringException();
        }
        int count = 0;
        for (int i = 0; i < string.length(); i++)
        {
            if(string.charAt(i) == 32) {
                count++;
            }
        }
        if(count < 4) {
            throw new TooShortStringException();
        }
        count = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < string.length(); i++){
            if(string.charAt(i) == 32) {
                count++;
            }
            if(count < 5 && count != 0){
                if(count == 1 && string.charAt(i) == 32){
                    continue;
                }
                sb.append(string.charAt(i));
            }
        }
        return sb.toString();
    }

    public static class TooShortStringException extends Exception{

    }
}
