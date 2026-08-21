/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package gt.edu.umg.sistema.estudiantes.dao;

import gt.edu.umg.sistema.estudiantes.modelo.Cliente;
import java.util.List;

public interface ClienteDAO {
    
    void guardar(Cliente cliente);
    
    List<Cliente> listar();
    
    void actualizar(Cliente cliente);
    
    void eliminar(int id);
}