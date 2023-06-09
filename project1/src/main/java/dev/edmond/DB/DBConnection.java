package dev.edmond.DB;

import java.sql.DriverManager;
import java.sql.SQLException;

import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;


import java.sql.Connection;

@Component
public class DBConnection {
    
    private static Connection dbConnection;
    public final static String DB_CONN_URL = "jdbc:h2:tcp://localhost/~/students";
    public final static String DB_USER = "edmond";
    public final static String DB_PASS = "123456";


    public static Connection getInstance() throws SQLException{
        if(dbConnection == null || dbConnection.isClosed()){
            dbConnection = DriverManager.getConnection(DB_CONN_URL, DB_USER, DB_PASS);
        }
        return dbConnection;
    }

    @PreDestroy
    public void close() throws SQLException{
        if(dbConnection != null){
            dbConnection.close();
        }
    }

   
}
