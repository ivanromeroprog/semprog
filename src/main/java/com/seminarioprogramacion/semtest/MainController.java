package com.seminarioprogramacion.semtest;

import java.io.IOException;
import javafx.application.Platform;
import javafx.fxml.FXML;

public class MainController {

    @FXML
    private void CloseApp() throws IOException {
        Platform.exit();
    }
    
    @FXML
    private void switchToTest() throws IOException {
        App.setRoot("testui",400,600);
    }
    
    @FXML
    private void switchToMecanicos() throws IOException {
        App.setRoot("Mecanicos",400,600);
    }
}