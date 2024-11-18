package Clases;

import java.util.UUID;

public final class Casa extends Alojamiento{

    public Casa(String nombre, String ubicacion, double precioXnoche, int aforo, boolean es_compartible, boolean estado) {
        super(nombre, ubicacion, precioXnoche, aforo, es_compartible, estado);
    }

    @Override
    public String toString() {
        return "Clases.Casa: " + super.toString();
    }
}
