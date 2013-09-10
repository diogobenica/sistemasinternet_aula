package br.faccamp.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DBSetup {

    
    public static void setup() {
        String sql = " CREATE TABLE POSTS (TITULO VARCHAR(50), CONTEUDO VARCHAR(300));";
        try {
            Class.forName("org.hsqldb.jdbcDriver");
            Connection  connection = DriverManager.getConnection("jdbc:hsqldb:mem:aname", "sa", "");
            
            Statement statement = null;
            statement = connection.createStatement();
            statement.execute(sql);
            
            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
}
