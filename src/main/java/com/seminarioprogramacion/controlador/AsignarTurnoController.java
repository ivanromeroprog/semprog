/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.seminarioprogramacion.controlador;

import com.seminarioprogramacion.dto.MecanicoDTO;
import com.seminarioprogramacion.dto.TitularDTO;
import com.seminarioprogramacion.dto.ServicioDTO;
import com.seminarioprogramacion.dto.VehiculoDTO;
import com.seminarioprogramacion.main.App;
import com.seminarioprogramacion.modelo.Mecanico;
import com.seminarioprogramacion.modelo.Titular;
import com.seminarioprogramacion.modelo.Servicio;
import com.seminarioprogramacion.modelo.Vehiculo;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
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
    private ComboBox combobox_vehiculos;

    @FXML
    private ComboBox combobox_servicios;

    @FXML
    private ComboBox combobox_mecanicos;

    @FXML
    private Button btnguardar;

    @FXML
    private Button btncancelar;
    @FXML
    private DatePicker dpdia_atencion;
    @FXML
    private TextField txthora_atencion;
    @FXML
    private TextField txtmin_atencion;

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

        //TODO: Buscar la forma de pasar datos a la nueva ventana abierta y recibir datos de ella
        MecanicoDTO mecanico = (MecanicoDTO) combobox_mecanicos.getSelectionModel().getSelectedItem();
        ServicioDTO servicio = (ServicioDTO) combobox_servicios.getSelectionModel().getSelectedItem();
        if (mecanico != null && servicio != null) {
            //System.out.println(mecanico.toString());

            //Cargar vista en FXMLLoader
            FXMLLoader ldr = App.getFXMLLoader("SeleccionarFecha");

            //Crear la ventana modal sin mostrarla
            Stage st = App.newWindow(ldr,
                    ((Stage) btnguardar.getScene().getWindow()),
                    "Seleccionar Fecha y Hora",
                    false);

            //Acceder al controlador de la ventana modal para establecer el mecanico
            // y el servicio
            SeleccionarFechaController seleccionarFechaController = ldr.getController();
            seleccionarFechaController.setMecanico(mecanico);
            seleccionarFechaController.setServicio(servicio);
            seleccionarFechaController.iniciar();

            //Mostrar la Ventana modal
            st.showAndWait();

            //Accerder al controlador luego de cerrarse la ventana para obtener los datos
            LocalDate fs = seleccionarFechaController.getFechasel();
            int hs = seleccionarFechaController.getHorasel();
            int ms = seleccionarFechaController.getMinsel();
            if (fs != null) {

                dpdia_atencion.setValue(fs);
                txthora_atencion.setText(String.format("%02d", (hs)));
                txtmin_atencion.setText(String.format("%02d", (ms)));
            }
        }
    }

    @FXML
    private void combobox_titulares_change() throws IOException {
        TitularDTO titular = (TitularDTO) combobox_titulares.getSelectionModel().getSelectedItem();
        combobox_vehiculos.getItems().clear();

        //Para la lista de titulares
        Vehiculo vehiculo = new Vehiculo(); //Modelo
        List<VehiculoDTO> vehiculos = vehiculo.listar(titular); //Lista 
        combobox_vehiculos.getItems().addAll(vehiculos); //Llena combobox
    }

    @FXML
    private void combobox_servicios_change() throws IOException {
        ServicioDTO servicio = (ServicioDTO) combobox_servicios.getSelectionModel().getSelectedItem();
        combobox_mecanicos.getItems().clear();

        //Para la lista de titulares
        Mecanico mecanico = new Mecanico(); //Modelo
        List<MecanicoDTO> mecanicos = mecanico.listar(servicio.getEspecialidad()); //Listar mecanicos por servicio > especialidad 
        combobox_mecanicos.getItems().addAll(mecanicos); //Llena combobox       
    }
}
