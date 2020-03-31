package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) {
        String filePath = args[0];
        try {
            addPersonToList(filePath);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    public static void addPersonToList(String path) throws IOException, ParseException {
        BufferedReader reader = new BufferedReader(new FileReader(path));
        while (reader.ready()) {
            String str = reader.readLine();

            String fio = str.replaceAll("\\d", "");

            String birthday = str.replaceAll("\\D", " ").trim();
            String[] arrBirthday = birthday.split(" ");

            SimpleDateFormat df = new SimpleDateFormat("ddMMyyyy");

            if (arrBirthday[1].length() == 1)
                arrBirthday[1] = 0 + arrBirthday[1];
            if (arrBirthday[0].length() == 1)
                arrBirthday[0] = 0 + arrBirthday[0];

            PEOPLE.add(new Person(fio.trim(), df.parse(arrBirthday[0] + arrBirthday[1] + arrBirthday[2])));
        }
        reader.close();
    }
}
