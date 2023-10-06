package fr.milleis.service.update;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import fr.milleis.User;

public class UserUpdateUsecaseTest {

    @Test
    public void updateTest(){

        UserUpdateLevel serviceLevel = new UserUpdateLevel();
        UserUpdateFirstnameToLowerCase serviceToLowerCase = new UserUpdateFirstnameToLowerCase();
        SortByAgeAndName serviceSortByAgeAndName = new SortByAgeAndName();


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

        List<User> newList = new ArrayList<>();

        //(done) when user is major , update his level to major, if minor update his level to minor 
        newList = serviceLevel.run(users);

        // (done) if user firstname begin by letter "A" put name in lower case 
        serviceToLowerCase.run(newList);
        
        // sort them by age and by name 
        serviceSortByAgeAndName.run(newList);
    
        
    }

}
