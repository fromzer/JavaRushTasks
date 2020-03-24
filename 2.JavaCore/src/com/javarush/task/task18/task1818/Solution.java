package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileOutputStream file1 = new FileOutputStream(reader.readLine(), true);
        FileInputStream file2 = new FileInputStream(reader.readLine());
        FileInputStream file3 = new FileInputStream(reader.readLine());

        writeToFile(file2, file1);
        writeToFile(file3, file1);

        file1.close();
        file2.close();
        file3.close();
    }
    public static void writeToFile(FileInputStream fileOut, FileOutputStream fileIn) throws IOException {
        byte[] buffer = new byte[fileOut.available()];
        if (fileOut.available() > 0) {
            fileOut.read(buffer);
            fileIn.write(buffer);
        }
    }
}
