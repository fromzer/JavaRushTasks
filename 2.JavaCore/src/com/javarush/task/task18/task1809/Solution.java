package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileInputStream inputStream = new FileInputStream(reader.readLine());
        FileOutputStream outputStream = new FileOutputStream(reader.readLine());

        byte[] buffer = new byte[inputStream.available()];
        if (inputStream.available() > 0) {
            inputStream.read(buffer);
        }

        for (int i = buffer.length - 1; i >= 0 ; i--) {
            outputStream.write(buffer[i]);
        }
        inputStream.close();
        outputStream.close();
    }
}
