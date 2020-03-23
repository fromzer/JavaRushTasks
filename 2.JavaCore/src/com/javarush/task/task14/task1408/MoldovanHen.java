package com.javarush.task.task14.task1408;                                                                                                    
                                                                                                    
public class MoldovanHen extends Hen {                                                                                                    
    public int getCountOfEggsPerMonth() {                                                  
        return 70;                                                                                            
    }   

    @Override
    String getDescription() {
        return (super.getDescription() + " Моя страна - " + Country.MOLDOVA + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.");
    }                                                                                                   
}