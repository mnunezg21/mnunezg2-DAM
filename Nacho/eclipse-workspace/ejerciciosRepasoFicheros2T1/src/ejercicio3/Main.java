package ejercicio3;

import java.io.File;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		File miAD = new File ("C:\\AD");
		File miEjercicios = new File ("C:\\AD\\Ejercicios");
		File miFichero = new File ("C:\\AD\\Ejercicios\\miFichero.txt");

		try {
			miAD.mkdir();
			miEjercicios.mkdir();
			if (miFichero.createNewFile()) {
				System.out.println("Fichero creado correctamente");
			} else System.out.println("Fichero no se pudo crear");
		} catch(IOException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Fin del programa");
	}

}
