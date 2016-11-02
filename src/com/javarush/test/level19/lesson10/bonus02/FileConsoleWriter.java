package com.javarush.test.level19.lesson10.bonus02;

/* Свой FileWriter
Реализовать логику FileConsoleWriter
Должен наследоваться от FileWriter
При записи данных в файл, должен дублировать эти данные на консоль
*/

import java.io.*;

public class FileConsoleWriter extends FileWriter {
    public FileConsoleWriter(String fileName) throws IOException {
        super(fileName);
    }

    public FileConsoleWriter(String fileName, boolean append) throws IOException {
        super(fileName, append);
    }

    public FileConsoleWriter(File file) throws IOException {
        super(file);
    }

    public FileConsoleWriter(File file, boolean append) throws IOException {
        super(file, append);
    }

    public FileConsoleWriter(FileDescriptor fd) {
        super(fd);
    }

    @Override
    public void write(int c) throws IOException {
        char[] var2 = new char[]{(char)c};
        write(var2, 0, 1);
    }

    @Override
    public void write(char[] cbuf, int off, int len) throws IOException {
        System.out.println(String.valueOf(cbuf).substring(off, len + off));
        super.write(cbuf, off, len);
    }

    @Override
    public void write(String str, int off, int len) throws IOException {
        if(len < 0) {
            throw new IndexOutOfBoundsException();
        } else {
            char[] var4 = new char[len];
            str.getChars(off, off + len, var4, 0);
            write(var4, 0, len);
        }
    }

    @Override
    public void write(char[] cbuf) throws IOException {
        write(cbuf, 0, cbuf.length);
    }

    @Override
    public void write(String str) throws IOException {
        write(str, 0, str.length());
    }

    /*public static void main(String[] args) throws IOException
    {
        FileConsoleWriter fileConsoleWriter = new FileConsoleWriter("C:\\FilesForJavaRush\\First.txt");
        fileConsoleWriter.write("Проверка String:");
        fileConsoleWriter.write(61);
        char[] buff = "Проверка char buff:".toCharArray();
        fileConsoleWriter.write(buff);
        fileConsoleWriter.write(buff, 3, 5);
        fileConsoleWriter.write("Проверка String обрезка:", 0, 2);
        fileConsoleWriter.flush();
        fileConsoleWriter.close();
    }*/
}
