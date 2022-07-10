/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.seminarioprogramacion.main;

import com.seminarioprogramacion.dto.TurnoDTO;
import javafx.scene.control.TableView;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 *
 * @author ikukl
 */
public class TurnosTest extends TestFXBase{
    @Test
    /*Probar que se abre la vetana de turnos y se listan valores*/
    public void menuTurnos(){
           //sleep(1000);
           clickOn("#btningreso");
           //sleep(1000);
           clickOn("#mturnos");
           //sleep(1000);
           clickOn("#smgestionturnos");
           TableView<TurnoDTO> tbViewTurnos = (TableView<TurnoDTO>)find("#tbViewTurnos");
           Assertions.assertTrue(tbViewTurnos.getItems().size() > 0);
    }
}
