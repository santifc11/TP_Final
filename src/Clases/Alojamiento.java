package Clases;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
import java.util.UUID;

public abstract class Alojamiento {
    private final UUID id;
    private String nombre;
    private String ubicacion;
    private double precioXnoche;
    private int aforo;
    private static String[] descripcion;
    private boolean es_compartible;

    public Alojamiento(String nombre, String ubicacion, double precioXnoche, int aforo, boolean es_compartible) {
        this.id = UUID.randomUUID();
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.precioXnoche = precioXnoche;
        this.aforo = aforo;
        this.descripcion = new String[10];
        this.es_compartible = es_compartible;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public double getPrecioXnoche() {
        return precioXnoche;
    }

    public void setPrecioXnoche(double precioXnoche) {
        this.precioXnoche = precioXnoche;
    }

    public int getAforo() {
        return aforo;
    }

    public void setAforo(int aforo) {
        this.aforo = aforo;
    }

    public String[] getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String[] descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isEs_compartible() {
        return es_compartible;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Alojamiento that)) return false;
        return Objects.equals(id, that.id) && Objects.equals(nombre, that.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
            StringBuilder mensaje = new StringBuilder();
            mensaje.append("Nombre: ").append(nombre).append("\n")
                    .append("Ubicacion: ").append(ubicacion).append("\n")
                    .append("Precio por noche: ").append(precioXnoche).append("\n")
                    .append("Aforo: ").append(aforo).append("\n")
                    .append("Descripcion y Caracteristicas: \n- ");

            for (String descripcion:descripcion){
                if (descripcion!=null){
                    mensaje.append(descripcion).append(".\n- ");
                }
            }

            return mensaje.toString();
    }

    //Metodos propios

    Scanner scanner = new Scanner(System.in);

    public void pedir_descripcion(){

        int control = 0, validos = 0;
        System.out.println("Ingrese las caracteristicas del alojamiento una a una: ");
        do {
            System.out.print("- ");
            String caract=scanner.nextLine();
            descripcion[validos] = caract;
            validos++;
            System.out.println();
            System.out.print("Desea continuar cargando caracteristicas?\n1- Continuar.\n0- Finalizar.\n. ");
            control = scanner.nextInt();
            scanner.nextLine();
            System.out.println();
        } while(control!=0);
    }


}
