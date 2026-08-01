/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.umg.sistema.estudiantes.modelo;

public class Estudiante {
    
    private int id;
    private String carne;
    private String nombre;
    private String apellido;
    private String email; 
    private String carrera;
    private boolean estado;
    
    
    public Estudiante() {
    }

    public Estudiante(int id, String carne, String nombre, String apellido, String email) {
        this.id = id;
        this.carne = carne;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getCarne() { return carne; }
    public void setCarne(String carne) { this.carne = carne; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    // Nuevos Getters y Setters para el Email
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public String getCarrera() { return carrera; }
    public void setCarrera(String carrera) { this.carrera = carrera; }

    public boolean isEstado() { return estado; } 
    public void setEstado(boolean estado) { this.estado = estado; }
}