package com.javarush.task.task31.task3105;

import java.io.*;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Добавление файла в архив
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        String filePath = args[0];
        String zipFilePath = args[1];
        String fileName = new File(filePath).getName();

        ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(zipFilePath));

        Map<ZipEntry, byte[]> entryMap = new HashMap<>();
        ZipEntry entry;

        while ((entry = zipInputStream.getNextEntry()) != null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            int count;
            while ((count = zipInputStream.read(buf)) != -1) {
                byteArrayOutputStream.write(buf, 0, count);
            }
            entryMap.put(entry, byteArrayOutputStream.toByteArray());
        }
        zipInputStream.close();

        ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(zipFilePath));
        for (Map.Entry<ZipEntry, byte[]> zipEntry : entryMap.entrySet()) {
            if (fileName.equals(zipEntry.getKey().getName()))
                continue;
            zipOutputStream.putNextEntry(zipEntry.getKey());
            zipOutputStream.write(zipEntry.getValue());
            zipOutputStream.closeEntry();
        }

        FileInputStream fileInputStream = new FileInputStream(filePath);
        byte[] fileArr = new byte[fileInputStream.available()];
        fileInputStream.read(fileArr);
        fileInputStream.close();

        ZipEntry zipEntry = new ZipEntry("new/" + fileName);
        zipOutputStream.putNextEntry(zipEntry);
        zipOutputStream.write(fileArr);
        zipOutputStream.closeEntry();
        zipOutputStream.close();
    }
}
