/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package gt.edu.umg.sistema.estudiantes.dao;

import gt.edu.umg.sistema.estudiantes.modelo.Producto;
import java.util.List;

public interface ProductoDAO {
    
    void guardar(Producto producto);
    
    List<Producto> listar();
    
    void actualizar(Producto producto);
    
    void eliminar(int id);
}