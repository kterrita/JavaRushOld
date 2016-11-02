package com.javarush.test.level20.lesson10.home03;

import java.io.*;

/* Найти ошибки
Почему-то при сериализации/десериализации объекта класса B возникают ошибки.
Найдите проблему и исправьте ее.
Класс A не должен реализовывать интерфейсы Serializable и Externalizable.
Сигнатура класса В не содержит ошибку :)
*/
public class Solution implements Serializable{
    public static class A {
        protected String name = "A";

        public A(){}

        public A(String name) {
            this.name += name;
        }
    }

    public class B extends A implements Serializable {
        public B(String name) {
            super(name);
            this.name += name;
        }

        private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException{
            name = (String) in.readObject();
        }
        private void writeObject(ObjectOutputStream out) throws IOException, ClassNotFoundException{
            out.writeObject(name);
        }

    }

    /*public static void main(String[] args) throws exception{
        FileOutputStream fos = new FileOutputStream("/Users/ilya/Documents/First.dat");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        B b = new Solution().new B("123");
        oos.writeObject(b);
        fos.close();
        oos.close();
        FileInputStream fis = new FileInputStream("/Users/ilya/Documents/First.dat");
        ObjectInputStream ois = new ObjectInputStream(fis);
        B b2 = (B) ois.readObject();
        fis.close();
        ois.close();
        System.out.println(b2.name);
    }*/
}
