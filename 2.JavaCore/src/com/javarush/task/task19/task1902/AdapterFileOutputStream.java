package com.javarush.task.task19.task1902;

/* 
Адаптер
*/

import java.io.FileOutputStream;
import java.io.IOException;

public class AdapterFileOutputStream implements AmigoStringWriter {
    private FileOutputStream fileOutputStream = null;

    public static void main(String[] args) {

    }

    public AdapterFileOutputStream(FileOutputStream fileOutputStream) {
        this.fileOutputStream = fileOutputStream;
    }

    @Override
    public void flush() throws IOException {
        fileOutputStream.flush();
    }

    @Override
    public void writeString(String s) throws IOException {
        byte[] cbuff = s.getBytes();
        fileOutputStream.write(cbuff);
    }

    @Override
    public void close() throws IOException {
        fileOutputStream.close();
    }
}

