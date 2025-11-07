package ejerciciosPdfProcesosVsHilos.ejercicio1;


public class MainThread {
	public static void main(String[] args) {
		Tarea tarea1 = new Tarea();
		Tarea tarea2 = new Tarea();
		Tarea tarea3 = new Tarea();
		
		tarea1.setName("A");
		tarea1.setName("B");
		tarea1.setName("C");
		
		tarea1.start();		
		tarea2.start();	
		tarea3.start();
	}
}
