package com.javarush.test.level26.lesson15.big01;

import java.util.*;

/**
 * Created by ilya on 05.04.2015.
 */
public class CurrencyManipulatorFactory
{
    private static Map<String, CurrencyManipulator> map = new HashMap<>();

    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode)
    {
        if(map.containsKey(currencyCode)){
            return map.get(currencyCode);
        } else {
            map.put(currencyCode, new CurrencyManipulator(currencyCode));
            return map.get(currencyCode);
        }
    }

    public static Collection<CurrencyManipulator> getAllCurrencyManipulators() {
        return map.values();
    }

    private CurrencyManipulatorFactory()
    {

    }
}
