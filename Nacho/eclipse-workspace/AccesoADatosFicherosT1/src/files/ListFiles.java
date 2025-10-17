package files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListFiles {

	public static void main(String[] args) {
		Path path=Path.of("ficheros");
		listar(path);
	}

	private static void listar(Path path) {
		//ETL Extraccion, Transformacion y Carga (ETL), q
		try {
			Stream<Path> stream=Files.list(path);
			ArrayList<Path> lista=(ArrayList<Path>) stream.collect(Collectors.toList());
			//1º forma
			System.out.println("1º Forma");
			for (int i = 0; i < lista.size(); i++) {
				System.out.println(lista.get(i));
			}
			//2º forma
			System.out.println("2º Forma");
			for (Path item:lista) {
				System.out.println(item);
			}
			//3º forma
			System.out.println("3º Forma");
			lista.forEach(item->{
				if(item.toFile().isDirectory()) {
					listar(Path.of(item.toString()));
					//Si es un directorio, llamo a este mismo metodo de listar 
					// pero le paso el path de este directorio, para que imprima sus ficheros
				}
				else {
					System.out.println(item.toString());
				}
			});
		} catch (IOException e) {
			System.err.println("No se ha podido recuperar"+
		"la lista del path: "+ path.toString());
			System.err.println(e.getMessage());
			System.exit(-1);
		}
	
	}

}
