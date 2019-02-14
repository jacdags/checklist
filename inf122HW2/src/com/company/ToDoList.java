package com.company;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ToDoList extends CheckList {
    User user;
    int priority;

    ToDoList(String name){
        super(name);
    }

    ToDoList(String name, int p){
        super(name);
        priority = p;
    }

    void editItemPriority(int i)
    {
        Scanner in = new Scanner(System.in);
        String input;

        System.out.println("Enter new priority number: ");
        input = in.nextLine();

        ((ToDoItem)items.get(i)).priority = Integer.parseInt(input);
    }

    void editItemDeadline(int i)
    {
        Scanner in = new Scanner(System.in);
        String input;

        System.out.println("Enter new deadline (MM-dd-yyyy HH:mm): ");
        input = in.nextLine();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm");
        ((ToDoItem)items.get(i)).deadline = LocalDate.parse(input, dateTimeFormatter);
    }

    void editItemStartRange(int i)
    {
        Scanner in = new Scanner(System.in);
        String input;

        System.out.println("Enter new start date (MM-dd-yyyy HH:mm): ");
        input = in.nextLine();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm");
        ((ToDoItem)items.get(i)).startRange = LocalDate.parse(input, dateTimeFormatter);
    }

    void editItemEndRange(int i)
    {
        Scanner in = new Scanner(System.in);
        String input;

        System.out.println("Enter new end date (MM-dd-yyyy HH:mm): ");
        input = in.nextLine();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm");
        ((ToDoItem)items.get(i)).endRange = LocalDate.parse(input, dateTimeFormatter);
    }

}
