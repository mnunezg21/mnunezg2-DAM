package runtime1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ping2 {

	Ping2(){}
	
	public static void main(String[] args) throws IOException {
		Runtime r = Runtime.getRuntime();
		BufferedReader br;
		Process p;
		String texto;
		String ip;
		
		for (int i = 0; i < 254; i++) {
			ip = "ping -n 1 192.168.60." + i;
			System.out.println("La máquina: " + ip);
			p = r.exec(ip);
			br = new BufferedReader(new InputStreamReader(p.getInputStream()));
			
			while ((texto = br.readLine()) != null) {
				System.out.println(texto);
			}
		}
	}

}
