package com.beleychev.philosophy.Archives;

import java.io.*;
import java.util.Enumeration;
import java.util.zip.*;

/**
 * Использование формата Archives для сжатия любого
 * количества файлов, указанных в командной строке.
 * {Параметры: ZipCimpress.java}
 * Created by ilya on 09.03.15.
 */
public class ZipCompress {
    public static void main(String[] args) throws Exception{
        FileOutputStream f = new FileOutputStream("test.zip");
        CheckedOutputStream csum =
                new CheckedOutputStream(f, new Adler32());
        ZipOutputStream zos = new ZipOutputStream(csum);
        BufferedOutputStream out =
                new BufferedOutputStream(zos);
        zos.setComment("Проверка Archives-сжатия файла");
        //Однако парного метода для получения комментария
        //getComment() не существует
        for(String arg : args) {
            System.out.println("Запись файла " + arg);
            BufferedReader in =
                    new BufferedReader(new FileReader(arg));
            zos.putNextEntry(new ZipEntry(arg));
            int c;
            while((c = in.read()) != -1)
                out.write(c);
            in.close();
            out.flush();
        }
        out.close();
        //Контрольная сумма становится ддействительной
        //только после закрытия файла с архивом!
        System.out.println("Checksum: " + csum.getChecksum().getValue());
        //Теперь извлекаем файлы
        System.out.println("Чтение файла");
        FileInputStream fi = new FileInputStream("test.zip");
        CheckedInputStream csumi = new CheckedInputStream(fi, new Adler32());
        ZipInputStream in2 = new ZipInputStream(csumi);
        BufferedInputStream bis = new BufferedInputStream(in2);
        ZipEntry ze;
        while((ze = in2.getNextEntry()) != null) {
            System.out.println("Reading file " + ze);
            int x;
            while ((x = bis.read()) != -1)
                System.out.write(x);
        }
        if(args.length == 1)
            System.out.println("Котрольная сумма: " + csumi.getChecksum().getValue());
        bis.close();
        //Альтернативный способ открытия и чтения
        //файлов в формате Archives
        ZipFile zf = new ZipFile("test.zip");
        Enumeration e = zf.entries();
        while (e.hasMoreElements()) {
            ZipEntry ze2 = (ZipEntry) e.nextElement();
            System.out.println("File: " + ze2);
            //затем данные извлекаются также, как прежде
        }
    }
}
