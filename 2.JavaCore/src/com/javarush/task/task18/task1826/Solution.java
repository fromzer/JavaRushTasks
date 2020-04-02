package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;
        switch (args[0]) {
            case ("-e"):
                inputStream = new FileInputStream(args[1]);
                outputStream = new FileOutputStream(args[2]);
                while (inputStream.available() > 0) {
                    int b = inputStream.read() - 1;
                    outputStream.write(b);
                }
                inputStream.close();
                outputStream.close();
                break;
            case ("-d"):
                inputStream = new FileInputStream(args[1]);
                outputStream = new FileOutputStream(args[2]);
                while (inputStream.available() > 0) {
                    int b = inputStream.read() + 1;
                    outputStream.write(b);
                }
                inputStream.close();
                outputStream.close();
                break;
        }
    }
}
