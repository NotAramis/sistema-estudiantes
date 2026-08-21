/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.umg.sistema.estudiantes.dao;

import gt.edu.umg.sistema.estudiantes.modelo.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAOImpl implements ClienteDAO {

    @Override
    public void guardar(Cliente cliente) {
        // Ajustamos la consulta para: nit, nombre, telefono, direccion
        String sql = "INSERT INTO cliente (nit, nombre, telefono, direccion) VALUES (?, ?, ?, ?)";
        
        try (Connection con = Conexion.getConnection(); 
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, cliente.getNit());
            ps.setString(2, cliente.getNombre());
            ps.setString(3, cliente.getTelefono());
            ps.setString(4, cliente.getDireccion());
            
            ps.executeUpdate();
            System.out.println("¡Cliente guardado en MySQL con éxito!");
            
        } catch (SQLException e) {
            System.err.println("Error al guardar cliente: " + e.getMessage());
        }
    }

    @Override
    public List<Cliente> listar() {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT id, nit, nombre, telefono, direccion FROM cliente";
        
        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) { 
            
            while (rs.next()) {
                Cliente cli = new Cliente();
                cli.setId(rs.getInt("id"));
                cli.setNit(rs.getString("nit"));
                cli.setNombre(rs.getString("nombre"));
                cli.setTelefono(rs.getString("telefono"));
                cli.setDireccion(rs.getString("direccion"));
                
                clientes.add(cli);
            }
        } catch (SQLException e) {
            System.err.println("Error al listar clientes: " + e.getMessage());
        }
        return clientes;
    }

    @Override
    public void actualizar(Cliente cliente) {
        String sql = "UPDATE cliente SET nit = ?, nombre = ?, telefono = ?, direccion = ? WHERE id = ?";
        
        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, cliente.getNit());
            ps.setString(2, cliente.getNombre());
            ps.setString(3, cliente.getTelefono());
            ps.setString(4, cliente.getDireccion());
            ps.setInt(5, cliente.getId()); 
            
            ps.executeUpdate();
            System.out.println("¡Cliente actualizado con éxito!");
            
        } catch (SQLException e) {
            System.err.println("Error al actualizar cliente: " + e.getMessage());
        }
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM cliente WHERE id = ?";
        
        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("¡Cliente eliminado con éxito!");
            
        } catch (SQLException e) {
            System.err.println("Error al eliminar cliente: " + e.getMessage());
        }
    }
}