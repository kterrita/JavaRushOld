package com.beleychev.philosophy.Buffer;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Получение каналов из потоков
 * Created by ilya on 09.03.15.
 */
public class GetChannel {
    private static final int BSIZE = 1024;

    public static void main(String[] args) throws Exception{
        //Запись файла
        FileChannel fc = new FileOutputStream("data.txt").getChannel();
        fc.write(ByteBuffer.wrap("Some text ".getBytes()));
        fc.close();
        //Добавление в конец файла
        fc = new RandomAccessFile("data.txt", "rw").getChannel();
        fc.position(fc.size()); //Переходим в конец
        fc.write(ByteBuffer.wrap("Some more".getBytes()));
        fc.close();
        //Чтение файла
        fc = new FileInputStream("data.txt").getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(BSIZE);
        fc.read(buffer);
        buffer.flip();
        while (buffer.hasRemaining()){
            System.out.print((char) buffer.get());
        }
    }
}
