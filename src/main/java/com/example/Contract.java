package com.example;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Contract {
    private String requirements;
    private String[] languages;
    private Date start, end;
    private int rate;
    private int id;

    public Contract(int id, String requirements, String[] languages, String startDate, String endDate, int rate)
            throws ParseException {
        this.id = id;
        this.requirements = requirements;
        this.languages = languages;
        start = new SimpleDateFormat("dd/MM/yyyy").parse(startDate);
        end = new SimpleDateFormat("dd/MM/yyyy").parse(endDate);
        this.rate = rate;
    }

    public int getMoney() {
        return this.rate;
    }

    public int getId() {
        return this.id;
    }

    public Date start() {
        return this.start;
    }

    public Date end() {
        return this.end;
    }

    public String toString() {
        return requirements + ". " + Dev.array(languages) + ". " + start + ", " + end + ". $" + rate;
    }
}
