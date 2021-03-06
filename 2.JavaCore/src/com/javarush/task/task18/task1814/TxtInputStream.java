package com.javarush.task.task18.task1814;

import java.io.*;
import java.nio.channels.FileChannel;

/* 
UnsupportedFileName
*/

public class TxtInputStream extends FileInputStream {

    public TxtInputStream(String fileName) throws IOException, UnsupportedFileNameException {
        super(fileName);
        if (!fileName.endsWith(".txt")) {
            super.close();
            throw new UnsupportedFileNameException();
        }
    }

    public TxtInputStream(FileDescriptor fdObj) {
        super(fdObj);
    }

    public static void main(String[] args) {
    }
}

