/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.seminarioprogramacion.controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author ikukl
 */
public class SeleccionarFechaController implements Initializable {

    @FXML
    private VBox vb;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        HBox hb;
        int contadorhoras = 0;
        int contadorminutos = 0;
        
        //Button btnArray[][] = new Button[24][4];
        
        for (int i = 0; i < 12; i++) {
            hb = new HBox();
            hb.setAlignment(Pos.CENTER);
            vb.getChildren().add(hb);
            for (int j = 0; j < 8; j++) {
                
                if(contadorminutos == 3){
                    contadorminutos = 0;
                    
                    if(contadorhoras == 23)
                        contadorhoras = 0;
                        
                    else
                        contadorhoras++;
                }else{
                    contadorminutos++;
                }
                
                Button btn = new Button((contadorhoras)+":"+(contadorminutos * 15));
                //btn.setPrefWidth(10);
                btn.setPrefSize(75, 75);
                
                //TODO: solo para pantallas
                if(contadorhoras == 9 || contadorhoras == 12)
                    btn.setStyle("-fx-background-color: #fdd; -fx-border: 1px solid #ccc");
                else if(contadorhoras > 9 && contadorhoras < 12)
                    btn.setStyle("-fx-background-color: #ddf; -fx-border: 1px solid #ccc");
                else
                    btn.setStyle("-fx-background-color: #ccc; -fx-border: 1px solid #ccc");
                
                btn.setOnAction(e -> {
                    Button src = (Button)e.getSource();
                    System.out.println(src.getText());
                });
                //btnArray[contadorhoras][contadorminutos] = btn;
                
                hb.getChildren().add(btn);
                
            }
        }
    }

}
