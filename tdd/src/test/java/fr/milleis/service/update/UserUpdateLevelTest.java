package fr.milleis.service.update;

import org.junit.Test;

import fr.milleis.User;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.util.ArrayList;
import java.util.List;

public class UserUpdateLevelTest {

    UserUpdateLevel service = new UserUpdateLevel();

    @Test
    public void testUpdateOK() {
        List<User> users = new ArrayList<>();
        var user1 = new User("JO", "Ar", 36, "tech lead", "ajosse", "pass");
        var user2 = new User("MA", "Do", 22, "Dev", "dmavo", "pass");
        var user3 = new User("PU", "Th", 51, "CDP", "tp", "pass");
        var user4 = new User("YOLO", "YOLO", 17, "Minor", "yy", "pass");

        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);

        var users2 = service.run(users);
        assertEquals(3, users2.stream().filter(d -> d.getLevel().equals("major")).count());
        assertEquals(1, users2.stream().filter(d -> !d.getLevel().equals("major")).count());

    }

    @Test
    public void userIsEmpty() {
        List<User> users1 = new ArrayList<>();
        var user1 = new User("JO", "Ar", 36, "tech lead", "ajosse", "pass");
        var user4 = new User("YOLO", "YOLO", 17, "Minor", "yy", "pass");

        users1.add(user1);
        users1.add(null);
        users1.add(user4);

        assertThrows(NullPointerException.class, () -> {
            service.run(users1);
        });

    }

    @Test
    public void ageNotPositive() {
        List<User> users1 = new ArrayList<>();

        var user1 = new User("null", "null", -1, "null", "null", " null");
        users1.add(user1);

        //var users = service.updateLevel(users1);

        assertThrows(IllegalArgumentException.class, () -> {
            service.run(users1);
        });
    }

}