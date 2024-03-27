/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Arboles;

import Clases.Historial_Habitaciones;

public class Habitacion {

    int numero_hab;
    int piso;
    String tipo;
    Historial_Habitaciones raiz;
    boolean ocupada;

    public Habitacion(int numero_hab, int piso, String tipo) {
        this.numero_hab = numero_hab;
        this.piso = piso;
        this.tipo = tipo;
        this.raiz = null;
        ocupada = false;
    }

    //FUNCIONES AUXILIARES QUE SE ENCARGAN DE LLAMAR A LAS PRIMITIVAS RECURSIVAS DEL ABB. SOLO ESTAS SON PUBLICAS
    public void añadir_info_historial(int ci, String nombre, String apellido, String email, String genero, String llegada) {
        Historial_Habitaciones historial = new Historial_Habitaciones(ci, nombre, apellido, email, genero, llegada);
        if (this.raiz == null) {
            this.raiz = historial;
        } else {
            this.insertar_abb(historial, this.raiz);
        }
    }

    public String mostrar_historial() {
        return this.imprimir_abb(raiz, "");
    }

    //FUNCIONES PRIVADAS, ESTAS SON LAS QUE REALMENTE HACEN TODO EL TRABAJO DE INSERTAR, IMPRIMIR Y MANTENER BALANCEADO EL ABB
    private void insertar_abb(Historial_Habitaciones nueva, Historial_Habitaciones padre) {
        if (padre != null) {
            if (padre.getCi() >= nueva.getCi()) {
                if (padre.getHijoIzquierdo() != null) {
                    this.insertar_abb(nueva, padre.getHijoIzquierdo());
                } else {
                    padre.setHijoIzquierdo(nueva);
                }
            } else if (padre.getCi() < nueva.getCi()) {
                if (padre.getHijoDerecho() != null) {
                    this.insertar_abb(nueva, padre.getHijoDerecho());
                } else {
                    padre.setHijoDerecho(nueva);
                }
            }
        }
    }

    private Historial_Habitaciones ordenar_abb(Historial_Habitaciones reservaActual) {
        if (reservaActual == null) {
            return reservaActual;
        }

        if (this.balance_abb(reservaActual) == 2) {
            if (this.balance_abb(reservaActual.getHijoIzquierdo()) < 0) {
                reservaActual.setHijoIzquierdo(this.rotar_izquierdo_abb(reservaActual.getHijoIzquierdo()));
            }
            reservaActual = this.rotar_derecho_abb(reservaActual);
        } else if (this.balance_abb(reservaActual) == -2) {
            if (this.balance_abb(reservaActual.getHijoDerecho()) > 0) {
                reservaActual.setHijoDerecho(this.rotar_derecho_abb(reservaActual.getHijoDerecho()));
            }
            reservaActual = this.rotar_izquierdo_abb(reservaActual);
        }

        reservaActual.height = this.max(this.altura_nodo(reservaActual.getHijoIzquierdo()), this.altura_nodo(reservaActual.getHijoDerecho())) + 1;

        return reservaActual;
    }

    private String imprimir_abb(Historial_Habitaciones actual, String txt) {
        if (actual != null) {
            txt = this.imprimir_abb(actual.getHijoIzquierdo(), txt);
            txt += actual.mostrar() + "\n";
            txt = this.imprimir_abb(actual.getHijoDerecho(), txt);

        }
        return txt;
    }
    
    
    //FUNCIONES AUXILIARES UTILIZADAS POR INSERTAR Y BALANCE

    private int altura_nodo(Historial_Habitaciones node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    private int max(int a, int b) {
        return (a > b) ? a : b;
    }

    private Historial_Habitaciones rotar_derecho_abb(Historial_Habitaciones y) {
        Historial_Habitaciones x = y.getHijoIzquierdo();
        Historial_Habitaciones aux = x.getHijoDerecho();

        x.setHijoDerecho(y);
        y.setHijoIzquierdo(aux);

        y.height = this.max(this.altura_nodo(y.getHijoIzquierdo()), this.altura_nodo(y.getHijoDerecho())) + 1;
        x.height = this.max(this.altura_nodo(x.getHijoIzquierdo()), this.altura_nodo(x.getHijoDerecho())) + 1;

        return x;
    }

    private Historial_Habitaciones rotar_izquierdo_abb(Historial_Habitaciones x) {
        Historial_Habitaciones y = x.getHijoDerecho();
        Historial_Habitaciones aux = y.getHijoIzquierdo();

        y.setHijoIzquierdo(x);
        x.setHijoDerecho(aux);

        x.height = this.max(this.altura_nodo(x.getHijoIzquierdo()), this.altura_nodo(x.getHijoDerecho())) + 1;
        y.height = this.max(this.altura_nodo(y.getHijoIzquierdo()), this.altura_nodo(y.getHijoDerecho())) + 1;

        return y;
    }

    private int balance_abb(Historial_Habitaciones N) {
        if (N == null) {
            return 0;
        }
        return this.altura_nodo(N.getHijoIzquierdo()) - this.altura_nodo(N.getHijoDerecho());
    }
}
