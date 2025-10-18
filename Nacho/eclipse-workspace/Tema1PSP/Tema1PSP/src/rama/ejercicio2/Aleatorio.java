package rama.ejercicio2;

import java.util.Random;

public class Aleatorio {
	public static void main(String[] args) {
		Random rnd = new Random();
		int rndNumber = rnd.nextInt(11);
		
		System.out.println(rndNumber);
		System.out.flush();
	}
}
