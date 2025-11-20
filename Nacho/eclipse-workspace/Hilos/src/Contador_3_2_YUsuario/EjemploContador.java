package Contador_3_2_YUsuario;

public class EjemploContador {
	final static int nHebras = 20;
	public static void main(String[] args) {
	// metodo principal
	final Contador cont1 = new Contador(10);
	Usuario hebra[] = new Usuario[nHebras];
	for (int i = 0; i < nHebras; i++) {
	//crea hebras
	hebra[i] = new Usuario("la hebra-" + i, cont1);
	// lanza hebras
	hebra[i].start(); }
	}
	
}
