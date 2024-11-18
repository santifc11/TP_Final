package Clases;

import java.util.UUID;

public final class Casa extends Alojamiento{
    ///CONSTRUCTOR
    public Casa(String nombre, String ubicacion, double precioXnoche, int aforo, boolean es_compartible, boolean estado) {
        super(nombre, ubicacion, precioXnoche, aforo, es_compartible, estado);
    }
    ///EQUALS, HASHCODE Y TO STRING se heredan de la clase padre
}
