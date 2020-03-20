package com.javarush.task.task18.task1805;                                                  
                                                  
/*                                                   
Сортировка байт                                                  
*/                                                  
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(reader.readLine());
        ArrayList<Integer> list = new ArrayList<Integer>();

        while (inputStream.available() > 0) {
            int data = inputStream.read();
            if (!list.contains(data))
                list.add(data);
        }
        inputStream.close();

        Collections.sort(list);

        for (Integer l : list)
            System.out.print(l + " ");
    }
}