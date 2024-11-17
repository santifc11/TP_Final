package Clases;

import java.util.HashSet;
import java.util.Set;

public class Cliente implements Sesion{
    private String usuario, contrasenia, dni, nombre;
    private Set<Reserva> historialReserva;
    private boolean comparte;

    ///CONSTRUCTOR
    public Cliente(String usuario, String contrasenia, String dni, String nombre, boolean comparte) {
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.dni = dni;
        this.nombre = nombre;
        this.historialReserva = new HashSet<>();
        this.comparte = comparte;
    }

    ///METODOS
    @Override
    public void cambiarContrasenia() {

    }
}
