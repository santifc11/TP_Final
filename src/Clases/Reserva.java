package Clases;

import org.json.JSONObject;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class Reserva {
    private final UUID id;
    private Alojamiento alojamiento;
    private Cliente cliente;
    private LocalDateTime fechaDeReserva;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private boolean comparte;

    ///CONSTRUCTOR

    public Reserva(UUID id, Alojamiento alojamiento, Cliente cliente, LocalDateTime fechaInicio, LocalDateTime fechaFin) {
        this.id = id;
        this.alojamiento = alojamiento;
        this.cliente = cliente;
        this.fechaDeReserva = fechaDeReserva;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.comparte = comparte;
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

    public LocalDateTime getFechaFin() {
        return fechaFin;
    }

    public void setFechaInicio(LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

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
                ", comparte=" + comparte +
                '.';
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


}
