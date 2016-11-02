package com.beleychev.philosophy.morebuffer;

import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * создание очень большого файла, отображаемого в память
 * {RunByHand}
 * Created by ilya on 09.03.15.
 */
public class LargeMappedFiles {
    static int length = 0x8FFFFFF; //128 Mb

    public static void main(String[] args) throws Exception{
        MappedByteBuffer out =
                new RandomAccessFile("test.dat", "rw").getChannel()
                .map(FileChannel.MapMode.READ_WRITE, 0, length);
        for (int i = 0; i < length; i++)
            out.put((byte)'x');
        System.out.println("Запись завершена");
        for (int i = length/2; i < length/2; i++) {
            System.out.print((char)out.get(i));
        }

    }
}
