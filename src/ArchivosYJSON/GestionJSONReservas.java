package ArchivosYJSON;
import Clases.Alojamiento;
import Clases.Cliente;
import Clases.Reserva;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.time.LocalDateTime;
import java.util.UUID;

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
            reserva.setId(UUID.fromString(jsonObject.getString("id")));
            reserva.setAlojamiento((Alojamiento) jsonObject.get("alojamiento"));
            reserva.setCliente((Cliente) jsonObject.get("cliente"));
            reserva.setFechaDeReserva((LocalDateTime) jsonObject.get("fechaDeReserva"));
            reserva.setFechaInicio((LocalDateTime) jsonObject.get("fechaInicio"));
            reserva.setFechaFin((LocalDateTime) jsonObject.get("fechaFin"));
        } catch (JSONException ex) {
            JSONException e = ex;
            e.printStackTrace();
        }

        return reserva;
    }
}
