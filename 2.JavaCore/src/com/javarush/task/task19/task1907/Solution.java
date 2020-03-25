package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            readTheWord(reader);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void readTheWord(BufferedReader bufferedReader) throws IOException {
        BufferedReader buffer = new BufferedReader(new FileReader(bufferedReader.readLine()));
        int count = 0;
        while (buffer.ready()) {
            String s = buffer.readLine();
            String[] arrStr = s.split("[ ?!:;.,]");
            for (String ar : arrStr)
                if (ar.equals("world")) count++;
        }
        System.out.println(count);
        buffer.close();
    }
}
