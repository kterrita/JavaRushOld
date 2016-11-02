package com.javarush.test.level17.lesson10.bonus02;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;


public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException{
        //start here - начни тут
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        if(args[0].equals("-c"))
        {
            synchronized (Solution.class) {
                for(int i = 1; i<args.length; i = i+3)
                {
                    if(args[i+1].equals("м"))
                    {
                        Person m = Person.createMale(args[i], sdf1.parse(args[i+2]));
                        allPeople.add(m);
                        System.out.println(allPeople.indexOf(m));
                    }
                    else if(args[i+1].equals("ж"))
                    {
                        Person w = Person.createFemale(args[i], sdf1.parse(args[i+2]));
                        allPeople.add(w);
                        System.out.println(allPeople.indexOf(w));
                    }
                }
            }
        }
        else if(args[0].equals("-u"))
        {
            synchronized (Solution.class) {
                for(int i = 1; i<args.length; i = i+4)
                {
                    int id = Integer.parseInt(args[i]);
                    allPeople.get(id).setName(args[i+1]);
                    allPeople.get(id).setBirthDay(sdf1.parse(args[i+3]));
                    if(args[i+2].equals("м"))
                        allPeople.get(id).setSex(Sex.MALE);
                    else if(args[i+2].equals("ж"))
                        allPeople.get(id).setSex(Sex.FEMALE);
                } }
        }
        else if(args[0].equals("-d"))
        {
            synchronized (Solution.class) {
                for(int i = 1; i<args.length; i++)
                {
                    int id = Integer.parseInt(args[i]);
                    allPeople.get(id).setName(null);
                    allPeople.get(id).setBirthDay(null);
                    allPeople.get(id).setSex(null);
                }   }
        }
        else if(args[0].equals("-i"))
        {
            synchronized (Solution.class) {
                for(int i = 1; i<args.length; i++)
                {
                    int id = Integer.parseInt(args[i]);
                    System.out.print(allPeople.get(id).getName() + " ");
                    if(allPeople.get(id).getSex().equals(Sex.MALE))
                        System.out.print("м ");
                    else if(allPeople.get(id).getSex().equals(Sex.FEMALE))
                        System.out.print("ж ");
                    System.out.print(sdf2.format(allPeople.get(id).getBirthDay()) + " ");
                }
            }   }
    }
}
