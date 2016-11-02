package com.javarush.test.level28.lesson06.home01;

/**
 * Created by ilya on 10.04.2015.
 */
public class MyThread extends Thread {
    static int priority = 0;

    public MyThread() {
        setThreads();
    }

    public MyThread(Runnable target) {
        super(target);
        setThreads();
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
        setThreads();
    }

    public MyThread(String name) {
        super(name);
        setThreads();
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
        setThreads();
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
        setThreads();
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        setThreads();
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
        setThreads();
    }

    public void setThreads() {
        priority++;
        if(priority <= MAX_PRIORITY){
            this.setPriority(priority);
        } else {
            priority = 1;
            this.setPriority(priority);
        }
    }
}
