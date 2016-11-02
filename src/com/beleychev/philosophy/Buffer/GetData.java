package com.beleychev.philosophy.Buffer;

import java.nio.ByteBuffer;

/**
 * Получение различных данных из буфера ByteBuffer
 * Created by ilya on 09.03.15.
 */
public class GetData {
    private static final int BSIZE = 1024;

    public static void main(String[] args) throws Exception{
        ByteBuffer buffer = ByteBuffer.allocate(BSIZE);
        // при выделении буфер заполняется нулями:
        int i = 0;
        while(i++ < buffer.limit())
            if(buffer.get() != 0)
                System.out.println("nonzero");

        System.out.println("i = " + i);
        buffer.rewind();
        //Сохраняем и считываем символьный массив:
        buffer.asCharBuffer().put("Howdy");
        char c;
        while((c = buffer.getChar()) != 0)
            System.out.print(c + " ");
        System.out.println();
        buffer.rewind();
        //Сохраняем и считываем число типа short
        buffer.asShortBuffer().put((short)471142);
        System.out.println(buffer.getShort());
        buffer.rewind();
        //Сохраняем и считываем число типа int
        buffer.asIntBuffer().put(99471142);
        System.out.println(buffer.getInt());
        buffer.rewind();
        //Сохраняем и считываем число типа long
        buffer.asLongBuffer().put(99471142);
        System.out.println(buffer.getLong());
        buffer.rewind();
        //Сохраняем и считываем число типа float
        buffer.asFloatBuffer().put(99471142);
        System.out.println(buffer.getFloat());
        buffer.rewind();
        //Сохраняем и считываем число типа double
        buffer.asDoubleBuffer().put(99471142);
        System.out.println(buffer.getDouble());
        buffer.rewind();

    }
}
