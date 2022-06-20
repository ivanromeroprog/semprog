package com.seminarioprogramacion.controlador;

import com.seminarioprogramacion.main.App;
import java.io.IOException;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.MenuBar;
import javafx.stage.Stage;

public class MainController {

    @FXML
    private MenuBar menup;
    
    @FXML
    private void CloseApp() throws IOException {
        Platform.exit();
    }

    @FXML
    private void switchToMecanicosListado() throws IOException {
        //App.setRoot("Mecanicos",400,600);
        //Cerrar esta ventana
        //((Stage) menup.getScene().getWindow()).close();
        App.newWindow("Mecanicos_listado", (Stage) menup.getScene().getWindow(), "Gestionar Mecánicos");
    }

    @FXML
    private void switchToTrabajos() throws IOException {
        //App.setRoot("Mecanicos",400,600);

        //Cerrar esta ventana
        //((Stage) menup.getScene().getWindow()).close();
        App.newWindow("Trabajos", ((Stage) menup.getScene().getWindow()), "Trabajos del Día");
    }

    @FXML
    private void switchToTurnos() throws IOException {
        //App.setRoot("Mecanicos",400,600);

        //Cerrar esta ventana
        //((Stage) menup.getScene().getWindow()).close();
        App.newWindow("Turnos", ((Stage) menup.getScene().getWindow()), "Turnos");
    }

    @FXML
    private void switchToGestionEspecialidad() throws IOException {

        App.newWindow("GestionEspecialidad", ((Stage) menup.getScene().getWindow()), "Gestionar Especialidades");
    }

    @FXML
    private void switchToGestionAseguradora() throws IOException {

        App.newWindow("GestionAseguradora", ((Stage) menup.getScene().getWindow()), "Gestionar Aseguradoras");
    }

    @FXML
    private void switchToGestionServicio() throws IOException {

        App.newWindow("GestionServicio", ((Stage) menup.getScene().getWindow()), "Gestionar Servicios");
    }

    @FXML
    private void switchToPrestacionesListado() throws IOException {

        App.newWindow("Prestaciones_Listado", ((Stage) menup.getScene().getWindow()), "Listado de Prestaciones");
    }

    @FXML
    private void switchToTitularesListado() throws IOException {

        App.newWindow("Titulares_listado", ((Stage) menup.getScene().getWindow()), "Gestionar Titulares");
    }
 
    @FXML
    private void switchToVehiculosListado() throws IOException {

        App.newWindow("Vehiculos_listado", ((Stage) menup.getScene().getWindow()), "Gestionar Vehiculos");
    }   
    
    @FXML
    private void switchToReporteMensual() throws IOException {

        App.newWindow("ReporteMensual", ((Stage) menup.getScene().getWindow()), "Generar Informe Mensual");
    } 
    @FXML
    private void acercaDe() throws IOException {
        Alert a = new Alert(AlertType.INFORMATION,"Romero, Iván Yamil - VINF08663\n" +
"Di Pierro, Sebastián Miguel - VINF07402\n" +
"Picca, Nahuel Ignacio - VINF07694\n" +
"Moll Rojas, Irma Esther - VINF05877\n" +
"Aguirre, Néstor Adrián - VINF07406", ButtonType.OK);
        a.setTitle("Acerca de...");
        a.setHeaderText("Miembros del Grupo");
        a.showAndWait();
    }
}
