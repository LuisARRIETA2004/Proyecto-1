/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*
@StefanoDiMichelangelo
desarrollo de clase y metodo city**/

package proyectoestructuras.pkg1;

public class City {
   private Adyacentes paths;  // Lista de caminos adyacentes a la ciudad
   private String name;  // Nombre de la ciudad
   
   public City(String name){  // Constructor de la clase City que recibe un nombre como parámetro
       this.paths = new Adyacentes();  // Inicializa la lista de caminos adyacentes como una nueva instancia de la clase Adyacentes
       this.name = name;  // Asigna el nombre especificado a la ciudad
   }

   /**
    * @return the paths
    */
   public Adyacentes getPaths() {  // Método para obtener la lista de caminos adyacentes
       return paths;
   }

   /**
    * @param paths the paths to set
    */
   public void setPaths(Adyacentes paths) {  // Método para establecer la lista de caminos adyacentes
       this.paths = paths;
   }

   /**
    * @return the name
    */
   public String getName() {  // Método para obtener el nombre de la ciudad
       return name;
   }

   /**
    * @param name the name to set
    */
   public void setName(String name) {  // Método para establecer el nombre de la ciudad
       this.name = name;
   }
}
