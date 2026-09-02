package ar.codigomariano.ejemplo1.domain;

public class Profesor extends Usuario {

    private String especialidad;

    public Profesor(
            String nombre,
            String apellido,
            String dni,
            String especialidad) {

        super(nombre, apellido, dni);

        this.especialidad = especialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }
    
    public void mostrarRol(){
		System.out.println("Rol : Profesor");
		
	}
    
    
    
}
