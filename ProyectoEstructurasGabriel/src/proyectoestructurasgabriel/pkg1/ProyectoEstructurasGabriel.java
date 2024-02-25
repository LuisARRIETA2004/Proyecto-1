/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectoestructurasgabriel.pkg1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ProyectoEstructurasGabriel {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MyGraph g = new MyGraph(20);
//        g.NewCity("1");
//        g.NewCity("2");
//        g.NewCity("3");
//        g.NewCity("4");
//        g.NewCity("5");
//        g.NewCity("6");
//        g.NewCity("7");
//
//        g.newPath("1", "2", 12);
//        g.newPath("1", "3", 11);
//        g.newPath("1", "6", 22);
//        g.newPath("2", "3", 32);
//        g.newPath("2", "4", 2);
//        g.newPath("3", "5", 1);
//        g.newPath("3", "4", 7);
//        g.newPath("4", "7", 5);
//        g.newPath("4", "6", 9);
//        g.newPath("4", "1", 18);
//        g.newPath("5", "1", 1);
//        g.newPath("5", "7", 8);
//        g.newPath("6", "7", 24);
//        g.newPath("6", "5", 12);
//        g.newPath("7", "1", 32);
//        
//        Ant a = new Ant();
//        g.iniciatePheromones();
//        g.setFL("1", "7");
//        g.run(a, 2, 1, 0.7);
//        g.calculatePheromonesTrail(0.7);
//        System.out.println(g.pheromones());
//        System.out.println(a.visitedCities);
      FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de Texto", "txt");
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(filter);
        File ruta = new File("e:/carpeta/");
        fileChooser.setCurrentDirectory(ruta);
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            String dir = String.valueOf(file).replace("\\", "//");
            String linea;
            file = new File(dir);
            String datos_txt = "";
            int estado = 1;
            String lineas[];
            try {
                if (!file.exists()) {
                    file.createNewFile();
                } else {
                    FileReader fr = new FileReader(file);
                    BufferedReader br = new BufferedReader(fr);
                    while ((linea = br.readLine()) != null) {
                        if (!linea.isEmpty() && !linea.equals("ciudad")) {
                            if (linea.equals("aristas")) {
                                estado = 2;
                            } else if (estado == 1) {
                                System.out.println("ñ"+linea);
                                g.NewCity(linea);
                            } else if (estado == 2) {
                                System.out.println("-"+linea);                                
                                linea = linea.replace(" ", "");
                                lineas = linea.split(",");                               
                                g.newPath(lineas[0], lineas[1], Double.parseDouble(lineas[2]));
                            }
                        }
                    }
                    br.close();
                    JOptionPane.showMessageDialog(null, "Se ha leido el archivo");
                    System.out.println(g.show());
                    VentanaPrincipal vp = new VentanaPrincipal(g, dir);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
        
        
    }

}
