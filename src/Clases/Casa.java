package Clases;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;
import java.util.UUID;

public final class Casa extends Alojamiento implements JsonConvertible{
    
    ///CONSTRUCTOR
    public Casa(String nombre, String ubicacion, double precioXnoche, int aforo, boolean es_compartible) {
        super(nombre, ubicacion, precioXnoche, aforo, es_compartible);
    }

    @Override
    public JSONObject toJson() {
        JSONObject jsonObject=new JSONObject();

        jsonObject.put("nombre", this.getNombre());
        jsonObject.put("ubicacion", this.getUbicacion());
        jsonObject.put("precioXnoche", this.getPrecioXnoche());
        jsonObject.put("aforo", this.getAforo());
        jsonObject.put("es_compartible", this.isEs_compartible());
        jsonObject.put("estado", this.isEstado());
        JSONArray reservasJson=new JSONArray();
        for (Reserva reserva: getReservas()){
            reservasJson.put(reserva.toJson());
        }
        jsonObject.put("reservas", reservasJson);

        JSONArray hospedadosJson=new JSONArray();
        for (Cliente cliente: getHospedados()){
            hospedadosJson.put(cliente.toJson());
        }
        jsonObject.put("hospedados", hospedadosJson);


        return jsonObject;
    }

    @Override
    public void fromJson(JSONObject jsonObject) {
        try {
            this.setNombre(jsonObject.getString("nombre"));
            this.setUbicacion(jsonObject.getString("ubicacion"));
            this.setPrecioXnoche(jsonObject.getDouble("precioXnoche"));
            this.setAforo(jsonObject.getInt("aforo"));
            this.setEs_compartible(jsonObject.getBoolean("es_compartible"));
            this.setEstado(jsonObject.getBoolean("estado"));
            this.setReservas((List<Reserva>) jsonObject.get("reservas"));
            this.setHospedados((List<Cliente>) jsonObject.get("hospedados"));
        } catch (JSONException e) {
            System.out.println(e.getMessage());
        }
    }
    ///EQUALS, HASHCODE Y TO STRING se heredan de la clase padre
}
