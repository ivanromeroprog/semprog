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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ikukl
 */
public class MecanicosListadoController implements Initializable {

    @FXML
    private Button btningreso1;
    @FXML
    private Button btningreso2;
    @FXML
    private Button btningreso;
    private AnchorPane lista;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    
    @FXML
    private void switchToMecanicos() throws IOException {
        //App.setRoot("Mecanicos",400,600);
        
        //Cerrar esta ventana
        //((Stage) menup.getScene().getWindow()).close();
        
        App.newWindow("Mecanicos",((Stage) lista.getScene().getWindow()),"Nuevo Mecánico");
    }
    
        
    @FXML
    private void switchToMecanicosEditar() throws IOException {
        //App.setRoot("Mecanicos",400,600);
        
        //Cerrar esta ventana
        //((Stage) menup.getScene().getWindow()).close();
        
        App.newWindow("Mecanicos",((Stage) lista.getScene().getWindow()),"Editar Mecánico");
    }
    
            @FXML
    private void eliminar(ActionEvent event) {
        String mensaje = "¿Está seguro que quiere eliminar este mecanico?";
         Alert alert = new Alert(Alert.AlertType.CONFIRMATION, mensaje, ButtonType.YES, ButtonType.NO);
        alert.showAndWait();
    }
    
}
