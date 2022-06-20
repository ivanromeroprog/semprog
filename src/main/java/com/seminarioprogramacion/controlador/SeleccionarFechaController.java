/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.seminarioprogramacion.controlador;

import com.seminarioprogramacion.dto.HorarioDTO;
import com.seminarioprogramacion.dto.MecanicoDTO;
import com.seminarioprogramacion.modelo.Horario;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 * FXML Controller class
 *
 * @author ikukl
 */
public class SeleccionarFechaController implements Initializable {

    @FXML
    private VBox vb;

            private MecanicoDTO mecanico;
           /* private Stage parentStage;
            private Stage stage;*/
    @FXML
    private Label lblmecanico;
    @FXML
    private Button btnprev;
    @FXML
    private Button btnnext;
    @FXML
    private DatePicker dpfecha;
    @FXML
    private Button btnaceptar;
    @FXML
    private Button btncancelar;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        HBox hb;
        int contadorhoras = 0;
        int contadorminutos = 0;

        dpfecha.setValue(LocalDate.now());
       
        
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
                    btn.setStyle("-fx-background-color: #fdd;");
                else if(contadorhoras > 9 && contadorhoras < 12)
                    btn.setStyle("-fx-background-color: #ddf;");
                else
                {
                    btn.setStyle("-fx-background-color: #ccc;");
                    btn.setTextFill(Color.DARKGREY);
                }
                
                btn.setOnAction(e -> {
                    Button src = (Button)e.getSource();
                    System.out.println(src.getText());
                });
                //btnArray[contadorhoras][contadorminutos] = btn;
                
                hb.getChildren().add(btn);
                
            }
        }
    }

    @FXML
    private void btnprev_click(ActionEvent event) throws IOException {
        LocalDate dv = dpfecha.getValue();
        dpfecha.setValue(dv.minusDays(1));
    }
    @FXML
    private void btnnext_click(ActionEvent event) throws IOException {
        LocalDate dv = dpfecha.getValue();
        dpfecha.setValue(dv.plusDays(1));
    }
        
    public MecanicoDTO getMecanico() {
        return mecanico;
    }

    public void setMecanico(MecanicoDTO mecanico) {
        this.mecanico = mecanico;
        System.out.println("Establecido el mecanico para ventana -Seleccionar Fecha y Hora-: " + this.mecanico.toString());
        lblmecanico.setText(mecanico.toString());
        
        //Modelo de Horario
        Horario horario = new Horario();
        this.mecanico.setHorarios(horario.listar(mecanico));
        List<HorarioDTO> listahorario = this.mecanico.getHorarios();
        
        for(HorarioDTO h: listahorario){
            System.out.println(h.toString());
        }
        
        /*
        this.stage = (Stage) vb.getScene().getWindow();
        this.parentStage = (Stage) stage.getOwner();
        */

        /*
        System.out.println(this.stage);
        System.out.println(this.parentStage);
        */
    }


}
