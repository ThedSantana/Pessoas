package main;

import java.sql.Connection;
import java.sql.DriverManager;

public class Tool {
	
    public static Connection getConnection(){
        
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cadastro_pessoa", "root", "kirchoff");
        } catch (Exception e) {
            System.out.println("Ops! We had an issue!");
			System.out.println(e.getMessage());
        }
        if(conn != null){
            return conn;
        }
        return null;
    }

}
