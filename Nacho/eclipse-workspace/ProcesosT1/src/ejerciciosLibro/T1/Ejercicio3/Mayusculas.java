package ejerciciosLibro.T1.Ejercicio3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Mayusculas {

	public static void main(String[] args) {
		try {
			// Crea proceso hijo (ejecuta la clase HijoMayuscula)
			ProcessBuilder pb = new ProcessBuilder("java","-jar","HijoMayusculas.jar");
			pb.redirectErrorStream(true); // Combina la salida y errores 
			Process procesoHijo = pb.start();// Inicia el proceso
			
			//Streams para comunicación
			BufferedWriter escritorHijo = new BufferedWriter(new OutputStreamWriter(procesoHijo.getOutputStream()));
			BufferedReader lectorHijo = new BufferedReader(new InputStreamReader(procesoHijo.getInputStream()));
			BufferedReader entradaUsuario = new BufferedReader(new InputStreamReader(System.in));
			
			
			System.out.println("Escribe texto (Ctrl+D o Ctrl+Z para terminar): ");
			
			String linea;
			while((linea = entradaUsuario.readLine()) != null ) {
				//Envia texto al hijo
				escritorHijo.write(linea);
				escritorHijo.newLine();
				escritorHijo.flush();
				
				//Leer respuesta del hijo
				String respuesta = lectorHijo.readLine();
				if (respuesta != null) {
					System.out.println("Hijo: "+ respuesta);
				} else {
					break;
				} 
			}
			
			
			escritorHijo.close();
			procesoHijo.waitFor();
			System.out.println("Proceso hijo finalizado");
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}
}
