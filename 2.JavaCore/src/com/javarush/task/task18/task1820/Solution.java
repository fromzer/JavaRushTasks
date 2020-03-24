package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        File filePath1 = new File(reader.readLine());
        File filePath2 = new File(reader.readLine());
        fileDoubleInFileInteger(filePath1, filePath2);
    }

    public static void fileDoubleInFileInteger(File fileDouble, File fileInteger) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileDouble));
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileInteger));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] numbers = line.split(" ");
            for (String num : numbers) {
                    int result = Math.toIntExact(Math.round(Double.parseDouble(num)));
                    writer.write(result + " ");
            }
        }
        reader.close();
        writer.close();
    }
}
