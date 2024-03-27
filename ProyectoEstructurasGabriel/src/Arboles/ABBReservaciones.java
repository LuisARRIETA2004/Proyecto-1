/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Arboles;

import Clases.Reservacion;

public class ABBReservaciones {

    public Reservacion raiz;

    public ABBReservaciones() {
        this.raiz = null;
    }

    //FUNCIONES AUXILIARES QUE SE ENCARGAN DE LLAMAR A LAS PRIMITIVAS RECURSIVAS DEL ABB. SOLO ESTAS SON PUBLICAS
    public void crear_reservacion(int ci, String primer_nombre, String segundo_nombre, String email, String genero, String tipo_hab, String celular, String fecha_llegada, String fecha_salida) {
        Reservacion nueva = new Reservacion(ci, primer_nombre, segundo_nombre, email, genero, tipo_hab, celular, fecha_llegada, fecha_salida);
        if (this.raiz == null) {
            this.raiz = nueva;
        } else {
            this.insertar_abb(nueva, this.raiz);
            this.ordenar_abb(this.raiz);
        }
    }

    public Reservacion encontar_reservacion(int ci) {
        return buscar_abb(ci, raiz);
    }

    public void borrar_reservacion(int ci) {
        this.raiz = eliminar_abb(this.raiz, ci);
    }

    public String ver_reservacion() {
        return this.imprimir_abb(raiz, "");
    }

    //FUNCIONES PRIVADAS, ESTAS SON LAS QUE REALMENTE HACEN TODO EL TRABAJO DE INSERTAR, ELIMINAR, BUSCAR. IMPRIMIR Y MANTENER BALANCEADO EL ABB
    private void insertar_abb(Reservacion nueva, Reservacion padre) {
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

    private Reservacion buscar_abb(int ci, Reservacion padre) {
        if (padre != null) {
            Reservacion buscar = null;
            if (padre.getCi() > ci) {
                buscar = this.buscar_abb(ci, padre.getHijoIzquierdo());
            } else if (padre.getCi() < ci) {
                buscar = this.buscar_abb(ci, padre.getHijoDerecho());
            } else {
                return padre;
            }
            return buscar;
        }
        return null;
    }

    public Reservacion ordenar_abb(Reservacion reservaActual) {
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

        reservaActual.setAltura(this.max(this.altura_nodo(reservaActual.getHijoIzquierdo()), this.altura_nodo(reservaActual.getHijoDerecho())) + 1);

        return reservaActual;
    }

    public String imprimir_abb(Reservacion actual, String txt) {
        if (actual != null) {
            txt = this.imprimir_abb(actual.getHijoIzquierdo(), txt);
            txt += actual.getCi() + "; ";
            txt = this.imprimir_abb(actual.getHijoDerecho(), txt);

        }
        return txt;
    }

    private Reservacion eliminar_abb(Reservacion reservaActual, int ci) {
        if (reservaActual == null) {
            return null;
        }

        if (ci < reservaActual.getCi()) {
            reservaActual.setHijoIzquierdo(eliminar_abb(reservaActual.getHijoIzquierdo(), ci));
        } else if (ci > reservaActual.getCi()) {
            reservaActual.setHijoDerecho(eliminar_abb(reservaActual.getHijoDerecho(), ci));
        } else {
            if (reservaActual.getHijoIzquierdo() == null && reservaActual.getHijoDerecho() == null) {
                reservaActual = null;
            } else if (reservaActual.getHijoIzquierdo() == null) {
                reservaActual = reservaActual.getHijoDerecho();
            } else if (reservaActual.getHijoDerecho() == null) {
                reservaActual = reservaActual.getHijoIzquierdo();
            } else {
                Reservacion reservaMinima = reserva_min(reservaActual.getHijoDerecho());
                reservaActual.setCi(reservaMinima.getCi());
                reservaActual.setHijoDerecho(eliminar_abb(reservaActual.getHijoDerecho(), reservaMinima.getCi()));
            }
        }

        if (reservaActual != null) {
            reservaActual.setAltura(1 + Math.max(altura_nodo(reservaActual.getHijoIzquierdo()), altura_nodo(reservaActual.getHijoDerecho())));
            int balance = altura_nodo(reservaActual.getHijoIzquierdo()) - altura_nodo(reservaActual.getHijoDerecho());

            if (balance > 1 && altura_nodo(reservaActual.getHijoIzquierdo().getHijoIzquierdo()) >= altura_nodo(reservaActual.getHijoIzquierdo().getHijoDerecho())) {
                reservaActual = rotar_derecho_abb(reservaActual);
            } else if (balance > 1 && altura_nodo(reservaActual.getHijoIzquierdo().getHijoDerecho()) > altura_nodo(reservaActual.getHijoIzquierdo().getHijoIzquierdo())) {
                reservaActual.setHijoIzquierdo(rotar_izquierdo_abb(reservaActual.getHijoIzquierdo()));
                reservaActual = rotar_derecho_abb(reservaActual);
            } else if (balance < -1 && altura_nodo(reservaActual.getHijoDerecho().getHijoDerecho()) >= altura_nodo(reservaActual.getHijoDerecho().getHijoIzquierdo())) {
                reservaActual = rotar_izquierdo_abb(reservaActual);
            } else if (balance < -1 && altura_nodo(reservaActual.getHijoDerecho().getHijoIzquierdo()) > altura_nodo(reservaActual.getHijoDerecho().getHijoDerecho())) {
                reservaActual.setHijoDerecho(rotar_derecho_abb(reservaActual.getHijoDerecho()));
                reservaActual = rotar_izquierdo_abb(reservaActual);
            }
        }

        return reservaActual;
    }
    
    
    //FUNCIONES AUXILIARES UTILIZADAS POR INSERTAR, BALANCE Y ELIMINAR

    private int altura_nodo(Reservacion node) {
        if (node == null) {
            return 0;
        }
        return node.getAltura();
    }

    private int max(int a, int b) {
        return (a > b) ? a : b;
    }

    public Reservacion rotar_derecho_abb(Reservacion y) {
        Reservacion x = y.getHijoIzquierdo();
        Reservacion aux = x.getHijoDerecho();

        x.setHijoDerecho(y);
        y.setHijoIzquierdo(aux);

        y.setAltura(this.max(this.altura_nodo(y.getHijoIzquierdo()), this.altura_nodo(y.getHijoDerecho())) + 1);
        x.setAltura(this.max(this.altura_nodo(x.getHijoIzquierdo()), this.altura_nodo(x.getHijoDerecho())) + 1);

        return x;
    }

    public Reservacion rotar_izquierdo_abb(Reservacion x) {
        Reservacion y = x.getHijoDerecho();
        Reservacion aux = y.getHijoIzquierdo();

        y.setHijoIzquierdo(x);
        x.setHijoDerecho(aux);

        x.setAltura(this.max(this.altura_nodo(x.getHijoIzquierdo()), this.altura_nodo(x.getHijoDerecho())) + 1);
        y.setAltura(this.max(this.altura_nodo(y.getHijoIzquierdo()), this.altura_nodo(y.getHijoDerecho())) + 1);

        return y;
    }

    public int balance_abb(Reservacion N) {
        if (N == null) {
            return 0;
        }
        return this.altura_nodo(N.getHijoIzquierdo()) - this.altura_nodo(N.getHijoDerecho());
    }

    private Reservacion reserva_min(Reservacion reservaActual) {
        if (reservaActual.getHijoIzquierdo() == null) {
            return reservaActual;
        }
        return reserva_min(reservaActual.getHijoIzquierdo());
    }
}
