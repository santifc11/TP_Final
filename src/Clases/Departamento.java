package Clases;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public final class Departamento extends Alojamiento implements JsonConvertible{
    private int piso;

    ///CONSTRUCTOR
    public Departamento(String nombre, String ubicacion, double precioXnoche, int aforo, String descripcion, String nombre_anfitrion, int piso) {
        super(nombre, ubicacion, precioXnoche, aforo, descripcion, nombre_anfitrion);
        this.piso = piso;
//        this.setReservas(new LinkedList<>());
//        this.setHospedados(new ArrayList<>());
    }

    public Departamento() {
    }

    ///SETTER Y GETTER
    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    ///TO STRING porque hay que mostrar el piso en el que está
    @Override
    public String toString() {
        return  super.toString()+ "\nEl departamento se encuentra en el piso " + piso + "\n";
    }

    @Override
    public JSONObject toJson() {
        JSONObject jsonObject=new JSONObject();

        jsonObject.put("nombre", this.getNombre());
        jsonObject.put("descripcion", this.getDescripcion());
        jsonObject.put("nombreDueño", this.getNombre_anfitrion());
        jsonObject.put("id", this.getIdentificador());
        jsonObject.put("ubicacion", this.getUbicacion());
        jsonObject.put("precioXnoche", this.getPrecioXnoche());
        jsonObject.put("aforo", this.getAforo());

        jsonObject.put("estado", this.isEstado());
//        JSONArray reservasJson=new JSONArray();
//        for (Reserva reserva: getReservas()){
//            reservasJson.put(reserva.toJson());
//        }
//        jsonObject.put("reservas", reservasJson);
//
//        JSONArray hospedadosJson=new JSONArray();
//        for (Cliente cliente: getHospedados()){
//            hospedadosJson.put(cliente.toJson());
//        }
//        jsonObject.put("hospedados", hospedadosJson);
        jsonObject.put("piso", this.piso);

        return jsonObject;
    }

    @Override
    public void fromJson(JSONObject jsonObject) {
        try {
            this.setIdentificador(jsonObject.getInt("id"));
            this.setNombre(jsonObject.getString("nombre"));
            this.setNombre_anfitrion(jsonObject.getString("nombreDueño"));
            this.setDescripcion(jsonObject.getString("descripcion"));
            this.setUbicacion(jsonObject.getString("ubicacion"));
            this.setPrecioXnoche(jsonObject.getDouble("precioXnoche"));
            this.setAforo(jsonObject.getInt("aforo"));

            this.setEstado(jsonObject.getBoolean("estado"));
//            this.setReservas((List<Reserva>) jsonObject.get("reservas"));
//            this.setHospedados((List<Cliente>) jsonObject.get("hospedados"));
            this.setPiso(jsonObject.getInt("piso"));
        } catch (JSONException e) {
            System.out.println(e.getMessage());
        }
    }
}
