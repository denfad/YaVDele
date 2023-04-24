package ru.denfad.yavdele;

import java.util.ArrayList;
import java.util.List;

import ru.denfad.yavdele.Model.Team;

public class Service {
    private static Service instance;
    private List<Team> teams = new ArrayList<>();

    private Service() {
        teams.add(new Team("Трамвайчики", "Coding👩‍💻"));
        teams.add(new Team("Компашка друзей", "Настолки🎲"));
        teams.add(new Team("Сборная двора", "Спорт🏅"));
        teams.add(new Team("Книголюбы", "Книги📚"));
    }

    public static Service getInstance() {
        if(instance == null) instance = new Service();
        return  instance;
    }

    public List<Team> getTeams() {
        return teams;
    }
}
