package com.dexlock;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;


public class connectToDb {
    Connection conn;

    public connectToDb() {
        conn = null;
        try {
            Class.forName("org.sqlite.JDBC");
            String path = "jdbc:sqlite:../studentDatabase.db";


//            connect to database
            conn = DriverManager.getConnection(path);

            System.out.println("Connection has been established");


        } catch (SQLException | ClassNotFoundException err) {
            System.out.println(err.getMessage());
        }

    }

    public void addStudent(Integer rollNumber, String name, Integer mark, String className) {
        String SQL = "INSERT INTO students(roll_number,name,class_name,mark) VALUES(?,?,?,?)";

        try {
            PreparedStatement statement = conn.prepareStatement(SQL);

            statement.setInt(1, rollNumber);
            statement.setString(2, name);

            statement.setString(3, className);
            statement.setInt(4, mark);

            statement.executeUpdate();

            System.out.println("Successfully added");

        } catch (SQLException err) {
            System.out.println(err.getMessage());
            System.out.println(err.getErrorCode());
        }
    }

    public void listStudents(){
        
    }

}
