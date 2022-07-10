/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.seminarioprogramacion.main;

import com.seminarioprogramacion.dto.TurnoDTO;
import javafx.scene.control.TableView;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

/**
 *
 * @author ikukl
 */
@TestMethodOrder(OrderAnnotation.class)
public class TurnosTest extends TestFXBase {

   @Test
    @Order(1) 
    /*Probar que se abre la vetana de turnos y se listan valores*/
    public void listarTurnos() {
        //sleep(1000);
        clickOn("#btningreso");
        //sleep(1000);
        clickOn("#mturnos");
        //sleep(1000);
        clickOn("#smgestionturnos");
        TableView<TurnoDTO> tbViewTurnos = (TableView<TurnoDTO>) find("#tbViewTurnos");
        Assertions.assertTrue(tbViewTurnos.getItems().size() > 0);
    }
    
    @Test
    @Order(2)
    public void registrarAsistenciaNo() {
        //sleep(1000);
        clickOn("#btningreso");
        //sleep(1000);
        clickOn("#mturnos");
        //sleep(1000);
        clickOn("#smgestionturnos");

        //Seleccionar primer valor
        TableView<TurnoDTO> tbViewTurnos = (TableView<TurnoDTO>) find("#tbViewTurnos");
        tbViewTurnos.getSelectionModel().select(0);
        //sleep(1000);

        //Modificar valor 
        clickOn("#brnAsistencia");
        //sleep(1000);
        clickOn("Sí");
        //sleep(1000);

        //comprobar Si en primer valor
        tbViewTurnos = (TableView<TurnoDTO>) find("#tbViewTurnos");
        TurnoDTO item = tbViewTurnos.getItems().get(0);
        Boolean nuevaAsistencia = item.getAsistencia();

        Assertions.assertEquals(true, nuevaAsistencia);
    }
    @Test
    @Order(3)
    public void registrarAsistenciaSi() {
        //sleep(1000);
        clickOn("#btningreso");
        //sleep(1000);
        clickOn("#mturnos");
        //sleep(1000);
        clickOn("#smgestionturnos");

        //Seleccionar primer valor
        TableView<TurnoDTO> tbViewTurnos = (TableView<TurnoDTO>) find("#tbViewTurnos");
        tbViewTurnos.getSelectionModel().select(0);
        //sleep(1000);

        //Modificar valor 
        clickOn("#brnAsistencia");
        //sleep(1000);
        clickOn("No");
        //sleep(1000);

        //comprobar Si en primer valor
        tbViewTurnos = (TableView<TurnoDTO>) find("#tbViewTurnos");
        TurnoDTO item = tbViewTurnos.getItems().get(0);
        Boolean nuevaAsistencia = item.getAsistencia();

        Assertions.assertEquals(false, nuevaAsistencia);
    }

 
    
    @Test
    @Order(4)
    // Probar Eliminar el turno creado por unittests
    public void eliminarTurno(){
           //sleep(1000);
           clickOn("#btningreso");
           //sleep(1000);
           clickOn("#mturnos");
           //sleep(1000);
           clickOn("#smgestionturnos");
           TableView<TurnoDTO> tbViewTurnos = (TableView<TurnoDTO>)find("#tbViewTurnos");
           int prevSize = tbViewTurnos.getItems().size();
           tbViewTurnos.getSelectionModel().selectFirst();
           clickOn("#btnEliminarTurno");
           //sleep(1000);
           clickOn("Sí");
           //sleep(1000);
           Assertions.assertEquals(prevSize-1,tbViewTurnos.getItems().size());
    } 
}
