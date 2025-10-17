package procesosUnidad1.runtime1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ping {
	Ping(){
		
	}
	public static void main(String[] args) throws IOException{
		
		Runtime r=Runtime.getRuntime();
		Process p=r.exec("ping 8.8.8.8");
		BufferedReader bR=new BufferedReader(
				new InputStreamReader(p.getInputStream()));
		
		String texto;
		while((texto=bR.readLine())!=null) {
			System.out.println(texto);
		}
	}

}
