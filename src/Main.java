import Clases.Administrador;
import Clases.Cliente;
import Clases.Gestion;

public class Main {
    public static void main(String[] args) {
        Administrador admin = new Administrador("TiagoJaen", "1234");
        Cliente cliente = new Cliente("UsuarioTiago", "1234", "111111", "Tiago David Jaen");

        Gestion gestion = new Gestion();
        gestion.cargarAdministrador(admin);
        gestion.inicio_de_sesion();
    }
}
