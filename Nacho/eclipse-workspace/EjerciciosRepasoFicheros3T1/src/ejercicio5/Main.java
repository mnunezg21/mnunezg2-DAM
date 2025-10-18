package ejercicio5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		File fichero = new File("ficheroTexto.txt");
		int i;
		
		try {
			FileReader fr = new FileReader(fichero);
			System.out.println("CONTENIDO DEL FICHERO: "+fichero.getName());
			
			while((i = fr.read())!= -1) {
				System.out.print((char) i);}
			fr.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
