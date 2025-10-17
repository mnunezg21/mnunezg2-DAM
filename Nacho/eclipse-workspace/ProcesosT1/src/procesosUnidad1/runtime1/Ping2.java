package procesosUnidad1.runtime1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;

public class Ping2 {
	Ping2(){}
	
	public static void main(String[] args) throws IOException{
		Runtime r=Runtime.getRuntime();
		for (int i = 0; i < 254; i++) {
			String ip="ping -n 1 192.168.60."+i;
			System.out.println("La maquina : "+ip);
			
			Process p=r.exec(ip);
			BufferedReader br= new BufferedReader(
					new InputStreamReader(p.getInputStream()));
			String texto;
			while((texto=br.readLine())!=null) {
				System.out.println(texto);
			}
		}
		
	}

}
