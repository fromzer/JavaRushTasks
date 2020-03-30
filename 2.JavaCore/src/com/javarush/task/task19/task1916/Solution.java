package com.javarush.task.task19.task1916;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader file1 = new BufferedReader(new FileReader(bufferedReader.readLine()));
        BufferedReader file2 = new BufferedReader(new FileReader(bufferedReader.readLine()));
        bufferedReader.close();
        boolean check = true;

        while (check) {
            String lineFile1 = "", lineFile2 = "";
            if (file1.ready()) {
                lineFile1 = file1.readLine();
            }
            if (file2.ready()) {
                lineFile2 = file2.readLine();
            }
            
            if (lineFile1.equals(lineFile2)) {
                lines.add(new LineItem(Type.SAME, lineFile1));
            } else if (lineFile1.equals("")) {
                lines.add(new LineItem(Type.ADDED, lineFile2));
            } else if (lineFile2.equals("")) {
                lines.add(new LineItem(Type.REMOVED, lineFile1));
            }

            if (!file1.ready() && !file2.ready()) check = false;
        }

        file1.close();
        file2.close();
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
