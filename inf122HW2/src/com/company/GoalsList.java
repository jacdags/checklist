package com.company;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.Scanner;

public class GoalsList extends CheckList {
    User user;

    GoalsList(String name)
    {
        super(name);
    }

    void editItemPriority(int i)
    {
        Scanner in = new Scanner(System.in);
        String input;

        System.out.println("Enter new priority number: ");
        input = in.nextLine();

        ((GoalItem)items.get(i)).priority = Integer.parseInt(input);
    }

    void editItemDeadline(int i)
    {
        Scanner in = new Scanner(System.in);
        String input;

        System.out.println("Enter new deadline (MM-dd-yyyy HH:mm): ");
        input = in.nextLine();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm");
        ((GoalItem)items.get(i)).deadline = LocalDate.parse(input, dateTimeFormatter);
    }

    void editItemStartRange(int i)
    {
        Scanner in = new Scanner(System.in);
        String input;

        System.out.println("Enter new start date (MM-dd-yyyy HH:mm): ");
        input = in.nextLine();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm");
        ((GoalItem)items.get(i)).startRange = LocalDate.parse(input, dateTimeFormatter);
    }

    void editItemEndRange(int i)
    {
        Scanner in = new Scanner(System.in);
        String input;

        System.out.println("Enter new end date (MM-dd-yyyy HH:mm): ");
        input = in.nextLine();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm");
        ((GoalItem)items.get(i)).endRange = LocalDate.parse(input, dateTimeFormatter);
    }

    void addSubItem(GoalItem subItem, int i)
    {
        ((GoalItem)items.get(i)).subItems.add(subItem);

    }

