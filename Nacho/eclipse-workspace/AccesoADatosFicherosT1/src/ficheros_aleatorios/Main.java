package ficheros_aleatorios;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Main {

	public static void main(String[] args) {
		File file = new File("ficheros/aleatorios.txt");
		// Random
		RandomAccessFile randomAccessFile = null;
		try {
			randomAccessFile = new RandomAccessFile(file,"rw");
		} catch (FileNotFoundException e) {
			System.err.println("Error al crear RandomAccessFile en el fichero"+file.getName());
			System.err.println(e.getMessage());
			System.exit(-1);
		}
		escribir(randomAccessFile, "Hola Mundo en fichero aleatorios!!!");
		pointer(randomAccessFile);//imprime posicion
		seek(randomAccessFile,3);//se posiciona
		pointer(randomAccessFile);//imprime posicion
		seek(randomAccessFile,0);//se posiciona
		pointer(randomAccessFile);//imprime posicion		
		leer(randomAccessFile);//lee el fichero
		pointer(randomAccessFile);//imprime posicion
		seek(randomAccessFile,6);//se posiciona
		pointer(randomAccessFile);//imprime posicion	
		escribir(randomAccessFile, "12*4");
		pointer(randomAccessFile);//imprime posicion	
		seek(randomAccessFile,0);//se posiciona
		pointer(randomAccessFile);//imprime posicion
		leer(randomAccessFile);//lee el fichero

	}

	private static void leer(RandomAccessFile randomAccessFile) {
		String leida;
		
		try {
			while((leida=randomAccessFile.readLine())!=null) {
				System.out.println(leida);
			}
		} catch (IOException e) {
			System.err.println("Error al leer con RandomAccessFile");
			System.err.println(e.getMessage());
			System.exit(-5);
		}	
		
	}

	private static void seek(RandomAccessFile randomAccessFile, int pos) {
		
		try {
			randomAccessFile.seek(pos);
		} catch (IOException e) {
			System.err.println("Error al posicionarse RandomAccessFile");
			System.err.println(e.getMessage());
			System.exit(-4);
		}	
	}

	private static void pointer(RandomAccessFile randomAccessFile) {
		//Imprime donde esta el puntero en este momento
		try {
			System.out.println("Posicion :"+randomAccessFile.getFilePointer());
		} catch (IOException e) {
			System.err.println("Error al posicionar el puntero RandomAccessFile");
			System.err.println(e.getMessage());
			System.exit(-3);
		}
		
	}

	private static void escribir(RandomAccessFile randomAccessFile, String texto) {
		
		System.out.println("Escribiendo en el fichero...");
		
		try {
			randomAccessFile.writeBytes(texto);
		} catch (IOException e) {
			System.err.println("Error al escribir en el fichero con RandomAccessFile");
			System.err.println(e.getMessage());
			System.exit(-2);
		}
		
	}

}
