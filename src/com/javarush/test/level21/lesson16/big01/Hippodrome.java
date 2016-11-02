package com.javarush.test.level21.lesson16.big01;


import java.util.ArrayList;

/**
 * Created by ilya on 26.03.2015.
 */
public class Hippodrome
{
    public static ArrayList<Horse> horses = new ArrayList<>();
    public static Hippodrome game;

    public static void main(String[] args) throws InterruptedException
    {
        game = new Hippodrome();

        horses.add(new Horse("A", 3, 0));
        horses.add(new Horse("B", 3, 0));
        horses.add(new Horse("C", 3, 0));

        game.run();
        game.printWinner();
    }

    public void move(){
        for(Horse horse : horses) {
            horse.move();
        }
    }
    public void print(){
        for(Horse horse : horses) {
            horse.print();
        }
        System.out.println();
        System.out.println();
    }
    public void run()throws InterruptedException{
        for (int i = 1; i < 101; i++)
        {
            move();
            print();
            Thread.sleep(100);
        }
    }

    public Horse getWinner() {
        Horse winner = new Horse("Winner", 0, 0);
        for(Horse horse : horses) {
            if(horse.getDistance() > winner.getDistance()) {
                winner = horse;
            }
        }
        return winner;
    }

    public void printWinner() {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }

    public ArrayList<Horse> getHorses()
    {
        return horses;
    }
}
