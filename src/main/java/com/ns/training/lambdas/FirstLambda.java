package com.ns.training.lambdas;

import java.io.File;
import java.io.FileFilter;

public class FirstLambda {

    public static void main(String[] args) {
        FileFilter fileFilter = new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(".java");
            }
        };

        File dir = new File("");
        File[] files = dir.listFiles(fileFilter);

        for (File file : files
        ) {
            System.out.println(file);
        }

        //With lambda
        FileFilter filterWithLamda = (File pathname) -> pathname.getName().endsWith(".java");



    }
}
