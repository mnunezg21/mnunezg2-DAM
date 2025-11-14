package ejercicios_14_11.ejercicio1;

public class HiloNumerosLetras implements Runnable{
	
	private int tipo=0;
	
	public HiloNumerosLetras(int tipo) {
		this.tipo = tipo;
	}
	
	public void run() {
		if(this.tipo==1) {
			for (int i = 0; i < 30; i++) {
				System.out.println(this.toString()+", Numero: "+i);
			}
		} else if (this.tipo==2) {
			for (char c ='a' ; c <= 'z'; c++) {
				System.out.println(this.toString()+", Letra: "+c);
			}
		}
	}
	
}
