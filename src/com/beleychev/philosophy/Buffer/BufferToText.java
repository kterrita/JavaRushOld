package com.beleychev.philosophy.Buffer;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/**
 * Получение текста из буфера ByteBuffers и обратно
 * Created by ilya on 09.03.15.
 */
public class BufferToText {
    private static final int BSIZE = 1024;

    public static void main(String[] args) throws Exception{
        FileChannel fc =
                new FileOutputStream("data2.txt").getChannel();
        fc.write(ByteBuffer.wrap("Some text ".getBytes()));
        fc.close();
        fc = new FileInputStream("data2.txt").getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(BSIZE);
        fc.read(buffer);
        buffer.flip();
        // Не работает
        System.out.println(buffer.asCharBuffer());
        //Декодирование с использованием кодировки по умолчанию
        buffer.rewind();
        String encoding = System.getProperty("file.encoding");
        System.out.println("Декодирвано в " + encoding + ": "
                    + Charset.forName(encoding).decode(buffer));
        //Кодирование в печатной форме
        fc = new FileOutputStream("data2.txt").getChannel();
        fc.write(ByteBuffer.wrap("Some text".getBytes("UTF-16BE")));
        fc.close();
        //Повторная попытка чтения
        fc = new FileInputStream("data2.txt").getChannel();
        buffer.clear();
        fc.read(buffer);
        buffer.flip();
        System.out.println(buffer.asCharBuffer());
        //Использование CharBuffer для записи
        fc = new FileOutputStream("data2.txt").getChannel();
        buffer = ByteBuffer.allocate(24); //Больше, чем необходимо
        buffer.asCharBuffer().put("Some text");
        fc.write(buffer);
        fc.close();
        //Чтение и вывод
        fc = new FileInputStream("data2.txt").getChannel();
        buffer.clear();
        fc.read(buffer);
        buffer.flip();
        System.out.println(buffer.asCharBuffer());
    }
}
