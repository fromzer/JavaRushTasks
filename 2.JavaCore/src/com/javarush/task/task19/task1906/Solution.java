package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            evenSerialNumber(reader);
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

    public static void evenSerialNumber(BufferedReader bufferedReader) throws IOException {
        FileReader reader = new FileReader(bufferedReader.readLine());
        FileWriter writer = new FileWriter(bufferedReader.readLine());
        int i = 1;
        while (reader.ready()) {
            int data = reader.read();
            if (i % 2 == 0) writer.write(data);
            i++;
        }
        reader.close();
        writer.close();
    }
}
