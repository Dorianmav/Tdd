package fr.milleis.service;

import java.util.List;
import java.util.stream.Collectors;

import fr.milleis.User;

public class UserService {

    public List<User> getMajorUsers(List<User> users) {
        if (users == null)
            return List.of();
        return users.stream().filter(d -> d.getAge() > 18).collect(Collectors.toList());
    }

    public User authenticate(String login, String pass) {

        User user = null;
        if (login == "ajosse" && pass == "pass") {
            user = new User("JOSSEAU", "Arthur", 36, "tech lead","ajosse", "pass");
        }
        return user;

    }

}