/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.umg.sistema.estudiantes.modelo;

public class Factura {
    private int id;
    private String nit;
    private String nombreCliente;
    private double total;

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNit() { return nit; }
    public void setNit(String nit) { this.nit = nit; }

    public String getNombreCliente() { return nombreCliente; }
    public void setNombreCliente(String nombreCliente) { this.nombreCliente = nombreCliente; }

    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }
}
