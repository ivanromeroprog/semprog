/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.seminarioprogramacion.controlador;

import com.seminarioprogramacion.dto.HorarioDTO;
import com.seminarioprogramacion.dto.MecanicoDTO;
import com.seminarioprogramacion.dto.ServicioDTO;
import com.seminarioprogramacion.dto.TurnoDTO;
import com.seminarioprogramacion.modelo.Horario;
import com.seminarioprogramacion.modelo.Turno;
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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ikukl
 */
public class SeleccionarFechaController implements Initializable {

    @FXML
    private VBox vb;

    private Button btnArray[];
    private boolean dispArray[];

    private MecanicoDTO mecanico;
    private ServicioDTO servicio;
    private List<TurnoDTO> turnos;
    
    //Datos para devolver a la ventana principal
    private LocalDate fechasel;
    private int horasel;
    private int minsel;
   

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
        fechasel = null;
        horasel = -1;
        minsel = -1;
   
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

    public LocalDate getFechasel() {
        return fechasel;
    }

    public int getHorasel() {
        return horasel;
    }

    public int getMinsel() {
        return minsel;
    }

    public MecanicoDTO getMecanico() {
        return mecanico;
    }

    public void setMecanico(MecanicoDTO mecanico) {
        this.mecanico = mecanico;
    }

    public ServicioDTO getServicio() {
        return servicio;
    }

    public void setServicio(ServicioDTO servicio) {
        this.servicio = servicio;
    }
    
