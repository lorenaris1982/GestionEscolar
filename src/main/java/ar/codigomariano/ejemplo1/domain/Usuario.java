package ar.codigomariano.ejemplo1.domain;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Usuario {
	
	public static final String ESTADO_PENDIENTE = "PENDIENTE";
	public static final String ESTADO_ACTIVO = "ACTIVO";
	public static final String ESTADO_RECHAZADO = "RECHAZADO";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String estado;
    private String nombre;
    private String apellido;
    private  String dni;
    private String fechaNacimiento;
    private String mail;
    private String telefono;
    
    protected Usuario() {
    }
    public Usuario(String nombre, String apellido, String dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
      
        this.estado = ESTADO_PENDIENTE;
    }
    
    public void completarDatos(String fechaNacimiento, String mail, String telefono) {

    	this.fechaNacimiento= fechaNacimiento;
    	this.mail= mail;
    	this.telefono=telefono;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public String getApellido() {
        return apellido;
    }

    public String getDni() {
        return dni;
    }
    
    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido: " + apellido);
        System.out.println("DNI: " + dni);
        System.out.println("Fecha de Nacimiento " + fechaNacimiento);
        System.out.println("Mail " + mail);
        System.out.println("Telefono " + telefono);
        System.out.println("Estado "+ estado);
    }
    
    public abstract void mostrarRol();
    
    public Long getId() {
        return id;
    }
}



