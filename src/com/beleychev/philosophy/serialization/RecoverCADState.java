package com.beleychev.philosophy.serialization;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;

/**
 * Восстоноваление состояния вымышленной системы CAD
 * {RunFirst: StoreCADState}
 * Created by ilya on 09.03.15.
 */
public class RecoverCADState {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception{
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("CADState.out"));
        //Данные читаются в том порядке, в котром они были записаны
        Line.deserializeStaticState(in);
        Circle.deserializeStaticState(in);
        Square.deserializeStaticState(in);
        List<Shape> shapes = (List<Shape>)in.readObject();
        System.out.println(shapes);
    }
}
