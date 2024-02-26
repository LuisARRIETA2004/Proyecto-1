/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoestructurasgabriel.pkg1;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Random;
import javax.swing.JOptionPane;

public class MyGraph {
// Arreglo de ciudades
    City[] cities;
    int max_cities;
    int actual_cities;
    int first;
    int last;
    // Constructor que inicializa el grafo con el tamaño proporcionado
    public MyGraph(int size) {
        this.max_cities = size;
        this.actual_cities = 0;
        this.cities = new City[size];
        this.inicializar(this.cities);
        first = last = 0;
    }
    // Método para inicializar el arreglo de ciudades con instancias de City
    public void inicializar(City[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = new City("");
        }
    }
    // Método para agregar una nueva ciudad al grafo
    public void NewCity(String name) {
        int position = this.searchEmpty();
        if (position != -1 && !this.searchCity(name)) {
            this.cities[position].setName(name);
            this.actual_cities++;
        } 
    }
    
    public void newPath(String origin, String destiny, double distance) {
        // Verifica si tanto el origen como el destino existen en el grafo
        if (this.searchCity(origin) && this.searchCity(destiny)) {
            if(this.searchPath(origin, destiny)== null){
            for (int i = 0; i < this.max_cities; i++) {
                if (this.cities[i].getName().equals(origin)) {
                    this.cities[i].getPaths().NewPath(destiny, distance);

                } else if (this.cities[i].getName().equals(destiny)) {
                    this.cities[i].getPaths().NewPath(origin, distance);

                }
            }}
            else{
//                JOptionPane.showMessageDialog(null, "YA EXISTE UN CAMINO ENTRE AMBAS CIUDADES");
            }
        } else {
            JOptionPane.showMessageDialog(null, "CIUDAD INEXISTENTE");
        }
    }
    // Método para eliminar una ciudad del grafo
    public void DeleteCity(String name) {
        for (int i = 0; i < max_cities; i++) {
            if (this.cities[i].getName().equals(name)) {
                this.cities[i].setName("");
                this.cities[i].setPaths(new Adyacentes());
                this.actual_cities--;
            } else {
                this.cities[i].getPaths().DeletePath(name);
            }
        }
    }
    // Método para buscar si una ciudad ya existe en el grafo
    public boolean searchCity(String name) {
        for (int i = 0; i < this.max_cities; i++) {
            if (this.cities[i].getName().equals(name)) {
                return true;
            }
        }
        return false;
    }
    // Método para buscar la primera posición vacía en el arreglo de ciudades
    public int searchEmpty() {
        for (int i = 0; i < this.max_cities; i++) {
            if (this.cities[i].getName().equals("")) {
                return i;
            }
        }
        return -1;
    }
    // Método para ejecutar el algoritmo de la hormiga con parámetros alpha, beta y ro
    public void run(Ant ant, double alpha, double beta, double ro) {
        boolean[] visited = new boolean[this.max_cities];
        for (int i = 0; i < this.max_cities; i++) {
            visited[i] = false;
        }

        this.deepRun(visited, this.first, alpha, beta, ant);
        this.newPheromones(ant);
    }

