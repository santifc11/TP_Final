package Clases;

import org.json.JSONObject;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Reserva {
    private UUID id;
    private Alojamiento alojamiento;
    private Cliente cliente;
    private LocalDateTime fechaDeReserva;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private boolean comparte;
    private double precioReserva;
    private int cantPersonas;
    private String estado;


    ///CONSTRUCTOR

    public Reserva(Alojamiento alojamiento, Cliente cliente, LocalDate fechaInicio, LocalDate fechaFin, boolean comparte,int cantPersonas) {
        this.id = UUID.randomUUID();
        this.alojamiento = alojamiento;
        this.cliente = cliente;
        this.fechaDeReserva = LocalDateTime.now();
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.comparte = comparte;
        this.precioReserva= calcularPrecioTotal();
        this.cantPersonas=cantPersonas;
        this.estado="Pendiente";

    }
    public Reserva() {
        this.id = UUID.randomUUID();
    }


    ///METODOS.


    private double calcularPrecioTotal() {
        long diasEstancia = ChronoUnit.DAYS.between(fechaInicio, fechaFin) + 1;

        return alojamiento.getPrecioXnoche() * diasEstancia;

    }


    //Metodo para verificar si las fechas se solapan
    public boolean seSolapaCon(LocalDate otraFechaInicio, LocalDate otraFechaFin) {
        return !fechaFin.isBefore(otraFechaInicio) && !fechaInicio.isAfter(otraFechaFin);
    }


    public JSONObject toJson(){
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("id",id);
        jsonObject.put("alojamiento",alojamiento.toJson());
        jsonObject.put("cliente",cliente.toJson());
        jsonObject.put("fechaDeReserva",fechaDeReserva.toString());
        jsonObject.put("fechaInicio",fechaInicio.toString());
        jsonObject.put("fechaFin",fechaFin.toString());
        jsonObject.put("comparte",comparte);

        return jsonObject;
    }

    ///EQUALS, HASHCODE Y TO STRING

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reserva reserva = (Reserva) o;
        return Objects.equals(id, reserva.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "id=" + id +
                ", alojamiento=" + alojamiento.getIdentificador() +
                ", cliente=" + cliente.getDni() +
                ", fechaDeReserva=" + fechaDeReserva +
                ", fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                ", cantPersonas=" + cantPersonas +
                ", comparte=" + comparte +
                ", precioReserva=" + precioReserva +
                '}';
    }

    ///SETTER Y GETTER
    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public Alojamiento getAlojamiento() {
        return alojamiento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public LocalDateTime getFechaDeReserva() {
        return fechaDeReserva;
    }


    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public void setAlojamiento(Alojamiento alojamiento) {
        this.alojamiento = alojamiento;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setFechaDeReserva(LocalDateTime fechaDeReserva) {
        this.fechaDeReserva = fechaDeReserva;
    }

    public boolean isComparte() {
        return comparte;
    }

    public void setComparte(boolean comparte) {
        this.comparte = comparte;
    }

    public int getCantPersonas() {
        return cantPersonas;
    }

    public void setCantPersonas(int cantPersonas) {
        this.cantPersonas = cantPersonas;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
