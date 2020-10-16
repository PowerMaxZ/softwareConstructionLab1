package com.company;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try
        {
            System.out.println("Enter file to check");
            Scanner sc = new Scanner(System.in);
            String filename = sc.next();
            File file = new File(filename);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String result = new String("");
            String line;
            while((line = br.readLine()) != null)
            {
                String []split = line.split(" ");
                if (Integer.parseInt(split[split.length - 1]) > 180) {
                    System.out.println(line + " - mark is greater than 180");
                    line = line.toLowerCase();
                }
                result = result.concat(line);
                result = result.concat("\n");
            }
            fr.close();
            System.out.println("Enter new file");
            filename = sc.next();
            File newFile = new File(filename);
            newFile.createNewFile();
            FileWriter newfile1 = new FileWriter(newFile);
            newfile1.write(result);
            br.close();
            newfile1.close();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
}
