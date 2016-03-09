package com.example.bradley.calendarapp;

import java.util.ArrayList;

/**
 * Created by Bradley on 3/8/2016.
 */
public class Event {
    private String date;
    private String title;
    private String time;
    public Event(){

    }
    public Event(String date, String title, String time){
        this.date = date;
        this.title = title;
        this.time = time;
    }
    public void setTime(String t){
        this.time = t;
    }
    public String getTime(){return this.time;}
    public String getTitle(){return this.title;}
}
