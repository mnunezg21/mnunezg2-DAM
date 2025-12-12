package src;

public class Productor extends Thread {
	private ClaseCompartida objetoCompartido;

	Productor(ClaseCompartida objetoCompartido) {
		this.objetoCompartido = objetoCompartido;
	}

	@Override
	public void run() {
		try {
			objetoCompartido.accionDeProducir();
			Thread.sleep((long) (Math.random() * 1000 + 1000));
		} catch (InterruptedException ex) {
			ex.getMessage();
		}
	}
}
