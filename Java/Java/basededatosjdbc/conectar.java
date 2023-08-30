/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basededatosjdbc;
import java.sql.*;

/**
 *
 * @author junio
 */

import java.sql.Connection;
import java.sql.DriverManager;

public class conectar {
    private Connection conectar;
    public Connection connect(){
        Statement st;
        try{
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Connection Sucess");
        }
        catch(ClassNotFoundException cmfe){
        System.out.println("Connection Fail" + cmfe);
        }
        String url = "jdbc:mysql://localhost:3306/ik";
        try{
        conectar = DriverManager.getConnection(url,"root","junior");
        System.out.println("Database Connected");
        }
        catch(SQLException e){
            System.out.println("No Datebase" + e);
            
        }
        return conectar;
    }
    Statement createStatement(){
    throw new UnsupportedOperationException("No soportado");
    }
}

