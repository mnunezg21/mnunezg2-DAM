package Basicos.ejemplo1;

public class TareaRunable implements Runnable {
	@Override
	public void run() {
		for (int i = 0; i <= 800; i++) {
			System.out.println("Tarea: "+this.toString()+" - "+String.valueOf(i));
		}
	}
}
