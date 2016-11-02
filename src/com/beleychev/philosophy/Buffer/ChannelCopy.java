package com.beleychev.philosophy.Buffer;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Копирование файла с использованием каналов и буферов
 * Created by ilya on 09.03.15.
 */
public class ChannelCopy {
    private static final int BSIZE = 1024;

    public static void main(String[] args) throws Exception{
        if(args.length != 2) {
            System.out.println("параметры: Источник Приемник");
            System.exit(1);
        }
        FileChannel
                in = new FileInputStream(args[0]).getChannel(),
                out = new FileOutputStream(args[1]).getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(BSIZE);
        while (in.read(buffer) != -1) {
            buffer.flip(); //Подготовка к записи
            out.write(buffer);
            buffer.clear(); // Подготовка к чтению
        }

    }
}
