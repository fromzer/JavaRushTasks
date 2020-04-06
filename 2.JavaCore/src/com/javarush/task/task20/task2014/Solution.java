package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/
public class Solution implements Serializable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println(new Solution(4));

        FileOutputStream outputStream = new FileOutputStream("d:\\Fromzer\\1.txt");
        ObjectOutputStream oos = new ObjectOutputStream(outputStream);
        Solution saveObject = new Solution(7);
        oos.writeObject(saveObject);
        outputStream.close();
        oos.close();

        FileInputStream inputStream = new FileInputStream("d:\\Fromzer\\1.txt");
        ObjectInputStream ois = new ObjectInputStream(inputStream);
        Object object = ois.readObject();
        inputStream.close();
        ois.close();

        Solution loadObject = (Solution)object;

        System.out.println(saveObject.equals(loadObject));
    }

    private transient final String pattern = "dd MMMM yyyy, EEEE";
    private transient Date currentDate;
    private transient int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and the current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
