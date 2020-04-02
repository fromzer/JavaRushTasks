package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader readerConsole = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> listPath = new ArrayList<>();
        String str;
        while (!(str = readerConsole.readLine()).equals("exit")) {
            listPath.add(str);
        }
        readerConsole.close();

        for (String fileName : listPath) {
            new ReadThread(fileName).start();
        }
    }

    public static class ReadThread extends Thread {
        private String fileName;
        public ReadThread(String fileName) {
            super(fileName);
            this.fileName = fileName;
        }

        @Override
        public void run() {
            try {
                FileInputStream inputStream = new FileInputStream(fileName);
                ArrayList<Integer> list = new ArrayList<Integer>();
                int max = Byte.MIN_VALUE;

                while (inputStream.available() > 0)
                {
                    list.add(inputStream.read()) ;
                }
                inputStream.close();
                int value = list.get(0);
                for (int i = 0; i < list.size(); i++) {
                    int count = Collections.frequency(list, list.get(i));
                    if (count > max) {
                        max = count;
                        value = list.get(i);
                    }
                }
                synchronized (resultMap) {
                    resultMap.put(fileName, value);
                }
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // implement file reading here - реализуйте чтение из файла тут
    }
}
