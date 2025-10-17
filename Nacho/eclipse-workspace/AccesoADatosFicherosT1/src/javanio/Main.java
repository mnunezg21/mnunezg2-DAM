package javanio;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class Main {

	public static void main(String[] args) {
		//Path path = Path.of("ficheros/aleatorio.txt");
		Path path = Path.of("fichero/nio/aleatorio.txt");
		System.out.println(path.normalize().toString());
		//Ruta absoluta
		System.out.println(path.toAbsolutePath());
		//Comprueba si existe el padre y si no existe lo crea
		path.toFile().getParentFile();		
		//Añadir archivo
		File file = path.toFile();
		
		try {
			file.createNewFile();
		} catch (IOException e) {
			System.err.println("ERROR al cerrar el fichero"+
		"en el Path: "+path.toString());
			System.err.println(e.getMessage());
			System.exit(-1);
		}
		
	}

}
