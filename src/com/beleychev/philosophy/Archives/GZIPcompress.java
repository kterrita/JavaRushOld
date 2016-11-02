package com.beleychev.philosophy.Archives;

import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * Параметры: GZIPcompress.java
 * Created by ilya on 09.03.15.
 */
public class GZIPcompress {
    public static void main(String[] args) throws IOException{
        if(args.length == 0) {
            System.out.println(
                    "Использование: \nGZIPcompress file\n" +
                            "\tИспользует метод GZIP для сжатия " +
                            "файла в архив test.gz");
            System.exit(1);
        }
        BufferedReader in = new BufferedReader(new FileReader(args[0]));
        BufferedOutputStream out = new BufferedOutputStream(new GZIPOutputStream(new FileOutputStream("test.gz")));
        System.out.println("Запись файла");
        int c;
        while((c = in.read()) != -1)
            out.write(c);
        in.close();
        out.close();
        System.out.println("Чтение файла");
        BufferedReader in2 = new BufferedReader(new InputStreamReader(new GZIPInputStream(
                new FileInputStream("test.gz"))));
        String s;
        while((s = in2.readLine()) != null)
            System.out.println(s);
    }
}
