package ejemplosRama;

import java.util.Random;



public class HijoAleatorios_0_10 {
	public static void main(String[] args) {
		Random rand= new Random();
		
		int random = rand.nextInt(11);
		System.out.println(random);
		System.out.flush();
	}

}
