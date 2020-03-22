package com.javarush.task.task15.task1514;                                                  
                                                  
import java.util.HashMap;                                                  
import java.util.Map;                                                  
                                                  
/*                                                   
Статики-1                                                  
*/                                                  
                                                  
public class Solution {                                                  
    public static Map<Double, String> labels = new HashMap<Double, String>(); 
      static{  
        labels.put(1.0, "one");
        labels.put(1.1,"two");
        labels.put(1.2,"three"); 
        labels.put(1.3,"four");
        labels.put(1.4,"five"); 
      }                                                          
                                                  
    public static void main(String[] args) {  
                                   
        System.out.println(labels);                                                  
    }                                                  
}