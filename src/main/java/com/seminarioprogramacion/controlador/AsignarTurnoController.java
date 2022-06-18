/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.seminarioprogramacion.controlador;

import com.seminarioprogramacion.dto.TitularDTO;
import com.seminarioprogramacion.dto.ServicioDTO;
import com.seminarioprogramacion.dto.VehiculoDTO;
import com.seminarioprogramacion.main.App;
import com.seminarioprogramacion.modelo.Titular;
import com.seminarioprogramacion.modelo.Servicio;
import com.seminarioprogramacion.modelo.Vehiculo;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ikukl
 */
public class AsignarTurnoController implements Initializable {

    @FXML
    private ComboBox combobox_titulares;
    
    @FXML
    private ComboBox combobox_servicios;    
    
    @FXML
    private Button btnguardar;
    @FXML
    private Button btncancelar;
    @FXML
    private ComboBox combobox_vehiculo;
    @FXML
    private ComboBox combobox_mecanico;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //Para la lista de titulares
        Titular titular = new Titular(); //Modelo
        List<TitularDTO> titulares = titular.listar(); //Lista 
        combobox_titulares.getItems().addAll(titulares); //Llena combobox
        
        //Para la lista de servicios
        Servicio servicio = new Servicio(); //Modelo
        List<ServicioDTO> servicios = servicio.listar(); //Lista                
        combobox_servicios.getItems().addAll(servicios); //Llena combobox
         
        //Para la lista de titulares
        Vehiculo vehiculo = new Vehiculo(); //Modelo
        List<VehiculoDTO> vehiculos = vehiculo.listar(); //Lista 
        combobox_vehiculo.getItems().addAll(vehiculos); //Llena combobox
        
        //TODO: Vehiculos por titulares
        //TODO: Filtrar mecanicos por Servicio > Especialidad
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
    
        @FXML
    private void switchToSeleccionarFecha() throws IOException {
        //App.setRoot("testui",400,600);
        
        //Cerrar esta ventana
        //((Stage) menup.getScene().getWindow()).close();
        
        App.newWindow("SeleccionarFecha",((Stage) btnguardar.getScene().getWindow()),"Seleccionar Fecha y Hora");
    }
    
    
}
