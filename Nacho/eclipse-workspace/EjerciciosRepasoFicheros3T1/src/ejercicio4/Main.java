package ejercicio4;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		File fichero= new File("FicheroTexto.txt");
		FileWriter fw;
		try {
			fw = new FileWriter(fichero);
			String cadena = "Esto es una frase que quiero almacenar";
			
			char[] arrayCadena = cadena.toCharArray();
			
			for (int i = 0; i < arrayCadena.length; i++) {
				fw.write(arrayCadena[i]);
			}
			fw.append('*');
			fw.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}	
		System.out.println("Fin del programa");
	}
}
