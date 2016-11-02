package com.javarush.test.level20.lesson02.task03;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* Знакомство с properties
В методе fillInPropertiesMap считайте имя файла с консоли и заполните карту properties данными из файла.
Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
Реализуйте логику записи в файл и чтения из файла для карты properties.
*/
public class Solution
{
    public static Map<String, String> properties = new HashMap<>();

   /* public static void main(String[] args) throws exception
    {
        Solution solution = new Solution();
        solution.fillInPropertiesMap();
        for(Map.Entry<String, String> entry : properties.entrySet()){
            System.out.println(entry.getKey() +  " " + entry.getValue());
        }
        FileOutputStream out = new FileOutputStream("E:\\FilesForJavaRush\\check.properties");
        solution.save(out);
    }*/

    public void fillInPropertiesMap() throws Exception
    {
        //implement this method - реализуйте этот метод
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        InputStream input = new FileInputStream(fileName);
        load(input);
        input.close();
    }

    public void save(OutputStream outputStream) throws Exception
    {
        //implement this method - реализуйте этот метод
        Properties p = new Properties();
        for(Map.Entry<String, String> entry : properties.entrySet()){
            p.setProperty(entry.getKey(), entry.getValue());
        }
        p.store(outputStream, null);
    }

    public void load(InputStream inputStream) throws Exception
    {
        //implement this method - реализуйте этот метод
        Properties p = new Properties();
        p.load(inputStream);
        for(Map.Entry<Object, Object> entry : p.entrySet()){
            properties.put((String)entry.getKey(), (String)entry.getValue());
        }
    }
}
