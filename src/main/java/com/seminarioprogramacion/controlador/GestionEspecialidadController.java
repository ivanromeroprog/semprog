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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Nahue
 */
public class GestionEspecialidadController implements Initializable {

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
    private void NuevoEspecialidad(ActionEvent event) throws IOException {
         App.newWindow("Especialidad",((Stage) btnNuevo.getScene().getWindow()),"Nueva Especialidad");

    }

    @FXML
    private void ModificarEspecialidad(ActionEvent event) throws IOException {
        App.newWindow("Especialidad",((Stage) btnNuevo.getScene().getWindow()),"Modificar Especialidad");
    }

    @FXML
    private void EliminarEspecialidad(ActionEvent event) {
        String mensaje = "¿Está seguro que quiere eliminar ésta especialidad?";
         Alert alert = new Alert(AlertType.CONFIRMATION, mensaje, ButtonType.YES, ButtonType.NO);
        alert.showAndWait();
    }

}
