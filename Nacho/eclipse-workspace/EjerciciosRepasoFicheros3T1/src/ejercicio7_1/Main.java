package ejercicio7_1;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Main {

    public static void main(String[] args) {
        File fichero = new File("AleatorioEmple.dat");
        
        try (RandomAccessFile file = new RandomAccessFile(fichero, "r")) {
            
            char[] apellido = new char[10];
            
            System.out.println("=== EMPLEADOS ===");
            
            while (file.getFilePointer() < file.length()) {
                int id = file.readInt();
                
                for (int i = 0; i < 10; i++) {
                    apellido[i] = file.readChar();
                }
                
                String apellidos = new String(apellido).trim();
                int dep = file.readInt();
                double salario = file.readDouble();
                
                System.out.printf("ID: %d, Apellido: %s, Departamento: %d, Salario: %.2f %n", 
                                 id, apellidos, dep, salario);
            }
            
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("Fin del programa");
    }
}
