/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.seminarioprogramacion.controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class AseguradoraController implements Initializable {

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
    private void guardar(ActionEvent event) {
        //Cerrar esta ventana
        ((Stage) btnguardar.getScene().getWindow()).close();

    }

    @FXML
    private void cancelar(ActionEvent event) {
        ((Stage) btncancelar.getScene().getWindow()).close();
    }
}
