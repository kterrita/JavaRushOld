package com.javarush.test.level20.lesson10.home06;

import java.io.*;

/* Запрет сериализации
Запретите сериализацию класса SubSolution используя NotSerializableException.
Сигнатуры классов менять нельзя
*/
public class Solution implements Serializable {

    public static class SubSolution extends Solution {
        private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException{
            throw new NotSerializableException();
        }
        private void writeObject(ObjectOutputStream out) throws IOException {
            throw new NotSerializableException();
        }
    }

    /*public static void main(String[] args) throws exception{
        FileOutputStream fos = new FileOutputStream("ilya.dat");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        SubSolution subSolution = new SubSolution();
        oos.writeObject(subSolution);

        fos.close();
        oos.close();

        FileInputStream fis = new FileInputStream("ilya.dat");
        ObjectInputStream ois = new ObjectInputStream(fis);

        SubSolution solution2 = (SubSolution) ois.readObject();

        fis.close();
        ois.close();

        System.out.println(solution2);
    }*/
}
