package com.company;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Hashtable;
import java.util.Objects;
import java.util.Scanner;

public class User {
    String name;
    Scanner in = new Scanner(System.in);
    String input;
    Hashtable<String, CheckList> myLists = new Hashtable();
    boolean hasGoalList = false;

    User(String n)
    {
        name = n;
    }

    void createShoppingList(String listName)
    {
        if(myLists.containsKey(listName))
        {
            System.out.println("List name already exists");
        }
        else {
            myLists.put(listName, new ShoppingList(listName));
        }
    }

    void createToDoList(String listName)
    {
        if(myLists.containsKey(listName))
        {
            System.out.println("List name already exists");
        }
        else {
            myLists.put(listName, new ToDoList(listName));
        }
    }

    void createToDoList(String listName, int priorityInput)
    {
        if(myLists.containsKey(listName))
        {
            System.out.println("List name already exists");
        }
        else {
            myLists.put(listName, new ToDoList(listName));
            ((ToDoList)myLists.get(listName)).priority = priorityInput;
        }
    }

    void createTeamList(String listName)
    {
        if(myLists.containsKey(listName))
        {
            System.out.println("List name already exists");
        }
        else {
            myLists.put(listName, new TeamList(listName, name));
        }
    }

    void joinTeamsList(String listName)
    {
        if(myLists.containsKey(listName))
        {
            ((TeamList)myLists.get(listName)).addUser(name);
        }
        else{
            System.out.println("List does not exist");
        }
    }

    void createGoalsList(String listName)
    {
        if(myLists.containsKey(listName))
        {
            System.out.println("List name already exists");
        }
        else if(hasGoalList)
        {
            System.out.println("Only one goal list per user");
        }
        else {
            myLists.put(listName, new GoalsList(listName));
            hasGoalList = true;
        }
    }

    String editShoppingList(String listName)
    {
        System.out.println("Items in " + listName);
        for(Item i : myLists.get(listName).items){
            System.out.println("+ "+i.task);
        }

        //PRINT OTHER ITEM DETAILS ALSO

        System.out.println("--------------------");
        System.out.println("1. Add item");
        System.out.println("2. Edit item");
        System.out.println("3. Complete item");
        System.out.println("4. Delete item");
        System.out.println("Enter option:");
        input = in.nextLine();

        if(Objects.equals(input, "done"))
        {
            return "done";
        }
        else if(Objects.equals(input, "1"))
        {
            System.out.println("Enter item: ");
            input = in.nextLine();
            Item tempItem = new Item();
            tempItem.task = input;

            myLists.get(listName).addItem(tempItem);
        }
        else if(Objects.equals(input, "2"))
        {
            int index = 0;
            for(Item i : myLists.get(listName).items){
                System.out.println(String.valueOf(index++)+": "+i.task);
            }

            System.out.println("Which item would you like to edit? ");
            input = in.nextLine();

            myLists.get(listName).editItem(Integer.parseInt(input));

        }
        else if(Objects.equals(input, "3"))
        {
            int index = 0;
            for(Item i : myLists.get(listName).items){
                System.out.println(String.valueOf(index++)+": "+i.task);
            }

            System.out.println("Which item would you like to mark complete?");
            input = in.nextLine();

            myLists.get(listName).completeItem(Integer.parseInt(input));

        }
        else if(Objects.equals(input, "4"))
        {
            int index = 0;
            for(Item i : myLists.get(listName).items){
                System.out.println(String.valueOf(index++)+": "+i.task);
            }

            System.out.println("Which item would you like to delete?");
            input = in.nextLine();

            myLists.get(listName).deleteItem(Integer.parseInt(input));
        }
        return input.toString();
    }

