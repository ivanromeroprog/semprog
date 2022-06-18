package com.seminarioprogramacion.dao;

import com.seminarioprogramacion.dto.MecanicoDTO;
import java.util.List;

/**
 *
 * @author Nahue
 */
public interface MecanicoDAO {
     
     MecanicoDTO Buscar(int idMecanico, int idEspecialidad);
     
     List<MecanicoDTO> listar();
     
     boolean Insertar(int idEspecilidad, String legajo, String nombre
                    , String apellido, String tipoDoc, String nroDoc
                    , double cargaHoraria);
     
     boolean Modificar(int idMecanico, int idEspecilidad, String legajo
                    , String nombre, String apellido, String tipoDoc
                    , String nroDoc, double cargaHoraria);
     
     boolean Borrar(int idMecanico);

     public void cerrarConexion();
}
