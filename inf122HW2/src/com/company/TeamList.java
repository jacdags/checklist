package com.company;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class TeamList extends CheckList{
    ArrayList<User> users = new ArrayList();

    TeamList(String name, String userName)
    {
        super(name);
        users.add(new User(userName));
    }

    void addUser(String userName)
    {
        users.add(new User(userName));
    }

    void editItemPriority(int i)
    {
        Scanner in = new Scanner(System.in);
        String input;

        System.out.println("Enter new priority number: ");
        input = in.nextLine();

        ((TeamItem)items.get(i)).priority = Integer.parseInt(input);
    }

    void editItemDeadline(int i)
    {
        Scanner in = new Scanner(System.in);
        String input;

        System.out.println("Enter new deadline (MM-dd-yyyy HH:mm): ");
        input = in.nextLine();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm");
        ((TeamItem)items.get(i)).deadline = LocalDate.parse(input, dateTimeFormatter);
    }

    void viewUsers()
    {
        System.out.println("Users: ");
        for(User i :users){
            System.out.println("+ "+i.name);
        }
    }
}
