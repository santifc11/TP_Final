package Clases;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Reserva implements JsonConvertible {
    private UUID id;
    private Alojamiento alojamiento;
    private Cliente cliente;
    private LocalDateTime fechaDeReserva;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private double precioReserva;
    private int cantPersonas, id_alojamiento;
    private String estado, nombre_cliente;


    ///CONSTRUCTOR

    public Reserva(Alojamiento alojamiento, Cliente cliente, LocalDate fechaInicio, LocalDate fechaFin,int cantPersonas) {
        this.id = UUID.randomUUID();
        this.alojamiento = alojamiento;
        this.id_alojamiento = alojamiento.getIdentificador();
        this.cliente = cliente;
        this.nombre_cliente = cliente.getNombreCompleto();
        this.fechaDeReserva = LocalDateTime.now();
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
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
        if(fechaFin.isBefore(otraFechaInicio)){
            return false;
        }else{
            return true; ///si se interrumpen se devuelve true (si se solapa)
        }
    }

    @Override
    public JSONObject toJson(){
        JSONObject jsonObject=new JSONObject();
        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        DateTimeFormatter frmLDT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        DateTimeFormatter frmLD = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        jsonObject.put("id", this.id.toString());
        jsonObject.put("id_alojamiento",this.id_alojamiento);
        jsonObject.put("nombre_cliente",this.nombre_cliente);
        jsonObject.put("fechaDeReserva",frmLDT.format(this.fechaDeReserva));
        jsonObject.put("fechaInicio",frmLD.format(this.fechaInicio));
        jsonObject.put("fechaFin", frmLD.format(this.fechaFin));
        jsonObject.put("precioReserva", this.precioReserva);
        jsonObject.put("cantPersonas", this.cantPersonas);
        jsonObject.put("estado", this.estado);

        return jsonObject;
    }

    @Override
    public void fromJson(JSONObject jsonObject) {
        try {
            DateTimeFormatter frmLDT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            this.setId(UUID.fromString(jsonObject.getString("id")));
            this.setId_alojamiento(jsonObject.getInt("id_alojamiento"));
            this.setNombre_cliente(jsonObject.getString("nombre_cliente"));
            this.setFechaDeReserva(LocalDateTime.parse(jsonObject.getString("fechaDeReserva"), frmLDT));
            this.setFechaInicio(LocalDate.parse(jsonObject.getString("fechaInicio")));
            this.setFechaFin(LocalDate.parse(jsonObject.getString("fechaFin")));
            this.setPrecioReserva(jsonObject.getDouble("precioReserva"));
            this.setCantPersonas(jsonObject.getInt("cantPersonas"));
            this.setEstado(jsonObject.getString("estado"));
        } catch (JSONException e) {
            System.out.println(e.getMessage());
        }
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
                ", id_alojamiento=" + id_alojamiento +
                ", nombre_cliente=" + nombre_cliente +
                ", fechaDeReserva=" + fechaDeReserva +
                ", fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                ", cantPersonas=" + cantPersonas +
                ", precioReserva=" + precioReserva +
                "}\n";
    }

    public int getId_alojamiento() {
        return id_alojamiento;
    }

    public void setId_alojamiento(int id_alojamiento) {
        this.id_alojamiento = id_alojamiento;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    ///SETTER Y GETTER
    ///


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
