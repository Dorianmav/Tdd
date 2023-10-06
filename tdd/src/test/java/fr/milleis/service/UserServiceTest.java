package fr.milleis.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import fr.milleis.User;

public class UserServiceTest {

    UserService service = new UserService();

    @Test
    public void getMajorUserTest() {
        ArrayList<User> users = new ArrayList<>();
        var user1 = new User("JOSSEAU", "Arthur", 36, "tech lead","ajosse", "pass");
        var user2 = new User("MAVOUNGOUD", "Dorian", 22, "Dev", "dmavo", "pass");
        var user3 = new User("PUSSEY", "Thierry", 51, "CDP", "tp", "pass");
        var user4 = new User("YOLO", "YOLO", 17, "Minor", "yy", "pass");

        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);

        var majors = service.getMajorUsers(users);
        assertEquals(3, majors.size());

    }

    @Test
    public void getMajorUserTestEmptyIfNull() {
        ArrayList<User> users = null;

        var majors = service.getMajorUsers(users);
        assertEquals(0, majors.size());

    }

    @Test
    public void testAuthenticateOk() {

        var login = "ajosse";
        var pass = "pass";
        var user = this.service.authenticate(login, pass);
        assertTrue(user != null);
    }

    @Test
    public void testUserIsNull(){
        var login = "";
        var pass = "";

        var user = this.service.authenticate(login, pass);
        assertTrue(user == null);
    }

    @Test
    public void testAuthenticateOkButLoginIsNull(){
        var login = "ajosse";
        var pass = "pass";
        var user = this.service.authenticate(login, pass);
        
    }
}
