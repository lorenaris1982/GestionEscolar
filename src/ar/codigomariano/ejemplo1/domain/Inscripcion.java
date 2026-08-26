package ar.codigomariano.ejemplo1.domain;

public class Inscripcion {

    private Alumno alumno;
    private Materia materia;

    public Inscripcion(Alumno alumno, Materia materia) {
        this.alumno = alumno;
        this.materia = materia;
    }

    public void mostrarInformacion() {
        System.out.println("=== INSCRIPCIÓN ===");
        System.out.println("Alumno: " + alumno.getNombre());
        System.out.println("Materia: " + materia.getNombre());
        System.out.println("Profesor: " + materia.getProfesor().getNombre());
    }
}

