package com.javarush.test.level27.lesson15.big01.ad;

/**
 * Created by ilya on 21.04.2015.
 */
public class Advertisement{

    private Object content;
    private String name;
    private long initialAmount;
    private int hits;
    private int duration;
    private long amountPerOneDisplaying;

    public Advertisement(Object content, String name, long initialAmount, int hits, int duration) {
        this.content = content;
        this.name = name;
        this.initialAmount = initialAmount;
        this.hits = hits;
        this.duration = duration;
        this.amountPerOneDisplaying = initialAmount/hits;
    }

    public void revalidate() throws UnsupportedOperationException{
        if(hits <= 0)
            throw new UnsupportedOperationException();
        else
            hits--;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public long getAmountPerOneDisplaying() {
        return amountPerOneDisplaying;
    }
}
