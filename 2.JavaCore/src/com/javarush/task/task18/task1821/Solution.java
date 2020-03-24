package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {
        String filename = args[0];
        try {
            howOftenAreCharacters(filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void howOftenAreCharacters(String filename) throws IOException {
        Map<Character, Integer> map = new TreeMap<>();
        FileInputStream inputStream = new FileInputStream(filename);
        while (inputStream.available() > 0) {
            char current = (char)inputStream.read();
            if (map.containsKey(current))
                map.put(current, map.get(current) + 1);
            else
                map.put(current, 1);
        }
        for (Map.Entry<Character, Integer> pair : map.entrySet())
            System.out.println(pair.getKey() + " " + pair.getValue());
        inputStream.close();
    }

}
