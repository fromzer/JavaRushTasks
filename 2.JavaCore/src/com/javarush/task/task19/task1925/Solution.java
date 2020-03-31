package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        String filePath1 = args[0];
        String filePath2 = args[1];
        try {
            searchLongWords(filePath1, filePath2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void searchLongWords(String filePath1, String filePath2) throws IOException {
        FileReader file1 = new FileReader(filePath1);
        FileWriter file2 = new FileWriter(filePath2);
        BufferedReader reader = new BufferedReader(file1);
        String result = "";
        while (reader.ready()) {
            StringBuilder lineFile1 = new StringBuilder();
            lineFile1.append(reader.readLine());
            String[] strArr = lineFile1.toString().split(" ");

            for (int i = 0; i < strArr.length; i++) {
                if (strArr[i].length() > 6)
                    result += strArr[i] + " ";
            }
        }
        file2.write(result.trim().replace(' ', ','));

        reader.close();
        file1.close();
        file2.close();
    }
}
