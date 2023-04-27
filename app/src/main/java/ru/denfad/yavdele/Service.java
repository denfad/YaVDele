package ru.denfad.yavdele;

import java.util.ArrayList;
import java.util.List;

import ru.denfad.yavdele.Model.Event;
import ru.denfad.yavdele.Model.Team;
import ru.denfad.yavdele.Model.User;

public class Service {
    private static Service instance;
    private List<Team> teams = new ArrayList<>();
    private List<Event> events = new ArrayList<>();
    private List<User> users = new ArrayList<>();
    private List<String> tags = List.of("#SQL", "#Java", "#C#", "#Аналитика", "#DataBases", "#Музыка", "#Гитара", "#Светошоу", "#Футбол", "#DnD", "#UNO");

    private Service() {

        events.add(new Event("Хакатон МОСПРОМ", "23 - 23 мая", "online", "Москва", List.of("#SQL", "#Java", "#C#", "#Аналитика", "#DataBases", "#DataScience", "#Arduino")));
        events.add(new Event("Концерт на Соколе", "2 июня", "offline", "Звенигород", List.of("#Музыка", "#Гитара", "#Светошоу")));
        events.add(new Event("Любительский чемпионат", "1 мая", "offline", "Москва", List.of("#Футбол")));
        events.add(new Event("Настолки", "23 - 23 мая", "offline", "Москва", List.of("#DnD", "#UNO")));
        events.add(new Event("Хакатон МОСПРОМ", "23 - 23 мая", "online", "Москва", List.of("#SQL", "#Java", "#C#", "#Аналитика", "#DataBases", "#DataScience", "#Arduino")));
        events.add(new Event("Концерт на Соколе", "2 июня", "offline", "Звенигород", List.of("#Музыка", "#Гитара", "#Светошоу")));
        events.add(new Event("Любительский чемпионат", "1 мая", "offline", "Москва", List.of("#Футбол")));
        events.add(new Event("Настолки", "23 - 23 мая", "offline", "Москва", List.of("#DnD", "#UNO")));


        teams.add(new Team("#DEFINE", "#Coding👩‍💻", "Москва", "Самая активная команда МАИ по хакатонам. Мы настолько любим хакатоны, что готовы брать мобильных разработчиков в рабство", List.of("#SQL", "#Java", "#C#", "#Аналитика", "#DataBases", "#DataScience", "#Arduino")));
        teams.add(new Team("Забиваки", "#Спорт🏅", "Кубинка", "Любительская команда ищет полузащитников", List.of("#ФутболL", "#Полузащиник", "#Защитник")));
        teams.add(new Team("Мастер и маргаритка", "#Книги‍📚", "Москва, МГУ", "Клуб читающих людей МГУ ищет новых участников книжных вечеров", List.of("#Книги", "#Художественное", "#История", "#Биография")));


        users.add(new User("Дмитрий Штапов", "galka", "Москва", List.of("#SQL", "#Java", "#C#", "#Аналитика", "#DataBases", "#DataScience", "#Arduino")));
        users.add(new User("Алина Димерева", "galka", "Тверь", List.of("#SQL", "#Java", "#C#", "#Аналитика", "#DataBases", "#DataScience", "#Arduino")));
        users.add(new User("Саша Голубь", "galka", "Казань", List.of("#SQL", "#Java", "#C#", "#Аналитика", "#DataBases", "#DataScience", "#Arduino")));
        users.add(new User("Мишаня", "galka", "Красногорск", List.of("#SQL", "#Java", "#C#", "#Аналитика", "#DataBases", "#DataScience", "#Arduino")));
        users.add(new User("Кирилыч", "galka", "Чита", List.of("#SQL", "#Java", "#C#", "#Аналитика", "#DataBases", "#DataScience", "#Arduino")));
        users.add(new User("Егорыч", "galka", "Москва, Лосиный Остров", List.of("#SQL", "#Java", "#C#", "#Аналитика", "#DataBases", "#DataScience", "#Arduino")));
        users.add(new User("Максимка", "galka", "Москва, где-то", List.of("#SQL", "#Java", "#C#", "#Аналитика", "#DataBases", "#DataScience", "#Arduino")));
        users.add(new User("Дмитрий Штапов", "galka", "Москва", List.of("#SQL", "#Java", "#C#", "#Аналитика", "#DataBases", "#DataScience", "#Arduino")));
        users.add(new User("Дмитрий Штапов", "galka", "Москва", List.of("#SQL", "#Java", "#C#", "#Аналитика", "#DataBases", "#DataScience", "#Arduino")));
        users.add(new User("Дмитрий Штапов", "galka", "Москва", List.of("#SQL", "#Java", "#C#", "#Аналитика", "#DataBases", "#DataScience", "#Arduino")));
        users.add(new User("Дмитрий Штапов", "galka", "Москва", List.of("#SQL", "#Java", "#C#", "#Аналитика", "#DataBases", "#DataScience", "#Arduino")));
        users.add(new User("Дмитрий Штапов", "galka", "Москва", List.of("#SQL", "#Java", "#C#", "#Аналитика", "#DataBases", "#DataScience", "#Arduino")));
        users.add(new User("Дмитрий Штапов", "galka", "Москва", List.of("#SQL", "#Java", "#C#", "#Аналитика", "#DataBases", "#DataScience", "#Arduino")));
        users.add(new User("Дмитрий Штапов", "galka", "Москва", List.of("#SQL", "#Java", "#C#", "#Аналитика", "#DataBases", "#DataScience", "#Arduino")));
        users.add(new User("Дмитрий Штапов", "galka", "Москва", List.of("#SQL", "#Java", "#C#", "#Аналитика", "#DataBases", "#DataScience", "#Arduino")));
        users.add(new User("Дмитрий Штапов", "galka", "Москва", List.of("#SQL", "#Java", "#C#", "#Аналитика", "#DataBases", "#DataScience", "#Arduino")));
        users.add(new User("Дмитрий Штапов", "galka", "Москва", List.of("#SQL", "#Java", "#C#", "#Аналитика", "#DataBases", "#DataScience", "#Arduino")));
        users.add(new User("Дмитрий Штапов", "galka", "Москва", List.of("#SQL", "#Java", "#C#", "#Аналитика", "#DataBases", "#DataScience", "#Arduino")));
        users.add(new User("Дмитрий Штапов", "galka", "Москва", List.of("#SQL", "#Java", "#C#", "#Аналитика", "#DataBases", "#DataScience", "#Arduino")));

    }

    public static Service getInstance() {
        if(instance == null) instance = new Service();
        return  instance;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public List<Event> getEvents() {
        return events;
    }

    public List<User> getUsers() {
        return users;
    }

    public List<String> getTags() {
        return tags;
    }
}
