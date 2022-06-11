/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.seminarioprogramacion.controlador;

import com.seminarioprogramacion.main.App;
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
public class GestionAseguradoraController implements Initializable {

    /**
     * Initializes the controller class.
     * @param url
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
     @FXML
    private Button btnNuevo;
    @FXML
    private Button btnModificar;
    
    @FXML
    private void NuevaAseguradora(ActionEvent event) throws IOException {
         App.newWindow("Aseguradora",((Stage) btnNuevo.getScene().getWindow()),"Nueva Aseguradora");

    }

    @FXML
    private void ModificarAseguradora(ActionEvent event) throws IOException {
        App.newWindow("Aseguradora",((Stage) btnNuevo.getScene().getWindow()),"Modificar Aseguradora");
    }

    @FXML
    private void EliminarAseguradora(ActionEvent event) {
        String mensaje = "¿Está seguro que quiere eliminar ésta Aseguradora?";
         Alert alert = new Alert(Alert.AlertType.CONFIRMATION, mensaje, ButtonType.YES, ButtonType.NO);
        alert.showAndWait();
    }
}
