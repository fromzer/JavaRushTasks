package com.javarush.task.task13.task1326;                                                  
import java.io.*;  
import java.util.*;                                                
/*                                                   
Сортировка четных чисел из файла                                                  
*/                                                  
                                                  
public class Solution {                                                  
    public static void main(String[] args) throws IOException  {                                                  
        // напишите тут ваш код 
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        String filePath = consoleReader.readLine();

        FileInputStream fileInputStream = new FileInputStream(filePath);
        BufferedReader reader = new BufferedReader(new InputStreamReader(fileInputStream));

        ArrayList<Integer> arrayList = new ArrayList<>();

        while (reader.ready())
        {
            String str = reader.readLine();
                int number = Integer.parseInt(str);
                if (number % 2 == 0)
                    arrayList.add(number);
        }

        Collections.sort( arrayList);
        for (Integer lst : arrayList)
            System.out.println(lst);

        reader.close();
        fileInputStream.close();
        consoleReader.close();
    }                                                  
}