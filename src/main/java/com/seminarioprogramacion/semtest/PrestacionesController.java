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
 * @author Esther
 */
public class PrestacionesController implements Initializable {

    @FXML
    private Button btnCargarFichaMecanica;
    @FXML
    private Button btnImprimirConstanciaConformidad;
    @FXML
    private Button btnRegistrarConformidad;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void switchToCargarFichaMecanica(ActionEvent event) throws IOException{
        App.newWindow("Cargar_Ficha_Mecanica",((Stage) btnCargarFichaMecanica.getScene().getWindow()),"Cargar Ficha Mecánica");
    }

    @FXML
    private void imprimirConstanciaConformidad(ActionEvent event) throws IOException{
        String mensaje = "¿Desea imprimir la constancia de conformidad?";
        Alert alert = new Alert(Alert.AlertType.INFORMATION, mensaje, ButtonType.OK, ButtonType.CANCEL);
        alert.showAndWait();
    }

    @FXML
    private void registrarConformidad(ActionEvent event) throws IOException{
        String mensaje = "¿El titular está conforme con las prestaciones realizadas?";
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, mensaje, ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
        alert.showAndWait();
    }
    
}
