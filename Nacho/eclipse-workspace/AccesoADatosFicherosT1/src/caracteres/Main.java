package caracteres;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		File file = new File("ficheros/caracteres.txt");
		escribir(file);
		leer(file);
	}

	
	private static void leer(File file) {
		FileReader fileReader = null;
		
		
		try {
			fileReader = new FileReader(file);
		}
		catch(FileNotFoundException e) {
			System.err.println("Error al crear el FileReader");
			System.err.println(e.getMessage());
			System.exit(-4);
		}
		
		try {
			int read;
			while ((read = fileReader.read())!= -1) {
				System.out.print((char)read);
			}
		} catch(IOException e) {
			System.err.println("Error al leer del fichero");
			System.err.println(e.getMessage());
			System.exit(-5);
		}
	}


	private static void escribir(File file) {
		//Escribir caracteres en un fichero de chars
		//1 FileWriter
		FileWriter fileWriter=null;
		
		try {
			fileWriter= new FileWriter(file);
		} catch (IOException e) {
			System.err.println("Error al crear el FileWriter");
			System.err.println(e.getMessage());
			System.exit(-1);
		}
		
		//2 Podemos escribir en el fichero
		try {
			fileWriter.write("\r\n"
					+ "\r\n"
					+ "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur sollicitudin ex interdum, interdum orci et, ullamcorper est. Donec vel sagittis nisl, at blandit ante. Nam cursus, erat vel scelerisque vestibulum, felis neque tempor sem, sit amet placerat ante lacus ut arcu. Aliquam tristique posuere quam, quis molestie lectus pellentesque congue. Nunc aliquam vitae est sed auctor. Etiam feugiat libero eget accumsan gravida. Nullam mollis molestie leo ac aliquet. Duis at ante quam.\r\n"
					+ "\r\n"
					+ "Aliquam tincidunt justo ut ligula viverra, ac consequat nunc aliquet. Praesent tempus hendrerit nisl, ac mattis tellus. Sed a tellus in odio fermentum accumsan ac sed nisi. Maecenas vehicula fermentum tincidunt. Sed at sem a tellus varius tempor in vel leo. Duis tristique nisl velit, non cursus mauris ornare vitae. Morbi sed enim quis lorem dictum tempus nec non mi. Donec non ullamcorper magna. In convallis nec velit ut scelerisque.\r\n"
					+ "\r\n"
					+ "Aenean fringilla ultrices lorem, ac mattis urna tempor id. Curabitur maximus dignissim tempor. Donec volutpat, urna pharetra euismod sodales, tortor nulla consequat erat, sed volutpat quam nunc et orci. Fusce in dui sit amet eros varius dictum at at ex. Nam tincidunt et leo in placerat. Morbi consectetur sapien ac lacus tempus dignissim. Praesent nec viverra tellus. Donec. ");
		} catch (IOException e) {
			System.err.println("Error al escribir en el File");
			System.err.println(e.getMessage());
			System.exit(-2);
		}
	}

}
