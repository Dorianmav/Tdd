package fr.milleis.service.update;

import java.util.ArrayList;
import java.util.List;

import fr.milleis.User;

public class UserUpdateUsecase {

    UserUpdateLevel level = new UserUpdateLevel(); 
    UserUpdateFirstnameToLowerCase updateLowerCase = new UserUpdateFirstnameToLowerCase(); 
    SortByAgeAndName sort = new SortByAgeAndName(); 

    public void update(List<User> users){
        List<User> newList = new ArrayList<>();
        //(done) when user is major , update his level to major, if minor update his level to minor 
        newList = level.run(users);
        // (done) if user firstname begin by letter "A" put name in lower case 
        updateLowerCase.run(newList);
        // sort them by age and by name 
        sort.run(newList);
        
    }

}