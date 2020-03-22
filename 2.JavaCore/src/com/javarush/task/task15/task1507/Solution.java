package com.javarush.task.task15.task1507;                                                  
                                                  
/*                                                   
ООП - Перегрузка                                                  
*/                                                  
                                                  
public class Solution {                                                  
    public static void main(String[] args) {                                                  
        printMatrix(2, 3, "8");                                                  
    }                                                  
                                                  
    public static void printMatrix(int m, int n, String value) {                                                  
        System.out.println("Заполняем объектами String");                                                  
        printMatrix(m, n, (Object) value);                                                  
    }                                                  
  
    //2
    public static void printMatrix(int m, short n, String value) {
        System.out.println("Заполняем объектами String");
        printMatrix(m,n,value);
    }
    //3
    public static void printMatrix(short m, int n, String value) {
        System.out.println("Заполняем объектами String");
        printMatrix(m,n,value);
    }
    //4
    public static void printMatrix(short m, short n, String value) {
        System.out.println("Заполняем объектами String");
        printMatrix(m,n,value);
    }
    //5
    public static void printMatrix(int m, int n, int value) {
        System.out.println("Заполняем объектами String");
        printMatrix(m,n,value);
    }
    //6
    public static void printMatrix(int m, int n, short value) {
        System.out.println("Заполняем объектами String");
        printMatrix(m,n,value);
    }
    //7
    public static void printMatrix(int m, int n, long value) {
        System.out.println("Заполняем объектами String");
        printMatrix(m,n,value);
    }
    //8
    public static void printMatrix(long m, int n, String value) {
        System.out.println("Заполняем объектами String");
        printMatrix(m,n,value);
    }
    //9
    public static void printMatrix(long m, long n, String value) {
        System.out.println("Заполняем объектами String");
        printMatrix(m,n,value);
    }
                                                
    public static void printMatrix(int m, int n, Object value) {                                                  
        for (int i = 0; i < m; i++) {                                                  
            for (int j = 0; j < n; j++) {                                                  
                System.out.print(value);                                                  
            }                                                  
            System.out.println();                                                  
        }                                                  
    }                                                  
}