package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут
        SimpleDateFormat oldTime = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        SimpleDateFormat newTime = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

        switch (args[0]) {
            case ("-c"):
                if (args[2].equals("м")) {
                    allPeople.add(Person.createMale(args[1], oldTime.parse(args[3])));
                    System.out.println(allPeople.size() - 1); }
                else if (args[2].equals("ж")) {
                    allPeople.add(Person.createFemale(args[1], oldTime.parse(args[3])));
                    System.out.println(allPeople.size() - 1); }
                break;
            case ("-u"):
                if (args[3].equals("м"))
                    allPeople.set(Integer.parseInt(args[1]), Person.createMale(args[2], oldTime.parse(args[4])));
                else if (args[3].equals("ж"))
                    allPeople.set(Integer.parseInt(args[1]), Person.createFemale(args[2], oldTime.parse(args[4])));
                break;
            case ("-d"):
                int id = Integer.parseInt(args[1]);
                allPeople.get(id).setName(null);
                allPeople.get(id).setSex(null);
                allPeople.get(id).setBirthDate(null);
                break;
            case ("-i"):
                Person person = allPeople.get(Integer.parseInt(args[1]));
                System.out.println(person.getName() + " " + (person.getSex().equals(Sex.MALE)? "м" : "ж") + " " + newTime.format(person.getBirthDate()));
                break;
            }


    }
}
