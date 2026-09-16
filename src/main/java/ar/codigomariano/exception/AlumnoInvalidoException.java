package ar.codigomariano.exception;

public class AlumnoInvalidoException extends RuntimeException {

    public AlumnoInvalidoException(String mensaje) {
        super(mensaje);
    }
}