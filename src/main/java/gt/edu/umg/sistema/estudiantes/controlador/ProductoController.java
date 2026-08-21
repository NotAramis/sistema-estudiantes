/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.umg.sistema.estudiantes.controlador;

import gt.edu.umg.sistema.estudiantes.dao.ProductoDAO;
import gt.edu.umg.sistema.estudiantes.dao.ProductoDAOImpl;
import gt.edu.umg.sistema.estudiantes.modelo.Producto;
import java.util.List;

public class ProductoController {
    
    ProductoDAOImpl dao;

    public ProductoController() {
        dao = new ProductoDAOImpl();
    }

    public void guardar(Producto producto) {
        dao.guardar(producto);
    }

    public List<Producto> getProductos() {
        return dao.listar();
    }

    public void actualizar(Producto producto) {
        dao.actualizar(producto);
    }

    public void eliminar(int id) {
        dao.eliminar(id);
    }
}
