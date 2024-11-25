package Clases;

import java.time.LocalDate;
import java.util.*;

public abstract class Alojamiento{
    private int identificador = 0, aforo = 0;
    private String nombre= "",ubicacion= "", descripcion = "", nombre_anfitrion = "";
    private double precioXnoche = 0;
    boolean estado; // estado: DISPONIBLE(TRUE)/ OCUPADO(FALSE).
    private static int contador=1;
    private static List<Reserva>reservas;

    ///CONSTRUCTOR

    public Alojamiento(String nombre, String ubicacion, double precioXnoche, int aforo, String descripcion, String nombre_anfitrion) {
        this.identificador=contador++;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.precioXnoche = precioXnoche;
        this.aforo = aforo;
        this.descripcion = descripcion;
        this.nombre_anfitrion = nombre_anfitrion;
        this.estado = true;
        this.reservas=new LinkedList<>();
    }

    public Alojamiento() {
        this.reservas=new LinkedList<>();
    }

    ///SETTER Y GETTER

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public List<Reserva> getReservas() {
        return reservas;
   }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }


    public int getIdentificador() {
        return identificador;
    }

    public String getNombre_anfitrion() {
        return nombre_anfitrion;
    }

    public void setNombre_anfitrion(String nombre_anfitrion) {
        this.nombre_anfitrion = nombre_anfitrion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Alojamiento that = (Alojamiento) o;
        return identificador == that.identificador;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(identificador);
    }

    ///METODOS


    public void agregarReserva(Reserva reserva){
        reservas.add(reserva);
    }

    public boolean verificaDisponibilidad(LocalDate fechaInicio, LocalDate fechaFin, Alojamiento otroAlojamiento) throws IllegalArgumentException{
        try {
            if(fechaInicio==null || fechaFin==null ){
                throw new IllegalArgumentException("Las fechas no pueden ser nulas");
            }
            for (Reserva reserva : reservas) {
                if (reserva.getId_alojamiento() == otroAlojamiento.getIdentificador() && reserva.seSolapaCon(fechaInicio, fechaFin)) {
                    return false; ///Si el alojamiento es el mismo y se solapa con alguna reserva, se devuelve false, por lo que no está disponible
                }
            }
        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }catch(NullPointerException e){

        }catch (Exception e){

        }
        return true;
    }


    public boolean puedeHospedar(int numeroPersonas) {
        if (numeroPersonas <= aforo){
            return true;
        }
        else {
            return false;
        }
    }


    ///EQUALS, HASHCODE Y TO STRING


    @Override
    public String toString() {
        String tipo = "";
        if (this.getClass().equals(Casa.class)){
            tipo = "Casa";
        }else{
            tipo = "Departamento";
        }
        return
                "\nNumero de alojamiento: " + identificador +
                ", \nNombre: '" + nombre + "'" +
                ", \nUbicacion: '" + ubicacion + "'" +
                ", \nPrecio por Noche: " + precioXnoche +
                ", \nAforo: " + aforo + " personas."+
                ", \nDescripción: '" + descripcion + "'" +
                ", \nNombre del Anfitrion: '" + nombre_anfitrion + "'" +
                ", \nDisponible: " + estado +
                ", \nTipo: " + tipo;
    }


}
