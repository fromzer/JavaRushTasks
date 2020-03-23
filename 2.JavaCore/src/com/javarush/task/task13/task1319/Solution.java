package com.javarush.task.task13.task1319;                                                  
                                                  
import java.io.*;                                                  
                                               
                                                  
/*                                                   
Писатель в файл с консоли                                                  
*/                                                  
                                                  
public class Solution {                                                  
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filePath = reader.readLine(); 
        String consoleStr = "";
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;

        try {
            fileWriter = new FileWriter(filePath);
            bufferedWriter = new BufferedWriter(fileWriter);

            while(!(consoleStr = reader.readLine()).equals("exit"))
                bufferedWriter.write(consoleStr + "\n");

            bufferedWriter.write(consoleStr + "\n");

        } catch (Exception e)  {
            e.printStackTrace();
        } finally {
            bufferedWriter.close();
            reader.close();
            fileWriter.close();
        }                                           
        // напишите тут ваш код                                                  
    }                                                  
}