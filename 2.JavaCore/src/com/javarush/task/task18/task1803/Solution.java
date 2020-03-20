package com.javarush.task.task18.task1803;                                                  
                                                  
/*                                                   
Самые частые байты                                                  
*/                                                  
                                                  
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Solution  {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(reader.readLine());
        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<Integer> listResult = new ArrayList<Integer>();
        while (inputStream.available() > 0)
        {
            list.add(inputStream.read()) ;
        }
        inputStream.close();

        int max = 0;
        
        for (int i = 0; i < list.size(); i++) {
            int count = Collections.frequency(list, list.get(i));

            if (count >= max) {
                max = count;
                if (!listResult.contains(list.get(i)))
                    listResult.add(list.get(i));
            }
           // max = count > max ? count : max;

        }
        for (Integer l : listResult) 
            System.out.print(l + " ");
    }
}