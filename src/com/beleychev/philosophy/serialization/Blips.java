package com.beleychev.philosophy.serialization;

import java.io.*;

/**
 * Простоя реализация интерфейса Externalizable... с проблемами
 * Created by ilya on 09.03.15.
 */

class Blip1 implements Externalizable {
public Blip1() {
    System.out.println("Конструктор Blip1");
}
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.println("Blip1.writeExternal");
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        System.out.println("Blip1.readExternal");
    }
}

class Blip2 implements Externalizable {
    public Blip2(){
        System.out.println("Конструктор Blip2");
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.println("Blip2.writeExternal");
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        System.out.println("Blip2.readExternal");
    }
}

public class Blips {
    public static void main(String[] args) throws Exception{
        System.out.println("Создание объектов:");
        Blip1 b1 = new Blip1();
        Blip2 b2 = new Blip2();
        ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("Blips.out"));
        System.out.println("Сохранение объектов:");
        o.writeObject(b1);
        o.writeObject(b2);
        o.close();
        //Восстановление сохраненных объектов
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("Blips.out"));
        System.out.println("Восстановление b1:");
        b1 = (Blip1) in.readObject();
        //Вот те раз! Исключение
        System.out.println("Восстановление b2:");
        b2 = (Blip2) in.readObject();
    }
}
