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
import java.time.LocalTime;
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

    private Button btnArray[][];

    private MecanicoDTO mecanico;

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

        dpfecha.setValue(LocalDate.now());

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
        System.out.println("Establecido el mecánico para ventana -Seleccionar Fecha y Hora-: " + this.mecanico.toString());
        lblmecanico.setText(mecanico.toString());

        //Modelo de Horario
        Horario horario = new Horario();
        this.mecanico.setHorarios(horario.listar(mecanico));

        //Obtener el dia de la semana
        String diasemana = diaSemana();

        //Cargar los botones
        botones();

        //Establecer los colores en base a estos datos
        actualizarBotones(diasemana);

        /*
        for(HorarioDTO h: listahorario){
            System.out.println(h.toString());
        }
        
        
        this.stage = (Stage) vb.getScene().getWindow();
        this.parentStage = (Stage) stage.getOwner();
         */

 /*
        System.out.println(this.stage);
        System.out.println(this.parentStage);
         */
    }

    private String diaSemana() {
        LocalDate dia = dpfecha.getValue();
        String diasemana = "";
        switch (dia.getDayOfWeek().getValue()) {
            case 1:
                diasemana = "Lunes";
                break;
            case 2:
                diasemana = "Martes";
                break;
            case 3:
                diasemana = "Miércoles";
                break;
            case 4:
                diasemana = "Jueves";
                break;
            case 5:
                diasemana = "Viernes";
                break;
            case 6:
                diasemana = "Sábado";
                break;
            case 7:
                diasemana = "Domingo";
                break;
        }

        return diasemana;
    }

    private void botones() {
        HBox hb;
        btnArray = new Button[24][4];
        int contadorhoras = 0;
        int contadorminutos = 0;

        for (int i = 0; i < 12; i++) {
            hb = new HBox();
            hb.setAlignment(Pos.CENTER);
            vb.getChildren().add(hb);

            for (int j = 0; j < 8; j++) {

                if (contadorminutos == 3) {
                    contadorminutos = 0;

                    if (contadorhoras == 23) {
                        contadorhoras = 0;
                    } else {
                        contadorhoras++;
                    }
                } else {
                    contadorminutos++;
                }

                Button btn = new Button((contadorhoras) + ":" + (contadorminutos * 15));
                //btn.setPrefWidth(10);
                btn.setPrefSize(75, 75);

                hb.getChildren().add(btn);

                btnArray[contadorhoras][contadorminutos] = btn;

            }
        }
    }

    private void actualizarBotones(String diasemana) {

        //Obtener el horario del día correcto
        List<HorarioDTO> listahorario = this.mecanico.getHorarios();
        HorarioDTO horariodia = null;

        int horainicio = 0;
        int mininicio = 0;
        int horafin = 0;
        int minfin = 0;

        for (HorarioDTO h : listahorario) {
            
            if (h.getDia() == diasemana) {
                horariodia = h;
                horainicio = horariodia.getHora_inicio().getHour();
                mininicio = horariodia.getHora_inicio().getMinute();
                horafin = horariodia.getHora_fin().getHour();
                minfin = horariodia.getHora_fin().getMinute();
                
                //System.out.println(h.getDia() + " - " + diasemana);
                break;
            }
        }
        
        //System.out.println(horariodia.toString());

        int contadorhoras = 0;
        int contadorminutos = 0;

        if (horariodia == null) {
            for (int i = 0; i < 12; i++) {

                for (int j = 0; j < 8; j++) {

                    if (contadorminutos == 3) {
                        contadorminutos = 0;

                        if (contadorhoras == 23) {
                            contadorhoras = 0;
                        } else {
                            contadorhoras++;
                        }

                    } else {
                        contadorminutos++;
                    }

                    //TODO: solo para pantallas
                    if (
                        (contadorhoras >= horainicio && contadorminutos*15 >= mininicio) &&
                        (contadorhoras < horafin && contadorminutos*15 < minfin)
                       ) {
                        btnArray[contadorhoras][contadorminutos].setStyle("-fx-background-color: #ddf;");
                        btnArray[contadorhoras][contadorminutos].setOnAction(e -> {
                            Button src = (Button) e.getSource();
                            System.out.println(src.getText());
                        });
                    } /*else if (contadorhoras > 9 && contadorhoras < 12) {
                        btnArray[contadorhoras][contadorminutos].setStyle("-fx-background-color: #fdd;");
                    }*/ else {
                        btnArray[contadorhoras][contadorminutos].setStyle("-fx-background-color: #ccc;");
                        btnArray[contadorhoras][contadorminutos].setTextFill(Color.DARKGREY);
                    }

                }
            }
        }
    }
}
