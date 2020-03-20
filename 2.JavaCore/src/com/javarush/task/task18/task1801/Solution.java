package com.javarush.task.task18.task1801;                                                  
                                                  
/*                                                   
Максимальный байт                                                  
*/  
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;                                                
                                                  
public class Solution {                                                  
    public static void main(String[] args) throws Exception {   
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inS = new FileInputStream(reader.readLine()); 
        int max = Byte.MIN_VALUE;
        
        while (inS.available() > 0) {
            int data = inS.read();
            if (data > max) max = data;
        }    
        inS.close();
        System.out.println(max);                                          
    }                                                  
}