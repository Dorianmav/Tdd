package fr.milleis.service.update;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

import fr.milleis.User;

public class SortByAgeAndName {

    public void run(List<User> users) {

        if (users.stream().anyMatch(Objects::isNull))
            throw new NullPointerException("one user is null");
        if (users.stream().anyMatch(e -> e.getAge() < 0))
            throw new IllegalArgumentException();

        users.stream().forEach(e -> e.setName(e.getName().toUpperCase()));

        Collections.sort(users, (user1, user2) -> {
            int equal = Integer.compare(user1.getAge(), user2.getAge());
            if (equal == 0) {
                return user1.getName().compareTo(user2.getName());
            }
            return equal;
        });

    }

}