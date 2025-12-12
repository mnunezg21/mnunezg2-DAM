package src;

public class Restador extends Thread{
	private Contador c;
	
	public Restador(String name, Contador c) {
		super(name);
		this.c = c;
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				c.dec();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}	
	}
}
