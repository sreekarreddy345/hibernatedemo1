package com.sreekar.hibernate;

public class StudentSIB {
    static {
        System.out.println("Static block in main class");
    }

    public static void main(String[] args) {
        System.out.println("Main method");

//        Marks marks = new Marks();
        Marks.marksDetails();
    }

}

class Marks {

    static int i = 10;
    static {
        System.out.println("static block in Marks class " + i);
    }

    public static void marksDetails() {
        System.out.println("This method will be executed only if its been called explicitly");

    }

}