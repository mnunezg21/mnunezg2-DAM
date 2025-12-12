package src;

public class EjemploContador {	
	public static void main(String[] args) {
		final Contador cont1 = new Contador(10);
		
		Restador restador = new Restador("restador", cont1);
		Sumador sumador = new Sumador("sumador", cont1);
		
		restador.start();
		sumador.start();
		
		try {
			restador.join();
			sumador.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}