package com.jim.spring.command;

/**
 * Created by jim on 17-11-17.
 */
public class ChartCommand {

    String year;
    int score;

    public ChartCommand(String year, int score) {
        this.year = year;
        this.score = score;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
