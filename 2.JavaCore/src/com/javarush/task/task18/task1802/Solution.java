package com.javarush.task.task18.task1802;                                                  
                                                  
/*                                                   
Минимальный байт                                                  
*/                                                  
                                                  
import java.io.BufferedReader;                                                  
import java.io.InputStreamReader;                                                  
import java.io.FileInputStream;                                                                                                  
                                                                                                    
public class Solution {                                                                                                    
    public static void main(String[] args) throws Exception {                                                     
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));                                                  
        FileInputStream inS = new FileInputStream(reader.readLine());                                                   
        int min = inS.read();                                                  
                                                          
        while (inS.available() > 0) {                                                  
            int data = inS.read();                                                  
            if (data < min) min = data;                                                  
        }                                                      
        inS.close();                                                  
        System.out.println(min);                                                                                            
    }                                                                                                    
}