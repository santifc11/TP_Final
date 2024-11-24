package Clases;

import java.time.LocalDate;
import java.util.*;

public abstract class Alojamiento{
    private int identificador = 0, aforo = 0;
    private String nombre= "",ubicacion= "", descripcion = "", nombre_anfitrion = "";
    private double precioXnoche = 0;
    boolean estado; // estado: DISPONIBLE(TRUE)/ OCUPADO(FALSE).
    private static int contador=1;
    private List<Reserva>reservas;
    private ArrayList<Cliente>hospedados;

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
        this.hospedados= new ArrayList<>();
    }

    public Alojamiento() {
        this.reservas=new LinkedList<>();
        this.hospedados= new ArrayList<>();
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

    public ArrayList<Cliente> getHospedados() {
        return hospedados;
    }

    public void setHospedados(ArrayList<Cliente> hospedados) {
        this.hospedados = hospedados;
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

    public void verificaDisponibilidad(LocalDate fechaInicio, LocalDate fechaFin) throws IllegalArgumentException{
        if(fechaInicio==null || fechaFin==null ){
            throw new IllegalArgumentException("Las fechas no pueden ser nulas");
        }
        try {
                for (Reserva reserva : reservas) {
                    if (reserva.seSolapaCon(fechaInicio, fechaFin)) {
                        this.estado = false;
                    }
                    else {
                        this.estado=true;
                    }
                }
        }catch (NullPointerException e){

        }catch (Exception e){

        }

    }

    public void agregarHuespedes(Cliente cliente, int numeroPersonas) {
        if (puedeHospedar(numeroPersonas)) {
            for (int i = 0; i < numeroPersonas; i++) {
                hospedados.add(cliente);
            }

        } else {
            System.out.println("El alojamiento no tiene capacidad suficiente para hospedar a " + numeroPersonas + " personas.");
        }
    }

    public boolean puedeHospedar(int numeroPersonas) {
        if ((hospedados.size() + numeroPersonas) <= aforo){
            return true;
        }
        else {
            System.out.println("No hay lugar disponible");
            return false;
        }
    }


    ///EQUALS, HASHCODE Y TO STRING


    @Override
    public String toString() {
        return "-------Alojamiento-------" +
                "\nNumero de alojamiento: " + identificador +
                ", \nNombre: '" + nombre + "'" +
                ", \nUbicacion: '" + ubicacion + "'" +
                ", \nPrecio por Noche: " + precioXnoche +
                ", \nAforo: " + aforo + " personas."+
                ", \nDescripción: " + descripcion +
                ", \nNombre del Anfitrion: '" + nombre_anfitrion + "'\n";
    }


}
