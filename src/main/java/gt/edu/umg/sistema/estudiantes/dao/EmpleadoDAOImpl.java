/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.umg.sistema.estudiantes.dao;

import gt.edu.umg.sistema.estudiantes.modelo.Empleado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDAOImpl implements EmpleadoDAO {

    @Override
    public void guardar(Empleado empleado) {
        // Quitamos nit y telefono de la consulta
        String sql = "INSERT INTO empleado (nombre, codigoEmpleado, puesto) VALUES (?, ?, ?)";
        
        try (Connection con = Conexion.getConnection(); 
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, empleado.getNombre());
            ps.setString(2, empleado.getCodigoEmpleado());
            ps.setString(3, empleado.getPuesto());
            
            ps.executeUpdate();
            System.out.println("¡Empleado guardado en MySQL con éxito!");
            
        } catch (SQLException e) {
            System.err.println("Error al guardar empleado: " + e.getMessage());
        }
    }

    @Override
    public List<Empleado> listar() {
        List<Empleado> empleados = new ArrayList<>();
        // Quitamos nit y telefono del SELECT
        String sql = "SELECT id, nombre, codigoEmpleado, puesto FROM empleado";
        
        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) { 
            
            while (rs.next()) {
                Empleado emp = new Empleado();
                emp.setId(rs.getInt("id"));
                emp.setNombre(rs.getString("nombre"));
                emp.setCodigoEmpleado(rs.getString("codigoEmpleado"));
                emp.setPuesto(rs.getString("puesto"));
                
                empleados.add(emp);
            }
        } catch (SQLException e) {
            System.err.println("Error al listar empleados: " + e.getMessage());
        }
        return empleados;
    }

    @Override
    public void actualizar(Empleado empleado) {
        // Quitamos nit y telefono del UPDATE
        String sql = "UPDATE empleado SET nombre = ?, codigoEmpleado = ?, puesto = ? WHERE id = ?";
        
        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, empleado.getNombre());
            ps.setString(2, empleado.getCodigoEmpleado());
            ps.setString(3, empleado.getPuesto());
            ps.setInt(4, empleado.getId()); 
            
            ps.executeUpdate();
            System.out.println("¡Empleado actualizado con éxito!");
            
        } catch (SQLException e) {
            System.err.println("Error al actualizar empleado: " + e.getMessage());
        }
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM empleado WHERE id = ?";
        
        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("¡Empleado eliminado con éxito!");
            
        } catch (SQLException e) {
            System.err.println("Error al eliminar empleado: " + e.getMessage());
        }
    }
}
