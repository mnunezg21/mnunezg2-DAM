package io;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

public class Main {

	public static void main(String[] args) {
		System.out.println("Iniciando programa de ficheros...");
		File directorio = new File("ficheros");
		
		if(!directorio.mkdir()) {
			if(!directorio.exists()) {
				System.err.println("No se ha podido crear el directorio");
				System.exit(-1);
			}
		}
		//Crear fichero
		File fichero = new File(directorio,"fichero.txt");
		
		try {
			fichero.createNewFile();
			System.out.println("Se ha generado el nuevo fichero");
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("No se ha podido generar el nuevo fichero");
			System.err.println(e.getMessage());
		}
		//Renombrar fichero
		File renombre = new File(directorio,"fichero_copia.txt");
		fichero.renameTo(renombre);
		System.out.println("Se ha cambiado el nombre del fichero correctamente");
		
		
		//COPIAR FICHERO 
		try {
			FileUtils.copyFile(renombre, fichero);
			System.out.println("Se ha copiado el nuevo fichero");
		} catch (IOException e) {
			System.err.println("No se puede copiar el fichero"+
					fichero.getName());

		}
		
		//MOVER FICHERO
		try {
			FileUtils.moveFile(fichero, new File("Fichero2.txt"));
			System.out.println("Se ha movido el nuevo fichero");
		} catch (IOException e) {
			System.err.println("No se puede mover el fichero"+
						fichero.getName());
		}
		
		//Eliminar fichero
		if(renombre.delete()) {
			System.out.println("Su fichero ha sido borrado");
		}
		else {
			System.out.println("Su fichero NO ha podido borrar");
		}
		
		System.out.println("Finalizando el programa...");
	}

}
