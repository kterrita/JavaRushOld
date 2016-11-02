package com.javarush.test.level30.lesson04.home01;

import java.util.concurrent.TransferQueue;

/**
 * Created by ilya on 17.04.2015.
 */
public class Consumer implements Runnable {
    private TransferQueue<ShareItem> queue;

    public Consumer(TransferQueue<ShareItem> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try{
            Thread.sleep(500);

        } catch (InterruptedException e) {
        }
        try{
            while(true) {
                System.out.println("Processing " + queue.take().toString());
            }
        } catch (InterruptedException e) {

        }

    }
}
