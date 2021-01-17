package com.company;

import java.io.FileWriter;
import java.io.IOException;

public class TryWithResource {
    public void Resource_practice() throws IOException {
        try (FileWriter f = new FileWriter("data2.txt")) {
            f.write("Hii");
        }catch(IOException e){
            e.printStackTrace();
        }finally {
            System.out.println("data2.txt 생성");
        }
    }
}
