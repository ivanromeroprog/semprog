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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Nahue
 */
public class GestionServicioController implements Initializable {

        @FXML
    private Button btnNuevo;
    @FXML
    private Button btnModificar;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    
     @FXML
    private void NuevoServicio(ActionEvent event) throws IOException {
         App.newWindow("Servicio",((Stage) btnNuevo.getScene().getWindow()),"Nuevo Servicio");

    }

    @FXML
    private void ModificarServicio(ActionEvent event) throws IOException {
        App.newWindow("Servicio",((Stage) btnNuevo.getScene().getWindow()),"Modificar Servicio");
    }

    @FXML
    private void EliminarServicio(ActionEvent event) {
        String mensaje = "¿Está seguro que quiere eliminar éste servicio?";
         Alert alert = new Alert(Alert.AlertType.CONFIRMATION, mensaje, ButtonType.YES, ButtonType.NO);
        alert.showAndWait();
    }
    
}
