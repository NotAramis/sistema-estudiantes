/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.umg.sistema.estudiantes.controlador;

import gt.edu.umg.sistema.estudiantes.dao.EmpleadoDAO;
import gt.edu.umg.sistema.estudiantes.dao.EmpleadoDAOImpl;
import gt.edu.umg.sistema.estudiantes.modelo.Empleado;
import java.util.List;

public class EmpleadoController {
    
    EmpleadoDAOImpl dao;

    public EmpleadoController() {
        dao = new EmpleadoDAOImpl();
    }

    public void guardar(Empleado empleado) {
        dao.guardar(empleado);
    }

    public List<Empleado> getEmpleados() {
        return dao.listar();
    }

    public void actualizar(Empleado empleado) {
        dao.actualizar(empleado);
    }

    public void eliminar(int id) {
        dao.eliminar(id);
    }
}