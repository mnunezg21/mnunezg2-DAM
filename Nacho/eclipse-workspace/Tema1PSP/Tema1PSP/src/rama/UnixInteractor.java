package rama;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class UnixInteractor {

	public static void main(String[] command) {
		ProcessBuilder pb = new ProcessBuilder(command);
		Process shell;
		InputStream is;
		BufferedReader br;
		String line;
		
		
		
		
		try {
			shell = pb.start();
			is = shell.getInputStream();
			br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			System.out.printf("La ");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
