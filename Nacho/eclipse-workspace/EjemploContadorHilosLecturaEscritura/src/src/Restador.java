package src;

public class Restador extends Thread{
	private Contador c;
	
	public Restador(String name, Contador c) {
		super(name);
		this.c = c;
	}

	public void run() {
		for (int i = 0; i < 1000; i++) {
			c.dec();
			System.out.println("Hola, soy " + this.getName() + ", mi contador vale " + c.valor());
			}	}
}
