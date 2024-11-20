package Clases;

import java.time.LocalDate;
import java.util.*;

public abstract class Alojamiento{
    private int identificador = 0, aforo = 0;
    private String nombre= "",ubicacion= "", descripcion = "", nombre_anfitrion = "";
    private double precioXnoche = 0;
    private boolean es_compartible, estado; // estado: DISPONIBLE(TRUE)/ OCUPADO(FALSE).
    private static int contador=1;
//    private List<Reserva>reservas;
    private List<Cliente>hospedados;

    ///CONSTRUCTOR

    public Alojamiento(String nombre, String ubicacion, double precioXnoche, int aforo, String descripcion, String nombre_anfitrion) {
        this.identificador=contador++;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.precioXnoche = precioXnoche;
        this.aforo = aforo;
        this.descripcion = descripcion;
        this.nombre_anfitrion = nombre_anfitrion;
        this.es_compartible = es_compartible;
        this.estado = true;
//        this.reservas=new LinkedList<>();
        this.hospedados=new ArrayList<>();
    }

    public Alojamiento() {
    }

    ///SETTER Y GETTER

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }



    public void setEs_compartible(boolean es_compartible) {
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isEs_compartible() {
        return es_compartible;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

//    public List<Reserva> getReservas() {
//        return reservas;
//    }
//
//    public void setReservas(List<Reserva> reservas) {
//        this.reservas = reservas;
//    }
//
    public List<Cliente> getHospedados() {
        return hospedados;
    }

    public void setHospedados(List<Cliente> hospedados) {
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




//    public void agregarReserva(Reserva reserva){
//        reservas.add(reserva);
//    }
//
//    public boolean verificaDisponibilidad(LocalDate fechaInicio, LocalDate fechaFin){
//        try {
//            for (Reserva reserva : this.reservas) {
//                if (reserva.seSolapaCon(fechaInicio, fechaFin)) {
//                    this.estado = false;
//                    return false;
//                }
//            }
//            this.estado = true;
//        }catch (NullPointerException e){
//            return true;
//        }catch (Exception e){
//
//        }
//        return true;
//    }

    public boolean agregarHuespedes(Cliente cliente, int numeroPersonas) {
        if (puedeHospedar(numeroPersonas)) {
            for (int i = 0; i < numeroPersonas; i++) {
                hospedados.add(cliente);
            }
            return true;
        } else {
            System.out.println("El alojamiento no tiene capacidad suficiente para hospedar a " + numeroPersonas + " personas.");
            return false; }
    }

    public boolean puedeHospedar(int numeroPersonas) {
        return (hospedados.size() + numeroPersonas) <= aforo;
    }


    ///EQUALS, HASHCODE Y TO STRING


    @Override
    public String toString() {
        return "Alojamiento{" +
                "\nidentificador=" + identificador +
                ", \nnombre='" + nombre + '\'' +
                ", \nubicacion='" + ubicacion + '\'' +
                ", \nprecioXnoche=" + precioXnoche +
                ", \naforo=" + aforo +
                ", \ndescripción" + descripcion +
                ", \nnombre_anfitrion='" + nombre_anfitrion + '\n' +
                '}';
    }


}
