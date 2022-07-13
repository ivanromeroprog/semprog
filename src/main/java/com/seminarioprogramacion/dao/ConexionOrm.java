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
 * @author Esther
 */
public class ConexionOrm {
    private String Url = "jdbc:sqlite:";
    
    public ConexionOrm(){
        try {
            //connection = DriverManager.getConnection("jdbc:sqlite:C:/Users/ikukl/SuperCharger.db");
            Url = "jdbc:sqlite:" + getClass().getResource("SuperCharger.db").toURI().toString();
        } catch (URISyntaxException ex) {
            Logger.getLogger(ConexionOrm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String GetConexion(){
        return this.Url;
    }
}
