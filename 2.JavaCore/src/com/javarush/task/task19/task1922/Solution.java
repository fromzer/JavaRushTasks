package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            searchNecessaryStrings(reader);
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

    public static void searchNecessaryStrings(BufferedReader bufferedReader) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(bufferedReader.readLine()));
        while (reader.ready()) {
            String str = reader.readLine();
            String[] strArr = str.split(" ");
            ArrayList<String> chek = new ArrayList<>();
            int count = 0;
            for (int i = 0; i < strArr.length; i++) {
                for (int j = 0; j < words.size(); j++) {
                    if (strArr[i].equals(words.get(j)) && !(chek.contains(strArr[i]))) {
                        count ++;
                        chek.add(strArr[i]);
                    }
                }
            }
            if (count == 2) {
                System.out.println(str);
            }
        }
        reader.close();
    }
}
