/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Arboles;

import Arboles.Habitacion;
import Clases.Reservacion;
import HashTable.TablaHash_Estado;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import Clases.Clientes_Actuales;

public class Administracion_Hotel {

    public Habitacion[] habitaciones;
    public ABBReservaciones reservaciones;
    public TablaHash_Estado huespedes;

    public Administracion_Hotel() {
        habitaciones = new Habitacion[300];
        for (int i = 0; i < 300; i++) {
            habitaciones[i] = null;
        }
        this.reservaciones = this.leerCSV_Reservaciones("reservas.csv");
        this.leerCSV_Habitaciones("habitaciones.csv");
        this.leer_CSV_Historico("historico.csv");
        this.huespedes = this.leerCSV_Estado("estado.csv");
    }

    //FUNCIONES DE LAS HABITACIONES
    public void crear_habitacion(int numero, int piso, String tipo) {
        this.habitaciones[numero - 1] = new Habitacion(numero, piso, tipo);
    }

    public String ver_historial_habitacion(int numero) {
        return this.habitaciones[numero - 1].mostrar_historial();
    }

    public Habitacion escoger_habitacion(String tipo_hab) {
        for (int i = 0; i < 300; i++) {
            if (this.habitaciones[i].ocupada == false && this.habitaciones[i].tipo.equals(tipo_hab)) {
                return this.habitaciones[i];
            }
        }
        return null;
    }

    //FUNCIONES DE CHEK-IN Y CHECK-OUT
    public String Check_in(int ci) {
        Reservacion reserva = reservaciones.encontar_reservacion(ci);
        if (reserva != null) {
            Habitacion habitacion = this.escoger_habitacion(reserva.getTipo_hab());
            if (habitacion != null) {
                habitacion.ocupada = true;
                huespedes.insertar(habitacion.numero_hab, reserva.getPrimer_nombre(), reserva.getSegundo_nombre(), reserva.getEmail(), reserva.getGenero(), reserva.getCelular(), reserva.getFecha_llegada());
                reservaciones.borrar_reservacion(ci);
                return "El cliente " + reserva.getPrimer_nombre() + " " + reserva.getSegundo_nombre() + " se hospedará en la habitación " + habitacion.numero_hab;
            } else {
                return "No hay habitaciones de ese tipo disponibles por el momento";
            }
        } else {
            return "No hay reserva con esa cédula";
        }
    }

    public String Check_out(String nombre, String apellido, int ci) {
        Clientes_Actuales cliente = this.huespedes.buscar(nombre, apellido);
        if (cliente != null) {
            Habitacion habitacion = this.habitaciones[cliente.getNumeroHab() - 1];
            if (habitacion != null) {
                habitacion.ocupada = false;
                habitacion.añadir_info_historial(ci, nombre, apellido, cliente.getEmail(), cliente.getGenero(), cliente.getLlegada());
                this.huespedes.eliminar(nombre, apellido);
                return "El cliente " + cliente.getNombre() + " " + cliente.getApellido() + " ha desalojado la habitación " + habitacion.numero_hab + ".\nGracias por visitarnos!";
            }
        }
        return "Error, datos invalidos";
    }

    
    
