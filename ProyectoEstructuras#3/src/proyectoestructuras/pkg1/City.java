/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*
@StefanoDiMichelangelo
desarroyo de clase y metodo city**/

package proyectoestructuras.pkg1;

public class City {
    private Adyacentes paths;
    private String name;
    
    public City(String name){
        this.paths = new Adyacentes();
        this.name = name;
    }

    /**
     * @return the paths
     */
    public Adyacentes getPaths() {
        return paths;
    }

    /**
     * @param paths the paths to set
     */
    public void setPaths(Adyacentes paths) {
        this.paths = paths;
    }


    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
}
