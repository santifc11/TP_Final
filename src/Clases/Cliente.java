package Clases;

import java.util.Set;

public class Cliente extends Usuario{
    private String dni;
    private String nombre;
    private String apellido;
    private String telefono;
    private String mail;
    private boolean comparte;

    Set<Reserva> historialReserva;

    
}
