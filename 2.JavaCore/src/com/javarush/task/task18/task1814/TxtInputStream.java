package com.javarush.task.task18.task1814;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/* 
UnsupportedFileName
*/

public class TxtInputStream extends FileInputStream {
    public TxtInputStream(File file) throws FileNotFoundException {
        super(file);
    }

    // public TxtInputStream(String fileName) {
    //}

    public static void main(String[] args) {
    }
}

