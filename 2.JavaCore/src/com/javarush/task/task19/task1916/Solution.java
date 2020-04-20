package com.javarush.task.task19.task1916;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();
    public static ArrayList<String> f1 = new ArrayList<>();
    public static ArrayList<String> f2 = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader file1 = new BufferedReader(new FileReader(bufferedReader.readLine()));
        BufferedReader file2 = new BufferedReader(new FileReader(bufferedReader.readLine()));
        bufferedReader.close();

        writeInList(file1, f1);
        writeInList(file2, f2);

        for (int i = 0; i<f1.size() && i<f2.size();i++) {
            try {
                if (f1.get(i).equals(f2.get(i))) {
                    lines.add(new LineItem(Type.SAME, f2.get(i)));
                    f1.remove(i);
                    f2.remove(i);
                    i--;
                } else if (!f1.get(i).equals(f2.get(i)) && !f1.get(i).equals(f2.get(i + 1))) {
                    lines.add(new LineItem(Type.REMOVED, f1.get(i)));
                    f1.remove(i);
                    i--;
                } else if (!f1.get(i).equals(f2.get(i)) && f1.get(i).equals(f2.get(i + 1))) {
                    lines.add(new LineItem(Type.ADDED, f2.get(i)));
                    f2.remove(i);
                    i--;
                }
            }
            catch (ArrayIndexOutOfBoundsException e) {
                lines.add(new LineItem(Type.REMOVED, f1.get(i)));
                f1.remove(i);
                i--;
            }
        }

        while (!f1.isEmpty()) {
            lines.add(new LineItem(Type.REMOVED, f1.get(0)));
            f1.remove(0);
        }
        while (!f2.isEmpty()) {
            lines.add(new LineItem(Type.ADDED, f2.get(0)));
            f2.remove(0);
        }

        for (LineItem t : lines) {
            System.out.println(t.line +" "+ t.type);
        }


        file1.close();
        file2.close();
    }

    public static Boolean trackСhanges(String line1, String line2) {

        return true;
    }

    public static void writeInList(BufferedReader reader, ArrayList<String> list) throws IOException {
        while (reader.ready()) {
            list.add(reader.readLine());
        }
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
