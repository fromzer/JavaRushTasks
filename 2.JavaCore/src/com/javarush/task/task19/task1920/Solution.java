package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        String filePath = args[0];
        try {
            findTheRichest(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void findTheRichest(String path) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(path));
        Map<String, Double> map = new HashMap<>();
        while (reader.ready()) {
            String line = reader.readLine();
            String name = line.replaceAll(" (-)?\\d+(\\.)?(\\d+)?", "").trim();
            String money = line.replaceAll("\\D+ ", "").trim();

            if (map.containsKey(name)) {
                map.put(name, map.get(name) + Double.parseDouble(money));
            } else {
                map.put(name, Double.parseDouble(money));
            }
        }
        ArrayList<String> result = new ArrayList<>();
        for (Map.Entry<String, Double> pair : map.entrySet()) {
            String key = pair.getKey();
            double value = pair.getValue();
            if (value == maxValue(map))
                result.add(key);
        }
        sortAndPrintResult(result);
        reader.close();
    }
    public static Double maxValue(Map<String, Double> map) {
        double max = Double.MIN_VALUE;
        for (Map.Entry<String, Double> pair : map.entrySet()) {
            String key = pair.getKey();
            double value = pair.getValue();
            if (value > max) max = value;
        }
        return max;
    }
    public static void sortAndPrintResult(ArrayList<String> result) {
        Collections.sort(result);
        for (String res : result) {
            System.out.println(res);
        }
    }
}