    public void iniciar() {
        System.out.println("Establecido el mecánico para ventana -Seleccionar Fecha y Hora-: " + this.mecanico.toString());
        lblmecanico.setText(mecanico.toString());

        //Horarios del Mecanico
        Horario horario = new Horario();
        this.mecanico.setHorarios(horario.listar(mecanico));

        //Turnos
        Turno turno = new Turno();
        turnos = turno.listar(this.mecanico, dpfecha.getValue());
        
        //Cargar los botones
        crearBotones();

        //Establecer los colores en base a los datos
        actualizarBotones();

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

    private void crearBotones() {
        HBox hb;
        //btnArray = new Button[24][4];
        btnArray = new Button[96];
        dispArray = new boolean[96];
        
        int contadorhoras = 0;
        int contadorminutos = 0;
        int contador = 0;

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

                Button btn = new Button(String.format("%02d", (contadorhoras)) + ":" + String.format("%02d", (contadorminutos * 15)));
                //btn.setPrefWidth(10);
                btn.setPrefSize(75, 75);
                btn.setUserData(contador);

                hb.getChildren().add(btn);

                btnArray[contador] = btn;
                dispArray[contador] = false;
                contador++;

            }
        }
    }

    @FXML
    private void dpfecha_change() {

        //Turnos
        Turno turno = new Turno();
        turnos = turno.listar(this.mecanico, dpfecha.getValue());
        
        fechasel = null;
        horasel = -1;
        minsel = -1;
        
        actualizarBotones();
    }
    private void actualizarBotones() {

        //Botones desactivados
        pintarBotones("-fx-background-color: #ccc;", Color.DARKGRAY, false);
                
        //Botones con horario de mecanico
        List<HorarioDTO> listahorario = this.mecanico.getHorarios();
        String diasemana = diaSemana();
        int horainicio = -1;
        int mininicio = -1;
        int horafin = -1;
        int minfin = -1;

        for (HorarioDTO h : listahorario) {
            if (h.getDia().equals(diasemana)) {//Si el día de la semana coincide...
                horainicio = h.getHora_inicio().getHour();
                mininicio = h.getHora_inicio().getMinute();
                horafin = h.getHora_fin().getHour();
                minfin = h.getHora_fin().getMinute();
                break; //Guardamos datos y salimos del bucle
            }
        }
        
        pintarBotones(horainicio, mininicio, horafin, minfin, "-fx-background-color: #ddf;", Color.BLACK, true);
        
        //Botones con horario ocupado
        horainicio = -1;
        mininicio = -1;
        horafin = -1;
        minfin = -1;

        
        for(TurnoDTO t: turnos){
            System.out.println(t);
            horainicio = t.getHora_atencion().getHour();
            mininicio = t.getHora_atencion().getMinute();
            horafin = t.getHora_atencion().plusMinutes(t.getServicio().getTiempo()).getHour();
            minfin = t.getHora_atencion().plusMinutes(t.getServicio().getTiempo()).getMinute();
            pintarBotones(horainicio, mininicio, horafin, minfin, "-fx-background-color: #fdd;", Color.BLACK, false);
        }

    }

    private void pintarBotones(String style, Color color, boolean accion) {
        int contadorhoras = 0;
        int contadorminutos = 0;
        int contador = 0;

        //Recorremos el array de botones
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

                //Pintar botones correctos dependiendo del horario del mecanico
                btnArray[contador].setStyle(style);
                btnArray[contador].setTextFill(color);
                if (accion) {
                    btnArray[contador].setOnAction(e -> {
                        Button src = (Button) e.getSource();
                        btn_clic((int)src.getUserData());
                    });
                    dispArray[contador] = true;
                } else {
                    btnArray[contador].setOnAction(e -> {
                    });
                    dispArray[contador] = false;
                }

                contador++;
            }
        }
    }

    private void pintarBotones(int horainicio, int mininicio, int horafin,
            int minfin, String style, Color color, boolean accion) {
        int contadorhoras = 0;
        int contadorminutos = 0;
        int contador = 0;

        //Recorremos el array de botones
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

                //Pintar y activar botones correctos dependiendo del horario del mecanico
                if (correspondeHorario(contadorhoras, contadorminutos, horainicio, mininicio, horafin, minfin)) {
                    btnArray[contador].setStyle(style);
                    btnArray[contador].setTextFill(color);
                    if (accion) {
                        btnArray[contador].setOnAction(e -> {
                            Button src = (Button) e.getSource();
                            btn_clic((int)src.getUserData());
                        });
                        dispArray[contador] = true;
                    } else {
                        btnArray[contador].setOnAction(e -> {
                        });
                        dispArray[contador] = false;
                    }
                }
                
                contador++;

            }
        }
    }

    private boolean correspondeHorario(int contadorhoras, int contadorminutos,
            int horainicio, int mininicio, int horafin, int minfin) {
        return //Si esta entre la hora inicial y final
                ((contadorhoras > horainicio) && (contadorhoras < horafin))

                || //Si es igual a la hora inicial / final tengo en cuenta los minutos
                (horainicio != horafin
                && (((contadorhoras == horainicio)
                && ((contadorminutos * 15) >= mininicio))
                || ((contadorhoras == horafin)
                && ((contadorminutos * 15) <= minfin))))

                || //Si la hora inicial es igual a la final solo tomo el lapso entre los minutos
                (horainicio == horafin
                && (((contadorhoras == horainicio)
                && ((contadorminutos * 15) >= mininicio)
                && ((contadorminutos * 15) <= minfin))));
    }

    @FXML
    private void cancelar() throws IOException {
        
        this.fechasel = null;
        this.horasel = -1;
        this.minsel = -1;
        
        //Cerrar esta ventana
        ((Stage) btncancelar.getScene().getWindow()).close();
    }

    @FXML
    private void aceptar() throws IOException {
        if(fechasel == null || horasel < 0 || minsel < 0)
            return;
        
        //Cerrar esta ventana
        ((Stage) btnaceptar.getScene().getWindow()).close();
    }

    private void btn_clic(int userData) {
        System.out.println(userData);
        
        int cantidadBotones = Math.ceilDiv(servicio.getTiempo(),15);
        
        System.out.println(userData+" + "+(userData+cantidadBotones));
        
        for(int i = userData; i <= userData+cantidadBotones; i++ )
        {
            if(!dispArray[i]){
                System.out.println("Horario Incorrecto");
                return;
            }
        }
        System.out.println("Horario Seleccionado"); 
        
        actualizarBotones();
        for(int i = userData; i <= userData+cantidadBotones; i++ )
        {
                    btnArray[i].setStyle("-fx-background-color: #22F;");
                    btnArray[i].setTextFill(Color.BLACK);
        }
        
        //Guardar valores para devolver a ventana padre
        fechasel = dpfecha.getValue();
        String[] tmp = btnArray[userData].getText().split(":");
        horasel = Integer.parseInt(tmp[0]);
        minsel = Integer.parseInt(tmp[1]);
    }
}
