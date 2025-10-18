package FicheroInformacion;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

public class Main {
//Ejercicio 10
	public static void main(String[] args) {
		// Crea un fichero de texto utilizando la clase FileWriter
		File file = new File("ejercicios/ficheroInformacion");
		FileWriter fileWriter;
			
		try {
			fileWriter = new FileWriter(file);
			fileWriter.write("Esto es un texto de prueba,"
					+ "\nEstamos creando nuestro primer fichero de texto "
					+ "\nhttps://codigonline.com");
			System.out.println("Texto escrito");
			fileWriter.close();
		} catch (IOException e) {
			System.err.println("Error al escribir en el fichero");
			System.err.println(e.getMessage());
			System.exit(-1);
			
		} 

	}

}
