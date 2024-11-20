package Clases;

import org.json.JSONException;
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

        jsonObject.put("id", this.id.toString());
        jsonObject.put("alojamiento",this.alojamiento);
        jsonObject.put("cliente",this.cliente);
        jsonObject.put("fechaDeReserva",fechaDeReserva.toString());
        jsonObject.put("fechaInicio",fechaInicio.toString());
        jsonObject.put("fechaFin", this.fechaFin.toString());
        jsonObject.put("comparte", this.comparte);
        jsonObject.put("precioReserva", this.precioReserva);
        jsonObject.put("cantPersonas", this.cantPersonas);
        jsonObject.put("estado", this.estado);

        return jsonObject;
    }

    public Reserva fromJson(JSONObject jsonObject) {
        Reserva reserva = new Reserva();
        try {
            reserva.setId(UUID.fromString(jsonObject.getString("id")));
            reserva.setAlojamiento((Alojamiento) jsonObject.get("alojamiento"));
            reserva.setCliente((Cliente) jsonObject.get("cliente"));
            reserva.setFechaDeReserva((LocalDateTime) jsonObject.get("fechaDeReserva"));
            reserva.setFechaInicio((LocalDate) jsonObject.get("fechaInicio"));
            reserva.setFechaFin((LocalDate) jsonObject.get("fechaFin"));
            reserva.setComparte(jsonObject.getBoolean("comparte"));
            reserva.setPrecioReserva(jsonObject.getDouble("precioReserva"));
            reserva.setCantPersonas(jsonObject.getInt("cantPersonas"));
            reserva.setEstado(jsonObject.getString("estado"));
        }catch (CasteoException ex){
            System.out.println("Hubo un error en la lectura");
        } catch (JSONException e) {
            System.out.println(e.getMessage());
        }
        return reserva;
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
                ", cliente=" + cliente.getNombreCompleto() +
                ", fechaDeReserva=" + fechaDeReserva +
                ", fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                ", cantPersonas=" + cantPersonas +
                ", comparte=" + comparte +
                ", precioReserva=" + precioReserva +
                "}\n";
    }

    ///SETTER Y GETTER

    public double getPrecioReserva() {
        return precioReserva;
    }

    public void setPrecioReserva(double precioReserva) {
        this.precioReserva = precioReserva;
    }

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
