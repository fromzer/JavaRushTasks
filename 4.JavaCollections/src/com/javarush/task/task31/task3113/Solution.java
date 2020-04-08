package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/* 
Что внутри папки?
*/
public class Solution extends SimpleFileVisitor {
    static int countDir = 0;
    static int countFile = 0;
    static int size = 0;

    @Override
    public FileVisitResult preVisitDirectory(Object dir, BasicFileAttributes attrs) throws IOException {
        if (attrs.isDirectory()) countDir++;
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Object file, BasicFileAttributes attrs) throws IOException {
        countFile++;
        size += attrs.size();
        return FileVisitResult.CONTINUE;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Path pathDir = Paths.get(reader.readLine());

        if (!Files.isDirectory(pathDir)) {
            System.out.println(pathDir + " - не папка");
            return;
        }

        FileVisitor<Path> fileVisitor = new Solution();
        Files.walkFileTree(pathDir, fileVisitor);
        countDir--;
        System.out.println("Всего папок - " + countDir);
        System.out.println("Всего файлов - " + countFile);
        System.out.println("Общий размер - " + size);
    }
}
