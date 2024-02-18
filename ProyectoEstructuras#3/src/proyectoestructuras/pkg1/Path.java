/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/*
@StefanoDiMichelangelo
desarroyo de clase y metodo Path/Camino**/

package proyectoestructuras.pkg1;

public class Path {
    private int distance;
    private int feromonas;
    private String destiny;
    private Path nextPath;
    
    public Path(String dest, int dist){
        this.destiny = dest;
        this.distance = dist;
        this.nextPath = null;
    }

    /**
     * @return the distance
     */
    public int getDistance() {
        return distance;
    }

    /**
     * @param distance the distance to set
     */
    public void setDistance(int distance) {
        this.distance = distance;
    }

    /**
     * @return the feromonas
     */
    public int getFeromonas() {
        return feromonas;
    }

    /**
     * @param feromonas the feromonas to set
     */
    public void setFeromonas(int feromonas) {
        this.feromonas = feromonas;
    }

    /**
     * @return the destiny
     */
    public String getDestiny() {
        return destiny;
    }

    /**
     * @param destiny the destiny to set
     */
    public void setDestiny(String destiny) {
        this.destiny = destiny;
    }

    /**
     * @return the nextPath
     */
    public Path getNextPath() {
        return nextPath;
    }

    /**
     * @param nextPath the nextPath to set
     */
    public void setNextPath(Path nextPath) {
        this.nextPath = nextPath;
    }
    
}
