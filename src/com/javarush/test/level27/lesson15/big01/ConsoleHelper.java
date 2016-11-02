package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ilya on 07.04.2015.
 */
public class ConsoleHelper
{
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message){
        System.out.println(message);
    }

    public static String readString() {
        String message = "";
        try {
            message = reader.readLine();
        } catch(IOException ignored) {

        }
        return message;
    }

    public static List<Dish> getAllDishesForOrder() {
        writeMessage("Choose the dishes " + Dish.allDishesToString());
        List<Dish> dishes = new ArrayList<>();

        while(true)
        {
            String s1 = readString();
            if (s1.equalsIgnoreCase("exit"))
            {
                break;
            }
            try {
                Dish dish = Dish.valueOf(s1);
                dishes.add(dish);
            } catch (Exception e) {
                writeMessage(s1 + " is not detected");
            }
        }
        return dishes;
    }
}
