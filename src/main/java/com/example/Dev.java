package com.example;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Dev {
    /*
     * , they will have to provide information regarding their experience.
     * At the very least this should include what proficiencies
     * they have, time available,
     * and the rate they are expecting to be paid.
     */
    private String name;
    private String[] languages;
    private int time, rate, years;
    private Date start, end;

    /**
     * Constructor for a developer object
     * 
     * @param years
     * @param languages
     * @param time
     * @param rate
     * @throws ParseException
     */
    public Dev(String devName, int years, String[] languages, int time, String startDate, String endDate, int rate)
            throws ParseException {
        this.years = years;
        this.name = devName;
        this.languages = languages;
        this.time = time;
        this.rate = rate;
        start = new SimpleDateFormat("dd/MM/yyyy").parse(startDate);
        end = new SimpleDateFormat("dd/MM/yyyy").parse(endDate);
    }

    public String getName() {
        return this.name;
    }

    public Date start() {
        return this.start;
    }

    public Date end() {
        return this.end;
    }

    public int getRate() {
        return this.rate;
    }

    public String toString() {
        return this.name + ", " + this.years + ", " + array(this.languages) + ", " + time + ", " + this.start + ", "
                + this.end + ", " + rate;
    }

    static String array(String[] arr) {
        int length = arr.length;
        String s = "[";
        for (int i = 0; i < length; i++) {
            if (i < length - 1)
                s += arr[i] + ", ";
            else {
                s += arr[i] + "]";
            }
        }
        return s;
    }
}
