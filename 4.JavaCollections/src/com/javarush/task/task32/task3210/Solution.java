package com.javarush.task.task32.task3210;

/* 
Используем RandomAccessFile
*/

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Solution {
    public static void main(String... args) throws IOException {
        RandomAccessFile raf = new RandomAccessFile(args[0], "rw");
        int lengthText = args[2].length();
        int dotStartRead = Integer.parseInt(args[1]);

        raf.seek(Long.parseLong(args[1]));
        byte[] buffer = new byte[lengthText];
        raf.read(buffer, 0, lengthText);
        String strFile = new String(buffer);

        raf.seek(raf.length());
        String bool = strFile.equals(args[2]) ? "true" : "false";
        raf.write(bool.getBytes());
        raf.close();
    }
}
