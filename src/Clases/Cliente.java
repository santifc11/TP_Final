package Clases;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Cliente implements Sesion{
    private String usuario = "", contrasenia = "", dni = "", nombreCompleto = "";
    private Set<Reserva> historialReserva;
    private boolean comparte;

    public Cliente() {
    }

    ///CONSTRUCTOR
    ///
    public Cliente(String usuario, String contrasenia, String dni, String nombreCompleto, boolean comparte) {
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.dni = dni;
        this.nombreCompleto = nombreCompleto;
        this.historialReserva = new HashSet<>();
        this.comparte = comparte;
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public Set<Reserva> getHistorialReserva() {
        return historialReserva;
    }

    public void setHistorialReserva(Set<Reserva> historialReserva) {
        this.historialReserva = historialReserva;
    }

    public boolean isComparte() {
        return comparte;
    }

    public void setComparte(boolean comparte) {
        this.comparte = comparte;
    }
}
