package ru.denfad.yavdele.Model;

import java.util.List;

public class Event {
    private String name;
    private String date;
    private String online;
    private String place;
    private List<String> tags;

    public Event(String name, String date, String online, String place, List<String> tags) {
        this.name = name;
        this.date = date;
        this.online = online;
        this.place = place;
        this.tags = tags;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getOnline() {
        return online;
    }

    public void setOnline(String online) {
        this.online = online;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}
