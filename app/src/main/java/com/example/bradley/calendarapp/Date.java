package com.example.bradley.calendarapp;

import java.util.ArrayList;

/**
 * Created by Bradley on 3/8/2016.
 */
public class Date {
    private String date;
    private ArrayList<Event> aList = new ArrayList<>();
    public Date(){

    }
    public Date(String date){

    }
    public void addEvent(Event event) {
        aList.add(event);
    }
    public void changeTime(String title, String time){
        ArrayList<Event> a = aList;

        for(int i = 0; i < a.size(); i++){
            if(a.get(i).getTitle().equals(title)){
                a.get(i).setTime(time);
            }
        }
    }
    public ArrayList<Event> getAList() {
        return this.aList;
    }
    public void delete(String name){
        ArrayList<Event> a = aList;

        for(int i = 0; i < a.size(); i++){
            if(a.get(i).getTitle().equals(name)){
                a.remove(i);
            }
        }
    }
    @Override
    public String toString(){
        String r;
        ArrayList<Event> a = aList;
        r = date;
        for(int i = 0; i < a.size(); i++){
            r = r + a.get(i);
        }
        return r;
    }

}
