package ArchivosYJSON;
import Clases.Administrador;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class GestionJSONAdministradores {
    private String nomJSON = "administrador.json";

    public GestionJSONAdministradores() {
    }

    public void administradorAarchivo(Administrador administrador) {
        OperacionesLectoEscritura.grabar(this.nomJSON, this.serializar(administrador));
    }

    public JSONObject serializar(Administrador administrador) {
        JSONObject jsonObject = null;

        try {
            jsonObject = new JSONObject();
            jsonObject.put("usuario", administrador.getUsuario());
            jsonObject.put("contraseña", administrador.getContrasenia());
        } catch (JSONException ex) {
            JSONException e = ex;
            e.printStackTrace();
        }

        return jsonObject;
    }

    public Administrador archivoAAdministrador() {
        JSONTokener jsonTokener = OperacionesLectoEscritura.leer(this.nomJSON);
        Administrador administradorLeido = null;

        try {
            administradorLeido = this.deserializar(new JSONObject(jsonTokener));
        } catch (JSONException ex) {
            JSONException e = ex;
            e.printStackTrace();
        }

        return administradorLeido;
    }

    public Administrador deserializar(JSONObject jsonObject) {
        Administrador administrador = new Administrador();

        try {
            administrador.setUsuario(jsonObject.getString("usuario"));
            administrador.setContrasenia(jsonObject.getString("contraseña"));
        } catch (JSONException ex) {
            JSONException e = ex;
            e.printStackTrace();
        }

        return administrador;
    }
}
