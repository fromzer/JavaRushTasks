package com.javarush.task.task19.task1917;

/* 
Свой FileWriter
*/

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;

public class FileConsoleWriter extends  FileWriter{
    private FileWriter fileWriter;

    public FileConsoleWriter(String fileName) throws IOException {
        super(fileName);
    }

    public FileConsoleWriter(String fileName, boolean append) throws IOException {
        super(fileName, append);
    }

    public FileConsoleWriter(File file) throws IOException {
        super(file);
    }

    public FileConsoleWriter(File file, boolean append) throws IOException {
        super(file, append);
    }

    public FileConsoleWriter(FileDescriptor fd) {
        super(fd);
    }

    public FileConsoleWriter(String fileName, Charset charset) throws IOException {
        super(fileName, charset);
    }

    public FileConsoleWriter(String fileName, Charset charset, boolean append) throws IOException {
        super(fileName, charset, append);
    }

    public FileConsoleWriter(File file, Charset charset) throws IOException {
        super(file, charset);
    }

    public FileConsoleWriter(File file, Charset charset, boolean append) throws IOException {
        super(file, charset, append);
    }

    public static void main(String[] args) {

    }

}