    String editToDoList(String listName)
    {
        System.out.println("Items in " + listName);
        for(Item i : myLists.get(listName).items){
            System.out.println("+ "+i.task);
        }
        //PRINT OTHER ITEM DETAILS ALSO

        System.out.println("--------------------");
        System.out.println("1. Add item");
        System.out.println("2. Edit item");
        System.out.println("3. Edit item priority");
        System.out.println("4. Edit item deadline");
        System.out.println("5. Edit item date range");
        System.out.println("6. Complete item");
        System.out.println("7. Delete item");
        System.out.println("Enter option:");
        input = in.nextLine();

        if(Objects.equals(input, "1"))
        {
            System.out.println("Enter item: ");
            input = in.nextLine();
            Item tempItem = new ToDoItem();
            tempItem.task = input;
            ((ToDoList)myLists.get(listName)).addItem(tempItem);
        }
        else if(Objects.equals(input, "2"))
        {
            int index = 0;
            for(Item i : myLists.get(listName).items){
                System.out.println(String.valueOf(index++)+": "+i.task);
            }

            System.out.println("Which item would you like to edit? ");
            input = in.nextLine();

            myLists.get(listName).editItem(Integer.parseInt(input));
        }
        else if(Objects.equals(input, "3"))
        {
            int index = 0;
            for(Item i : myLists.get(listName).items){
                System.out.println(String.valueOf(index++)+": "+i.task);
            }

            System.out.println("Which item priority would you like to change? ");
            input = in.nextLine();

            ((ToDoList)myLists.get(listName)).editItemPriority(Integer.parseInt(input));
        }
        else if(Objects.equals(input, "4"))
        {
            int index = 0;
            for(Item i : myLists.get(listName).items){
                System.out.println(String.valueOf(index++)+": "+i.task);
            }

            System.out.println("Which item deadline would you like to change?");
            input = in.nextLine();

            ((ToDoList)myLists.get(listName)).editItemDeadline(Integer.parseInt(input));

        }
        else if(Objects.equals(input, "5"))
        {
            int itemIndex;
            String option;
            int index = 0;
            for(Item i : myLists.get(listName).items){
                System.out.println(String.valueOf(index++)+": "+i.task);
            }

            System.out.println("Which item date range would you like to change?");
            input = in.nextLine();
            itemIndex = Integer.parseInt(input);

            System.out.println("Edit start date or end date? (start/end)");
            input = in.nextLine();
            option = input;
            if(Objects.equals(option, "start"))
            {
                ((ToDoList)myLists.get(listName)).editItemStartRange(itemIndex);
                System.out.println("Edit end date too? (y/n)");
                input = in.nextLine();

                if(Objects.equals(input, "y"))
                {
                    ((ToDoList)myLists.get(listName)).editItemEndRange(itemIndex);
                }
            }
            else if(Objects.equals(option, "end"))
            {
                ((ToDoList)myLists.get(listName)).editItemEndRange(itemIndex);
                System.out.println("Edit start date too? (y/n)");
                input = in.nextLine();

                if(Objects.equals(input, "y"))
                {
                    ((ToDoList)myLists.get(listName)).editItemStartRange(itemIndex);
                }
            }
        }
        else if(Objects.equals(input, "6"))
        {
            int index = 0;
            for(Item i : myLists.get(listName).items){
                System.out.println(String.valueOf(index++)+": "+i.task);
            }

            System.out.println("Which item would you like to mark complete?");
            input = in.nextLine();

            myLists.get(listName).completeItem(Integer.parseInt(input));
        }
        else if(Objects.equals(input, "7"))
        {
            int index = 0;
            for(Item i : myLists.get(listName).items){
                System.out.println(String.valueOf(index++)+": "+i.task);
            }

            System.out.println("Which item would you like to delete?");
            input = in.nextLine();

            myLists.get(listName).deleteItem(Integer.parseInt(input));
        }

        return input;
    }

    String editGoalsList(String listName)
    {
        int index =0;
        System.out.println("Items in " + listName);
        for(Item i : myLists.get(listName).items){
            System.out.println(String.valueOf(index++)+": "+i.task);
        }
        //PRINT OTHER ITEM DETAILS ALSO

        System.out.println("--------------------");
        System.out.println("1. Add item");
        System.out.println("2. Edit item");
        System.out.println("3. Edit item priority");
        System.out.println("4. Edit item deadline");
        System.out.println("5. Edit item date range");
        System.out.println("6. Complete item");
        System.out.println("7. Delete item");
        System.out.println("Enter option:");
        input = in.nextLine();

        if(Objects.equals(input, "1"))
        {
            System.out.println("Enter item: ");
            input = in.nextLine();
            Item tempItem = new GoalItem();
            tempItem.task = input;
            ((GoalsList)myLists.get(listName)).addItem(tempItem);
        }
        else if(Objects.equals(input, "2"))
        {
            int parentItem;
//            int index = 0;
//            for(Item i : myLists.get(listName).items){
//                System.out.println(String.valueOf(index++)+": "+i.task);
//            }

            System.out.println("Which item would you like to edit? ");
            input = in.nextLine();
            parentItem = Integer.parseInt(input);

            //print item details

            System.out.println("1. Edit task");
            System.out.println("2. Add sub-goal");
            System.out.println("3. Edit sub-goal");
            System.out.println("What would you like to do?");
            input = in.nextLine();

            if(Objects.equals(input, "1"))
            {
                myLists.get(listName).editItem(Integer.parseInt(input));
            }
            else if(Objects.equals(input, "2"))
            {
                System.out.println("Enter sub-goal: ");
                input = in.nextLine();
                String name = input;
                GoalItem subGoal = new GoalItem();
                ((GoalsList)myLists.get(listName)).addSubItem(subGoal, parentItem);
            }
            else if(Objects.equals(input, "3"))
            {
                ((GoalsList)myLists.get(listName)).editSubItem(parentItem);
            }


        }
        else if(Objects.equals(input, "3"))
        {
            index = 0;
            for(Item i : myLists.get(listName).items){
                System.out.println(String.valueOf(index++)+": "+i.task);
            }

            System.out.println("Which item priority would you like to change? ");
            input = in.nextLine();

            ((GoalsList)myLists.get(listName)).editItemPriority(Integer.parseInt(input));
        }
        else if(Objects.equals(input, "4"))
        {
            index = 0;
            for(Item i : myLists.get(listName).items){
                System.out.println(String.valueOf(index++)+": "+i.task);
            }

            System.out.println("Which item deadline would you like to change?");
            input = in.nextLine();

            ((GoalsList)myLists.get(listName)).editItemDeadline(Integer.parseInt(input));

        }
        else if(Objects.equals(input, "5"))
        {
            int itemIndex;
            String option;
            index = 0;
            for(Item i : myLists.get(listName).items){
                System.out.println(String.valueOf(index++)+": "+i.task);
            }

            System.out.println("Which item date range would you like to change?");
            input = in.nextLine();
            itemIndex = Integer.parseInt(input);

            System.out.println("Edit start date or end date? (start/end)");
            input = in.nextLine();
            option = input;
            if(Objects.equals(option, "start"))
            {
                ((GoalsList)myLists.get(listName)).editItemStartRange(itemIndex);
                System.out.println("Edit end date too? (y/n)");
                input = in.nextLine();

                if(Objects.equals(input, "y"))
                {
                    ((GoalsList)myLists.get(listName)).editItemEndRange(itemIndex);
                }
            }
            else if(Objects.equals(option, "end"))
            {
                ((GoalsList)myLists.get(listName)).editItemEndRange(itemIndex);
                System.out.println("Edit start date too? (y/n)");
                input = in.nextLine();

                if(Objects.equals(input, "y"))
                {
                    ((GoalsList)myLists.get(listName)).editItemStartRange(itemIndex);
                }
            }
        }
        else if(Objects.equals(input, "6"))
        {
            index = 0;
            for(Item i : myLists.get(listName).items){
                System.out.println(String.valueOf(index++)+": "+i.task);
            }

            System.out.println("Which item would you like to mark complete?");
            input = in.nextLine();

            myLists.get(listName).completeItem(Integer.parseInt(input));
        }
        else if(Objects.equals(input, "7"))
        {
            index = 0;
            for(Item i : myLists.get(listName).items){
                System.out.println(String.valueOf(index++)+": "+i.task);
            }

            System.out.println("Which item would you like to delete?");
            input = in.nextLine();

            myLists.get(listName).deleteItem(Integer.parseInt(input));
        }

        return input;
    }

