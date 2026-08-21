/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.umg.sistema.estudiantes.controlador;

import gt.edu.umg.sistema.estudiantes.dao.FacturaDAOImpl;
import gt.edu.umg.sistema.estudiantes.modelo.Factura;

public class FacturaController {
    
    FacturaDAOImpl dao;

    public FacturaController() {
        dao = new FacturaDAOImpl();
    }

    // Pasa la factura para guardar el encabezado y devuelve el ID generado
    public int guardarCabecera(Factura factura) {
        return dao.guardarFactura(factura);
    }

    // Pasa los datos de cada fila de la tabla para guardarlos como detalles
    public void guardarDetalle(int idFactura, String descripcion, int cantidad, double precio, double subtotal) {
        dao.guardarDetalle(idFactura, descripcion, cantidad, precio, subtotal);
    }
}
