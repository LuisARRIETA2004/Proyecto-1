/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;


public class Reservacion {
    private int ci;
    private String primer_nombre;
    private String segundo_nombre;
    private String email;
    private String genero;
    private String tipo_hab;
    private String celular;
    private String fecha_llegada;
    private String fecha_salida;
    private Reservacion HijoIzquierdo;
    private Reservacion HijoDerecho;
    private int altura;

    public Reservacion(int ci, String primer_nombre, String segundo_nombre, String email, String genero, String tipo_hab, String celular, String fecha_llegada, String fecha_salida) {
        this.ci = ci;
        this.primer_nombre = primer_nombre;
        this.segundo_nombre = segundo_nombre;
        this.email = email;
        this.genero = genero;
        this.tipo_hab = tipo_hab;
        this.celular = celular;
        this.fecha_llegada = fecha_llegada;
        this.fecha_salida = fecha_salida;
        this.HijoIzquierdo = this.HijoDerecho = null;
        altura = 0;
    }
    
    @Override
    public String toString(){
        return this.primer_nombre + " " + this.segundo_nombre + " (" + this.ci + ")\nGenero: " + this.genero + "\nCorreo: " + this.email + "\nCelular: " + this.celular + "\nTipo de Habitacion: "+this.tipo_hab + "\nFecha de llegada: " + 
                this.fecha_llegada+"\nFecha de Salida: " + this.fecha_salida;
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
     * @return the primer_nombre
     */
    public String getPrimer_nombre() {
        return primer_nombre;
    }

    /**
     * @param primer_nombre the primer_nombre to set
     */
    public void setPrimer_nombre(String primer_nombre) {
        this.primer_nombre = primer_nombre;
    }

    /**
     * @return the segundo_nombre
     */
    public String getSegundo_nombre() {
        return segundo_nombre;
    }

    /**
     * @param segundo_nombre the segundo_nombre to set
     */
    public void setSegundo_nombre(String segundo_nombre) {
        this.segundo_nombre = segundo_nombre;
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
     * @return the tipo_hab
     */
    public String getTipo_hab() {
        return tipo_hab;
    }

    /**
     * @param tipo_hab the tipo_hab to set
     */
    public void setTipo_hab(String tipo_hab) {
        this.tipo_hab = tipo_hab;
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

    /**
     * @return the fecha_llegada
     */
    public String getFecha_llegada() {
        return fecha_llegada;
    }

    /**
     * @param fecha_llegada the fecha_llegada to set
     */
    public void setFecha_llegada(String fecha_llegada) {
        this.fecha_llegada = fecha_llegada;
    }

    /**
     * @return the fecha_salida
     */
    public String getFecha_salida() {
        return fecha_salida;
    }

    /**
     * @param fecha_salida the fecha_salida to set
     */
    public void setFecha_salida(String fecha_salida) {
        this.fecha_salida = fecha_salida;
    }

    /**
     * @return the HijoIzquierdo
     */
    public Reservacion getHijoIzquierdo() {
        return HijoIzquierdo;
    }

    /**
     * @param HijoIzquierdo the HijoIzquierdo to set
     */
    public void setHijoIzquierdo(Reservacion HijoIzquierdo) {
        this.HijoIzquierdo = HijoIzquierdo;
    }

    /**
     * @return the HijoDerecho
     */
    public Reservacion getHijoDerecho() {
        return HijoDerecho;
    }

    /**
     * @param HijoDerecho the HijoDerecho to set
     */
    public void setHijoDerecho(Reservacion HijoDerecho) {
        this.HijoDerecho = HijoDerecho;
    }

    /**
     * @return the altura
     */
    public int getAltura() {
        return altura;
    }

    /**
     * @param altura the altura to set
     */
    public void setAltura(int altura) {
        this.altura = altura;
    }
    
    
    
}
