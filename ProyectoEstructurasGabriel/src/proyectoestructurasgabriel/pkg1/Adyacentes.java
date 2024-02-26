/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoestructuras.pkg1;

public class Adyacentes {
    Path pFirst;  // Primer camino en la lista de adyacencias
    
    public Adyacentes(){  // Constructor de la clase Adyacentes
        this.pFirst = null;  // Inicializa el primer camino como nulo
    }
    
    // Método para crear un nuevo camino entre ciudades
    public void NewPath(String name, int distance) {
        if(!this.search(name)) {  // Verifica si el camino ya existe
            Path newPath = new Path(name, distance);  // Crea un nuevo camino
            if(this.pFirst != null) {
                Path aux = this.pFirst;
                while(aux.getNextPath() != null) {
                    aux = aux.getNextPath();
                }
                aux.setNextPath(newPath);  // Agrega el nuevo camino al final de la lista
            }
        } else {
            // Si el camino ya existe, no hace nada
        }
    }
    
    // Método para eliminar un camino por su nombre
    public void DeletePath(String name) {
        Path aux = this.pFirst;
        if(this.pFirst != null) {
            while(aux.getNextPath() != null && !aux.getNextPath().getDestiny().equals(name)) {
                aux = aux.getNextPath();
            }
            if(aux.getNextPath() != null) {
                aux.setNextPath(aux.getNextPath().getNextPath());  // Elimina el camino
            }
        }
    }
    
    // Método para imprimir la lista de ciudades adyacentes
    public String print() {
        Path aux = this.pFirst;
        String adyacentes = "Ciudades adyacentes: \n";
        while(aux != null) {
            adyacentes += aux.getDestiny() + "\n";
            aux = aux.getNextPath();
        }
        return adyacentes;
    }
    
    // Método para buscar un camino por su nombre
    public Path SearchPath(String name) {
        Path aux = this.pFirst;
        while(aux != null && !aux.getDestiny().equals(name)) {
            aux = aux.getNextPath();
        }
        return aux;
    }
    
    // Método para verificar si un camino con un nombre dado ya existe
    public boolean search(String name) {
        Path aux = this.pFirst;
        while(aux != null) {
            if(aux.getDestiny().equals(name)) {
                return true;  // El camino ya existe
            }
            aux = aux.getNextPath();
        }
        return false;  // El camino no existe
    }
}
