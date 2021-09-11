package com.dexlock;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class connectToDb {


    public connectToDb() {
        Connection conn = null;
        try
        {
            Class.forName("org.sqlite.JDBC");
            String path="jdbc:sqlite:../studentDatabase.db";
//            connect to database
            conn=DriverManager.getConnection(path);

            System.out.println("Connection has been established");
        }
        catch(SQLException | ClassNotFoundException err)
        {
            System.out.println(err.getMessage());
        }

    }
    
}
