package com.javarush.task.task15.task1527;

/* 
Парсер реквестов
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        URL url = new URL(reader.readLine());
        LinkedHashMap<String,String> map = new LinkedHashMap<>();
        String[] arr = url.getQuery().split("&");

        for (int i = 0; i < arr.length; i++) {
            String[] subArr = arr[i].split("=");
                String key = subArr[0];
                String val = "null";
                if (subArr.length > 1)
                    val = subArr[1];
                map.put(key, val);
        }

        for (HashMap.Entry<String,String> m : map.entrySet()) {
            System.out.print(m.getKey() + " ");
        }
        System.out.println();

        for (Map.Entry<String,String> m : map.entrySet()) {
            if (m.getKey().contains("obj")) {
                try {
                    alert(Double.parseDouble(m.getValue()));
                } catch (NumberFormatException e) {
                    alert((String) m.getValue());
                }
            }
        }
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
