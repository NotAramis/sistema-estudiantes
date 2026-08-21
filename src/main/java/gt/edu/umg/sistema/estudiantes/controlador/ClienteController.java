/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.umg.sistema.estudiantes.controlador;

import gt.edu.umg.sistema.estudiantes.dao.ClienteDAO;
import gt.edu.umg.sistema.estudiantes.dao.ClienteDAOImpl;
import gt.edu.umg.sistema.estudiantes.modelo.Cliente;
import java.util.List;

public class ClienteController {
    
    ClienteDAOImpl dao;

    public ClienteController() {
        dao = new ClienteDAOImpl();
    }

    public void guardar(Cliente cliente) {
        dao.guardar(cliente);
    }

    public List<Cliente> getClientes() {
        return dao.listar();
    }

    public void actualizar(Cliente cliente) {
        dao.actualizar(cliente);
    }

    public void eliminar(int id) {
        dao.eliminar(id);
    }
}