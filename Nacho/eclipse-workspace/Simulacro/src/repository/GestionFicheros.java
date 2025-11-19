package repository;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import modelo.Almacen;
import modelo.Producto;

public class GestionFicheros {
	
	public static boolean exportarStockBajo(File fichero, List<Producto> productos) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fichero))) {

            for (Producto p : productos) {
                bw.write(p.getId_producto() +";"+ p.getNombre() +";"+ p.getPrecio()+";"+ p.getStock());
                bw.newLine();
            }
            return true;
        } catch (IOException e) {
            System.err.println("Error al escribir el fichero: " + e.getMessage());
            return false;
        }
    }
	
	public static List<Almacen> leerAlmacenes(File fichero) {

        List<Almacen> lista = new ArrayList<>();

        try (Scanner sc = new Scanner(fichero)) {

            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                String[] partes = linea.split(";");

                if (partes.length == 4) {
                    String codigo = partes[0];
                    String nombre = partes[1];
                    String ciudad = partes[2];
                    int capacidad = Integer.parseInt(partes[3]);

                    lista.add(new Almacen(codigo, nombre, ciudad, capacidad));
                }
            }

        } catch (Exception e) {
            System.err.println("Error leyendo almacenes: " + e.getMessage());
        }

        return lista;
    }
}
