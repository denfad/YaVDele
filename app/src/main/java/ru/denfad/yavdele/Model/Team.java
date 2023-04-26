package ru.denfad.yavdele.Model;

import java.util.List;

public class Team {
    private String name;
    private String activity;
    private String place;
    private String description;
    private List<String> tags;

    public Team(String name, String activity) {
        this.name = name;
        this.activity = activity;
    }

    public Team(String name, String activity, String place, String description, List<String> tags) {
        this.name = name;
        this.activity = activity;
        this.place = place;
        this.description = description;
        this.tags = tags;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
