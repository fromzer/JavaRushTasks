package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) {
        if (string == null) throw new TooShortStringException();

        char[] charArrStr = string.toCharArray();
        int check = 0;
        for (char chars : charArrStr) {
            if (chars == ' ') check++;
        }

        int count = 4;
        String[] strArr = string.split(" ");
        StringBuilder result = new StringBuilder();

        if (check < count) {
            throw new TooShortStringException();
        } else {
            for (int i = 1; i < count+1; i++) {
                result.append(strArr[i] + " ");
            }
        }

        return result.toString().trim();
    }

    public static class TooShortStringException extends RuntimeException{
    }
}
