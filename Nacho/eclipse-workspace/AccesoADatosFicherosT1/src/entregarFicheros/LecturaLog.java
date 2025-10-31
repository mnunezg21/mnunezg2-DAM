package entregarFicheros;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LecturaLog {

	public static void main(String[] args) {
		
		String configPath = "C:\\ventas\\config.txt";
		String incidenciasPath = "incidencias.log";
		
		try {
			createDirectoryAndFile(incidenciasPath);
			Map<String, String> config = leerConfiguracion(configPath);
			String logPath = config.get("fichlog");
			
			if(logPath==null) {
				System.err.println("No se encontro la ruta del log en el archivo de configuracion");
				return;
			}
			
			procesarLog(logPath,incidenciasPath);
			
		} catch (IOException e) {
			System.err.println("Error "+e.getMessage());
		}
	}
	
	private static void createDirectoryAndFile(String incidenciasPath) throws IOException{
		File ventasDirectory = new File("C:\\ventas");
		File configFile = new File("C:\\ventas\\config.txt");
		File logFile = new File("incidenciasPath");
		
		if(!ventasDirectory.exists()) ventasDirectory.mkdir();
		if(!configFile.exists()) configFile.createNewFile();
		if(!logFile.exists()) logFile.createNewFile();
		
	}

	private static void procesarLog(String logPath, String incidenciasPath) throws IOException {
		List<String> errores = new ArrayList<>();
		List<String> lineas = Files.readAllLines(Paths.get(logPath));
		
		for (int i = 0; i < lineas.size(); i++) {
			String linea = lineas.get(i).toLowerCase();
			if (linea.contains("error")) {
				errores.add("Linea "+(i+1)+": "+lineas.get(i));
			}
		}
		
		if(!errores.isEmpty()) {
			try (BufferedWriter writer = new BufferedWriter(new FileWriter(incidenciasPath, true))) {
                writer.write("=== Incidencias detectadas ===");
                writer.newLine();
                for (String error : errores) {
                    writer.write(error);
                    writer.newLine();
                }
                writer.write("=== Fin de incidencias ===");
                writer.newLine();
                writer.newLine();
            }
			System.out.println("Se encontraro "+errores.size()+" errores y se guardaron "+incidenciasPath);
		} else {
			System.out.println("No se encontaron errores en el archivo log");
		} 
	}

	private static Map<String, String> leerConfiguracion(String configPath) throws IOException {
        Map<String, String> config = new HashMap<>();
		List<String> lineas = Files.readAllLines(Paths.get(configPath));
        
		for(String linea : lineas) {
			String[] partes = linea.split(":");
			if (partes.length == 2) {
                config.put(partes[0].trim(), partes[1].trim());
            }
		}
		
        return config;
	}
}
