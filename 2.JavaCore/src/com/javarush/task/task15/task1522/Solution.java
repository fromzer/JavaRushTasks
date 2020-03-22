package com.javarush.task.task15.task1522;                                                                                                    
                                                                                                    
/*                                                                                                     
Закрепляем паттерн Singleton                                                                                                    
*/                                                                                                    
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
                                                                                                    
public class Solution {                                                                                                    
    public static void main(String[] args) {                                                                                                    
                                                                                                    
    }                                                                                                    
                                                                                                    
    public static Planet thePlanet;                                                                                                    
                                                                                                    
    //add static block here - добавьте статический блок тут                                                                                                    
    static {
        readKeyFromConsoleAndInitPlanet();
    }    
                                                                                            
    public static void readKeyFromConsoleAndInitPlanet() {                                                                                                    
        // implement step #5 here - реализуйте задание №5 тут                                                                                                    
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = "";

        try {
            input = reader.readLine();
            if (input.equals(Sun.SUN)) thePlanet = Sun.getInstance();
            else if (input.equals(Earth.EARTH)) thePlanet = Earth.getInstance();
            else if (input.equals(Moon.MOON)) thePlanet = Moon.getInstance();
            else thePlanet = null;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }                                                                                                    
}