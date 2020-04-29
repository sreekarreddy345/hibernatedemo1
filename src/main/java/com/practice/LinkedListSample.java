package com.practice;

import java.util.LinkedList;

public class LinkedListSample {
    public static void main(String[] args) throws Exception {

        // Java code for Linked List implementation

        // Creating object of class linked list
        LinkedList<String> object = new LinkedList<>();


        // Adding elements to the linked list
        object.add("A");
        object.add("B");
        object.addLast("C");
        object.addFirst("D");
        object.add(2, "E");
        object.add("F");
        object.add("G");


        System.out.println("Linked list : " + object);
        Object anotherObject = object.clone();
        System.out.println("anotherObject " + anotherObject);
//        object.addAll()----??
        boolean c = object.offer("H");
        System.out.println("object.offer adds as last element in the list -  " + object.getLast());
        String peek = object.peek();
        System.out.println("peek will retrieve first element in the linked list-----" + peek);
        String poll = object.poll();
        System.out.println("poll will remove the first element in the list -  " + poll);
        System.out.println(object);
//        String[] strings = object.toArray(args);------???

//        System.out.println("strings - " + strings)

        // Removing elements from the linked list
//        object.remove("B");
//        object.remove(3);
//        object.removeFirst();
//        object.removeLast();
//        System.out.println("Linked list after deletion: " + object);

        // Finding elements in the linked list
        boolean status = object.contains("E");

        if (status)
            System.out.println("List contains the element 'E' ");
        else
            System.out.println("List doesn't contain the element 'E'");

        // Number of elements in the linked list
        int size = object.size();
        System.out.println("Size of linked list = " + size);

        // Get and set elements from linked list
        Object element = object.get(2);
//        String s = object.get(4);
//        System.out.println("ssssssssss " + s);
        String s = object.set(4, "sreekar");
//        object.add(4, "sreekar");
        System.out.println("Element returned by get() : " + element);
        System.out.println("Element returned by get() : " + object.get(4));
        object.set(2, "Y");
        System.out.println("Linked list after change : " + object);


    }

    @Override
    public String toString() {
        return "sample{}";
    }

}
