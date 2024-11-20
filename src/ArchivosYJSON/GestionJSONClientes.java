package ArchivosYJSON;
import Clases.Cliente;
import Clases.Reserva;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.util.Iterator;
import java.util.concurrent.locks.ReentrantLock;

public class GestionJSONClientes {
    private String nomJSON = "cliente.json";
    private GestionJSONReservas gestionJSONReservas = new GestionJSONReservas();

    public GestionJSONClientes() {
    }

    public void clienteAarchivo(Cliente cliente) {
        OperacionesLectoEscritura.grabar(this.nomJSON, this.serializar(cliente));
    }

    public JSONObject serializar(Cliente cliente) {
        JSONObject jsonObject = null;

        try {
            jsonObject = new JSONObject();
            jsonObject.put("usuario", cliente.getUsuario());
            jsonObject.put("contraseña", cliente.getContrasenia());
            jsonObject.put("dni", cliente.getDni());
            jsonObject.put("nombre", cliente.getNombreCompleto());
        } catch (JSONException ex) {
            JSONException e = ex;
            e.printStackTrace();
        }

        return jsonObject;
    }

    public Cliente archivoACliente() {
        JSONTokener jsonTokener = OperacionesLectoEscritura.leer(this.nomJSON);
        Cliente clienteLeido = null;

        try {
            clienteLeido = this.deserializar(new JSONObject(jsonTokener));
        } catch (JSONException ex) {
            JSONException e = ex;
            e.printStackTrace();
        }

        return clienteLeido;
    }

    public Cliente deserializar(JSONObject jsonObject) {
        Cliente cliente = new Cliente();

        try {
            cliente.setUsuario(jsonObject.getString("usuario"));
            cliente.setContrasenia(jsonObject.getString("contraseña"));
            cliente.setDni(jsonObject.getString("dni"));
            cliente.setNombreCompleto(jsonObject.getString("nombre"));
        } catch (JSONException ex) {
            JSONException e = ex;
            e.printStackTrace();
        }

        return cliente;
    }
}
