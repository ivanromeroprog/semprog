/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.seminarioprogramacion.semtest;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ikukl
 */
public class AsignarTurnoController implements Initializable {

    @FXML
    private Button btnguardar;
    @FXML
    private Button btncancelar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    private void cancelar() throws IOException {
        //Cerrar esta ventana
        ((Stage) btncancelar.getScene().getWindow()).close();
    }
    
    
    @FXML
    private void guardar() throws IOException {
        //Cerrar esta ventana
        ((Stage) btnguardar.getScene().getWindow()).close();
    }
    
        @FXML
    private void switchToSeleccionarFecha() throws IOException {
        //App.setRoot("testui",400,600);
        
        //Cerrar esta ventana
        //((Stage) menup.getScene().getWindow()).close();
        
        App.newWindow("SeleccionarFecha",((Stage) btnguardar.getScene().getWindow()),"Seleccionar Fecha y Hora");
    }
    
    
}
