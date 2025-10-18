package ejercicio7;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Main {

	public static void main(String[] args) {
		File fichero = new File("AleatorioEmple.dat");
		RandomAccessFile file;
		try {
			file = new RandomAccessFile(fichero,"rw");
			
			String apellido[] = {"FERNANDEZ","GIL","LOPEZ","RAMOS","SEVILLA","CASTILLA","REY"};
			
			int dep[] = {10, 20, 10, 10, 30, 30, 20};
			
			double salario[] = {1000, 45, 2400.60, 3000.0, 1500.56,
					2200.0, 1435.87, 2000.0};
			
			StringBuffer buffer = null;
			int n = apellido.length;
			
			for (int i = 0; i < n; i++) {
				file.writeInt(i+1);
				buffer = new StringBuffer(apellido[i]);
				buffer.setLength(10);
				file.writeChars(buffer.toString());
				file.writeInt(dep[i]);
				file.writeDouble(salario[i]);
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Fin del programa");
	}

}
