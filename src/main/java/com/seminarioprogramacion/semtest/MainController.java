package com.seminarioprogramacion.semtest;

import java.io.IOException;
import javafx.application.Platform;
import javafx.fxml.FXML;

public class MainController {

    @FXML
    private void CloseApp() throws IOException {
        Platform.exit();
    }
}