package com.dexlock;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;



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

    public void listThreeTopStudents() {
        String SQL = "SELECT * from students ORDER BY mark DESC LIMIT 3 ";

        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(SQL);

            System.out.println("The Top 3 Students are" + "\n");
            while (rs.next()) {
                System.out.println(rs.getString("name") + "\t" + rs.getString("class_name") + "\t" + rs.getInt("mark") + "\t" + rs.getInt("roll_number"));
            }


        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
    }

    public boolean checkIfStudentAlreadyExist(Integer roll_number,String class_name){
        String SQL="SELECT * FROM students WHERE roll_number = ?  AND class_name = ?";

        try{
            PreparedStatement statement=conn.prepareStatement(SQL);


            statement.setInt(1,roll_number);
            statement.setString(2,class_name);

            System.out.println(statement);
            ResultSet result= statement.executeQuery();

//            go to the last position of the result set to get the maximum index
            while(result.next()){
//               keep iterating
            }


            int lengthOfResult=result.getRow();
            System.out.println(lengthOfResult);




        }
        catch(SQLException  err){
            System.out.println(err.getMessage());
        }
        return true;
    }


}
