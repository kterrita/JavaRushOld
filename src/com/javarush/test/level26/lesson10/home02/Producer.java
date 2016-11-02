package com.javarush.test.level26.lesson10.home02;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by ilya on 05.04.2015.
 */
public class Producer implements Runnable {
    protected ConcurrentHashMap<String, String> map;

    public Producer(ConcurrentHashMap<String, String> map) {
        this.map = map;
    }

    public void run()
    {
        while(true) {
            try
            {
                int i = 1;
                while(true)
                {
                    System.out.println("Some text for " + i);
                    Thread.sleep(500);
                    i++;
                }
            }catch (Exception e) {
                System.out.println(Thread.currentThread().getName() + "thread was terminated");
            }
        }
    }
}
