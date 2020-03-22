package com.javarush.task.task15.task1529;                                                  
                                                  
/*                                                   
Осваивание статического блока                                                  
*/                                                  
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
                                                  
public class Solution {                                                  
    public static void main(String[] args) {                                                  
                                                  
    }                                                  
                                                  
    static {                                                  
        //add your code here - добавьте код тут                                                  
        try {
            reset();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }                                                  
                                                  
    public static CanFly result;                                                  
                                                  
    public static void reset() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        int numOfPass = 0;
        try {
            input = reader.readLine();
            if (input.equals("helicopter")) result = new Helicopter();
            else if (input.equals("plane")) {
                numOfPass = Integer.parseInt(reader.readLine());
                result = new Plane(numOfPass);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            reader.close();
        }                                                  
        //add your code here - добавьте код тут                                                  
    }                                                  
}