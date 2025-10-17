package sol4;

import java.util.ArrayList;
import java.util.List;

public class Alumno {
	private String nombre;
	private List<Asignatura> asignaturas;
	
	public Alumno() {}
	public Alumno(String nombre, Asignatura...asignaturas) {
		this.nombre=nombre;
		this.asignaturas=new ArrayList<>();
		for(int i =0;i<asignaturas.length;i++) {
			this.asignaturas.add(asignaturas[i]);
		}
	}
}
