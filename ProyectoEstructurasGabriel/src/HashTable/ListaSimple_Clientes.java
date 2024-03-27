/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HashTable;

import Clases.Clientes_Actuales;

public class ListaSimple_Clientes {

    Clientes_Actuales primero;

    public ListaSimple_Clientes() {
        this.primero = null;
    }

    public void insertar(Clientes_Actuales nuevo) {
        if (this.primero == null) {
            this.primero = nuevo;
        } else {
            nuevo.setpNext(this.primero);
            this.primero = nuevo;
        }
    }

    public Clientes_Actuales buscar(String nombre, String apellido) {
        if (this.primero == null) {
            return null;
        } else {
            Clientes_Actuales auxiliar = this.primero;
            while (auxiliar != null && !auxiliar.getNombre().equals(nombre) && !auxiliar.getApellido().equals(apellido)) {
                auxiliar = auxiliar.getpNext();
            }
            return auxiliar;
        }
    }

    public void eliminar(String nombre, String apellido) {
        if (this.primero != null) {
            Clientes_Actuales auxiliar = this.primero;
            if (auxiliar.getNombre().equals(nombre) && auxiliar.getApellido().equals(apellido)) {
                this.primero = this.primero.getpNext();
            } else {
                while (auxiliar.getpNext() != null && !auxiliar.getpNext().getNombre().equals(nombre) && !auxiliar.getpNext().getApellido().equals(apellido)) {
                    auxiliar = auxiliar.getpNext();
                }
                if (auxiliar.getpNext() != null) {
                    auxiliar.setpNext(auxiliar.getpNext().getpNext());
                }
            }
        }

    }
}
