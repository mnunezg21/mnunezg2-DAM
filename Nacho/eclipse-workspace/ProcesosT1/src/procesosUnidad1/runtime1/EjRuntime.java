package procesosUnidad1.runtime1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class EjRuntime {

	public static void main(String[] args) {
		ejVariablesEntornos();
		System.out.println("---------------------");
		ejDir();
		System.out.println("---------------------");
		ejNotapad();
		System.out.println("---------------------");
		ejNotapad2();
		System.out.println("---------------------");
		ejPing();
		System.out.println("---------------------");
		ejEstMemory();
		System.out.println("---------------------");
		ejEstMemory2();
		System.out.println("---------------------");
		 
	}

	private static void ejEstMemory2() {
		System.out.println("Estado de la memoria");
		Runtime r=Runtime.getRuntime();
		System.out.println("Procesadores : "+r.availableProcessors());
		//Cantidad máxima de memoria que usará JVM
		System.out.println("Memoria maxima de JVM: "+r.maxMemory());
		//Cantidad total de memoria que usará JVM
		System.out.println("Memoria total de JVM: "+r.totalMemory());
		//Cantidad libre de memoria que usará JVM
		System.out.println("Memoria libre de JVM: "+r.freeMemory());
		//Llamamos al recolector de basura
		System.out.println("Recolector de basura de JVM");
		r.gc();
		System.out.println("Eliminando basura...");
		//Cantidad máxima de memoria que usará JVM
		System.out.println("Memoria maxima de JVM: "+r.maxMemory());
		//Cantidad total de memoria que usará JVM
		System.out.println("Memoria total de JVM: "+r.totalMemory());
		//Cantidad libre de memoria que usará JVM
		System.out.println("Memoria libre de JVM: "+r.freeMemory());
	}

	private static void ejEstMemory() {
		Runtime r=Runtime.getRuntime();
		String programa = "CMD /C systeminfo";
		
		try {
			Process p= r.exec(programa);
			InputStream is=p.getInputStream();
			InputStreamReader isr=new InputStreamReader(is);
			BufferedReader br=new BufferedReader(isr);
			String linea;
			
			while((linea=br.readLine())!=null)
			{
				System.out.println(linea);
			}
			//CIERRE FLUJOS 
			br.close();
			isr.close();
			is.close();
			
		} catch (IOException e) {
			System.err.println("No existe el programa");
			System.err.println(e.getMessage());
			System.exit(-6);
		}
	}

	private static void ejPing() {
		Runtime r=Runtime.getRuntime();
		String programa = "ping -n 1 192.168.1.1";
		
		try {
			Process p= r.exec(programa);
			InputStream is=p.getInputStream();
			InputStreamReader isr=new InputStreamReader(is);
			BufferedReader br=new BufferedReader(isr);
			String linea;
			
			while((linea=br.readLine())!=null)
			{
				System.out.println(linea);
			}
			//CIERRE FLUJOS 
			br.close();
			isr.close();
			is.close();
			
		} catch (IOException e) {
			System.err.println("No existe el programa");
			System.err.println(e.getMessage());
			System.exit(-6);
		}
		
	}

	private static void ejNotapad2() {
		Runtime r=Runtime.getRuntime();
		String programa="NOTEPAD";
		try {
			System.out.println("Esta linea antes de lanzar a mi hijo");
			Process p=r.exec(programa);
			p.waitFor();
			System.out.println("Esta linea despues de cerrar ejecutar, mi hijo ha terminado");
			
		} catch (Exception e) {
			System.err.println("No existe el programa");
			System.err.println(e.getMessage());
			System.exit(-5);
		}
	}

	private static void ejNotapad() {
		Runtime r=Runtime.getRuntime();
		String programa="NOTEPAD";
		try {
			System.out.println("Antes de ejecutar");
			Process p=r.exec(programa);
			System.out.println("Despues de ejecutar");
			
		} catch (IOException e) {
			System.err.println("No existe el programa");
			System.err.println(e.getMessage());
			System.exit(-4);
		}
		
	}

	private static void ejDir() {
		Runtime r=Runtime.getRuntime();
		String programa="CMD /C dir";
		try {
			Process p= r.exec(programa);
			InputStream is=p.getInputStream();
			InputStreamReader isr=new InputStreamReader(is);
			BufferedReader br=new BufferedReader(isr);
			String linea;
			
			while((linea=br.readLine())!=null)
				{
					System.out.println(linea);
				}
				//CIERRE FLUJOS 
				br.close();
				isr.close();
				is.close();
				
				
				int valor = 0;
				valor=p.waitFor();
				System.out.println("Valor de salida del proceso: "+valor);
		} catch (IOException e) {
			System.err.println("No existe el programa");
			System.err.println(e.getMessage());
			System.exit(-2);
		} catch (InterruptedException e) {
			System.err.println("No existe el programa");
			System.err.println(e.getMessage());
			System.exit(-2);
		}
	}

	private static void ejVariablesEntornos() {
		Runtime r=Runtime.getRuntime();
		String programa = "CMD /C set";
		
		try {
			Process p= r.exec(programa);
			InputStream is=p.getInputStream();
			InputStreamReader isr=new InputStreamReader(is);
			BufferedReader br=new BufferedReader(isr);
			String linea;
			
			while((linea=br.readLine())!=null)
			{
				System.out.println(linea);
			}
			//CIERRE FLUJOS 
			br.close();
			isr.close();
			is.close();
			
		} catch (IOException e) {
			System.err.println("No existe el programa");
			System.err.println(e.getMessage());
			System.exit(-1);
		}
		
	}

}
