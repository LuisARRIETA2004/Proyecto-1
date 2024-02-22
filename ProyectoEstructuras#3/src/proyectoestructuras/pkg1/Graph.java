/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/*
@LuisArrieta
desarroyo de clase y metodo de los graphos**/

package proyectoestructuras.pkg1;

import java.util.Random;

public class Graph {
    City[] cities;
    int max_cities;
    int actual_cities;
    int first;
    public Graph(int size){
        this.max_cities = size;
        this.actual_cities = 0;
        this.cities= new City[size];
        this.inicializar(this.cities);
        first = 0;
    }
    
    public void inicializar(City[] array){
        for (int i = 0; i < array.length; i++) {
            array[i] = new City("");
        }
    }
    

    
    public void NewCity(String name){
        int position = this.searchEmpty();
        if(position!= -1){
            this.cities[position].setName(name);
        }else{
            City[] newCity = new City[max_cities + max_cities/2];
            this.inicializar(newCity);
            for (int i = 0; i < this.max_cities; i++) {
                newCity[i] = this.cities[i];
            }
            newCity[max_cities].setName(name);
            this.cities = newCity;
        }
    }
    public void newPath(String origin, String destiny, int distance){
        if(this.searchCity(origin) && this.searchCity(destiny)){
            for (int i = 0; i < this.max_cities; i++) {
                if(this.cities[i].getName().equals(origin)){
                    this.cities[i].getPaths().NewPath(destiny, distance);
                }else if(this.cities[i].getName().equals(destiny)){
                    this.cities[i].getPaths().NewPath(origin, distance);
                }
            }
        }else{
            
        }
    }   
    public void DeleteCity(String name){
        for (int i = 0; i < max_cities; i++) {
            if(this.cities[i].getName().equals(name)){
                this.cities[i].setName("");
                this.cities[i].setPaths(new Adyacentes());
            }else{
                this.cities[i].getPaths().DeletePath(name);
            }
        }
    }
    
    public boolean searchCity(String name){
        for (int i = 0; i < this.max_cities; i++) {
            if(this.cities[i].getName().equals(name)){
                return true;
            }
        }
        return false;
    }
    


    
    public int searchEmpty(){
        for (int i = 0; i < this.max_cities; i++) {
            if(this.cities[i].getName().equals("")){
                return i;
            }
        }
        return -1;
    }
    
    
    public void run(Ant ant,double alpha, double beta, double ro){
        boolean[] visited = new boolean[this.max_cities];
        for (int i = 0; i < this.max_cities; i++) {
            visited[i] = false;
        }
        
        this.deepRun(visited, this.first, alpha, beta, ant);
    }
    
    public void deepRun(boolean[]  visited, int position, double alpha, double beta, Ant ant){
        visited[position] = true;
        double probabilities = 0;
        Random random = new Random();
        float randFloat = random.nextFloat();
        
        for (int i = 0; i < this.max_cities; i++) {
            if(!visited[i] && this.cities[position].getPaths().search(this.cities[i].getName())){
                probabilities += this.calcProbabilities(visited, position, alpha, beta, ant);
            }
            if(randFloat < probabilities){
                deepRun(visited, i, alpha, beta, ant);
            }
        }
    }
}
