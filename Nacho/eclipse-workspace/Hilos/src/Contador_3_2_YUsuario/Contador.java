package Contador_3_2_YUsuario;

public class Contador {
	private int actual;
	public Contador(int inicial)
	{
	actual = inicial;
	}
	public synchronized void inc() { actual++; }
	public synchronized void dec() { actual--; }
	public synchronized int valor() { return actual;}
}
