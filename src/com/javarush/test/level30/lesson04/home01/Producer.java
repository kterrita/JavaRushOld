package com.javarush.test.level30.lesson04.home01;

import java.util.concurrent.TransferQueue;

/**
 * Created by ilya on 17.04.2015.
 */
public class Producer implements Runnable {
    private TransferQueue<ShareItem> queue;

    public Producer(TransferQueue<ShareItem> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
            int count = 10;
            for (int i = 1; i < count; i++) {
                String name = "ShareItem-" + i;
                System.out.printf("Элемент '%s' добавлен \n", name);
                queue.offer(new ShareItem(name, i));

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }

                if(queue.hasWaitingConsumer()) {
                    System.out.println("Consumer в ожидании!");
                }
            }
    }
}