    public void deepRun(boolean[] visited, int position, double alpha, double beta, Ant ant) {
        // Marca la posición actual como visitada
        visited[position] = true;
        double probabilities = 0;
        Random random = new Random();
        double randFloat = random.nextDouble();

        double sum = 0;
        for (int i = 0; i < this.max_cities; i++) {
            Path actualPath = this.cities[position].getPaths().SearchPath(this.cities[i].getName());
            if (!visited[i] && actualPath != null) {
                sum += Math.pow(actualPath.getFeromonas(), alpha) * Math.pow(1 / actualPath.getDistance(), beta);
            }
        }
//        System.out.println(randFloat);
        // Calcula las probabilidades para las ciudades adyacentes no visitadas
        for (int i = 0; i < this.max_cities; i++) {
            Path actualPath2 = this.cities[position].getPaths().SearchPath(this.cities[i].getName());
            if (i != position &&!visited[i] && actualPath2 != null) {
//                System.out.println(actualPath2.getDestiny());
                probabilities += this.calcProbabilities(visited, position, actualPath2, alpha, beta, ant, sum);
//                System.out.println("PROBABILIDAD " + probabilities);
            }
            if (randFloat < probabilities) {
//                System.out.println("PASÓ PO"+actualPath2.getDestiny());
                ant.totalDistance += actualPath2.getDistance();
                ant.visitedCities += actualPath2.getDestiny() + ",";
                if (i != last) {
                    deepRun(visited, i, alpha, beta, ant);
                    break;
                }else{
                    break;
                }
            }
        }
    }
    // Método para calcular las probabilidades de moverse a una ciudad adyacente
    public double calcProbabilities(boolean[] visited, int position, Path actualPath, double alpha, double beta, Ant ant, double sum) {
        return (Math.pow(actualPath.getFeromonas(), alpha) * Math.pow(1/actualPath.getDistance(), beta)) / sum;
    }
    // Método para inicializar las feromonas de los caminos entre ciudades
    public void iniciatePheromones() {
        for (int i = 0; i < this.max_cities; i++) {
            Path aux = this.cities[i].getPaths().pFirst;
            while (aux != null) {
                aux.setFeromonas(1 / (double)this.actual_cities);
                aux = aux.getNextPath();
            }
        }
    }
    // Método para actualizar las feromonas de los caminos visitados por la hormiga
    public void newPheromones(Ant h) {
        String[] visitados = h.visitedCities.split(",");
        for (int i = 0; i < visitados.length; i++) {
            if (i + 1 < visitados.length) {
                this.searchPath(visitados[i], visitados[i + 1]).trail += 1 / h.totalDistance;
                this.searchPath(visitados[i + 1], visitados[i]).trail += 1 / h.totalDistance;
            }
        }
    }
    // Método para calcular el rastro de feromonas con la evaporación
    public void calculatePheromonesTrail(double evaporacion) {
        for (int i = 0; i < this.max_cities; i++) {
            Path aux = this.cities[i].getPaths().pFirst;
            while (aux != null) {
                aux.setFeromonas(aux.getFeromonas() * (1 - evaporacion) + aux.trail);
                System.out.println(aux.trail);
                aux = aux.getNextPath();
            }
        }
    }
    // Método para buscar un camino entre ciudades
    public Path searchPath(String city, String path) {
        for (int i = 0; i < this.max_cities; i++) {
            if (this.cities[i].getName().equals(city)) {
                Path aux = this.cities[i].getPaths().pFirst;
                while (aux != null && !aux.getDestiny().equals(path)) {
                    aux = aux.getNextPath();
                }
                return aux;
            }
        }
        return null;
    }
    // Método para obtener información sobre las feromonas en los caminos
    public String pheromones() {
        String str = "";
        String[] visited = new String[max_cities];
        for (int i = 0; i < max_cities; i++) {
            visited[i] = "";
        }
        for (int i = 0; i < this.max_cities; i++) {
            Path aux = this.cities[i].getPaths().pFirst;
            while (aux != null) {
                if (!this.visited(aux.getDestiny(), visited)) {
                    str += this.cities[i].getName() + " - " + aux.getDestiny() + " -> " + aux.getFeromonas() + "\n";

                }
                aux = aux.getNextPath();
            }
            visited[i] = this.cities[i].getName();
        }
        return str;
    }
    // Método para verificar si una ciudad ha sido visitada
    public boolean visited(String city, String[] visited) {
        for (int i = 0; i < max_cities; i++) {
            if (visited[i].equals(city)) {
                return true;
            }
        }
        return false;
    }

    public String show() {
        String str = "";

        for (int i = 0; i < this.max_cities; i++) {
            if (!this.cities[i].getName().equals("")) {
                Path aux = this.cities[i].getPaths().pFirst;
                str += this.cities[i].getName();
                if(aux!= null){
                    str += " tiene un camino hacia: ";
                }
                while (aux != null) {

                    str += aux.getDestiny();
                    if (aux.getNextPath() == null) {
                        str += ".";
                    } else {
                        str += ", ";
                    }

                    aux = aux.getNextPath();
                }
                str += "\n";
            }
        }
        return str;
    }
    // Método para obtener el índice de una ciudad en el arreglo
    public int indexCity(String city){
        for (int i = 0; i < this.max_cities; i++) {
            if (this.cities[i].getName().equals(city)) {
                return i;
            }
        }
        return -1;
    }
    // Método para establecer el índice de la ciudad de inicio (first) y destino (last)
    public boolean setFL(String origin, String destiny){
        if(this.searchCity(origin) && this.searchCity(destiny)){
            this.first = indexCity(origin);
            this.last = this.indexCity(destiny);
            return true;
        }
        return false;
    }
    // Método para mostrar el nombre de las ciudades
    public String showVertex(){
        String vertex = "";
        for (int i = 0; i < this.max_cities; i++) {
            if (!this.cities[i].getName().equals("")) {
                vertex += this.cities[i].getName() + "\n";
            }
        }
        return vertex;
    }
    // Método para escribir la información del grafo en un archivo
    public void escribirArchivo(String archivo) {
        System.out.println(archivo);
        String path = archivo;
        File file = new File(path);
        file.delete();
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            PrintWriter pw = new PrintWriter(fw);
            pw.write("ciudad" + "\n");
            for (int i = 0; i < this.max_cities; i++) {
                try {
                    pw.write(this.cities[i].getName() + "\n");

                } catch (Exception e) {
                    System.out.println("En " + i + " no hay usuario registrado");
                }
            }
            pw.write("aristas");
            for (int i = 0; i < this.max_cities; i++) {
                if (!this.cities[i].getName().equals("")) {
                    Path ciudad =this.cities[i].getPaths().pFirst;
                    while (ciudad != null) {
                        pw.write("\n" + this.cities[i].getName() + "," + ciudad.getDestiny()+ "," + ciudad.getDistance());
                        ciudad = ciudad.getNextPath();
                    }
                }
            }
            pw.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
}
