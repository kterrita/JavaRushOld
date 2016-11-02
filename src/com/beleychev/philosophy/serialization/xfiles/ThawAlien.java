package com.beleychev.philosophy.serialization.xfiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * Попытка восстановления сериализованного файла
 * без сохранения класса объекта в этом файле
 * {RunByHand}
 * Created by ilya on 09.03.15.
 */
public class ThawAlien {
    public static void main(String[] args) throws Exception{
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(new File("X.file")));
        Object mystery = in.readObject();
        System.out.println(mystery.getClass());
    }
}
