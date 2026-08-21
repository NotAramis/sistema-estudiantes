/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.umg.sistema.estudiantes.dao;

import gt.edu.umg.sistema.estudiantes.modelo.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAOImpl implements ProductoDAO {

    @Override
    public void guardar(Producto producto) {
        String sql = "INSERT INTO producto (nombre, precio, existencia) VALUES (?, ?, ?)";
        
        try (Connection con = Conexion.getConnection(); 
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, producto.getNombre());
            ps.setDouble(2, producto.getPrecio());
            ps.setInt(3, producto.getExistencia());
            
            ps.executeUpdate();
            System.out.println("¡Producto guardado en MySQL con éxito!");
            
        } catch (SQLException e) {
            System.err.println("Error al guardar producto: " + e.getMessage());
        }
    }

    @Override
    public List<Producto> listar() {
        List<Producto> productos = new ArrayList<>();
        // Asumimos que tu llave primaria en la BD se llama idProducto
        String sql = "SELECT idProducto, nombre, precio, existencia FROM producto";
        
        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) { 
            
            while (rs.next()) {
                Producto prod = new Producto();
                prod.setIdProducto(rs.getInt("idProducto"));
                prod.setNombre(rs.getString("nombre"));
                prod.setPrecio(rs.getDouble("precio"));
                prod.setExistencia(rs.getInt("existencia"));
                
                productos.add(prod);
            }
        } catch (SQLException e) {
            System.err.println("Error al listar productos: " + e.getMessage());
        }
        return productos;
    }

    @Override
    public void actualizar(Producto producto) {
        String sql = "UPDATE producto SET nombre = ?, precio = ?, existencia = ? WHERE idProducto = ?";
        
        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, producto.getNombre());
            ps.setDouble(2, producto.getPrecio());
            ps.setInt(3, producto.getExistencia());
            ps.setInt(4, producto.getIdProducto()); 
            
            ps.executeUpdate();
            System.out.println("¡Producto actualizado con éxito!");
            
        } catch (SQLException e) {
            System.err.println("Error al actualizar producto: " + e.getMessage());
        }
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM producto WHERE idProducto = ?";
        
        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("¡Producto eliminado con éxito!");
            
        } catch (SQLException e) {
            System.err.println("Error al eliminar producto: " + e.getMessage());
        }
    }
}
