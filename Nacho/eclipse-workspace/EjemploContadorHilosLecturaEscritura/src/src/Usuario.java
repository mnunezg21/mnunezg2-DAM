package src;

public class Usuario extends Thread{
	private Contador cnt;
	
	public Usuario(String nombre, Contador cnt) {
		super(nombre); this.cnt = cnt;
	}
	
	public void run() {
		for (int i = 0; i < 1000; i++) {
		cnt.inc();
		System.out.println("Hola, soy " + this.getName() + ", mi contador vale " + cnt.valor());
		}
	}
}
