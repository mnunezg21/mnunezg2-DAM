package ejercicio3_1;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	private static Scanner teclado =new Scanner(System.in);
	public static void main(String[] args) {
		
		File miAD = new File ("C:\\AD");
		File miEjercicios = new File ("C:\\AD\\Ejercicios");
		File miFichero = new File ("C:\\AD\\Ejercicios\\miFichero.txt");

		File miNuevoDirectorio = new File("C:\\AD\\Ejercicios\\miNuevoDirectorio");
		File miFichero2 = new File ("C:\\AD\\Ejercicios\\miNuevoDirectorio\\miFichero2.txt");
		
		int opcion = 1;
		try {
			miAD.mkdir();
			miEjercicios.mkdir();
			miFichero.createNewFile();
			
			while(opcion != 0){
				opcion = mostrarMenu();
				switch(opcion) {
					case 1:
						if (miNuevoDirectorio.mkdir()) {
							System.out.println("NuevoDirectorio creado correctamente");
							if (miFichero2.createNewFile()) {
								System.out.println("Fichero2 creado correctamente");
							} else System.out.println("No se pudo crear el Fichero2");
						} else System.out.println("No se pudo crear el NuevoDirectorio");
					break;
					case 2:
						if (miFichero.exists() && miFichero.delete()) {
                            System.out.println("Fichero2 borrado correctamente");
                        } else System.out.println("Fichero no existe");
                        
                        break;
					case 3:
						if (miFichero2.exists() && miFichero2.delete()) {
                            System.out.println("Fichero2 borrado correctamente");
                        }
						if (miNuevoDirectorio.delete()) {
                            System.out.println("NuevoDirectorio borrado correctamente");
                        } else {
                            System.out.println("No se pudo borrar NuevoDirectorio");
                        }
						break;
					case 0:
						System.out.println("Saliendo");
						break;
					default:
						System.out.println("Introduce una opcion valida");
						break;
				}	
			}
		} catch(IOException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Fin del programa");
	}
	private static int mostrarMenu(){
		System.out.println(""
				+ "\n1 Crear directorio nuevoDirectorio y miFichero2.txt"
				+ "\n2 Eliminar miFichero"
				+ "\n3 Eliminar miNuevoDirectorio"
				+ "\n0 Salir");
		return teclado.nextInt();
	}
}
