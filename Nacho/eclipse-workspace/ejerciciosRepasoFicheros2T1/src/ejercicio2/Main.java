package ejercicio2;

import java.io.File;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		File miDirectorio = new File("C:\\PruebaAD");
		File miFichero = new File("C:\\PruebaAD\\miFichero.txt");

		try {
			miDirectorio.mkdir();
			if(miFichero.createNewFile()) {
				System.out.println("Fichero creado correctamente");
			}else System.out.println("No se pudo crear el fichero");
		} catch(IOException e){
			System.out.println(e.getMessage());
		}
		System.out.println("Fin programa");
	}

}
