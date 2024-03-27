/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

public class Historial_Habitaciones {
    private String nombre;
    private String apellido;
    private String email;
    private String genero;
    private String llegada;
    private int ci;
    public int height;
    
    private Historial_Habitaciones HijoIzquierdo;
    private Historial_Habitaciones HijoDerecho;

    
    public Historial_Habitaciones(int ci,String nombre, String apellido, String email, String genero, String llegada) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.genero = genero;
        this.llegada = llegada;
        this.ci = ci;
        this.height = 0;
        this.HijoDerecho = this.HijoIzquierdo = null;
    }
    
    public String mostrar(){
        return "Huesped: " +this.nombre + " " + this.apellido + "\nCorreo: " + this.email + "\nGenero: " + this.genero + "\nFecha: " + this.llegada;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the genero
     */
    public String getGenero() {
        return genero;
    }

    /**
     * @param genero the genero to set
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * @return the llegada
     */
    public String getLlegada() {
        return llegada;
    }

    /**
     * @param llegada the llegada to set
     */
    public void setLlegada(String llegada) {
        this.llegada = llegada;
    }

    /**
     * @return the ci
     */
    public int getCi() {
        return ci;
    }

    /**
     * @param ci the ci to set
     */
    public void setCi(int ci) {
        this.ci = ci;
    }

    /**
     * @return the HijoIzquierdo
     */
    public Historial_Habitaciones getHijoIzquierdo() {
        return HijoIzquierdo;
    }

    /**
     * @param HijoIzquierdo the HijoIzquierdo to set
     */
    public void setHijoIzquierdo(Historial_Habitaciones HijoIzquierdo) {
        this.HijoIzquierdo = HijoIzquierdo;
    }

    /**
     * @return the HijoDerecho
     */
    public Historial_Habitaciones getHijoDerecho() {
        return HijoDerecho;
    }

    /**
     * @param HijoDerecho the HijoDerecho to set
     */
    public void setHijoDerecho(Historial_Habitaciones HijoDerecho) {
        this.HijoDerecho = HijoDerecho;
    }
    
   
    
}
