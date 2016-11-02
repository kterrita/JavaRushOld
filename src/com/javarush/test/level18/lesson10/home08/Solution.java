package com.javarush.test.level18.lesson10.home08;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Не забудьте закрыть все потоки
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s;
        List<Thread> threadList = new ArrayList<Thread>();
        while (!(s = reader.readLine()).equals("exit")) {
            ReadThread readThread = new ReadThread(s);
            threadList.add(readThread);
            readThread.start();
        }
        for (Thread thread : threadList){
            thread.join();
        }
        reader.close();
        System.out.println(resultMap);
    }

    public static class ReadThread extends Thread {
        private String fileName;

        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;
            run();
        }
        // implement file reading here - реализуйте чтение из файла тут

        @Override
        public void run() {
            super.run();
            try {
                synchronized (this) {
                    resultMap.put(fileName, getMaxQuantityByte(fileName));
                }
            } catch (Exception e) {
                System.out.println(e);
            }

        }

        public static Integer getMaxQuantityByte(String fileName) throws Exception {
            FileInputStream fis = new FileInputStream(fileName);
            ArrayList<Integer> list = new ArrayList<Integer>();
            int maxQuantityByte = 0;
            int byteValue = 0;

            while (fis.available() > 0) {
                int count = fis.read();
                list.add(count);
            }
            fis.close();

            for (Integer item : list) {
                int helpNum = 0;
                for (Integer num : list) {
                    if (item == num) {
                        helpNum++;
                    }
                }
                if (helpNum > maxQuantityByte) {
                    maxQuantityByte = helpNum;
                    byteValue = item;
                }
            }

            return byteValue;
        }
    }
}
