/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoestructurasgabriel.pkg1;

public class City {
   // Variable de instancia para almacenar los caminos adyacentes
   private Adyacentes paths;
   // Variable de instancia para almacenar el nombre de la ciudad
   private String name;
   
   // Constructor que inicializa el nombre de la ciudad y los caminos adyacentes como una nueva instancia de Adyacentes
   public City(String name){
       this.paths = new Adyacentes();
       this.name = name;
   }

   /**
    * @return los caminos adyacentes
    */
   public Adyacentes getPaths() {
       return paths;
   }

   /**
    * @param paths los caminos adyacentes a establecer
    */
   public void setPaths(Adyacentes paths) {
       this.paths = paths;
   }


   /**
    * @return el nombre
    */
   public String getName() {
       return name;
   }

   /**
    * @param name el nombre a establecer
    */
   public void setName(String name) {
       this.name = name;
   }
}
