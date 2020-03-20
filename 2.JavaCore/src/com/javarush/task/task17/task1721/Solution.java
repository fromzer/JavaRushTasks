package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        try {
            fileReader(fileName1, allLines);
            fileReader(fileName2, forRemoveLines);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Solution sol = new Solution();
        try {
            sol.joinData();
        } catch (CorruptedDataException e)
        {
            e.printStackTrace();
//            System.out.println(allLines);
//            System.out.println(forRemoveLines);
        }
//        System.out.println(allLines);
//        System.out.println(forRemoveLines);
        reader.close();
    }
    public static void fileReader(String name, List<String> list) throws IOException {
        File file = new File(name);
        FileReader fileReader = new FileReader(file);
        BufferedReader fileBufferedReader = new BufferedReader(fileReader);

        String line = fileBufferedReader.readLine();
        while (line != null) {
            list.add(line);
            line = fileBufferedReader.readLine();
        }
        fileBufferedReader.close();
    }

    public  void joinData() throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines))
            allLines.removeAll(forRemoveLines);
        else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}
