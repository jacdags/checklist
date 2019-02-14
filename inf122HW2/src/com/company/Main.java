package com.company;

import javafx.scene.chart.BarChart;
import org.jfree.ui.RefineryUtilities;

import java.util.Hashtable;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

import static javafx.application.Application.launch;

public class Main {

    public static Hashtable<String, User> userList = new Hashtable();
    public static String userName;
    public static Scanner in = new Scanner(System.in);
    public static String input = new String();

    public static void main(String[] args) {
//        launch(args);

        System.out.println("Welcome to Checklists! To exit type 'quit'");
        System.out.print("Please enter user name: ");
        input = in.nextLine();
        userName = input;
        //Check if user exists
        if (!userList.containsKey(userName)) {
            userList.put(userName, new User(userName));
        }

        while (!Objects.equals(input, "quit")) {
            System.out.println("MAIN MENU (to exit type 'quit')");
            System.out.println("1: Create a checklist");
            System.out.println("2: Delete a checklist");
            System.out.println("3: Edit a checklist");
            System.out.println("4: Join a team list");
            System.out.println("5: Change user");
            System.out.println("-------------------------------");
            System.out.print("Choose an option:");

            input = in.nextLine();
            System.out.println("input is: " + input);

            if (Objects.equals(input, "quit")) {
                break;
            } else if (Objects.equals(input, "1")) {
                System.out.println("What type of list? (shopping, todo, goal, or team)");
                input = in.nextLine();
                if (Objects.equals(input, "shopping")) {
                    System.out.print("Please enter list name: ");
                    input = in.nextLine();
                    userList.get(userName).createShoppingList(input);
                } else if (Objects.equals(input, "todo")) {
                    String listName;
                    int priorityInput;

                    System.out.print("Please enter list name: ");
                    input = in.nextLine();
                    listName = input;

                    System.out.println("Add priority to list? (y/n) ");
                    input = in.nextLine();

                    if (Objects.equals(input, "y")) {
                        System.out.print("Please enter list priority: ");
                        input = in.nextLine();
                        priorityInput = Integer.parseInt(input);

                        userList.get(userName).createToDoList(listName, priorityInput);
                    } else {
                        userList.get(userName).createToDoList(listName);
                    }
                } else if (Objects.equals(input, "goal")) {
                    System.out.print("Please enter list name: ");
                    input = in.nextLine();
                    userList.get(userName).createGoalsList(input);
                } else if (Objects.equals(input, "team")) {
                    System.out.print("Please enter list name: ");
                    input = in.nextLine();
                    userList.get(userName).createTeamList(input);
                }
            } else if (Objects.equals(input, "2")) {
                System.out.println("Enter list name to delete: ");
                input = in.nextLine();

                userList.get(userName).deleteList(input);

            } else if (Objects.equals(input, "3")) {
                System.out.println();
                System.out.println("Current Lists: ");
                for(CheckList i : userList.get(userName).myLists.values()){
                    System.out.println("+ "+i.name);
                }
                System.out.println("Please enter list name: ");
                input = in.nextLine();

                CheckList list = userList.get(userName).myLists.get(input);
                //print list info
                System.out.println("When done editing list, enter 'done'.");

                String editInput = "";
                while (!Objects.equals(editInput, "done"))
                {
                    if (list instanceof ShoppingList)
                    {
                        userList.get(userName).myLists.get(input).removeCompleteItems();
                        editInput = userList.get(userName).editShoppingList(userList.get(userName).myLists.get(input).name);
//                        System.out.println("after input: "+ input);
                    } else if (list instanceof ToDoList)
                    {
                        userList.get(userName).myLists.get(input).removeCompleteItems();
                        editInput = userList.get(userName).editToDoList(userList.get(userName).myLists.get(input).name);

                    } else if (list instanceof GoalsList)
                    {
                        userList.get(userName).myLists.get(input).removeCompleteItems();
                        editInput = userList.get(userName).editGoalsList(userList.get(userName).myLists.get(input).name);

                    } else if (list instanceof TeamList)
                    {
                        userList.get(userName).myLists.get(input).removeCompleteItems();
                        editInput = userList.get(userName).editTeamList(userList.get(userName).myLists.get(input).name);

                    }
                    userList.get(userName).myLists.get(input).removeCompleteItems();
                }

            }
            else if(Objects.equals(input, "4"))
            {
                boolean teamAdded = false;
                System.out.println("Team list name: ");
                input = in.nextLine();
                System.out.println("user list size: " + userList.size());
                Set<String> userkeys = userList.keySet();

                for(String key: userkeys )
                {
                    Set<String> listKeys = userList.get(key).myLists.keySet();
                    for(String j: listKeys)
                    {
                        if(Objects.equals(userList.get(key).myLists.get(j).name, input))
                        {
                            userList.get(userName).myLists.put(input, userList.get(key).myLists.get(j));
                            ((TeamList)userList.get(userName).myLists.get(input)).users.add(userList.get(userName));
                            teamAdded= true;
                            break;
                        }
                    }
                    if(teamAdded)
                        break;
                }
            }
            else if (Objects.equals(input, "5"))
            {
                System.out.print("Please enter user name: ");
                input = in.nextLine();
                userName = input;
                if (!userList.containsKey(userName)) {
                    userList.put(userName, new User(userName));
                }
                System.out.println("=================================");
            }
        }

        System.out.println("UserList contains: ");
        System.out.println(userList.keySet());
    }

}

