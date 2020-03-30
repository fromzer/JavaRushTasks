package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            fileContentsReverse(reader);
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
    public static void fileContentsReverse(BufferedReader bufferedReader) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(bufferedReader.readLine()));

        while (reader.ready()) {
            StringBuilder sb = new StringBuilder();
            sb.append(reader.readLine());
            System.out.println(sb.reverse().toString());
        }
        reader.close();
    }
}
