package ArchivosYJSON;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class OperacionesLectoEscritura {
    public OperacionesLectoEscritura() {
    }

    public static void grabar(String nombreArchivo, JSONObject jsonObject) {
        try {
            FileWriter fileWriter = new FileWriter(nombreArchivo);
            fileWriter.write(jsonObject.toString(2));
            fileWriter.close();
        } catch (IOException ex) {
            IOException e = ex;
            e.printStackTrace();
        }

    }

    public static void grabar(String nombreArchivo, JSONArray jsonArray) {
        try {
            FileWriter fileWriter = new FileWriter(nombreArchivo);
            fileWriter.write(jsonArray.toString(2));
            fileWriter.close();
        } catch (IOException ex) {
            IOException e = ex;
            e.printStackTrace();
        }

    }

    public static JSONTokener leer(String nombreArchivo) {
        JSONTokener jsonTokener = null;

        try {
            jsonTokener = new JSONTokener(new FileReader(nombreArchivo));
        } catch (FileNotFoundException ex) {
            FileNotFoundException e = ex;
            e.printStackTrace();
        } catch (JSONException | IOException ex2) {
            Exception e = ex2;
            ((Exception)e).printStackTrace();
        }
        return jsonTokener;
    }
}
