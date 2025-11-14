package ejercicios_14_11.ejercicio1;

public class Main {

	public static void main(String[] args) {
		Thread tipo1 = new Thread(new HiloNumerosLetras(1));
		Thread tipo2 = new Thread(new HiloNumerosLetras(2));

		tipo1.start();
		tipo2.start();
	}
}