/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/*
@LuisArrieta
desarroyo de clase y metodo de los graphos**/

package proyectoestructuras.pkg1;

import java.util.Random;

// Esta clase representa un grafo que consiste en ciudades y rutas entre ellas
public class Graph {
   City[] cities; // Array para almacenar ciudades
   int max_cities; // Número máximo de ciudades que puede contener el grafo
   int actual_cities; // Número actual de ciudades en el grafo
   int first; // Índice de la primera ciudad
   public Graph(int size){ // Método constructor para la clase Graph
       this.max_cities = size; // Inicializa el número máximo de ciudades
       this.actual_cities = 0; // Inicializa el número actual de ciudades en 0
       this.cities= new City[size]; // Inicializa el array para almacenar ciudades con el tamaño especificado
       this.inicializar(this.cities); // Llama al método de inicialización para configurar el array de ciudades
       first = 0; // Inicializa el índice de la primera ciudad
   }
   
   // Método para inicializar el array de ciudades
   public void inicializar(City[] array){
       for (int i = 0; i < array.length; i++) {
           array[i] = new City(""); // Crea un nuevo objeto City y lo añade al array
       }
   }
   
   // Método para añadir una nueva ciudad al grafo
   public void NewCity(String name){
       int position = this.searchEmpty(); // Busca una posición vacía en el array de ciudades
       if(position != -1){ // Si se encuentra una posición vacía
           this.cities[position].setName(name); // Establece el nombre de la ciudad en esa posición
       } else { // Si no hay posiciones vacías
           City[] newCity = new City[max_cities + max_cities/2]; // Crea un nuevo array con capacidad aumentada
           this.inicializar(newCity); // Inicializa el nuevo array de ciudades
           for (int i = 0; i < this.max_cities; i++) {
               newCity[i] = this.cities[i]; // Copia las ciudades existentes al nuevo array
           }
           newCity[max_cities].setName(name); // Establece el nombre de la nueva ciudad en el nuevo array
           this.cities = newCity; // Reemplaza el antiguo array con el nuevo array
       }
   }
   
   // Método para añadir una nueva ruta entre dos ciudades con una distancia especificada
   public void newPath(String origin, String destiny, int distance){
       if(this.searchCity(origin) && this.searchCity(destiny)){ // Verifica si tanto la ciudad de origen como la de destino existen en el grafo
           for (int i = 0; i < this.max_cities; i++) {
               if(this.cities[i].getName().equals(origin)){ 
                   this.cities[i].getPaths().NewPath(destiny, distance); // Añade una nueva ruta desde la ciudad de origen a la ciudad de destino
               } else if(this.cities[i].getName().equals(destiny)){
                   this.cities[i].getPaths().NewPath(origin, distance); // Añade una nueva ruta desde la ciudad de destino a la ciudad de origen
               }
           }
       } else {
       }
   }
}
    public void DeleteCity(String name){
        for (int i = 0; i < max_cities; i++) {
            if(this.cities[i].getName().equals(name)){
                this.cities[i].setName("");
                this.cities[i].setPaths(new Adyacentes());
            } else {
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

