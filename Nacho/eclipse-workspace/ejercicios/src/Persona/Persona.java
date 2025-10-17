package Persona;

import java.io.Serializable;

//9 Crea una nueva clase llamada Persona con los atributos (id,nombre,edad, dni).
public class Persona implements Serializable{
	 private int id;
	 private String nombre;
	 private int edad;
	 private String dni;
	 
	 public Persona() {}
	 
	 public Persona(int id, String nombre, int edad, String dni) {
		 this.id=id;
		 this.nombre=nombre;
		 this.edad=edad;
		 this.dni=dni;
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

	 public int getEdad() {
		 return edad;
	 }

	 public void setEdad(int edad) {
		 this.edad = edad;
	 }

	 public String getDni() {
		 return dni;
	 }

	 public void setDni(String dni) {
		 this.dni = dni;
	 }

	 @Override
	 public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", edad=" + edad + ", dni=" + dni + "]";
	 }
	 
}
