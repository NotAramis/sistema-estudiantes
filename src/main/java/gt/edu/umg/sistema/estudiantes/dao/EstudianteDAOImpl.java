/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.umg.sistema.estudiantes.dao;

import gt.edu.umg.sistema.estudiantes.modelo.Estudiante;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EstudianteDAOImpl implements EstudianteDAO {

    // Ya no usamos el ArrayList como variable global.

    @Override
public void guardar(Estudiante estudiante) {
    // Agregamos 'correo' a la instrucción SQL y un cuarto signo de interrogación
    String sql = "INSERT INTO estudiante (carne, nombre, apellido, correo, carrera, estado) VALUES (?, ?, ?, ?, ?, ?)";
    
    try (Connection con = Conexion.getConnection(); 
         PreparedStatement ps = con.prepareStatement(sql)) {
        
        ps.setString(1, estudiante.getCarne());
        ps.setString(2, estudiante.getNombre());
        ps.setString(3, estudiante.getApellido());
        ps.setString(4, estudiante.getEmail()); // Aquí enviamos el correo
        ps.setString(5, estudiante.getCarrera());
        ps.setBoolean(6, estudiante.isEstado());
        
        ps.executeUpdate();
        System.out.println("¡Estudiante guardado en MySQL con éxito!");
        
    } catch (SQLException e) {
        System.err.println("Error al guardar: " + e.getMessage());
    }
}

   @Override
public List<Estudiante> listar() {
    List<Estudiante> estudiantes = new ArrayList<>();
    String sql = "SELECT id, carne, nombre, apellido, correo, carrera, estado FROM estudiante";
    
    try (Connection con = Conexion.getConnection();
         PreparedStatement ps = con.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) { 
        
        while (rs.next()) {
            Estudiante est = new Estudiante();
            est.setId(rs.getInt("id"));
            est.setCarne(rs.getString("carne"));
            est.setNombre(rs.getString("nombre"));
            est.setApellido(rs.getString("apellido"));
            est.setEmail(rs.getString("correo")); 
            est.setCarrera(rs.getString("carrera"));
            est.setEstado(rs.getBoolean("estado"));
            
            estudiantes.add(est);
        }
        
    } catch (SQLException e) {
        System.err.println("Error al extraer los datos: " + e.getMessage());
    }
    
    return estudiantes;
}

    @Override
public void actualizar(Estudiante estudiante) {
    String sql = "UPDATE estudiante SET carne = ?, nombre = ?, apellido = ?, correo = ?, carrera = ?, estado = ? WHERE id = ?";
    
    try (Connection con = Conexion.getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {
        
        ps.setString(1, estudiante.getCarne());
        ps.setString(2, estudiante.getNombre());
        ps.setString(3, estudiante.getApellido());
        ps.setString(4, estudiante.getEmail());
        ps.setString(5, estudiante.getCarrera());
        ps.setBoolean(6, estudiante.isEstado());
        ps.setInt(7, estudiante.getId()); // El ID sirve para localizar exactamente a quién modificar
        
        ps.executeUpdate();
        System.out.println("¡Estudiante actualizado con éxito!");
        
    } catch (SQLException e) {
        System.err.println("Error al actualizar: " + e.getMessage());
    }
}

    @Override
public void eliminar(int id) {
    String sql = "DELETE FROM estudiante WHERE id = ?";
    
    try (Connection con = Conexion.getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {
        
        ps.setInt(1, id);
        ps.executeUpdate();
        System.out.println("¡Estudiante eliminado con éxito!");
        
    } catch (SQLException e) {
        System.err.println("Error al eliminar: " + e.getMessage());
    }
} 

} 