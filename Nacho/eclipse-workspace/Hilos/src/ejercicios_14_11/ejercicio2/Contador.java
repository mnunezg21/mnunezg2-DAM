package ejercicios_14_11.ejercicio2;

import java.util.Iterator;

public class Contador implements Runnable{

	private int contador;
	private int limiteContador;
	private String nombreHilo;
	
	public Contador(int contador, int limiteContador, String nombreHilo) {
		this.contador = contador;
		this.limiteContador = limiteContador;
		this.nombreHilo = nombreHilo;
	}

	public void run() {
		for (int i = contador; i < limiteContador; i++) {
			System.out.println("Nombre: "+nombreHilo+", Contador: "+i);
		}
		System.out.println("Nombre: "+nombreHilo+", ha terminado.");
	}
	
}
