package com.beleychev.philosophy.serialization;

import java.io.*;

/**
 * Управление серализацией с определением собственных методов
 * writeObject() и readObject()
 * Created by ilya on 09.03.15.
 */
public class SerialCtl implements Serializable {
    private String a;
    private transient String b;

    public SerialCtl(String aa, String bb) {
        a = "Не объявлено transient: " + aa;
        b = "Объявлено transient: " + bb;
    }
    public String toString() {
        return a + "\n" + b;
    }
    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
        stream.writeObject(b);
    }
    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        stream.defaultReadObject();
        b = (String) stream.readObject();
    }

    public static void main(String[] args) throws Exception{
        SerialCtl sc = new SerialCtl("Test1", "Test2");
        System.out.println("Перед записью:\n" + sc);
        ByteArrayOutputStream buf = new ByteArrayOutputStream();
        ObjectOutputStream o = new ObjectOutputStream(buf);
        o.writeObject(sc);
        //Теперь получим его обратно
        ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(buf.toByteArray()));
        SerialCtl sc2 = (SerialCtl)in.readObject();
        System.out.println("После восстановления:\n" + sc2);
    }
}
