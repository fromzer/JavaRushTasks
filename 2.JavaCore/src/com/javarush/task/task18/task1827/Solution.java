package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        int maxID = 0;
        BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        maxID = 0;
        while (fileReader.ready()) {
            String someString = fileReader.readLine();

            if (!someString.equals("")) {
                String substringString = someString.substring(0, 8);
                int id;
                if (someString.contains(" ")) {
                    id = Integer.parseInt(substringString.split(" ")[0]);
                } else id = Integer.parseInt(someString);
                if (id > maxID) maxID = id;
            }
        }


        if (args.length != 0) {
            if ((args[0].equals("-c"))) {
                String productName = args[1];
                double price = Double.parseDouble(args[2]);
                int quantity = Integer.parseInt(args[3]);
                int id = ++maxID;
                String fullString = String.format("%n%-8d%-30s%-8.2f%-4d", id, productName, price, quantity);
                byte[] buffer = fullString.getBytes();
                OutputStream outputStream = new FileOutputStream(fileName, true);
                outputStream.write(buffer);
                outputStream.flush();
                outputStream.close();
            }
        }
        fileReader.close();
        reader.close();
    }
}
