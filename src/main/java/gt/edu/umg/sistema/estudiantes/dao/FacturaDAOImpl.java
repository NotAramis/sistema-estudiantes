/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.umg.sistema.estudiantes.dao;

import gt.edu.umg.sistema.estudiantes.modelo.Factura;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement; // Importante para recuperar el ID generado

public class FacturaDAOImpl {
    
    // Método para guardar la cabecera y devolver el ID con el que se guardó
    public int guardarFactura(Factura factura) {
        String sql = "INSERT INTO factura (nit, nombre_cliente, total) VALUES (?, ?, ?)";
        int idFacturaGenerada = 0;
        
        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            
            ps.setString(1, factura.getNit());
            ps.setString(2, factura.getNombreCliente());
            ps.setDouble(3, factura.getTotal());
            ps.executeUpdate();
            
            // Obtenemos el ID autoincrementable de la factura recién insertada
            var resultadoKeys = ps.getGeneratedKeys();
            if (resultadoKeys.next()) {
                idFacturaGenerada = resultadoKeys.getInt(1);
            }
            
        } catch (SQLException e) {
            System.out.println("Error al guardar la factura: " + e.getMessage());
        }
        return idFacturaGenerada; // Retorna el ID para usarlo en el detalle
    }

    // NUEVO MÉTODO: Para guardar cada producto en la tabla detalle_factura
    public void guardarDetalle(int idFactura, String descripcion, int cantidad, double precio, double subtotal) {
        String sql = "INSERT INTO detalle_factura (id_factura, descripcion, cantidad, precio_unitario, subtotal) VALUES (?, ?, ?, ?, ?)";
        
        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setInt(1, idFactura);
            ps.setString(2, descripcion);
            ps.setInt(3, cantidad);
            ps.setDouble(4, precio);
            ps.setDouble(5, subtotal);
            ps.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println("Error al guardar el detalle de factura: " + e.getMessage());
        }
    }
}
