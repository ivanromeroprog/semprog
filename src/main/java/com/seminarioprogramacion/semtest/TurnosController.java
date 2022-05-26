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
 * @author ikukl
 */
public class TurnosController implements Initializable {

    @FXML
    private Button btnasignarturno;
    @FXML
    private Button btneliminarturno;
    @FXML
    private Button brnasistencia;
    @FXML
    private Button btnfichamec;
    @FXML
    private Button btncomprobante;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    
    @FXML
    private void switchToAsignarTurno() throws IOException {
        //App.setRoot("testui",400,600);
        
        //Cerrar esta ventana
        //((Stage) menup.getScene().getWindow()).close();
        
        App.newWindow("AsignarTurno",((Stage) btnasignarturno.getScene().getWindow()),"Asignar Turno");
    }
    
        @FXML
    private void EliminarTurno(ActionEvent event) {
        String mensaje = "¿Está seguro que quiere eliminar este Turno?";
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, mensaje, ButtonType.YES, ButtonType.NO);
        alert.showAndWait();
    }
    
        
        @FXML
    private void ConfirmarAsistencia(ActionEvent event) {
        String mensaje = "¿El titular asistió al turno seleccionado?";
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, mensaje, ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
        alert.showAndWait();
    }
    
}
