package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream(args[0]);
        int sizeString = inputStream.available(), numberOfSpaces = 0;
        byte[] buffer = new byte[inputStream.available()];
        if (inputStream.available() > 0) inputStream.read(buffer);

        for (int i = 0; i < buffer.length; i++)
            if (buffer[i] == 32) numberOfSpaces++;
        double result = numberOfSpaces/ (double)sizeString * 100;
        System.out.printf("%.2f", result);
        inputStream.close();
    }
}
