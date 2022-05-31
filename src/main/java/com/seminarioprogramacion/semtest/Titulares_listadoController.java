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
import javafx.scene.control.TableView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ikukl
 */
public class Titulares_listadoController implements Initializable {

    @FXML
    private Button btningreso1;
    @FXML
    private Button btningreso2;
    @FXML
    private Button btningreso;
    @FXML
    private TableView<?> lista;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void switchToTitulares() throws IOException {
        //App.setRoot("Titulares",400,600);
        
        //Cerrar esta ventana
        //((Stage) menup.getScene().getWindow()).close();
        
        App.newWindow("Titulares",((Stage) lista.getScene().getWindow()),"Nuevo Mecánico");
    }
    
        
    @FXML
    private void switchToTitularesEditar() throws IOException {
        //App.setRoot("Titulares",400,600);
        
        //Cerrar esta ventana
        //((Stage) menup.getScene().getWindow()).close();
        
        App.newWindow("Titulares",((Stage) lista.getScene().getWindow()),"Editar Mecánico");
    }
    
        
    @FXML
    private void eliminar(ActionEvent event) {
        String mensaje = "¿Está seguro que quiere eliminar este titular?";
         Alert alert = new Alert(Alert.AlertType.CONFIRMATION, mensaje, ButtonType.YES, ButtonType.NO);
        alert.showAndWait();
    }
    
}
