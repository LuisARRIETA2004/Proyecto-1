/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoestructurasgabriel.pkg1;

public class Adyacentes {

    Path pFirst;

    public Adyacentes() {
        this.pFirst = null;
    }

    public void NewPath(String name, double distance) {
        if (!this.search(name)) {
            Path newPath = new Path(name, distance);
            if (this.pFirst != null) {
                Path aux = this.pFirst;
                while (aux.getNextPath() != null) {
                    aux = aux.getNextPath();
                }
                aux.setNextPath(newPath);
            } else {
                this.pFirst = newPath;
            }
        } else {

        }
    }

    public void DeletePath(String name) {
        Path aux = this.pFirst;
        if (this.pFirst != null) {
            if (this.pFirst.getDestiny().equals(name)) {
                this.pFirst = this.pFirst.getNextPath();
            } else {
                while (aux.getNextPath() != null && !aux.getNextPath().getDestiny().equals(name)) {
                    aux = aux.getNextPath();
                }
                if (aux.getNextPath() != null) {
                    aux.setNextPath(aux.getNextPath().getNextPath());
                }
            }

        }
    }

    public String print() {
        Path aux = this.pFirst;
        String adyacentes = "Ciudades adyacentes: \n";
        while (aux != null) {
            adyacentes += aux.getDestiny() + "\n";
            aux = aux.getNextPath();
        }
        return adyacentes;
    }

    public Path SearchPath(String name) {
        Path aux = this.pFirst;
        while (aux != null && !aux.getDestiny().equals(name)) {
            aux = aux.getNextPath();
        }
        return aux;
    }

    public boolean search(String name) {
        Path aux = this.pFirst;
        while (aux != null) {
            if (aux.getDestiny().equals(name)) {
                return true;
            }
            aux = aux.getNextPath();
        }
        return false;

    }

}
