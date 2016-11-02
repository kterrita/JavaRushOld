package com.javarush.test.level27.lesson15.big01;


import com.javarush.test.level27.lesson15.big01.kitchen.Cook;
import com.javarush.test.level27.lesson15.big01.kitchen.Waitor;

import java.util.Locale;


/**
 * Created by ilya on 07.04.2015.
 */
public class Restaurant
{
    public static void main(String[] args)
    {
        Locale.setDefault(Locale.ENGLISH);
        Tablet tablet = new Tablet(5);
        Cook cook = new Cook("Amigo");
        tablet.addObserver(cook);
        Waitor waitor = new Waitor();
        cook.addObserver(waitor);
        tablet.createOrder();
    }
}
