package com.company;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class GoalItem extends Item{
    int priority;
    LocalDate deadline;
    LocalDate startRange;
    LocalDate endRange;
    ArrayList<GoalItem> subItems = new ArrayList<>();


}
