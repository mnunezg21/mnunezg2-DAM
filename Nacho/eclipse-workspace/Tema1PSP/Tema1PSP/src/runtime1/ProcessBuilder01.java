package runtime1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ProcessBuilder01 {

    public static void main(String[] args) {
        String comando = "ping";
        String ip = "127.0.0.1";
        String linea;
        
        try {
            //ProcessBuilder pb = new ProcessBuilder("ping","192.168.60.5");
            ProcessBuilder pb = new ProcessBuilder(comando, ip);
            Process p = pb.start();

            InputStream is = p.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }

            br.close();
            isr.close();
            is.close();

            System.out.println("Después");
        } catch (IOException ex) {
            System.err.println("No existe el " + comando + " " + ip);
        }

    }
}