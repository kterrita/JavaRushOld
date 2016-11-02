package com.beleychev.philosophy.serialization;

import java.io.FileOutputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

/**
 * Created by ilya on 09.03.15.
 */
public class FreezeAlien {
    public static void main(String[] args) throws Exception{
        ObjectOutput out = new ObjectOutputStream(new FileOutputStream("X.file"));
        Alien quellek = new Alien();
        out.writeObject(quellek);
    }
}
