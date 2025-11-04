package ejemplo1.modelo;

public class Alumno {
	private int id;
	private String nombre;
	private String apellido;
	private String email;
	private String curso;
	
	public Alumno(String nombre, String apellido, String email, String curso) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.curso = curso;
	}

	public Alumno(int id, String nombre, String apellido, String email, String curso) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.curso = curso;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}
}
