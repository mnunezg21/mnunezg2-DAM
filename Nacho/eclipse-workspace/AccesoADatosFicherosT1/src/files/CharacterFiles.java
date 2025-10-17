package files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class CharacterFiles {

	public static void main(String[] args) {
		Path path=Path.of("ficheros/fichero_de_caracteres.txt");
		escribir(path);
		leer(path);
	}

	private static void leer(Path path) {
		try {
			List<String> lista= Files.readAllLines(path);
			for(String texto:lista) {
				System.out.println(texto);
			}
		} catch (IOException e) {
			System.err.println("Error en la lectura de las lineas");
			System.err.println(e.getMessage());
			System.exit(-2);
		}
		System.out.println("El fichero ha sido leido correctamente");
	}

	private static void escribir(Path path) {
		try {
			Files.writeString(path, "Hola mundo con la clase Files\n");
			Files.writeString(path, "Hola mundo 2 con la clase Files\n",StandardOpenOption.APPEND);
			Files.writeString(path, "Hola mundo 3 con la clase Files\n",StandardOpenOption.APPEND);
			Files.writeString(path, "Hola mundo 4 con la clase Files\n",StandardOpenOption.APPEND);
		} catch (IOException e) {
			System.err.println("Error al escribir en el fichero: "+path.toString());
			System.err.println(e.getMessage());
			System.exit(-1);
		}
		System.out.println("El texto ha sido creado correctamente");
		
	}

}
