package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str;
        FileInputStream inputStream = null;
        try {

            while (true) {
                str = reader.readLine();
                try {
                    inputStream = new FileInputStream(str);
                    inputStream.close();
                } catch (FileNotFoundException e) {
                    System.out.println(str);
                    break;
                }
            }
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
}
