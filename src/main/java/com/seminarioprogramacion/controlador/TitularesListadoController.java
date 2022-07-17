/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.seminarioprogramacion.controlador;

import com.seminarioprogramacion.dto.TitularDTO;
import com.seminarioprogramacion.main.App;
import com.seminarioprogramacion.modelo.Titular;
import java.io.IOException;
import java.net.URL;
import java.util.List;
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
public class TitularesListadoController implements Initializable {

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
        Titular titular = new Titular();
        List<TitularDTO> lista = titular.listar();
        for(TitularDTO tit: lista){
            System.out.print(tit.getNombre());
            System.out.println(tit.getApellido());
        }
    }    

    @FXML
    private void switchToTitulares() throws IOException {
        //App.setRoot("Titulares",400,600);
        
        //Cerrar esta ventana
        //((Stage) menup.getScene().getWindow()).close();
        
        App.newWindow("Titulares",((Stage) lista.getScene().getWindow()),"Nuevo Titular");
    }
    
        
    @FXML
    private void switchToTitularesEditar() throws IOException {
        //App.setRoot("Titulares",400,600);
        
        //Cerrar esta ventana
        //((Stage) menup.getScene().getWindow()).close();
        
        App.newWindow("Titulares",((Stage) lista.getScene().getWindow()),"Editar Titular");
    }
    
        
    @FXML
    private void eliminar(ActionEvent event) {
        String mensaje = "¿Está seguro que quiere eliminar este titular?";
         Alert alert = new Alert(Alert.AlertType.CONFIRMATION, mensaje, ButtonType.YES, ButtonType.NO);
        alert.showAndWait();
    }
    
}
