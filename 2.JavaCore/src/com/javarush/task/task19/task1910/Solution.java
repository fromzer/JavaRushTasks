package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            removePunctuationMarks(reader);
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

    public static void removePunctuationMarks(BufferedReader bufferedReader) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(bufferedReader.readLine()));
        BufferedWriter writer = new BufferedWriter(new FileWriter(bufferedReader.readLine()));
        while (reader.ready()) {
            String str = reader.readLine();
            writer.write(str.replaceAll("\\p{Punct}", ""));
        }
        reader.close();
        writer.close();
    }
}
