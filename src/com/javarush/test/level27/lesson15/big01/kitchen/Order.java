package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.Tablet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ilya on 07.04.2015.
 */
public class Order
{
    public Tablet tablet;
    public List<Dish> dishes = new ArrayList<>();

    public Order(Tablet tablet) throws IOException
    {
        this.tablet = tablet;
        this.dishes = ConsoleHelper.getAllDishesForOrder();
    }

    public boolean isEmpty() {
        return dishes.isEmpty();
    }

    public int getTotalCookingTime(){
        int totalTime = 0;
        for(Dish dish : dishes){
            totalTime += dish.getDuration();
        }
        return  totalTime;
    }

    @Override
    public String toString()
    {
        return dishes.isEmpty() ? "" : "Your order: " + dishes.toString() + " of " + tablet.toString();
    }
}
