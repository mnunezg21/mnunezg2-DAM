package rama;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ejecuta {

	public static void main(String[] args) throws IOException {
		String line;
		Runtime runtime;
		Process process;
		BufferedReader br;
		
		if (args.length <= 0) {
			System.err.println("Se necesita un programa a ejecutar");
			System.exit(-1);
		}
		
		runtime = Runtime.getRuntime();
		process = runtime.exec(args);
		br = new BufferedReader(new InputStreamReader(process.getErrorStream()));
		
		System.out.println("Errores de ejecución del proceso hijo " + Arrays.toString(args));
		while ((line = br.readLine()) != null) {
			System.out.println(line);
		}
	}

}
