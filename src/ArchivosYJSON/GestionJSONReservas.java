package ArchivosYJSON;
import Clases.Reserva;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class GestionJSONReservas {
    private String nomJSON = "anfitrion.json";

    public GestionJSONReservas() {
    }

    public void reservaAarchivo(Reserva reserva) {
        OperacionesLectoEscritura.grabar(this.nomJSON, this.serializar(reserva));
    }

    public JSONObject serializar(Reserva reserva) {
        JSONObject jsonObject = null;

        try {
            jsonObject = new JSONObject();
            jsonObject.put("id", reserva.getId());
            jsonObject.put("alojamiento", reserva.getAlojamiento());
            jsonObject.put("cliente", reserva.getCliente());
            jsonObject.put("fechaDeReserva", reserva.getFechaDeReserva());
            jsonObject.put("fechaInicio", reserva.getFechaInicio());
            jsonObject.put("fechaFin", reserva.getFechaFin());
        } catch (JSONException ex) {
            JSONException e = ex;
            e.printStackTrace();
        }

        return jsonObject;
    }

    public Reserva archivoAReserva() {
        JSONTokener jsonTokener = OperacionesLectoEscritura.leer(this.nomJSON);
        Reserva reservaLeido = null;

        try {
            reservaLeido = this.deserializar(new JSONObject(jsonTokener));
        } catch (JSONException ex) {
            JSONException e = ex;
            e.printStackTrace();
        }

        return reservaLeido;
    }

    public Reserva deserializar(JSONObject jsonObject) {
        Reserva reserva = new Reserva();

        try {
            reserva.setId(jsonObject.getString("id"));
            reserva.setAlojamiento(jsonObject.getString("alojamiento"));
            reserva.setCliente(jsonObject.getString("cliente"));
            reserva.setFechaDeReserva(jsonObject.getString("fechaDeReserva"));
            reserva.setFechaInicio(jsonObject.getString("fechaInicio"));
            reserva.setFechaFin(jsonObject.getString("fechaFin"));
        } catch (JSONException ex) {
            JSONException e = ex;
            e.printStackTrace();
        }

        return reserva;
    }
}
