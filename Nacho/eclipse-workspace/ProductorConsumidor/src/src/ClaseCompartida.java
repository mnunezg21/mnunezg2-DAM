package src;

public class ClaseCompartida {

	int valorAccedidoSimultaneamente;

	ClaseCompartida() {
		this.valorAccedidoSimultaneamente = 0;
	}

	public synchronized void accionDeConsumir() {
		while (valorAccedidoSimultaneamente == 0) {
			try {
				System.out.println("Consumidor espera...");
				wait();
			} catch (InterruptedException ex) {
			}
		}
		valorAccedidoSimultaneamente--;
		System.out.printf("Se ha consumido: %d.\n", valorAccedidoSimultaneamente);
		notifyAll();
	}

	public synchronized void accionDeProducir() {
		while (valorAccedidoSimultaneamente > 10) {
			try {
				System.out.println("Productor espera...");
				wait();
			} catch (InterruptedException ex) {
				ex.getMessage();
			}
		}
		valorAccedidoSimultaneamente++;
		System.out.printf("Se ha producido: %d.\n", valorAccedidoSimultaneamente);
		notifyAll();
	}

}
