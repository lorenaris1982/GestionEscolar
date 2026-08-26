package ar.codigomariano.ejemplo1.domain;

public class Alumno extends Usuario {
	
	private String numeroLegajo;
	private String curso;
	private String division;
	private String turno;
	
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
	
