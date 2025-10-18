package rama;

import java.io.IOException;
import java.util.Arrays;

public class Ejemplo1_6 {

	public static void main(String[] args) throws IOException {
		ProcessBuilder pb;
		Process process;
		int retorno;
		
		if(args.length <= 0) {
			System.err.println("Se necesita un programa a ejecutar");
		}
		
		pb = new ProcessBuilder(args);
		
		try {
			process = pb.start();
			retorno = process.waitFor();
			System.out.printf("La ejecución de %s devuelve %d\n", Arrays.toString(args), retorno);
		} catch (IOException e) {
			e = new IOException("[ERROR]: Error de E/S");
			System.err.println(e.getMessage());
			System.exit(-1);
		} catch (InterruptedException e) {
			e = new InterruptedException("[ERROR]: El porceso hijo finalizó de forma incorrecta");
			System.err.println(e.getMessage());
			System.exit(-2);
		}
	}

}
