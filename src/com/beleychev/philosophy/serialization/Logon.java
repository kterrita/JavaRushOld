package com.beleychev.philosophy.serialization;

import java.io.*;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Ключевое слово transient
 * Created by ilya on 09.03.15.
 */
public class Logon implements Serializable {
    private Date date = new Date();
    private String username;
    private transient String password;
    public Logon(String name, String pwd) {
        username = name;
        password = pwd;
    }
    public String toString() {
        return "информация о сеансе: \n пользователь: " + username + "\n дата: " + date + "\n пароль: " + password;
    }

    public static void main(String[] args) throws Exception{
        Logon a = new Logon("Пользователь", "Пароль");
        System.out.println("Сеанс а = " + a);
        ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("Logon.out"));
        o.writeObject(a);
        o.close();
        TimeUnit.SECONDS.sleep(1); //Задержка
        //Восстановление
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("Logon.out"));
        System.out.println("Восстановление объекта. Время: " + new Date());
        a = (Logon) in.readObject();
        System.out.println("Сеанс а = " + a);
    }
}
