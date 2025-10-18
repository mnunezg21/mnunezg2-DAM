package ejercicio6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		File fichero = new File("Empleados.txt");
		
		
		try {
			FileWriter fw = new FileWriter(fichero);
			
			String encabezado1 = "  - LISTA DE EMPLEADOS -		\n";
			String encabezado2 = "-------------------------------";
			
			fw.write(encabezado1);
			fw.write(encabezado2);
			
			String empleados[] = {"Pilar","Ivan","Pablo","Rafa","Luisa"};
			
			for (int i = 0; i < empleados.length; i++) {
				fw.write("\nID: "+ (i+1) + " - "+empleados[i]);
			}
			fw.close();
			
			System.out.println("Fichero empleados.txt creados correctamente");
			
			File fichero2 = new File("Empleados.txt");
			BufferedReader bf = new BufferedReader(new FileReader(fichero2));
			String linea;
			
			while((linea=bf.readLine())!=null) {
				System.out.println(linea);
			}
			bf.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Fin del programa");	
	}
}
