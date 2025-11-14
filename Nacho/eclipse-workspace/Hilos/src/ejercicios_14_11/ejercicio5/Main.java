package ejercicios_14_11.ejercicio5;

public class Main {

	public static void main(String[] args) {
		int[] notas1 = {2,3,4,5,7,5,9,7,6};
		int[] notas2 = {10,5,3,7,8,4,5,7,9};
		
		Thread t1 = new Thread(new HiloMedia(notas1,2,8));
		Thread t2 = new Thread(new HiloMedia(notas2,4,12));
		
		t1.start();
		t2.start();
	}
	
}
