package ejerciciosPdfProcesosVsHilos.ejercicio2;

public class Main {
	public static void main(String[]args) {
		Hilo1 par = new Hilo1();
		Hilo2 impar = new Hilo2();
		
		par.setPriority(Hilo1.MAX_PRIORITY);
		impar.setPriority(Hilo2.MIN_PRIORITY);
		
		par.start();
		impar.start(); 
	} 
}
