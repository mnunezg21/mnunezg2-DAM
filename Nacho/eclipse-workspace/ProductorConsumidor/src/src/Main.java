package src;

public class Main {

	public static void main(String[] args) {

		ClaseCompartida objetoCompartido = new ClaseCompartida();

		Productor productor = new Productor(objetoCompartido);
		Consumidor consumidor = new Consumidor(objetoCompartido);

		productor.start();
		consumidor.start();
		
		try {
			productor.join();
			consumidor.join();
		} catch (InterruptedException e) {
 			e.printStackTrace();
		}
	}
}
