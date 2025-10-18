package rama.ejercicio3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HijoMayusculas {

	public static void main(String[] args) {
		String line;
		
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			while((line = br.readLine()) != null) {
				System.out.println(line.toUpperCase());
				System.out.flush();
			} 
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

}
