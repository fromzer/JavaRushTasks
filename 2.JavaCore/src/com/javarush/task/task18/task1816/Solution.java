package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    private static int count = 0;
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream(args[0]);
        checkEnglish(inputStream);
        System.out.println(count);
        inputStream.close();
    }
    public static void checkEnglish(FileInputStream inputStream) throws IOException {
        byte[] buffer = new byte[inputStream.available()];
        if (inputStream.available() > 0)
            inputStream.read(buffer);

        for (int i = 0; i < buffer.length; i++) {
            if (((buffer[i] >= 65) && (buffer[i] <= 90)) || ((buffer[i] >= 97)&&(buffer[i] <= 122)))
                count++;
        }
    }
}
