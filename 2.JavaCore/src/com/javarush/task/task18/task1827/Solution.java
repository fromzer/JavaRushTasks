package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        int id = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        File path = new File(reader.readLine());
        id = selectId(path);
        if (args[0] != null) {
            String productName = args[1].length() > 30? args[1].substring(0,30) : args[1];
            while (productName.length() < 30) {
                productName += " ";
            }
            String price = args[2].length() > 8? args[2].substring(0,8) : args[2];
            while (price.length() < 8) {
                price += " ";
            }
            String quantity = args[3].length() > 4? args[3].substring(0,4) :args[3];
            while (quantity.length() < 4) {
                quantity += " ";
            }
            id++;
            String strId = id + "";
            while (strId.length() < 8) {
                strId += " ";
            }
            String resultStr ="\n" + strId + productName + price + quantity;
            writeToFile(resultStr, path);
        }
        reader.close();
    }
    public static int selectId(File path) throws IOException {
        int id = 0, maxId = 0;
        BufferedReader fileReader = new BufferedReader(new FileReader(path));
        while (fileReader.ready()) {
            String str = fileReader.readLine();
            String[] arrStr = str.split(" ");
            id = Integer.parseInt(arrStr[0]);
            if (id > maxId) maxId = id;
        }
        fileReader.close();
        return id;
    }
    public static void writeToFile(String result, File path) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(path, true));
        writer.write(result);
        writer.close();
    }
}
