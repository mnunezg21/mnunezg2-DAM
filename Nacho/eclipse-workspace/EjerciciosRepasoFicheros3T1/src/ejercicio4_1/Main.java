package ejercicio4_1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		File fichero= new File("FicheroTexto2.txt");
		FileWriter fw;
		try {
			fw = new FileWriter(fichero);
			String cadena = "Esto es una frase que quiero almacenar";
			
			String[] provincias = {"Albacete","Ávila","Cádiz","Córdoba","Madrid"};
			
			for (int i = 0; i < provincias.length; i++) {
				fw.write(provincias[i]+", ");
			}
			fw.append('*');
			
			fw.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}	
		System.out.println("Fin del programa");
	}

}