    //LECTORES DE CSV
    public ABBReservaciones leerCSV_Reservaciones(String filePath) {
        ABBReservaciones nodes = new ABBReservaciones();
        try ( CSVReader reader = new CSVReader(new FileReader(filePath))) {
            // Read the header line
            String[] header = null;
            try {
                header = reader.readNext();
            } catch (CsvValidationException ex) {
                Logger.getLogger(Administracion_Hotel.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (header == null || header.length != 9) {
                throw new IOException("Invalid CSV format");
            }

            String[] values;
            try {
                while ((values = reader.readNext()) != null) {
                    if (values.length != 9) {
                        throw new IOException("Invalid CSV format");
                    }
                    String ci = values[0].replace(".", "");
                    nodes.crear_reservacion(Integer.parseInt(ci), values[1], values[2], values[3], values[4], values[5], values[6], values[7], values[8]);
                }
            } catch (CsvValidationException ex) {
                Logger.getLogger(Administracion_Hotel.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException e) {
            System.err.println("Error reading CSV file: " + e.getMessage());
        }
        System.out.println(nodes.imprimir_abb(nodes.raiz, ""));
        return nodes;
    }

    public void leerCSV_Habitaciones(String filePath) {
//        Habitacion nodes = new Habitacion();
        try ( CSVReader reader = new CSVReader(new FileReader(filePath))) {
            // Read the header line
            String[] header = null;
            try {
                header = reader.readNext();
            } catch (CsvValidationException ex) {
                Logger.getLogger(Administracion_Hotel.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (header == null || header.length != 3) {
                throw new IOException("Invalid CSV format");
            }

            String[] values;
            try {
                while ((values = reader.readNext()) != null) {
                    if (values.length != 3) {
                        throw new IOException("Invalid CSV format");
                    }
                    this.crear_habitacion(Integer.parseInt(values[0]), Integer.parseInt(values[2]), values[1]);
                }
            } catch (CsvValidationException ex) {
                Logger.getLogger(Administracion_Hotel.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException e) {
            System.err.println("Error reading CSV file: " + e.getMessage());
        }

    }

    public TablaHash_Estado leerCSV_Estado(String filePath) {
        TablaHash_Estado nodes = new TablaHash_Estado();
        try ( CSVReader reader = new CSVReader(new FileReader(filePath))) {
            // Read the header line
            String[] header = null;
            try {
                header = reader.readNext();
            } catch (CsvValidationException ex) {
                Logger.getLogger(Administracion_Hotel.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (header == null || header.length != 7) {
                throw new IOException("Invalid CSV format");
            }

            String[] values;
            Clientes_Actuales[] clientes = new Clientes_Actuales[10];
            for (int i = 0; i < 10; i++) {
                clientes[i] = null;
            }
            try {
                while ((values = reader.readNext()) != null) {
                    if (values.length != 7) {
                        throw new IOException("Invalid CSV format");
                    }
                    if (values[0].equals("")) {
                        for (int i = 0; i < 10; i++) {
                            if (clientes[i] == null) {
                                clientes[i] = new Clientes_Actuales(0, values[1], values[2], values[3], values[4], values[6], values[5]);
                                break;
                            }

                        }
                    } else {
                        nodes.insertar(Integer.parseInt(values[0]), values[1], values[2], values[3], values[4], values[5], values[6]);
                        for (int i = 0; i < 10; i++) {
                            if (clientes[i] != null) {
                                nodes.insertar(Integer.parseInt(values[0]), clientes[i].getNombre(), clientes[i].getApellido(), clientes[i].getEmail(), clientes[i].getGenero(), clientes[i].getLlegada(), clientes[i].getCelular());
                                clientes[i] = null;
                            }
                        }
                        this.habitaciones[Integer.parseInt(values[0]) - 1].ocupada = true;

                    }

                }
            } catch (CsvValidationException ex) {
                Logger.getLogger(Administracion_Hotel.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException e) {
            System.err.println("Error reading CSV file: " + e.getMessage());
        }
        return nodes;
    }

    public void leer_CSV_Historico(String filePath) {
//        ArregloHabitaciones nodes = habs;
        try ( CSVReader reader = new CSVReader(new FileReader(filePath))) {
            // Read the header line
            String[] header = null;
            try {
                header = reader.readNext();
            } catch (CsvValidationException ex) {
                Logger.getLogger(Administracion_Hotel.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (header == null || header.length != 7) {
                throw new IOException("Invalid CSV format");
            }

            String[] values;
            try {
                while ((values = reader.readNext()) != null) {
                    if (values.length != 7) {
                        throw new IOException("Invalid CSV format");
                    }
                    String ci = values[0].replace(".", "");
                    this.habitaciones[Integer.parseInt(values[6]) - 1].añadir_info_historial(Integer.parseInt(ci), values[1], values[2], values[3], values[4], values[5]);
                }
            } catch (CsvValidationException ex) {
                Logger.getLogger(Administracion_Hotel.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException e) {
            System.err.println("Error reading CSV file: " + e.getMessage());
        }

    }

}
