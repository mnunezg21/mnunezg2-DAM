package src;

public class Sumador extends Thread{
	private Contador c; 

	public Sumador(String name, Contador c) {
		super(name);
		this.c = c;
	}
	
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				c.inc();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}	
	}
}
