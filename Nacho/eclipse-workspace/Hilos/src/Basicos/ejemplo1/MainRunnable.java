package Basicos.ejemplo1;

public class MainRunnable {
	public static void main(String[] args) {
		TareaRunable tarea1 = new TareaRunable();
		TareaRunable tarea2 = new TareaRunable();
		
		Thread t1 = new Thread(tarea1);
		Thread t2 = new Thread(tarea2);
		
		t1.setPriority(Thread.MAX_PRIORITY);
		t2.setPriority(Thread.MIN_PRIORITY);
		
		t1.start();
		t2.start();
	}
}