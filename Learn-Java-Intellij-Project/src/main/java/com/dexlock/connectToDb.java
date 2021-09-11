package com.dexlock;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class connectToDb {


    public connectToDb() {
        Connection conn = null;
        try
        {
            String path="jdbc:sqlite:/studentDatabase.db";
//            connect to database
            conn=DriverManager.getConnection(path);

            System.out.println("Connection has been established");
        }
        catch(SQLException err)
        {
            System.out.println(err.getMessage());
        }

    }
    
}
