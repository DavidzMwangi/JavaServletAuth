/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author mwang
 */
public class DBConnection {
    public static Connection getConnection(){
        Connection connection;

        String url = "jdbc:mysql://localhost:3306/rahab";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(url,"root","");
            System.out.println("Connection successful");
            return connection;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
