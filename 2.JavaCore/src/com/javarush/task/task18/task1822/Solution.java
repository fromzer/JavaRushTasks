package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader = new BufferedReader(new FileReader(consoleReader.readLine()));
        int id = Integer.parseInt(args[0]);
        while (reader.ready()) {
            String str = reader.readLine();
            String[] resStr = str.split(" ");
            int strId = 0;
            try {
                strId = Integer.parseInt(resStr[0]);   
            } catch (NumberFormatException e) {}
            if (strId == id) {
                System.out.println(str);
            }
        }
        reader.close();
        consoleReader.close();
    }
}
