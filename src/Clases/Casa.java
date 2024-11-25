package Clases;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public final class Casa extends Alojamiento implements JsonConvertible{



    ///CONSTRUCTOR
    public Casa(String nombre, String ubicacion, double precioXnoche, int aforo, String descripcion, String nombre_anfitrion) {
        super(nombre, ubicacion, precioXnoche, aforo, descripcion, nombre_anfitrion);
    }


    public Casa() {
    }

    @Override
    public JSONObject toJson() {
        JSONObject jsonObject=new JSONObject();

        jsonObject.put("nombre", this.getNombre());
        jsonObject.put("nombreDueño", this.getNombre_anfitrion());
        jsonObject.put("descripcion", this.getDescripcion());
        jsonObject.put("id", this.getIdentificador());
        jsonObject.put("ubicacion", this.getUbicacion());
        jsonObject.put("precioXnoche", this.getPrecioXnoche());
        jsonObject.put("aforo", this.getAforo());
        jsonObject.put("disponible", this.isEstado());
        JSONArray reservasJson = new JSONArray();
        for (Reserva reserva: this.getReservas()){
            reservasJson.put(reserva.toJson());
        }
        jsonObject.put("reservas", reservasJson);


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
            this.setEstado(jsonObject.getBoolean("disponible"));
            JSONArray jsonArray = jsonObject.getJSONArray("reservas");
            List<Reserva> Reservas = new LinkedList<>();

            for(int i = 0; i < jsonArray.length(); ++i) {
                JSONObject jsonReserva = jsonArray.getJSONObject(i);
                Reserva reserva = new Reserva();
                reserva.fromJson(jsonReserva);
                Reservas.add(reserva);
            }
            this.setReservas(Reservas);
        } catch (JSONException e) {
            System.out.println(e.getMessage());
        }
    }
    ///EQUALS, HASHCODE Y TO STRING se heredan de la clase padre
}
