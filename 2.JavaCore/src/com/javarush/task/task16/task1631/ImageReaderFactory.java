package com.javarush.task.task16.task1631;                                                                                                                                                                                                        
import com.javarush.task.task16.task1631.common.*;                                                                                                                                                                                                        
public class ImageReaderFactory {                                                  
    public static ImageReader getImageReader(ImageTypes types) {                                                  
        ImageReader reader = null;                                                  
        if (types == null)                                                  
            throw new IllegalArgumentException("Неизвестный тип картинки");                                                  
                                                  
        try {                                                  
            switch (types) {                                                  
                case BMP:                                                  
                    reader = new BmpReader();                                                  
                    break;                                                  
                case JPG:                                                  
                    reader = new JpgReader();                                                  
                    break;                                                  
                case PNG:                                                  
                    reader = new PngReader();                                                  
                    break;                                                  
                default:                                                  
                    throw new IllegalArgumentException("Не известный тип картинки");                                                  
            }                                                  
        } catch (IllegalArgumentException e) {                                                  
           System.out.println("Не известный тип картинки");                                                  
        }                                                  
        if (reader == null)                                                  
            throw new IllegalArgumentException("Неизвестный тип картинки");                                                  
                                                  
        return reader;                                                  
    }                                                  
}