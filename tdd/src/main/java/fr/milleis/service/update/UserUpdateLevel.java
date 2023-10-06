package fr.milleis.service.update;

import java.util.List;
import java.util.Objects;

import fr.milleis.User;

public class UserUpdateLevel {

    public List<User> run(List<User> users) {

        if (users.stream().anyMatch(Objects::isNull))
            throw new NullPointerException("one user is null");

        if (users.stream().anyMatch(e -> e.getAge() < 0)) {
            throw new IllegalArgumentException("Age should be positive");
        }
        users.stream().forEach(e -> e.setLevel(e.getAge() > 18 ? "major" : "minor"));

        return users;
    }
}