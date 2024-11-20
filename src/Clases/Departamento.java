package Clases;

import java.util.UUID;

public final class Departamento extends Alojamiento{
    private int piso;

    ///CONSTRUCTOR
    public Departamento(String nombre, String ubicacion, double precioXnoche, int aforo, String nombre_anfitrion, int piso) {
        super(nombre, ubicacion, precioXnoche, aforo, nombre_anfitrion);
        this.piso = piso;
    }

    ///SETTER Y GETTER
    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    ///TO STRING porque hay que mostrar el piso en el que está
    @Override
    public String toString() {
        return  super.toString()+ "El departamento se encuentra en el piso " + piso + "\n";
    }
}
