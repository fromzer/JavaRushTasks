package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            replacementOfSigns(reader);
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
    public static void replacementOfSigns(BufferedReader bufferedReader) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(bufferedReader.readLine()));
        BufferedWriter writer = new BufferedWriter(new FileWriter(bufferedReader.readLine()));
        while (reader.ready()) {
            String str = reader.readLine();
            writer.write(str.replace('.', '!'));
        }
        reader.close();
        writer.close();
    }
}