    void editSubItem(int iParent)
    {
        int index = 0;
        System.out.println("Items in " + ((GoalItem)items.get(iParent)).task);
        for(Item i : ((GoalItem)items.get(iParent)).subItems){
            System.out.println(String.valueOf(index++)+"+ "+i.task);
        }
        //PRINT OTHER ITEM DETAILS ALSO

        System.out.println("--------------------");
        System.out.println("1. Add subgoal to item");
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
            System.out.println("Enter sub-goal: ");
            input = in.nextLine();
            Item tempItem = new GoalItem();
            tempItem.task = input;
            ((GoalItem)items.get(iParent)).subItems.add((GoalItem)tempItem);
        }
        else if(Objects.equals(input, "2"))
        {
            int subItemIndex;
            index = 0;
            for(Item i : ((GoalItem)items.get(iParent)).subItems){
                System.out.println(String.valueOf(index++)+": "+i.task);
            }

            System.out.println("Which item would you like to edit? ");
            input = in.nextLine();
            subItemIndex = Integer.parseInt(input);

            //print item details

            System.out.println("1. Edit task");
            System.out.println("2. Add sub-goal");
            System.out.println("3. Edit sub-goal");
            System.out.println("What would you like to do?");
            input = in.nextLine();
//            subItemIndex = Integer.parseInt(input);

            if(Objects.equals(input, "1"))
            {
                System.out.println("Enter new text for item: ");
                input = in.nextLine();
                ((GoalItem)items.get(iParent)).subItems.get(subItemIndex).task = input;
            }
            else if(Objects.equals(input, "2"))
            {
                System.out.println("Enter sub-goal: ");
                input = in.nextLine();
                String name = input;
                GoalItem subGoal = new GoalItem();
                ((GoalItem)items.get(iParent)).subItems.add(subGoal);
            }
            else if(Objects.equals(input, "3"))
            {

            }


        }
        else if(Objects.equals(input, "3"))
        {
            index = 0;
//            for(Item i : myLists.get(listName).items){
//                System.out.println(String.valueOf(index++)+": "+i.task);
//            }

            System.out.println("Which item priority would you like to change? ");
            input = in.nextLine();
            index = Integer.parseInt(input);
            System.out.println("Enter new priority: ");
            input = in.nextLine();

            ((GoalItem)items.get(iParent)).subItems.get(index).priority = Integer.parseInt(input);
        }
        else if(Objects.equals(input, "4"))
        {
            index = 0;

            System.out.println("Which item deadline would you like to change?");
            input = in.nextLine();
            index = Integer.parseInt(input);
            System.out.println("Enter new deadline (MM-dd-yyyy HH:mm): ");
            input = in.nextLine();
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm");

            ((GoalItem)items.get(iParent)).subItems.get(index).deadline = LocalDate.parse(input, dateTimeFormatter);

        }
        else if(Objects.equals(input, "5"))
        {
            int itemIndex;
            String option;
//            int index = 0;
//            for(Item i : myLists.get(listName).items){
//                System.out.println(String.valueOf(index++)+": "+i.task);
//            }

            System.out.println("Which item date range would you like to change?");
            input = in.nextLine();
            itemIndex = Integer.parseInt(input);

            System.out.println("Edit start date or end date? (start/end)");
            input = in.nextLine();
            option = input;
            if(Objects.equals(option, "start"))
            {
                System.out.println("Enter new start date (MM-dd-yyyy HH:mm): ");
                input = in.nextLine();
                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm");
                ((GoalItem)items.get(iParent)).subItems.get(itemIndex).startRange = LocalDate.parse(input, dateTimeFormatter);

                System.out.println("Edit end date too? (y/n)");
                input = in.nextLine();

                if(Objects.equals(input, "y"))
                {
                    System.out.println("Enter new end date (MM-dd-yyyy HH:mm): ");
                    input = in.nextLine();
                    dateTimeFormatter = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm");
                    ((GoalItem)items.get(iParent)).subItems.get(itemIndex).endRange = LocalDate.parse(input, dateTimeFormatter);
                }
            }
            else if(Objects.equals(option, "end"))
            {
                System.out.println("Enter new end date (MM-dd-yyyy HH:mm): ");
                input = in.nextLine();
                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm");
                ((GoalItem)items.get(iParent)).subItems.get(itemIndex).endRange = LocalDate.parse(input, dateTimeFormatter);

                System.out.println("Edit start date too? (y/n)");
                input = in.nextLine();

                if(Objects.equals(input, "y"))
                {
                    System.out.println("Enter new start date (MM-dd-yyyy HH:mm): ");
                    input = in.nextLine();
                    dateTimeFormatter = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm");
                    ((GoalItem)items.get(iParent)).subItems.get(itemIndex).startRange = LocalDate.parse(input, dateTimeFormatter);
                }
            }
        }
        else if(Objects.equals(input, "6"))
        {
            index = 0;
//            for(Item i : myLists.get(listName).items){
//                System.out.println(String.valueOf(index++)+": "+i.task);
//            }

            System.out.println("Which item would you like to mark complete?");
            input = in.nextLine();

            ((GoalItem)items.get(iParent)).subItems.get(Integer.parseInt(input)).isCompleted = true;
            ((GoalItem)items.get(iParent)).subItems.get(Integer.parseInt(input)).timeCompleted = java.time.LocalDateTime.now();
        }
        else if(Objects.equals(input, "7"))
        {
            index = 0;
//            for(Item i : myLists.get(listName).items){
//                System.out.println(String.valueOf(index++)+": "+i.task);
//            }

            System.out.println("Which item would you like to delete?");
            input = in.nextLine();

            ((GoalItem)items.get(iParent)).subItems.remove(Integer.parseInt(input));
        }

    }
}


//1) Goal list items can be composed of/broken down into sub-items,
// and sub-items maybe broken down into sub-sub-items, and so on. Each
// of these smaller items represent smaller sub-goals that contribute to
// the larger overall goal, e.g., "do 15 minutes of Rosetta Stone Chinese,"
// "jog 30 minutes," or "demo bathroom floor." Each of these smaller items
// can also have priorities, deadlines, etc.
// 2) A user may only have one goal list, while they can have multiple other types of lists.