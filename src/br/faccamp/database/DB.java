package br.faccamp.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {

    private static DB db;

    private DB() {
        DBSetup.setup();
    }
    
    
    public static DB DBinstance(){
        if (db==null) {
            db = new DB();
        }
        return db;
    }
    
    public Connection getConnection() throws SQLException{
        return DriverManager.getConnection("jdbc:hsqldb:mem:aname", "sa", "");
    }
}
