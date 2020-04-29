package com.sreekar.hibernate.pojo.natural_id;

import java.io.FileNotFoundException;

public class Sample {

    static Integer i;

    public static void main(String []args){
        String s1 = "sssssssss";
        String s2 = s1.concat("rrrrr");
        System.out.println( s2);
        System.out.println(i);

        try {
            readInputFile();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static void readInputFile() throws Exception, FileNotFoundException {

    }
}
