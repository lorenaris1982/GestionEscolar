package ar.codigomariano.ejemplo1.domain;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "alumno")
public class Alumno extends Usuario {
	
	private String numeroLegajo;
	private String curso;
	private String division;
	private String turno;
	private String contrasena;
	
	protected Alumno() {
	}
	
	public Alumno(
	        String nombre,
	        String apellido,
	        String dni,
	        String numeroLegajo,
	        String curso,
	        String division,
	        String turno) {

	    super(nombre, apellido, dni);

	    this.numeroLegajo = numeroLegajo;
	    this.curso = curso;
	    this.division = division;
	    this.turno = turno;
	}
	
	public String getNumeroLegajo() {
	    return numeroLegajo;
	}
	
	public String getCurso() {
	    return curso;
	}
	
	public String getDivision() {
	    return division;
	}
	
	public String getTurno() {
	    return turno;
	}
	
	public String getContrasena() {
	    return contrasena;
	}
	
	
	public void setContrasena(String contrasena) {
	    this.contrasena = contrasena;
	}
	
	
	public void mostrarDatosAcademicos() {
	    System.out.println("Legajo: " + numeroLegajo);
	    System.out.println("Curso: " + curso);
	    System.out.println("División: " + division);
	    System.out.println("Turno: " + turno);
	}
	
	public void mostrarRol(){
		System.out.println("Rol : Alumno");
		
	}

	}
	
