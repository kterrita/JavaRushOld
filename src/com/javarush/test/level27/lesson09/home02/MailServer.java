package com.javarush.test.level27.lesson09.home02;

import javax.lang.model.util.ElementScanner6;

public class MailServer implements Runnable {
    private Mail mail;

    public MailServer(Mail mail) {
        this.mail = mail;
    }

    @Override
    public void run() {
        try
        {
            long beforeTime = System.currentTimeMillis();
            //сделайте что-то тут - do something here
            synchronized (mail) {
                while (mail.getText() == null) {
                    try {
                        mail.wait();
                    } catch (Exception e) {
                    }
                }
            }
            String name = Thread.currentThread().getName();
            long afterTime = System.currentTimeMillis();
            System.out.format("%s MailServer has got: [%s] in %d ms after start", name, mail.getText(), (afterTime - beforeTime));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
