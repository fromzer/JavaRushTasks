package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(reader.readLine());
        FileOutputStream outputStream1 = new FileOutputStream(reader.readLine());
        FileOutputStream outputStream2 = new FileOutputStream(reader.readLine());

        byte[] buffer = new byte[inputStream.available()];
        if (inputStream.available() > 0)
            inputStream.read(buffer);

        if (buffer.length % 2 != 0) {
            outputStream1.write(buffer, 0, buffer.length / 2 + 1);
            outputStream2.write(buffer, buffer.length / 2 + 1, buffer.length/2);
        } else {
            outputStream1.write(buffer, 0, buffer.length / 2);
            outputStream2.write(buffer, buffer.length / 2, buffer.length/2);
        }
        inputStream.close();
        outputStream1.close();
        outputStream2.close();
    }
}
