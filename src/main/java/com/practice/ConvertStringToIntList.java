package com.practice;

// Java Program to convert
// List<String> to List<Integer> in Java 8

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ConvertStringToIntList {

    public static void main(String[] args) {
        ConvertStringToIntList obj = new ConvertStringToIntList();

        // Create a list of String
        List<String> listOfString = Arrays.asList("1", "2", "3", "4", "5");
        System.out.println("List of String: " + listOfString);

        // Convert List of String to list of Integer
        List<Integer> listOfInteger = obj.convertStringListToIntList(listOfString, Integer::parseInt);
        System.out.println("List of Integer: " + listOfInteger);

        System.out.println(listOfInteger.get(4));
        System.out.println(listOfInteger.get(1));
    }

    // Generic function to convert List of  String to List of Integer
    public <T, U> List<U> convertStringListToIntList(List<T> listOfString, Function<T, U> function) {

        return listOfString.stream().map(function).collect(Collectors.toList());
    }
}


