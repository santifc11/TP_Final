package Clases;

public class UsuarioYaExistenteException extends RuntimeException {
    public UsuarioYaExistenteException(String message) {
        super(message);
    }
}
