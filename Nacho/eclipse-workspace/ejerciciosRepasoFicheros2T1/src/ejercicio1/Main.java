package ejercicio1;

import java.io.File;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		File miDirectorio = new File("src/miDirectorio");
		File miFichero = new File("src/miDirectorio/miFichero.txt");
		try {
			miDirectorio.mkdir();
			if (miFichero.createNewFile()) {
				System.out.println("El fichero se ha creado correctamente");
			} else System.out.println("El fichero ya esta creado");
		} catch(IOException e) {
			System.err.println("Error de fichero/directorio");
			System.err.println(e.getMessage());
			System.exit(-1);
		}
		System.out.println("Fin programa");
	}

}
