package ficherosbinarios;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// CREAMOS UN FICHERO DONDE GUARDAR NUESTROS OBJETOS
		File file = new File("ficheros/objetos.txt");
		guardarObjeto(file);
	}

	
	private static void recuperarObjeto(File file) {
		//CREAR UN FLUJO FILEINPUTSTREAM
		FileInputStream fileInputStream=null;
		
		try {
			fileInputStream=new FileInputStream(file);
		} catch (FileNotFoundException e) {
			System.err.println("No se pudo recuperar el archivo"+file.getName());
			System.err.println(e.getMessage());
			System.exit(-5);
		}
		//CREAR EL ObjectInputStream
		ObjectInputStream objectInputStream=null;
		
		try {
			objectInputStream = new ObjectInputStream(fileInputStream);
		} catch (IOException e) {
			System.err.println("No se pudo crear el ObjectInputStream del fichero"+file.getName());
			System.err.println(e.getMessage());
			System.exit(-6);
		}
		
		//Crear una persona y volcar el objeto leido ***
		//lee del fichero y lo convierte a objeto persona
		try {
			Persona persona =(Persona)objectInputStream.readObject();
			System.out.println(persona);
		} catch (ClassNotFoundException | IOException e) {
			System.err.println("Error al crear una persona y volcarla al objeto");
			System.err.println(e.getMessage());
			System.exit(-7);
			
		}
		
			
			try {
				objectInputStream.close();
				fileInputStream.close();
			} catch (IOException e) {
				System.err.println("No se ha podido cerrar los metodos");
				System.err.println(e.getMessage());
				System.exit(-8);
			}

	} 
	
	
	private static void guardarObjeto(File file) {
		
		//CREAR FICHERO EN EL S. ALMACENAMIENTO
		try {
			file.createNewFile();
			
		} catch (IOException e) {
			System.err.println("No se ha podido guardar el fichero"+
						file.getName());
			System.err.println(e.getMessage());
			System.exit(-1);
		}
		//CREAR INSTANCIAS DE LOS OBJETOS
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el ID de la persona:");
		int id=sc.nextInt();
		//
		sc.nextLine();
		System.out.println("Introduce el Nombre de la persona:");
		String nombre=sc.nextLine();
		//
		System.out.println("Introduce la Edad de la persona:");
		int edad=sc.nextInt();
		//
		sc.nextLine();
		System.out.println("Introduce la Direccion de la persona:");
		String direccion=sc.nextLine();
		System.out.println("Persona creada perfectamente");
		
		//LLAMAMOS AL CONSTRUCTOR PARA CREAR UNA PERSONA
		Persona persona= new Persona(id, nombre, edad, direccion);
		//CREAR EL FILEOUTPUTSTREAM
		//para guardar el objeto en el flujo de datos de salida-->
		FileOutputStream fileOutputStream = null;
		
		try {
			fileOutputStream = new FileOutputStream(file);
		} catch(FileNotFoundException e){
			System.err.println("No se ha podido crear el FileOutputStream");
			System.err.println(e.getMessage());
			System.exit(-2);
		}
		
		//CREAMOS EL objetOutputStream PARA CONVERTIR EL OBJETO  EN BYTES
		ObjectOutputStream objectOutputStream=null;
		try {
			objectOutputStream=new ObjectOutputStream(fileOutputStream);
		} catch (IOException e) {
			System.err.println("No se ha podido crear el objectOutputStream");
			System.err.println(e.getMessage());
			System.exit(-2);
		}
		
		//ESCRIBIMOS EL OBJETO EN EL FICHERO BINARIO
		//GRACIAS AL FLUJO AHORA EN EL objectOutputStream
		try {
			objectOutputStream.writeObject(persona);
		} catch (IOException e) {
			System.err.println("No se ha podido escribir en el fichero"
					+ file.getName());
			System.err.println(e.getMessage());
			System.exit(-3);
		}
		
		//HAY QUE CERRAR TODOS LOS FLUJOS.
		try {
			objectOutputStream.close();
			fileOutputStream.close();
			sc.close();
			System.out.println("Fin programa");
		} catch (IOException e) {
			System.err.println("No se pudo cerrar el programa");
			System.err.println(e.getMessage());
			System.exit(-4);
		}
		
	}

}
