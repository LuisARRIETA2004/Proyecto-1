/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/*
@LuisArrieta
desarroyo de clase y metodo de los graphos**/

package proyectoestructuras.pkg1;

public class Ant {
    double totalDistance;  // Almacena la distancia total recorrida por la hormiga
    City[] visitedCities;  // Almacena las ciudades visitadas por la hormiga
    
    public Ant(int size){  // Constructor de la clase Ant que recibe el tamaño como parámetro
        this.totalDistance = 0;  // Inicializa la distancia total en cero
        this.visitedCities = new City[size];  // Inicializa el arreglo de ciudades visitadas con el tamaño especificado
        for (int i = 0; i < size; i++) {
            visitedCities[i] = new City("");  // Inicializa cada elemento del arreglo como una nueva instancia de la clase City con un nombre vacío
        }
    }
}
