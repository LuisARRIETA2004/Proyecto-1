/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

public class Clientes_Actuales {

    private String nombre;
    private String apellido;
    private String email;
    private String genero;
    private String llegada;
    private String celular;
    private int numeroHab;
    private Clientes_Actuales pNext;
    
    
    public Clientes_Actuales(int numeroHab, String nombre, String apellido, String email, String genero, String celular, String llegada) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.numeroHab = numeroHab;
        this.email = email;
        this.genero = genero;
        this.llegada = llegada;
        this.celular = celular;
        this.pNext =  null;
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
     * @return the numeroHab
     */
    public int getNumeroHab() {
        return numeroHab;
    }

    /**
     * @param numeroHab the numeroHab to set
     */
    public void setNumeroHab(int numeroHab) {
        this.numeroHab = numeroHab;
    }

    /**
     * @return the pNext
     */
    public Clientes_Actuales getpNext() {
        return pNext;
    }

    /**
     * @param pNext the pNext to set
     */
    public void setpNext(Clientes_Actuales pNext) {
        this.pNext = pNext;
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
     * @return the celular
     */
    public String getCelular() {
        return celular;
    }

    /**
     * @param celular the celular to set
     */
    public void setCelular(String celular) {
        this.celular = celular;
    }
}
