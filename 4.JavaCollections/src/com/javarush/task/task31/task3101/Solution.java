package com.javarush.task.task31.task3101;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;


/*
Проход по дереву файлов
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        File path = new File(args[0]);
        File resultFileAbsolutePath = new File(args[1]);
        File newResultFile = new File(resultFileAbsolutePath.getParent() + "/allFilesContent.txt");

        FileUtils.renameFile(resultFileAbsolutePath, newResultFile);

        BufferedWriter writer = new BufferedWriter(new FileWriter(newResultFile, true));
        ArrayList<File> list = new ArrayList<>();
        fileList(path, list);
        Collections.sort(list);
        writeToFile(writer, list);
        writer.close();
    }
    public static void fileList(File path, ArrayList<File> list) {
        for (File file : path.listFiles()) {
            if (!file.isDirectory()) {
                if (file.length() <= 50) {
                    list.add(file);
                }
            } else {
                fileList(file, list);
            }
        }
    }

    public static void writeToFile(BufferedWriter writer, ArrayList<File> files) {
        BufferedReader reader = null;
        try {
            for (File file : files) {
                reader = new BufferedReader(new FileReader(file));
                while (reader.ready()) {
                    String line = reader.readLine();
                    writer.write(line);
                }
                writer.write("\n");
                reader.close();
            }
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
