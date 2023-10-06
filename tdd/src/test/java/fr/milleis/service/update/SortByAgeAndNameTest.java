package fr.milleis.service.update;


import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import fr.milleis.User;

public class SortByAgeAndNameTest {

    SortByAgeAndName service = new SortByAgeAndName();

    @Test
    public void testSortByAgeTest() {
        List<User> users = new ArrayList<>();
        var user1 = new User("JO", "Ar", 36, "tech lead", "ajosse", "pass");
        var user2 = new User("MA", "Do", 22, "Dev", "dmavo", "pass");
        var user3 = new User("PU", "Th", 51, "CDP", "tp", "pass");
        var user4 = new User("YOLO", "YOLO", 17, "Minor", "yy", "pass");

        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);

        var expected = new ArrayList<User>();
        expected.add(user4);
        expected.add(user2);
        expected.add(user1);
        expected.add(user3);

        service.run(users);

        assertTrue(expected.equals(users));

    }

    @Test
    public void testSortByAgeTestThrowIfNull() {
        List<User> users = new ArrayList<>();
        var user1 = new User("JO", "Art", 36, "tech lead", "ajosse", "pass");
        var user2 = new User("MA", "Do", 22, "Dev", "dmavo", "pass");
        var user3 = new User("PU", "Th", 51, "CDP", "tp", "pass");
        var user4 = new User("YOLO", "YOLO", 17, "Minor", "yy", "pass");

        users.add(user1);
        users.add(null);
        users.add(user3);
        users.add(user4);

        var expected = new ArrayList<User>();
        expected.add(user4);
        expected.add(user2);
        expected.add(user1);
        expected.add(user3);

        assertThrows(NullPointerException.class, () -> service.run(users));

    }

}
