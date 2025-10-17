package sol3;

import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		String nombre="Monica Garcia";
		List<Asignatura> asignaturas=Arrays.asList(
				new Asignatura("Matematicas",6),
				new Asignatura("Lengua",7),
				new Asignatura("Ingles",4),
				new Asignatura("Informatica",6));
		System.out.println("Nombre alumno "+nombre);
	//SOLUCION A
		System.out.println("//SOLUCION A");
		for (int i = 0; i < asignaturas.size(); i++) {
			System.out.println("Nota de "+asignaturas.get(i).getNombre()+": "+asignaturas.get(i).getNota());
		}
		System.out.println("Nota media de "+nombre+" es "+media(asignaturas));
		
	//SOLUCION B
		System.out.println("//SOLUCION B");
		for (int i = 0; i < asignaturas.size(); i++) {
			System.out.println("Nota de "+asignaturas.get(i).getNombre()+": "+asignaturas.get(i).getNota());
		}
		System.out.println("Nota media de "+nombre+" es "+media(asignaturas));
		
	//SOLUCION C
		System.out.println("//SOLUCION C");
		asignaturas.forEach(
				a-> System.out.println("Nota de "+a.getNombre()+" : "+a.getNota()));
		System.out.println("Nota media de "+nombre+" es "+media(asignaturas));
		
	//SOLUCION D
		System.out.println("//SOLUCION D");
		asignaturas.forEach(System.out::println);
		System.out.println("Nota media de "+nombre+" es "+media(asignaturas));
		
	//SOLUCION E, pero solo mostrando las asignaturas que empiezan por la M
		System.out.println("//SOLUCION E");
		asignaturas.stream()
			.filter(a->a.getNombre().startsWith("M"))
			.forEach(System.out::println);
		System.out.println("Nota media de "+nombre+" es "+media(asignaturas));
		
	}

	
	
	
	private static double media(List<Asignatura> asignaturas) {
		double suma=0;
		for(Asignatura asignatura : asignaturas) {
			suma+=asignatura.getNota();
		}
		return suma/asignaturas.size();
	}

}
