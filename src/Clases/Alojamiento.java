package Clases;

import org.json.JSONArray;
import org.json.JSONObject;

import java.time.LocalDate;
import java.util.*;

public abstract class Alojamiento{
    private int identificador;
    private String nombre,ubicacion;
    private double precioXnoche;
    private int aforo;
    private static String[] descripcion;
    private boolean es_compartible, estado; // estado: DISPONIBLE(TRUE)/ OCUPADO(FALSE).
    private List<Reserva>reservas;
    private static int contador=0;
    private List<Cliente>hospedados;
    private String nombre_anfitrion;

    ///CONSTRUCTOR
    public Alojamiento(String nombre, String ubicacion, double precioXnoche, int aforo, String nombre_anfitrion) {
        this.identificador=contador++;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.precioXnoche = precioXnoche;
        this.aforo = aforo;
        this.es_compartible = es_compartible;
        this.estado = true;
        this.reservas=new LinkedList<>();
        this.hospedados=new ArrayList<>();
        this.nombre_anfitrion = nombre_anfitrion;
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

    public String[] getDescripcion() {
        return descripcion;
    }

    public static void setDescripcion(String[] descripcion) {
        Alojamiento.descripcion = descripcion;
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

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public int getIdentificador() {
        return identificador;
    }

    public List<Cliente> getHospedados() {
        return hospedados;
    }

    public void setHospedados(List<Cliente> hospedados) {
        this.hospedados = hospedados;
    }

    public String getNombre_anfitrion() {
        return nombre_anfitrion;
    }

    public void setNombre_anfitrion(String nombre_anfitrion) {
        this.nombre_anfitrion = nombre_anfitrion;
    }

    ///METODOS
    public void pedir_descripcion(){
        Scanner scanner = new Scanner(System.in);
        int control = 0, validos = 0;
        System.out.println("Ingrese las caracteristicas del alojamiento una a una: ");
        do {
            System.out.print("- ");
            descripcion[validos] = scanner.nextLine();          //VER SI SE PUEDE HACER CON UN StringBuilder
            System.out.println();
            validos++;
            System.out.println("Desea continuar cargando caracteristicas?\n1- Continuar.\n0- Finalizar.\n. ");
            control = scanner.nextInt();
        } while(control!=0);
    }


    public void agregarReserva(Reserva reserva){
        reservas.add(reserva);
    }

    public boolean verificaDisponibilidad(LocalDate fechaInicio, LocalDate fechaFin){
        for (Reserva reserva:reservas){
            if(reserva.seSolapaCon(fechaInicio,fechaFin)){
                this.estado=false;
                return false;
            }
        }
        this.estado=true;
        return true;
    }

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

    @Override
    public String toString() {
        return "Alojamiento{" +
                "identificador=" + identificador +
                ", nombre='" + nombre + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                ", precioXnoche=" + precioXnoche +
                ", aforo=" + aforo +
                ", nombre_anfitrion='" + nombre_anfitrion + '\'' +
                '}';
    }


}
