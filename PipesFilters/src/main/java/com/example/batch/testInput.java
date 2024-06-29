package com.example.batch;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class testInput { 
    
    public static void main(String[] args) throws IOException {
        String filePath="src/main/resources/data/meta_Magazine_Subscriptions_100.json";

        File file = new File(filePath);
        BufferedReader reader = new BufferedReader(new FileReader(file));

        String line = reader.readLine();
        System.err.println(line);
        System.err.println("===========================");

        String line1 = reader.readLine();
        System.err.println(line1);
        System.err.println("===========================");

        String line2 = reader.readLine();
        System.err.println(line2);
        System.err.println("===========================");

        String line3 = reader.readLine();
        System.err.println(line3);
        System.err.println("===========================");

	}
}
