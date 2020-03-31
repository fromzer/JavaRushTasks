package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        String filePath1 = args[0];
        String filePath2 = args[1];
        try {
            spellWordsWithNumbers(filePath1, filePath2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void spellWordsWithNumbers(String path1, String path2) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(path1));
        BufferedWriter writer = new BufferedWriter(new FileWriter(path2));

        while (reader.ready()) {
            String[] arrStr = reader.readLine().split(" ");
            String result = "";
            for (String str : arrStr) {
                char[] searchDigit = str.toCharArray();
                for (int i = 0; i < searchDigit.length; i++) {
                    if (Character.isDigit(searchDigit[i])) {
                        result += str + " ";
                        break;
                    }
                }
            }
        writer.write(result);
        }
        reader.close();
        writer.close();
    }
}
