package com.javarush.task.task16.task1632;                                                                                                                                                      
                                                                                                                                                      
import java.io.BufferedReader;                                                  
import java.io.IOException;                                                  
import java.io.InputStreamReader;                                                  
import java.util.ArrayList;                                                  
import java.util.List;                                                                                                                                                     
                                                                                                                                                      
public class Solution {                                                                                                                                                      
    public static List<Thread> threads = new ArrayList<>(5);                                                                                                                                                      
                                                          
    static {                                                  
        threads.add(new Thread1());                                                  
        threads.add(new Thread2());                                                  
        threads.add(new Thread3());                                                  
        threads.add(new Thread4());                                                  
        threads.add(new Thread5());                                                  
    }                                                  
                                                      
                                                                                                                                              
    public static void main(String[] args) {                                                    
        threads.get(0).start();                                                  
        threads.get(1).start();                                                  
        threads.get(1).interrupt();                                                  
        threads.get(2).start();                                                  
        threads.get(3).start();                                                  
        threads.get(4).start();                                                                                                                                                   
    }                                                       
                                                  
    public static class Thread1 extends Thread {                                                  
        @Override                                                  
        public void run() {                                                  
            while (true){                                                  
            }                                                  
        }                                                  
    }                                                  
                                                  
    public static class Thread2 extends Thread {                                                  
        @Override                                                  
        public void run() {                                                  
            try {                                                  
                throw new InterruptedException();                                                  
            } catch (InterruptedException e) {                                                  
                System.out.println("InterruptedException");                                                  
            }                                                  
        }                                                  
    }                                                  
                                                  
    public static class Thread3 extends Thread {                                                  
        @Override                                                  
        public void run() {                                                  
            while (true)                                                  
                try {                                                  
                                                                      
                    System.out.println("Ура"); 
                    Thread.sleep(500);                                                 
                } catch (InterruptedException e){                                                  
                    e.printStackTrace();                                                  
                }                                                  
        }                                                  
    }                                                  
                                                  
    public static class Thread4 extends Thread implements Message{   
        boolean repeat = true;                                               
        @Override                                                  
        public void showWarning() {                                                  
            repeat = false;                                                  
        }                                                  
                                                  
        @Override                                                  
        public void run() { 
            while (repeat) {
               
            }                                                
                                                                  
        }                                                  
    }                                                  
                                                  
    public static class Thread5 extends Thread {                                                  
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));                                                  
                                                  
        @Override                                                  
        public void run() {                                                  
            int dig = 0;                                                  
            String str = "";                                                  
                                                  
            while (true) {                                                  
                try {                                                  
                    str = reader.readLine();                                                  
                } catch (IOException e) {                                                  
                    e.printStackTrace();                                                  
                }                                                  
                if (str.equals("N")) break;                                                  
                else {                                                  
                    dig += Integer.parseInt(str);                                                  
                }                                                  
            }                                                  
            try {                                                  
                reader.close();                                                  
            } catch (IOException e) {                                                  
                e.printStackTrace();                                                  
            }                                                  
            System.out.println(dig);                                                  
        }                                                  
    }                                                  
}