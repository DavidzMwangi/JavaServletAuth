/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.User;

/**
 *
 * @author David
 */
public class AuthDao {
    
    //insert new user
    public static void insertUser(Connection connection, User user) {
        String sql = "INSERT into users(name, email,user_type, password) VALUES (?,?,?,?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setInt(3, user.getUser_type());

            statement.setString(4, user.getPassword());

            int i = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    
    
     //find a user using their username
    public static User findUser(Connection connection, User userCode) {
        String sql = "SELECT * FROM users WHERE name=? AND password=? ";
        User user = null;
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, userCode.getName());
            statement.setString(2, userCode.getPassword());
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {


                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");

                int userType = resultSet.getInt("user_type");
                int id = resultSet.getInt("id");

                user = new User(id, name, email, userType, password);
//                return user;
            }

        } catch (SQLException e) {

            e.printStackTrace();

        }
        return user;
    }

}
