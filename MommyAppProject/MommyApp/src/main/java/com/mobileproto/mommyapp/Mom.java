package com.mobileproto.mommyapp;

/**
 * Created by Chloe Local on 11/11/13.
 */
public class Mom {

    private String name;
    private int percent_full;

    public Mom(String name){
        this.name = name;
        this.percent_full = 0;
    }

    //increments by 10%
    public void incr_glass(){
        setPercent_full(getPercent_full()+10);
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
}