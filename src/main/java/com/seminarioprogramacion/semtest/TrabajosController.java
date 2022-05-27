/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.seminarioprogramacion.semtest;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;

/**
 * FXML Controller class
 *
 * @author ikukl
 */
public class TrabajosController implements Initializable {

    @FXML
    private Button btnaImprimir;
    @FXML
    private Button btnAprobarInforme;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void switchToAsignarTurno(ActionEvent event) {
    }
    
     @FXML
    private void imprimir(ActionEvent event) throws IOException{
        String mensaje = "¿Desea imprimir el listado de trabajos del día?";
        Alert alert = new Alert(Alert.AlertType.INFORMATION, mensaje, ButtonType.OK, ButtonType.CANCEL);
        alert.showAndWait();
    }
    
     @FXML
    private void aprobarInforme(ActionEvent event) throws IOException{
        String mensaje = "¿Está seguro que desea aprobar informe?";
        Alert alert = new Alert(Alert.AlertType.INFORMATION, mensaje, ButtonType.OK, ButtonType.CANCEL);
        alert.showAndWait();
    }
    
}
