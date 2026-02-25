package com.simats.afinal;

public class PatientHistoryItem {
    private final String timestamp;
    private final String eventTitle;
    private final String eventDescription;
    private final int eventIcon;
    private final int dotDrawable;

    public PatientHistoryItem(String timestamp, String eventTitle, String eventDescription, int eventIcon, int dotDrawable) {
        this.timestamp = timestamp;
        this.eventTitle = eventTitle;
        this.eventDescription = eventDescription;
        this.eventIcon = eventIcon;
        this.dotDrawable = dotDrawable;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public int getEventIcon() {
        return eventIcon;
    }

    public int getDotDrawable() {
        return dotDrawable;
    }
}
