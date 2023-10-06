package fr.milleis.service.update;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import fr.milleis.User;

public class UserUpdateFirstnameToLowerCaseTest {

    UserUpdateFirstnameToLowerCase service = new UserUpdateFirstnameToLowerCase();

    @Test
    public void updateToLowerCaseFirstCharOfFirstname() {
        List<User> users = new ArrayList<>();
        var user1 = new User("JO", "Ar", 36, "tech lead", "ajosse", "pass");
        var user2 = new User("MA", "Do", 22, "Dev", "dmavo", "pass");
        var user3 = new User("PU", "Th", 51, "CDP", "tp", "pass");
        var user4 = new User("YOLO", "YOLO", 17, "Minor", "yy", "pass");
        var user5 = new User("aOLO", "YOLO", 17, "Minor", "yy", "pass");

        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);

        service.run(users);

        assertTrue(user1.getName().equals("jo"));
    }

    @Test
    public void updateToLowerCaseNullUser() {

        List<User> users = new ArrayList<>();
        var user1 = new User("JO", "Ar", 36, "tech lead", "ajosse", "pass");
        var user2 = new User("MA", "Do", 22, "Dev", "dmavo", "pass");
        var user4 = new User("", "YOLO", 17, "Minor", "yy", "pass");
        var user5 = new User("aOLO", "YOLO", 17, "Minor", "yy", "pass");

        users.add(user1);
        users.add(user2);
        users.add(null);
        users.add(user4);
        users.add(user5);

        assertThrows(NullPointerException.class, () -> {
            service.run(users);
        });

    }

    @Test
    public void updateNoFirstname() {
        List<User> users = new ArrayList<>();
        var user1 = new User("JO", "Ar", 36, "tech lead", "ajosse", "pass");
        var user2 = new User("MA", "Do", 22, "Dev", "dmavo", "pass");
        var user3 = new User("PU", "", 51, "CDP", "tp", "pass");
        var user4 = new User("YOLO", "YOLO", 17, "Minor", "yy", "pass");
        var user5 = new User("aOLO", "YOLO", 17, "Minor", "yy", "pass");

        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);

        assertThrows(IllegalArgumentException.class, () -> {
            service.run(users);
        });
    }

}
