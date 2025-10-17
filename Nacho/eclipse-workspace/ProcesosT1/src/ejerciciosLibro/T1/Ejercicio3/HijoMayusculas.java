package ejerciciosLibro.T1.Ejercicio3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HijoMayusculas {

	public static void main(String[] args) {
		try (BufferedReader reader =new BufferedReader(new InputStreamReader(System.in))){
			String linea;
			while((linea = reader.readLine()) != null) {
				System.out.println(linea.toUpperCase()); // Cambiar a mayuscula
				System.out.flush();
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
