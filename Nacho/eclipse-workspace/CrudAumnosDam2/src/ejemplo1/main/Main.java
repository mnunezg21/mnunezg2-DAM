package ejemplo1.main;

import ejemplo1.dao.AlumnoDAO;
import ejemplo1.modelo.Alumno;

public class Main {

	public static void main(String[] args) {
		AlumnoDAO dao= new AlumnoDAO();

		//1-Create
		System.out.println("1. ----CREANDO ALUMNO ----");
		Alumno nuevoAlumno = new Alumno("Marta","Reyes","marta_reyes@email.com","2DAM");
		
		if(dao.insertarAlumno(nuevoAlumno)) {
			System.out.println("Alumno creado correctamente");
		} 
		
		//2-Read
		System.out.println("2. ----LEER ALUMNOS ----");
		dao.obtenerTodosAlumnos().forEach(a ->
		System.out.println(a.toString()));
	}

}
