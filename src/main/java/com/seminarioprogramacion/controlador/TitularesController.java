/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.seminarioprogramacion.controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ikukl
 */
public class TitularesController implements Initializable {

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

}
