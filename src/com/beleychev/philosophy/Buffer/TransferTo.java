package com.beleychev.philosophy.Buffer;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

/**
 * Использование метода transferTo() для соединения каналов
 * {Параметры: TransferTo.java TransferTo.txt}
 * Created by ilya on 09.03.15.
 */
public class TransferTo {
    public static void main(String[] args) throws Exception{
        if(args.length != 2) {
            System.out.println("параметры: источник приемник");
            System.exit(1);
        }
        FileChannel
                    in = new FileInputStream(args[0]).getChannel(),
                    out = new FileOutputStream(args[1]).getChannel();
        in.transferTo(0, in.size(), out);
        // Или:
        // out: transferFrom(in, 0, in.size());
    }
}
