package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

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
                for (int i = 1; i < args.length; i = i + 3) {
                    if (args[i + 1].equals("м")) {
                        allPeople.add(Person.createMale(args[i], oldTime.parse(args[i + 2])));
                        System.out.println(allPeople.size() - 1);
                    }
                    else if (args[i + 1].equals("ж")) {
                        allPeople.add(Person.createFemale(args[i], oldTime.parse(args[i + 2])));
                        System.out.println(allPeople.size() - 1);
                    }
                }
                break;
            case ("-u"):
                for (int i = 1; i < args.length; i = i + 4) {
                    if (args[i + 2].equals("м"))
                        allPeople.set(Integer.parseInt(args[i]), Person.createMale(args[i + 1], oldTime.parse(args[i + 3])));
                    else if (args[i + 2].equals("ж"))
                        allPeople.set(Integer.parseInt(args[i]), Person.createFemale(args[i + 1], oldTime.parse(args[i + 3])));
                }
                break;
            case ("-d"):
                for (int i = 1; i < args.length; i++) {
                    int id = Integer.parseInt(args[i]);
                    allPeople.get(id).setName(null);
                    allPeople.get(id).setSex(null);
                    allPeople.get(id).setBirthDate(null);
                }
                break;
            case ("-i"):
                for (int i = 1; i < args.length; i++) {
                    Person person = allPeople.get(Integer.parseInt(args[i]));
                    System.out.println(person.getName() + " " + (person.getSex().equals(Sex.MALE) ? "м" : "ж") + " " + newTime.format(person.getBirthDate()));
                }
                break;
        }

    }
}
