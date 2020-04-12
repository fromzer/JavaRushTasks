package com.javarush.task.task32.task3201;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/*
Запись в существующий файл
*/
public class Solution {
    public static void main(String... args) {
        try (RandomAccessFile raf = new RandomAccessFile(args[0], "rw");){

            if (raf.length() < Long.parseLong(args[1])) {
                raf.seek(raf.length());
            } else {
                raf.seek(Long.parseLong(args[1]));
            }
            raf.write(args[2].getBytes());
            //raf.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}