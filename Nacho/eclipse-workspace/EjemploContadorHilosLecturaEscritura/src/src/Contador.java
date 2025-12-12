package src;

public class Contador {
	private int actual;
	private boolean bool;
	
	public Contador(int inicial) {
		this.actual = inicial;
	}

	public synchronized void inc() throws InterruptedException {
		while(bool) {
			wait();
		}
		this.actual++;
		bool=true;
		notify();
		System.out.println("Hola, soy Sumador, mi contador vale " + this.valor());
	}

	public synchronized void dec() throws InterruptedException {
		while(!bool) {
			wait();
		}
		this.actual--;
		bool = false;
		notify();
		System.out.println("Hola, soy Restador, mi contador vale " + this.valor());
	}

	public synchronized int valor() {
		return this.actual;
	}
}
