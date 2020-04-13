package com.javarush.task.task22.task2211;

import java.io.*;
import java.nio.charset.Charset;

/* 
Смена кодировки
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        File fileW1251 = new File(args[0]);
        File fileUTF8 = new File(args[1]);

        FileInputStream reader = new FileInputStream(fileW1251);
        FileOutputStream writer = new FileOutputStream(fileUTF8);

        Charset windows1251 = Charset.forName("Windows-1251");
        Charset utf8 = Charset.forName("UTF-8");

        while (reader.available() > 0) {
            byte[] buffer = new byte[1024];
            reader.read(buffer);
            String line = new String(buffer, windows1251 );
            buffer = line.getBytes(utf8);
            writer.write(buffer);
        }
    }
}
