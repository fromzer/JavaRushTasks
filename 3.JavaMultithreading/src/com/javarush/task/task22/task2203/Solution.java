package com.javarush.task.task22.task2203;

/* 
Между табуляциями
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException{
        if (string == null) throw new TooShortStringException();
        String result = null;
        String[] str = string.split("\t");
        String s = string.replaceAll("\\t", "");
        if (string.length() - s.length() < 2) {
            throw new TooShortStringException();
        } else {
            result = str[1];
        }
        return result;
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
    }
}
