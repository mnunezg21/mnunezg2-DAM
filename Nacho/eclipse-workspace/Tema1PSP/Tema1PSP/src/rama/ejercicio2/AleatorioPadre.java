package rama.ejercicio2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class AleatorioPadre {
	public static void main(String[] args) throws IOException {
		String line;
		Process process;
		BufferedReader br, in;
		PrintStream ps;
		
		if (args.length <= 0) {
			System.err.println("Se necesita un programa a ejecutar");
			System.exit(-1);
		}
		
		System.out.println("Lanzando el proceso hijo:");
		process = new ProcessBuilder("java", "-jar", "aleatorioHijo.jar").start();
		br = new BufferedReader(new InputStreamReader(process.getInputStream()));
		ps = new PrintStream(process.getOutputStream());
		in = new BufferedReader(new InputStreamReader(System.in));
		
		while ((in.readLine().compareTo("fin")) != 0) {
			ps.println("");
			ps.flush();
			
			if ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		}
		
		System.out.println("Fin del porceso");
	}
}
