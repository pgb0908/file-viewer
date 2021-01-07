package com.gyubong.fileviewer.controller;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class FileTest {

    @Test
    public void fileTest() {
        File dir = new File("C:/Users/Tmax/test");
        File[] files = dir.listFiles();

        //Arrays.sort(files, (a, b) -> a.getPath().toCharArray()[0] - b.getPath().toCharArray()[0]);

        ArrayList<String> fileName = new ArrayList();
        ArrayList<String> fileSize = new ArrayList();
        ArrayList<String> fileModified = new ArrayList();
        for (File file : files) {
            fileName.add(file.getName());
            fileSize.add(String.valueOf(file.length()));
            fileModified.add(String.valueOf(file.lastModified()));
        }

        for(int i=0; i < fileName.size(); i++){
            System.out.print(fileName.get(i) + " | ");
            System.out.print(fileSize.get(i) + " | ");
            System.out.println(fileModified.get(i));
        }
    }
}
