package ru.denfad.yavdele.Model;

import java.util.List;

public class User {
    private String name;
    private String nickname;
    private String place;
    private List<String> tags;

    public User(String name, String nickname, String place, List<String> tags) {
        this.name = name;
        this.nickname = nickname;
        this.place = place;
        this.tags = tags;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
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
