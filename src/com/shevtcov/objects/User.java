package com.shevtcov.objects;

/**
 * Created by deadRabbit on 18.06.2015.
 */
public class User {

    private Long id;
    private String login;
    private String password;
    private String name;
    private int age;

    public User() {
        super();
    }

    public User(String login, String password,int age, String name ) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.age = age;
    }

    public User(Long id, String login, String password, int age, String name) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.name = name;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
