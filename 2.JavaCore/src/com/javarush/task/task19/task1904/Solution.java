package com.javarush.task.task19.task1904;

/* 
И еще один адаптер
*/

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner{
        private Scanner fileScanner = null;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws  ParseException {
            String s = fileScanner.nextLine();
            String[] str = s.split(" ");
            String d = s.replaceAll("\\D","");
            GregorianCalendar calendar = new GregorianCalendar(Integer.parseInt(str[5]), Integer.parseInt(str[4]) - 1, Integer.parseInt(str[3]));
            Date date = calendar.getTime();
            Person person = new Person(str[1], str[2], str[0], date);
            return person;
        }

        @Override
        public void close() {
            fileScanner.close();
        }
    }
}
