/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seminarioprogramacion.dao;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.sqlite.JDBC;

/**
 *
 * @author agustin
 */
public class ConexionSql { //Singleton
    private String URL = "jdbc:sqlite:";
    private Connection connection = null; //instancia de una conexion SQL (Java)
    private static ConexionSql instancia = null;
    
    
    private ConexionSql() {
        if (connection == null) {
            try {
                
                //connection = DriverManager.getConnection("jdbc:sqlite:C:/sqlite/SuperCharger.db");
                String url = getClass().getResource("SuperCharger.db").toURI().toString();
                connection = DriverManager.getConnection("jdbc:sqlite:"+url);
                
                if (connection != null) {
                    System.out.println("DB: Conexión OK");
                }
            } catch (SQLException e) {
                System.out.println(e);
            } catch (URISyntaxException e) {
                System.out.println(e);
            }
        }
    }
    
    public static ConexionSql getInstancia() {
        if(instancia == null) {
            instancia = new ConexionSql();
        }else{
            System.out.println("DB: Ya estas conectado, devolviendo instancia.");
        }
        return instancia;
    }
    
    public Connection getConnection() {
        return connection;
    }
    
    protected void desconectar() {
        try {
            connection.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        connection = null;
    }
    
}
