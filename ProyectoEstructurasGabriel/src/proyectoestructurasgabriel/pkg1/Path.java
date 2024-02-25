/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoestructurasgabriel.pkg1;

public class Path {
    private double distance;
    private double feromonas;
    private String destiny;
    private Path nextPath;
    public double trail;
    public Path(String dest, double dist){
        this.destiny = dest;
        this.distance = dist;
        this.nextPath = null;
        this.trail = 0;
    }

    /**
     * @return the distance
     */
    public double getDistance() {
        return distance;
    }

    /**
     * @param distance the distance to set
     */
    public void setDistance(double distance) {
        this.distance = distance;
    }

    /**
     * @return the feromonas
     */
    public double getFeromonas() {
        return feromonas;
    }

    /**
     * @param feromonas the feromonas to set
     */
    public void setFeromonas(double feromonas) {
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
