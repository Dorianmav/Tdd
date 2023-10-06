package fr.milleis.service.update;

import java.util.List;
import java.util.Objects;

import fr.milleis.User;

public class UserUpdateFirstnameToLowerCase {

    public void run(List<User> users) {
        if (users.stream().anyMatch(Objects::isNull))
            throw new NullPointerException("one user is null");
            
        if (users.stream().anyMatch(e -> e.getFirstname().equals(null)))
            throw new NullPointerException("The name of this user is null");

        if (users.stream().anyMatch(e -> e.getFirstname().equals("")))
            throw new IllegalArgumentException("This field is empty");

        users.stream()
                .filter(e -> e.getFirstname().charAt(0) == 'A')
                .forEach(e -> e.setName(e.getName().toLowerCase()));
    }
}