package Clases;

import javax.swing.plaf.basic.BasicDesktopIconUI;
import java.util.Scanner;

public final class Anfitrion implements Sesion{
    private String usuario, nombre, contrasenia;
    ///CONSTRUCTOR
    public Anfitrion() {
    }

    public Anfitrion(String usuario, String nombre, String contrasenia) {
        this.usuario = usuario;
        this.nombre = nombre;
        this.contrasenia = contrasenia;
    }

    ///METODOS
    public void agregarAlojamiento(){
    }
    public void quitarAlojamiento(){

    }
    @Override
    public void cambiarContrasenia() throws ContraseñaIncorrectaException{
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

    ///SETTER Y GETTERS
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}
