package fr.milleis;

import java.util.Comparator;

public class User implements Comparator<User> {

    private String name;
    private String firstname;
    private int age;
    private String level;
    private String login;
    private String pass;

    public User(String name, String firstname, int age, String level, String login, String pass) {
        this.name = name;
        this.firstname = firstname;
        this.age = age;
        this.level = level;
        this.login = login;
        this.pass = pass;
    }

    /**
     * @return String return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    /**
     * @return String return the firstname
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * @param firstname the firstname to set
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * @return int return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * @return String return the level
     */
    public String getLevel() {
        return level;
    }

    /**
     * @param level the level to set
     */
    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public int compare(User o1, User o2) {
        User user1 = o1;
        User user2 = o2;

        if (user1.age > user2.age) {
            return 1;
        } else if (user1.age < user2.age) {
            return -1;
        }
        return 0;
    }

}