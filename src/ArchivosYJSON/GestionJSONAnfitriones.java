package ArchivosYJSON;
import Clases.Anfitrion;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class GestionJSONAnfitriones {
    private String nomJSON = "anfitrion.json";

    public GestionJSONAnfitriones() {
    }

    public void anfitrionAarchivo(Anfitrion anfitrion) {
        OperacionesLectoEscritura.grabar(this.nomJSON, this.serializar(anfitrion));
    }

    public JSONObject serializar(Anfitrion anfitrion) {
        JSONObject jsonObject = null;

        try {
            jsonObject = new JSONObject();
            jsonObject.put("usuario", anfitrion.getUsuario());
            jsonObject.put("contraseña", anfitrion.getContrasenia());
            jsonObject.put("nombre", anfitrion.getNombre());
        } catch (JSONException ex) {
            JSONException e = ex;
            e.printStackTrace();
        }

        return jsonObject;
    }

    public Anfitrion archivoAAnfitrion() {
        JSONTokener jsonTokener = OperacionesLectoEscritura.leer(this.nomJSON);
        Anfitrion anfitrionLeido = null;

        try {
            anfitrionLeido = this.deserializar(new JSONObject(jsonTokener));
        } catch (JSONException ex) {
            JSONException e = ex;
            e.printStackTrace();
        }

        return anfitrionLeido;
    }

    public Anfitrion deserializar(JSONObject jsonObject) {
        Anfitrion anfitrion = new Anfitrion();

        try {
            anfitrion.setUsuario(jsonObject.getString("usuario"));
            anfitrion.setContrasenia(jsonObject.getString("contraseña"));
            anfitrion.setNombre(jsonObject.getString("nombre"));
        } catch (JSONException ex) {
            JSONException e = ex;
            e.printStackTrace();
        }

        return anfitrion;
    }
}
