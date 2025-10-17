package sol2;

import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		String nombreAlumno="Monica Garcia";
		Asignatura[] asignaturas= {
			new Asignatura("Matematicas",6),
			new Asignatura("Lengua",7),
			new Asignatura("Ingles",4),
			new Asignatura("Informatica",6)
			};
		System.out.println("Nombre Alumno_:"+nombreAlumno);
		for (int i = 0; i < asignaturas.length; i++) {
			System.out.println("Nota de "+asignaturas[i].getNombre()+
			" : "+asignaturas[i].getNota());
		}
		//SOLUCION A
		System.out.println("//SOLUCION A//");
		double suma=0, cont=0;
		for (int i = 0; i < asignaturas.length; i++) {
			suma+=asignaturas[i].getNota();
			cont++;
		}
		System.out.println("La nota media del alumno "+nombreAlumno+" es "+suma/cont);
		//SOLUCION B
		System.out.println("//SOLUCION B//");
		System.out.println("La nota media del alumno "+nombreAlumno+" es "+media(asignaturas));
	}

	private static double media(Asignatura... asignaturas) {
		double suma=0;
		for (Asignatura asignatura : asignaturas) {
			suma+=asignatura.getNota();
		}
		return suma/asignaturas.length;
	}
}
