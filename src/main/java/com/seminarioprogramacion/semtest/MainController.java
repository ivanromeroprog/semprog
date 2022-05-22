package com.seminarioprogramacion.semtest;

import java.io.IOException;
import javafx.application.Platform;
import javafx.fxml.FXML;
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
    private void switchToTest() throws IOException {
        //App.setRoot("testui",400,600);
        
        //Cerrar esta ventana
        //((Stage) menup.getScene().getWindow()).close();
        
        App.newWindow("testui",((Stage) menup.getScene().getWindow()));
    }
    
    @FXML
    private void switchToMecanicosListado() throws IOException {
        //App.setRoot("Mecanicos",400,600);
         
        //Cerrar esta ventana
        //((Stage) menup.getScene().getWindow()).close();
        
        App.newWindow("Mecanicos_listado",((Stage) menup.getScene().getWindow()));
    }
    
    @FXML
    private void switchToTurnos() throws IOException {
        //App.setRoot("Mecanicos",400,600);
         
        //Cerrar esta ventana
        //((Stage) menup.getScene().getWindow()).close();
        
        App.newWindow("Turnos",((Stage) menup.getScene().getWindow()));
    }

}