    String editTeamList(String listName)
    {
        System.out.println("Items in " + listName);
        for(Item i : myLists.get(listName).items){
            System.out.println("+ "+i.task);
        }
        //PRINT OTHER ITEM DETAILS ALSO

        System.out.println("--------------------");
        System.out.println("1. Add item");
        System.out.println("2. Edit item");
        System.out.println("3. Edit item priority");
        System.out.println("4. Edit item deadline");
        System.out.println("5. Complete item");
        System.out.println("6. Delete item");
        System.out.println("7: View users");
        System.out.println("Enter option:");
        input = in.nextLine();

        if(Objects.equals(input, "1"))
        {
            String itemDesc;
            int priority;
            LocalDate deadline;

            System.out.println("Enter item: ");
            input = in.nextLine();
            itemDesc = input;

            System.out.println("Enter item priority: ");
            input = in.nextLine();
            priority = Integer.parseInt(input);

            System.out.println("Enter item deadline: ");
            input = in.nextLine();
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm");
            deadline = LocalDate.parse(input, dateTimeFormatter);

            Item tempItem = new TeamItem(itemDesc, priority, deadline);
            ((TeamList)myLists.get(listName)).addItem(tempItem);

        }
        else if(Objects.equals(input, "2"))
        {
            System.out.println("Which item would you like to edit?");
            input = in.nextLine();
            ((TeamList)myLists.get(listName)).editItem(Integer.parseInt(input));

        }
        else if(Objects.equals(input, "3"))
        {
            System.out.println("Which item priority would you like to edit?");
            input = in.nextLine();
            ((TeamList)myLists.get(listName)).editItemPriority(Integer.parseInt(input));

        }
        else if(Objects.equals(input, "4"))
        {
            System.out.println("Which item deadline would you like to edit?");
            input = in.nextLine();
            ((TeamList)myLists.get(listName)).editItemDeadline(Integer.parseInt(input));

        }
        else if(Objects.equals(input, "5"))
        {
            System.out.println("Which item would you like to complete?");
            input = in.nextLine();
            ((TeamList)myLists.get(listName)).completeItem(Integer.parseInt(input));
        }
        else if(Objects.equals(input, "6"))
        {
            System.out.println("Which item would you like to delete?");
            input = in.nextLine();
            ((TeamList)myLists.get(listName)).deleteItem(Integer.parseInt(input));

        }
        else if(Objects.equals(input, "7"))
        {
            ((TeamList)myLists.get(listName)).viewUsers();
        }
        return input;
    }

    void deleteList(String listName)
    {
        if(myLists.containsKey(listName)) {
            myLists.remove(listName);
        }
        else{
            System.out.println("List does not exist");
        }
    }



}
