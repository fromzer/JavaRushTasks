package com.javarush.task.task14.task1408;                                                                                                    
                                                                                                    
public class RussianHen extends Hen{                                                  
                                                  
    public int getCountOfEggsPerMonth() {                                                  
        return 100;                                                                                            
    }   

    @Override
    String getDescription() {
        return (super.getDescription() + " Моя страна - " + Country.RUSSIA + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.");
    }                                                                                                    
}