package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        File filePath1 = new File(reader.readLine());
        File filePath2 = new File(reader.readLine());
        writeToFile(filePath2, filePath1);
    }
    public static void writeToFile(File fileIn, File fileOut) throws IOException {
        FileInputStream file1Read = new FileInputStream(fileOut);
        byte[] buffer1 = new byte[file1Read.available()];
        if (file1Read.available() > 0) {
            file1Read.read(buffer1);
        }

        FileOutputStream file1 = new FileOutputStream(fileOut);
        FileInputStream file2 = new FileInputStream(fileIn);

        byte[] buffer2 = new byte[file2.available()];
        if (file2.available() > 0) {
            file2.read(buffer2);
        }

        file1.write(buffer2);
        file1.write(buffer1);

        file1Read.close();
        file1.close();
        file2.close();
    }
}
