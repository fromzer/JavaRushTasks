package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            selectNumber(reader);
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

    public static void selectNumber(BufferedReader bufferedReader) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(bufferedReader.readLine()));
        BufferedWriter writer = new BufferedWriter(new FileWriter(bufferedReader.readLine()));

        while (reader.ready()) {
            String str= reader.readLine();
            String[] arrStr = str.split(" ");
            for (String arrS : arrStr) {
                try {
                    long number = Long.parseLong(arrS);
                    writer.write(number + " ");
                } catch (NumberFormatException e) {}
            }
        }
        reader.close();
        writer.close();
    }
}
