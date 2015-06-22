package com.shevtcov.objects;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by deadRabbit on 18.06.2015.
 */
public class Operation {

    private static String URL = "jdbc:postgresql://localhost:5432/userBD";
    private static String USER = "postgres";
    private static String PASS = "qweszxc";
    private static String DRIVER = "org.postgresql.Driver";

    private Connection getConnection() throws Exception {
        Class.forName(DRIVER);

        return DriverManager.getConnection(URL, USER, PASS);
    }

    private ArrayList<User> users = new ArrayList<>();

    public ArrayList<User> getUsers() {
        return users;
    }



    public User getUser(Long id) throws Exception {
        Connection con  = getConnection();

        PreparedStatement pr = con.prepareStatement("SELECT * FROM user_profile WHERE id = ?");
        pr.setLong(1, id);
        User u = new User();
        ResultSet rs =  pr.executeQuery();
        while (rs.next()) {

            u.setId(rs.getLong("id"));
            u.setLogin(rs.getString("login"));
            u.setPassword(rs.getString("password"));
            u.setName(rs.getString("name"));
            u.setAge(rs.getInt("age"));
        }

        pr.executeQuery();


        return u;
    }

    public void updateUser(Long id, User user) throws Exception {
        Connection con  = getConnection();

        PreparedStatement pr = con.prepareStatement("UPDATE user_profile SET login = ?, password = ?, age = ?, name = ? WHERE id = ?");
        pr.setString(1, user.getLogin());
        pr.setString(2, user.getPassword());
        pr.setInt(3, user.getAge());
        pr.setString(4, user.getName());
        pr.setLong(5, id);


        pr.executeQuery();
    }

    public void addUser(User user) throws Exception {

            Connection con = getConnection();
            String sql = "INSERT INTO user_profile(login, password, age, name) VALUES(?, ?, ?, ?) ";

            PreparedStatement pr = con.prepareStatement(sql);
            pr.setString(1, user.getLogin());
            pr.setString(2, user.getPassword());
            pr.setInt(3, user.getAge());
            pr.setString(4, user.getName());


            pr.executeQuery();

        //users.add(user);
    }

    public void removeUser(Long id) throws Exception {
        Connection con  = getConnection();

        PreparedStatement pr = con.prepareStatement("DELETE FROM user_profile WHERE id = ?");
        pr.setLong(1, id);

        pr.executeQuery();
    }

    public ArrayList getAll() throws Exception {
        ArrayList<User> usersList = new ArrayList<>();

        Connection con  = getConnection();

        String sql = "SELECT * FROM user_profile";
        PreparedStatement pr = con.prepareStatement(sql);

        ResultSet rs =  pr.executeQuery();
        while (rs.next()){
            User u = new User();
            u.setId(rs.getLong("id"));
            u.setLogin(rs.getString("login"));
            u.setPassword(rs.getString("password"));
            u.setName(rs.getString("name"));
            u.setAge(rs.getInt("age"));
            usersList.add(u);
        }
        return usersList;
    }

}
