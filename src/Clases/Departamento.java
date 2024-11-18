package Clases;

import java.util.UUID;

public final class Departamento extends Alojamiento{
    private int piso;

    public Departamento(String nombre, String ubicacion, double precioXnoche, int aforo, boolean es_compartible, boolean estado, int piso) {
        super(nombre, ubicacion, precioXnoche, aforo, es_compartible, estado);
        this.piso = piso;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    @Override
    public String toString() {
        return  super.toString()+ "El departamento se encuentra en el piso " + piso + "\n";
    }
}
