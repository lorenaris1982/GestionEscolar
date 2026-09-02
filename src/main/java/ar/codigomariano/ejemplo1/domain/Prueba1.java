package ar.codigomariano.ejemplo1.domain;

import java.util.Scanner;

public class Prueba1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
       

        String opcion = null;
        String subOpcion = null;
        
        String nombre = null;
        String apellido = null;
        String dni = null;

        do {

            System.out.println();
            System.out.println("===== SISTEMA DE GESTIÓN =====");
            System.out.println("A. Registrar Usuario");
            System.out.println("B. Alta de Usuario");
            System.out.println("C. Cargar documentos");
            System.out.println("X. Salir");
            System.out.println();

            System.out.print("Ingresa la opción seleccionada: ");
            opcion = sc.next().toUpperCase();

            if (opcion.equals("A")) {

              

                    System.out.println("Ingresá nombre");
                    nombre = sc.next();

                    System.out.println("Ingresá apellido");
                    apellido = sc.next();

                    System.out.println("Ingresá DNI");
                    dni = sc.next();
                    
                    System.out.println("Ingresá fecha de nacimiento");
                    String fechaNacimiento = sc.next();

                    System.out.println("Ingresá mail");
                    String mail = sc.next();

                    System.out.println("Ingresá teléfono");
                    String telefono = sc.next();

                    
                    
                
                    //Usuario usuario = new Usuario(nombre, apellido, dni);
                    
                    //usuario.completarDatos(fechaNacimiento,mail,telefono);
                    
                   // usuario.mostrarInformacion();
                

            } else if (opcion.equals("B")) {

                System.out.println();
                System.out.println("=== ALTA DE USUARIO ===");
                System.out.println("1. Ingresar Mail");
                System.out.println("2. Ingresar Contraseña");
                System.out.print("Seleccioná una opción: ");

                subOpcion = sc.next();

                if (subOpcion.equals("1")) {
                    System.out.println("Ingresá el Mail");
                } else if (subOpcion.equals("2")) {
                    System.out.println("Ingresá la Contraseña");
                } else {
                    System.out.println("Opción incorrecta");
                }

            } else if (opcion.equals("C")) {

                System.out.println();
                System.out.println("=== CARGAR DOCUMENTOS ===");
                System.out.println("1. Cargar foto del DNI");
                System.out.println("2. Cargar título");
                System.out.print("Seleccioná una opción: ");

                subOpcion = sc.next();

                if (subOpcion.equals("1")) {
                    System.out.println("Cargando foto del DNI...");
                } else if (subOpcion.equals("2")) {
                    System.out.println("Cargando título...");
                } else {
                    System.out.println("Opción incorrecta");
                }

            } else if (!opcion.equals("X")) {

                System.out.println("Opción incorrecta");

            }

        } while (!opcion.equals("X"));

        System.out.println("Programa finalizado.");
        
        
     // PRUEBA DE LAS CLASES

        Profesor profesor = new Profesor(
                "Carlos",
                "Gomez",
                "22333444",
                "Matemática"
        );

        Alumno alumno = new Alumno(
                "Ana",
                "Perez",
                "33444555",
                "A001",
                "5",
                "A",
                "Mañana"
        );

        Materia materia = new Materia(
                "MAT001",
                "Matemática",
                profesor
        );

        Inscripcion inscripcion = new Inscripcion(
                alumno,
                materia
        );
        
        Usuario usuario1 = alumno;
        Usuario usuario2 = profesor;

        usuario1.mostrarRol();
        usuario2.mostrarRol();
        
        if (usuario1 instanceof Alumno) {
            System.out.println("Es un Alumno");
            Alumno alumnoConvertido = (Alumno) usuario1;
            alumnoConvertido.mostrarDatosAcademicos();
        }
        
        if (usuario2 instanceof Profesor) {
            System.out.println("Es un Profesor");
        }      
        

        alumno.mostrarInformacion();
        alumno.mostrarDatosAcademicos();

        materia.mostrarInformacion();

        inscripcion.mostrarInformacion();

        sc.close();
    }
}


