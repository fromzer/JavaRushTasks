package com.javarush.task.task14.task1417;                                                  
                                                  
import java.util.ArrayList;                                                  
import java.util.List;                                                  
                                                  
/*                                                   
Валюты                                                  
*/                                                  
                                                  
public class Solution {                                                  
    public static void main(String[] args) {                                                  
        Person ivan = new Person("Иван");                                                  
        for (Money money : ivan.getAllMoney()) {                                                  
            System.out.println(ivan.name + " имеет заначку в размере " + money.getAmount() + " " + money.getCurrencyName());                                                  
        }                                                  
    }                                                  
                                                  
    static class Person {                                                  
        public String name;                                                  
                                                  
        Person(String name) {                                                  
            this.name = name;                                                  
            this.allMoney = new ArrayList<Money>(); 
            allMoney.add(new Hrivna(26.7)); 
            allMoney.add(new Ruble(11.1));
            allMoney.add(new USD(2.2));                                                 
            //напишите тут ваш код                                                  
        }                                                  
                                                  
        private List<Money> allMoney;                                                  
                                                  
        public List<Money> getAllMoney() {                                                  
            return allMoney;                                                  
        }                                                  
    }                                                  
}