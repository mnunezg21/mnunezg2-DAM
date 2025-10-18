package rama.ejercicio3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Mayusculas {

	public static void main(String[] args) {
		ProcessBuilder pb;
		Process process;
		
		BufferedWriter escritorHijo;
		BufferedReader lectorHijo;
		BufferedReader userInput;
		
		String line;
		String result;
		
		
		try {
			pb = new ProcessBuilder("java", "-jar", "HijoMayusculas.jar");
			pb.redirectErrorStream(true);
			process = pb.start();
			
			escritorHijo = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
			lectorHijo = new BufferedReader(new InputStreamReader(process.getInputStream()));
			userInput = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.print("Escribe texto (Ctrl + Z para salir): ");
			
			while ((line = userInput.readLine()) != null) {
				escritorHijo.write(line);
				escritorHijo.newLine();
				escritorHijo.flush();
				
				result = lectorHijo.readLine();
				
				if (result != null) System.out.println("Hijo: " + result);
				else break;
			}
			System.out.println();
			escritorHijo.close();
			process.waitFor();
			System.out.println("Porceso finalizado");
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
