package com.company;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Scanner;

public class CheckList {
    String name;
    ArrayList<Item> items = new ArrayList();
    Scanner in = new Scanner(System.in);
    String input;

    CheckList(String n){
        name = n;
    }

    void addItem(Item i){
        items.add(i);
    }

    void editItem(int i){
        System.out.println("Enter new text for item: ");
        input = in.nextLine();

        items.get(i).task = input;
    }

    void deleteItem(int i){
        items.remove(i);
    }

    void completeItem(int i){
        items.get(i).isCompleted = true;
        items.get(i).timeCompleted = java.time.LocalDateTime.now();
    }

    void removeCompleteItems(){
        ArrayList<Item> toRemove = new ArrayList();
        if(items.size() > 0) {
            for (Item item : items)
                if (item.isCompleted) {
                    LocalDateTime tempDateTime = LocalDateTime.from(item.timeCompleted);

                    long hours = tempDateTime.until(LocalDateTime.now(), ChronoUnit.HOURS);
                    tempDateTime = tempDateTime.plusHours(hours);

                    if(hours >= 24) {
                        toRemove.add(item);
                    }
                }
            for(Item tr : toRemove)
            {
                items.remove(tr);

            }
        }


    }

}
