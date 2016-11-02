package com.javarush.test.level20.lesson02.task05;

import java.io.*;

/* И еще раз о синхронизации
Реализуйте логику записи в файл и чтения из файла для класса Object
Метод load должен инициализировать объект данными из файла
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution
{
    public static void main(java.lang.String[] args)
    {

        try
        {
            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            Object object = new Object();
            object.string1 = new String();   //string #1
            object.string2 = new String();   //string #2
            object.save(outputStream);
            outputStream.flush();

            Object loadedObject = new Object();
            loadedObject.string1 = new String(); //string #3
            loadedObject.string2 = new String(); //string #4


            loadedObject.load(inputStream);
            //check here that the object variable equals to loadedObject - проверьте тут, что object и loadedObject равны

            if (object.equals(loadedObject))
            {
                System.out.println("The Same!");
            }

            outputStream.close();
            inputStream.close();

        }
        catch (IOException e)
        {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        }
        catch (Exception e)
        {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }


    public static class Object
    {
        public String string1;
        public String string2;

        public void save(OutputStream outputStream) throws Exception
        {
            //implement this method - реализуйте этот метод
            PrintWriter writer = new PrintWriter(outputStream);
            writer.println(string1.number);
            writer.println(string2.number);
            writer.close();
        }

        public void load(InputStream inputStream) throws Exception
        {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            int count = countStrings;
            int s1 = Integer.parseInt(reader.readLine());
            int s2 = Integer.parseInt(reader.readLine());
            countStrings = s1 - 1;
            string1 = new String();
            countStrings = s2 - 1;
            string2 = new String();
            countStrings = count;
            reader.close();
        }


        public boolean equals(Object o)
        {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Object object = o;

            if (string1 != null ? !string1.equals(object.string1) : object.string1 != null) return false;
            if (string2 != null ? !string2.equals(object.string2) : object.string2 != null) return false;

            return true;
        }

        @Override
        public int hashCode()
        {
            int result = string1 != null ? string1.hashCode() : 0;
            result = 31 * result + (string2 != null ? string2.hashCode() : 0);
            return result;
        }
    }

    public static int countStrings;

    public static class String
    {
        private final int number;

        public String()
        {
            number = ++countStrings;
        }

        public void print()
        {
            System.out.println("string #" + number);
        }

        @Override
        public boolean equals(java.lang.Object o)
        {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            String string = (String) o;

            if (number != string.number) return false;

            return true;
        }

        @Override
        public int hashCode()
        {
            return number;
        }
    }
}
