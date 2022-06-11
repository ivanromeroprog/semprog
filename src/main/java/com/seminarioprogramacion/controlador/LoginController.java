package com.seminarioprogramacion.controlador;

import com.seminarioprogramacion.main.App;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class LoginController {

    @FXML
    private Button btningreso;

    @FXML
    private void switchToMain() throws IOException {
        
        //Cerrar esta ventana
        ((Stage) btningreso.getScene().getWindow()).close();
        
        App.newWindow("MainMenu","Sistema Supercharger");
    }
    
    
}
