package ejemplosRama;

import java.io.IOException;
import java.util.Arrays;

public class Actividad1_10 {
	public static void main(String[] args) throws IOException, InterruptedException {
		try {
			Process process = new ProcessBuilder(args).start();
			int retorno = process.waitFor();
			//el padre se queda esperando a que el hijo termine su ejecucion, y le devuelve el 
			//Estado de la ejecucion, por norma un 0 es exito de ejecucion
			System.out.println("Comando " + Arrays.toString(args) + " devolvió: " + retorno);
		} catch (IOException e) {
			System.out.println("Error ocurrió ejecutando el comando. Descripción: " + e.getMessage());
		} catch (InterruptedException e) {
			System.out.println("El comando fue interrumpido. Descripción del error: " + e.getMessage());
		}
	}
}