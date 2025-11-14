package ejercicios_14_11.ejercicio5;

public class HiloMedia implements Runnable{
	private int[] notas;
	private int suma;
	private float media;
	private int posicion;
	private int limite;	
	
	public HiloMedia(int[] notas, int posicion, int limite) {
		this.notas = notas;
		this.posicion = posicion;
		this.limite = limite;
	}

	public void run() {
		for (int i = this.posicion; i <= this.limite; i++) {			
			suma+=this.notas[posicion];
		}
		this.media = this.suma/(this.limite-this.posicion);
		System.out.println("La media de las notas es: " + this.media);
	}

	public float getMedia() {
		return media;
	}	
}
