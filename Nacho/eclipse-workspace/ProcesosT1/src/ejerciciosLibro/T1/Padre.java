package ejerciciosLibro.T1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Padre {

    public static void main(String[] args) {
        Process procesoHijo = null;
        BufferedReader lectorHijo = null;
        BufferedWriter escritorHijo = null;
        Scanner scanner = null;
        
        try {
            ProcessBuilder pb = new ProcessBuilder("java", "GeneradorAleatorios");
            pb.redirectErrorStream(true); // Redirige stderr a stdout
            
            System.out.println("Iniciando proceso Hijo");
            procesoHijo = pb.start();
            
            lectorHijo = new BufferedReader(new InputStreamReader(procesoHijo.getInputStream()));
            escritorHijo = new BufferedWriter(new OutputStreamWriter(procesoHijo.getOutputStream()));
            scanner = new Scanner(System.in);
            
            // ⚠️ PROBLEMA: Esta línea lee el mensaje "Hijo: Proceso iniciado y listo"
            // y lo consume, por eso el primer número no se muestra correctamente
            // String mensajeInicial = lectorHijo.readLine();
            // System.out.println("Hijo: " + mensajeInicial);
            
            // ✅ SOLUCIÓN: En lugar de eso, simplemente esperamos que el hijo esté listo
            // o mostramos un mensaje sin leer del stream
            System.out.println("Proceso hijo iniciado correctamente");
            
            System.out.println("Escribe lineas o 'fin' para terminar el programa");
            
            String lineaUsuario;
            while(true) {
                System.out.print("Entrada: ");
                lineaUsuario = scanner.nextLine();
                
                if ("fin".equalsIgnoreCase(lineaUsuario.trim())) {
                    escritorHijo.write("fin");
                    escritorHijo.newLine();
                    escritorHijo.flush();
                    break;
                }
                
                // Enviar comando para generar número
                escritorHijo.write("generar");
                escritorHijo.newLine();
                escritorHijo.flush();
                
                // Leer respuesta del hijo (el número aleatorio)
                String numero = lectorHijo.readLine();
                if (numero != null) {
                    System.out.println(numero); // ⚠️ SOLO imprime el número, sin texto adicional
                } else {
                    System.out.println("El hijo ha terminado inesperadamente");
                    break;
                }
            }
            
        } catch(IOException e) {
            System.err.println("Error de entrada y salida: " + e.getMessage());
            e.printStackTrace();
            
        } finally {
            // Limpieza
            try {
                if (escritorHijo != null) escritorHijo.close();
                if (lectorHijo != null) lectorHijo.close();
                if (scanner != null) scanner.close();
                
                if (procesoHijo != null && procesoHijo.isAlive()) {
                    int exitCode = procesoHijo.waitFor();
                    System.out.println("Proceso hijo terminado con código: " + exitCode);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("Programa terminado.");
        }
    }
}