package com.company;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class TeamItem extends Item {
    int priority;
    LocalDate deadline;
    ArrayList<User> users;

    TeamItem(String taskInput, int priorityInput, LocalDate deadlineInput){
        task = taskInput;
        priority = priorityInput;
        deadline = deadlineInput;

    }
}

// Team lists are associated with a group of two or more users, and serve as a
// todo list for a team. Team list items can be assigned to one or more users.
// Team list items have mandatory deadlines and priorities, but do not have
// the option of adding a suggested date/time range.