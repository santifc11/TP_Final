package Clases;

import java.util.Objects;
import java.util.Scanner;

public class Administrador implements Sesion{
    private String usuario = "";
    private String contrasenia = "";

    ///CONSTRUCTOR
    public Administrador() {
    }

    public Administrador(String usuario, String contrasenia) {
    this.usuario = usuario;
    this.contrasenia = contrasenia;
    }

    ///METODOS
    @Override
    public void cambiarContrasenia() {
        boolean flag = false;
        Scanner scanner = new Scanner(System.in);
        String contraseniaActual = "";
        int cantIntentos = 0;
        try {
            while (!flag && cantIntentos < 3) {
                System.out.println("Ingrese su contraseña actual:");
                contraseniaActual = scanner.nextLine();
                if (contraseniaActual.compareTo(contrasenia) != 0){
                    throw new ContraseñaIncorrectaException("La contraseña ingresada no coincide con la de este usuario.");
                }
            }
        }catch (ContraseñaIncorrectaException ex){
            System.out.println(ex.getMessage());
            cantIntentos++;
        }
        if(cantIntentos == 3){
            System.out.println("Has alcanzado el limite de intentos fallidos.");
        }else{
            System.out.println("Ingrese su nueva contraseña:");
            contrasenia = scanner.nextLine();
        }
    }

    ///SETTER Y GETTER
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    ///EQUALS, HASHCODE Y TO STRING
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Administrador that = (Administrador) o;
        return Objects.equals(usuario, that.usuario);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(usuario);
    }

    @Override
    public String toString() {
        return "Administrador{" +
                "usuario='" + usuario + '\'' +
                '}';
    }
}
