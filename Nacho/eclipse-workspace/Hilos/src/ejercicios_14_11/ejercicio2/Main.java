package ejercicios_14_11.ejercicio2;

public class Main {

	public static void main(String[] args) {

        Thread t1 = new Thread(new Contador(1, 10, "Hilo A"));
        Thread t2 = new Thread(new Contador(5, 15, "Hilo B"));
        Thread t3 = new Thread(new Contador(10, 20, "Hilo C"));

        t1.start();
        t2.start();
        t3.start();
	}

}
