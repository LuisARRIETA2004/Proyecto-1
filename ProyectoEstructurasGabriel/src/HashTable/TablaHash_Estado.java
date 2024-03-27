/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HashTable;

import Clases.Clientes_Actuales;


public class TablaHash_Estado {

    ListaSimple_Clientes[] clientes_actuales;
    
    public TablaHash_Estado(){
        this.clientes_actuales = new ListaSimple_Clientes[300];
        for (int i = 0; i < 300; i++) {
            this.clientes_actuales[i] = new ListaSimple_Clientes();
        }
    }
    
    //FUNCION DE HASH PARA OBTENER EL INDICE DONDE SE INSERTARÁ EL NUEVO HUÉSPED
    public int hash(String nombre, String apellido){
        int hashcode = 0;
        for (int i = 0; i < nombre.length(); i++) {
            hashcode += nombre.charAt(i) * i;
        }
        for (int i = 0; i < apellido.length(); i++) {
            hashcode += apellido.charAt(i) * i;
        }
        return hashcode % clientes_actuales.length;
    }
    
    //PRIMITIVAS, SE BUSCA LA LISTA EN LA POSICION QUE DEVUELVE EL HASH Y SE INSERTA/BUSCA/ELIMINA EL CLIENTE UTILIZANDO LAS PRIMITIVAS DE DICHA LISTA.
    //LO MÁS PROBABLE ES QUE CADA LISTA TENGA UN SOLO ELEMENTO, POR LO QUE LA BUSQUEDA ES DE O(1)
    public void insertar(int numeroHab, String nombre, String apellido, String email, String genero, String celular, String llegada){
        Clientes_Actuales nuevo = new Clientes_Actuales( numeroHab,  nombre,  apellido,  email,  genero,  celular,  llegada);
        int hash = this.hash(nombre, apellido);
        this.clientes_actuales[hash].insertar(nuevo);
    }
    
    public Clientes_Actuales buscar(String nombre, String apellido){
        int hash = this.hash(nombre, apellido);
        return this.clientes_actuales[hash].buscar(nombre, apellido);
    }
    
    public void eliminar(String nombre, String apellido){
        int hash = this.hash(nombre, apellido);
        this.clientes_actuales[hash].eliminar(nombre, apellido);
    }
}
