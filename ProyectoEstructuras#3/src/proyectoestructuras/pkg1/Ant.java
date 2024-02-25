/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/*
@LuisArrieta
desarroyo de clase y metodo de los graphos**/

package proyectoestructuras.pkg1;

public class Ant {
    double totalDistance;
    City[] visitedCities;
    
    public Ant(int size){
        this.totalDistance = 0;
        this.visitedCities = new City[size];
        for (int i = 0; i < size; i++) {
            visitedCities[i] = new City("");
        }
    }
}
