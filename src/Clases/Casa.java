package Clases;

import org.json.JSONObject;

import java.util.UUID;

public final class Casa extends Alojamiento implements JsonConvertible{
    ///CONSTRUCTOR
    public Casa(String nombre, String ubicacion, double precioXnoche, int aforo, boolean es_compartible) {
        super(nombre, ubicacion, precioXnoche, aforo, es_compartible);
    }

    @Override
    public void fromJson(JSONObject jsonObject) {

    }
    ///EQUALS, HASHCODE Y TO STRING se heredan de la clase padre
}
