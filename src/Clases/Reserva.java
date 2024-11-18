package Clases;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

public class Reserva {
    private UUID id;
    private Alojamiento alojamiento;
    private Cliente cliente;
    private LocalDateTime fechaDeReserva;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;


    ///CONSTRUCTOR

    public Reserva() {
    }

    public Reserva(UUID id, Alojamiento alojamiento, Cliente cliente, LocalDateTime fechaInicio, LocalDateTime fechaFin) {
        this.id = id;
        this.alojamiento = alojamiento;
        this.cliente = cliente;
        this.fechaDeReserva = LocalDateTime.now();
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    ///METODOS

    ///GETTER Y SETTER
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

    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }

    public LocalDateTime getFechaFin() {
        return fechaFin;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public void setFechaInicio(LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setFechaFin(LocalDateTime fechaFin) {
        this.fechaFin = fechaFin;
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
        return "Reserva:" +
                "id=" + id +
                ", alojamiento=" + alojamiento.getId() +
                ", cliente=" + cliente.getDni() +
                ", fechaDeReserva=" + fechaDeReserva +
                ", fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                '.';
    }




}
