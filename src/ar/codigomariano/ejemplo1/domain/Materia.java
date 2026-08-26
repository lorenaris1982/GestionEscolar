package ar.codigomariano.ejemplo1.domain;

public class Materia {

    private String codigo;
    private String nombre;
    private Profesor profesor;

    public Materia(String codigo, String nombre, Profesor profesor) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.profesor = profesor;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void mostrarInformacion() {
        System.out.println("Código: " + codigo);
        System.out.println("Materia: " + nombre);
        System.out.println("Profesor: " + profesor.getNombre());
    }
}
