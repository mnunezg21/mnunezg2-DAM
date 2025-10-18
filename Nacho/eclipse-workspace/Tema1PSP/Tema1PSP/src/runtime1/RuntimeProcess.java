package runtime1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RuntimeProcess {

	public static void main(String[] args) {
		variablesEntorno();
		System.out.println("-----------------------");
		dir();
		System.out.println("-----------------------");
		//abrirNotepad();
		System.out.println("-----------------------");
		//abrirNotepad2();
		System.out.println("-----------------------");
		ping();
		System.out.println("-----------------------");
		estadoMemoria();
	}

	private static void estadoMemoria() {
		Runtime runtime = Runtime.getRuntime();
		String program = "wmic MemoryChip get Capacity, Speed, Manufacturer";
		
		System.out.println("Procesadores: " + runtime.availableProcessors());
		System.out.println("Memoria máxima JVM: " + runtime.maxMemory());
		System.out.println("Memoria usada JVM: " + runtime.totalMemory());
		System.out.println("Memoria libre JVM: " + runtime.freeMemory());
		
		System.out.println("Limpiando basura...");
		runtime.gc();
		
		System.out.println("Memoria máxima JVM: " + runtime.maxMemory());
		System.out.println("Memoria usada JVM: " + runtime.totalMemory());
		System.out.println("Memoria libre JVM: " + runtime.freeMemory());
		
	}

	private static void ping() {
		Runtime runtime = Runtime.getRuntime();
		String program = "ping -n 1 192.168.1.1";
		
		try {
			Process process = runtime.exec(program);
			InputStream inputStream = process.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			String linea;
			
			while ((linea = bufferedReader.readLine()) != null) {
				System.out.println(linea);
			}
			
			bufferedReader.close();
			inputStreamReader.close();
			inputStream.close();
		} catch (IOException e) {
			System.err.println("No existe el programa " + program);
			System.exit(-1);
		}
	}

	private static void abrirNotepad2() {
		Runtime runtime = Runtime.getRuntime();
		String program = "NOTEPAD";
		
		try {
			System.out.println("Antes de ejecutar");
			Process process = runtime.exec(program);
			process.waitFor();
			System.out.println("Despues de cerrar");
		} catch (IOException e) {
			System.err.println("No existe el programa " + program);
			System.exit(-1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void abrirNotepad() {
		Runtime runtime = Runtime.getRuntime();
		String program = "NOTEPAD";
		
		try {
			System.out.println("Antes de ejecutar");
			Process process = runtime.exec(program);
			System.out.println("Despues de ejecutar");
		} catch (IOException e) {
			System.err.println("No existe el programa " + program);
			System.exit(-1);
		}
	}

	private static void dir() {
		Runtime runtime = Runtime.getRuntime();
		String program = "CMD /C dir";
		
		try {
			Process process = runtime.exec(program);
			InputStream inputStream = process.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			String linea;
			
			while ((linea = bufferedReader.readLine()) != null) {
				System.out.println(linea);
			}
			
			bufferedReader.close();
			inputStreamReader.close();
			inputStream.close();
			
			int valor = 0;
			valor = process.waitFor();
			System.out.println("Valor de salida del porceso: " + valor);
		} catch (IOException e) {
			System.err.println("No existe el programa " + program);
			System.exit(-1);
		} catch (InterruptedException e) {
			System.err.println("Error en la espera del proceso");
		}
	}

	private static void variablesEntorno() {
		Runtime runtime = Runtime.getRuntime();
		String program = "CMD /C set";
		
		try {
			Process process = runtime.exec(program);
			InputStream inputStream = process.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			String linea;
			
			while ((linea = bufferedReader.readLine()) != null) {
				System.out.println(linea);
			}
			
			bufferedReader.close();
			inputStreamReader.close();
			inputStream.close();
		} catch (IOException e) {
			System.err.println("No existe el programa " + program);
			System.exit(-1);
		}
	}

}
