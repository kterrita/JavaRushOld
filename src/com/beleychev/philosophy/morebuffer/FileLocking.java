package com.beleychev.philosophy.morebuffer;

import java.io.FileOutputStream;
import java.nio.channels.FileLock;
import java.util.concurrent.TimeUnit;

/**
 * Блокировка файла
 * Created by ilya on 09.03.15.
 */
public class FileLocking {
    public static void main(String[] args) throws Exception{
        FileOutputStream fos = new FileOutputStream("file.txt");
        FileLock fl = fos.getChannel().tryLock();
        if(fl != null) {
            System.out.println("Файл заблокирован");
            TimeUnit.MILLISECONDS.sleep(100);
            fl.release();
            System.out.println("Блокировка снята");
        }
        fos.close();
    }
}
