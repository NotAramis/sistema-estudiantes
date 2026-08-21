/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package gt.edu.umg.sistema.estudiantes.dao;

import gt.edu.umg.sistema.estudiantes.modelo.Empleado;
import java.util.List;

public interface EmpleadoDAO {
    
    void guardar(Empleado empleado);
    
    List<Empleado> listar();
    
    void actualizar(Empleado empleado);
    
    void eliminar(int id);
}