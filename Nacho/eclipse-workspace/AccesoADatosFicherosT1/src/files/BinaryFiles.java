package files;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class BinaryFiles {

	public static void main(String[] args) {
		Path path = Path.of("ficheros/fichero_binario");
		escribir(path);
		leer(path);
	}

	private static void leer(Path path) {
		byte[] byteDelFichero= new byte[] {};
		try {
			byteDelFichero=Files.readAllBytes(path);
		} catch (IOException e) {
			System.err.println("Error al leer los bytes del fichero "+
		path.toString());
			System.err.println(e.getMessage());
			System.exit(-4);
		}
		ByteArrayInputStream byteArrayInputStream= new ByteArrayInputStream(byteDelFichero);
		ObjectInputStream objectInputStream=null;
		try {
			objectInputStream=new ObjectInputStream(byteArrayInputStream);
		} catch (IOException e) {
			System.err.println("Error al crear el objetInputStream "+
					path.toString());
			System.err.println(e.getMessage());
			System.exit(-5);
		}
		try {
			Curso curso=(Curso) objectInputStream.readObject();
			System.out.println(curso.toString());
		} catch (ClassNotFoundException | IOException e) {
			System.err.println("Error al leer el objeto de la memoria ram "
					+ "y combertirlo en el objeto curso "+path.toString());
			System.err.println(e.getMessage());
			System.exit(-6);
		}
	}

	private static void escribir(Path path) {
		Curso curso = new Curso(1,"Procesos y Servicios",30);
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		//CREAMOS UN OBJETO PARA ESCRIBIRLO EN LA RAM
		ObjectOutputStream objectOutputStream = null;
		
		try {
			objectOutputStream= new ObjectOutputStream(byteArrayOutputStream);
		} catch (IOException e) {
			System.err.println("ERROR al crear el objectOutputStream");
			System.err.println(e.getMessage());
			System.exit(-1);
		}
		
		try {
			objectOutputStream.writeObject(curso);
		} catch (IOException e) {
			System.err.println("ERROR al escribir el objectOutputStream");
			System.err.println(e.getMessage());
			System.exit(-2);
		}
		try {
			Files.write(path, byteArrayOutputStream.toByteArray());
		} catch (IOException e) {
			System.err.println("ERROR al escribir en el fichero");
			System.err.println(e.getMessage());
			System.exit(-3);
		}
		System.out.println("El fichero binario ha sido creado");
		
	}

}
