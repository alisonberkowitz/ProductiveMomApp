package com.mobileproto.mommyapp;

import java.util.ArrayList;

/**
 * Created by Chloe Local on 11/11/13.
 */
public class Mom {

    private String name;
    private int percent_full;
    private ArrayList<Task> tasks;

    public Mom(String name){
        this.name = name;
        this.percent_full = 0;
        this.tasks = new ArrayList<Task>();
    }

    //increments by 10%
    public void incr_glass(){
        if (this.getPercent_full() == 5) {
            //for now, lets just leave it
        }
        else{
            setPercent_full(getPercent_full()+1);
        }
    }


    public int getPercent_full() {
        return percent_full;
    }

    public void setPercent_full(int percent_full) {
        this.percent_full = percent_full;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void setTasks(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }
}
