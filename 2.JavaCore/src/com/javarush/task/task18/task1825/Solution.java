package com.javarush.task.task18.task1825;

/* 
Собираем файл
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader readerConsole = new BufferedReader(new InputStreamReader(System.in));
        String pathWrite = "";
        String str;
        ArrayList<String> listPath = new ArrayList<>();

        while (!(str = readerConsole.readLine()).equals("end")) {
            listPath.add(str);
        }
        if (listPath.size() > 0) {
            pathWrite = listPath.get(0).replaceAll("\\.part+.+", "");
        }
        Collections.sort(listPath);
        FileOutputStream outputStream = new FileOutputStream(pathWrite, true);
        for (String filePath : listPath) {
            BufferedReader fileReader = new BufferedReader(new FileReader(filePath));
            while (fileReader.ready()) {
                String line = fileReader.readLine();
                byte[] byteArray = line.getBytes();
                outputStream.write(byteArray);
            }
            fileReader.close();
        }
        outputStream.close();
    }
}
