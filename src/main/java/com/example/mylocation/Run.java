package com.example.mylocation;

import com.google.firebase.database.IgnoreExtraProperties;

public class Run {

    public String date;
    public String time;
    public String distance;
    public String avgPace;
    public String description;

    public Run() {
    }

    public Run(String date, String time, String distance, String avgPace, String description) {
        this.date = date;
        this.time = time;
        this.distance = distance;
        this.avgPace = avgPace;
        this.description = description;
    }
}
