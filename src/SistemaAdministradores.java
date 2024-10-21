import java.util.Map;
import java.util.TreeMap;

public class SistemaAdministradores{

    private Map<String, Administrador> administradores;

    public SistemaAdministradores(Map<String, Administrador> administradores) {
        this.administradores = new TreeMap<>();  //Hago TreeMap para que se guarden en orden.
    }

/*    public void registrarAdministrador(String usuario, String contrasenia){
        if (!administradores.containsKey(usuario)){
            administradores.put(usuario, new Administrador(usuario, contrasenia));
            System.out.println("Administrador Registrado con exito.");                          USAR PARA CLIENTES.
        }
        else {
            System.out.println("El nombre de usuario ya existe");
        }
    }*/

}
