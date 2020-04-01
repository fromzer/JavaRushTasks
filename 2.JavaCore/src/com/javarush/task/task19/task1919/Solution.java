package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {
        String filePath = args[0];
        try {
            countSalaries(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void countSalaries(String path) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(path));
        Map<String,Double> map = new TreeMap<>();
        while (reader.ready()) {
            String[] lineArray = reader.readLine().split(" ");
            String name = lineArray[0];
            Double zarpl = Double.parseDouble(lineArray[1]);
            if (map.containsKey(name)) {
                map.put(name, map.get(name) + zarpl);
            } else {
                map.put(name, zarpl);
            }
        }
        map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey());

        printResult(map);
        reader.close();
    }

    public static void printResult(Map<String, Double> map) {
        for (Map.Entry<String, Double> pairs : map.entrySet()) {
            System.out.println(pairs.getKey() + " " + pairs.getValue());
        }
    }
}
