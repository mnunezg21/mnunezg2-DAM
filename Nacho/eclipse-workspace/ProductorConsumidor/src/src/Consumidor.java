package src;

public class Consumidor extends Thread {
	private ClaseCompartida objetoCompartido;

	Consumidor(ClaseCompartida objetoCompartido) {
		this.objetoCompartido = objetoCompartido;
	}

	@Override
	public void run() {
		try {
			objetoCompartido.accionDeConsumir();
			Thread.sleep((long) (Math.random() * 1000 + 1000));
		} catch (InterruptedException ex) {
			ex.getMessage();
		}
	}
}
