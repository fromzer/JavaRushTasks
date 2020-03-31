package com.javarush.task.task19.task1924;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();
    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            replacingNumbersWithWords(reader);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void replacingNumbersWithWords(BufferedReader bufferedReader) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(bufferedReader.readLine()));

        while (reader.ready()) {
            String[] strArr = reader.readLine().split(" ");
            for (int i = 0; i < strArr.length; i++) {
                try {
                    if (map.containsKey(Integer.parseInt(strArr[i]))) {
                        strArr[i] = map.get(Integer.parseInt(strArr[i]));
                    }
                } catch (NumberFormatException e) {}
            }
            String result = "";
            for (String str : strArr) {
                result += str + " ";
            }
            System.out.println(result.trim());
        }
        reader.close();
    }
}
