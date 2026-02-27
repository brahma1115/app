package com.simats.afinal;

public class Report {
    private final String title;
    private final String details;

    public Report(String title, String details) {
        this.title = title;
        this.details = details;
    }

    public String getTitle() {
        return title;
    }

    public String getDetails() {
        return details;
    }
}
