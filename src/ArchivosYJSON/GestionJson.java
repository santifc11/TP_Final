package ArchivosYJSON;

import Clases.Alojamiento;
import Clases.Cliente;
import Clases.JsonConvertible;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GestionJson <T extends JsonConvertible> {

    private String nomJs;

    public GestionJson(String nomJs) {
        this.nomJs = nomJs;
    }


    public void objet_A_Arch(T objet){
        JSONArray jsonArray=new JSONArray();
        try {
            jsonArray.put(objet.toJson());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        OperacionesLectoEscritura.grabar(nomJs,jsonArray);
    }



    public T arcch_A_Objet(){
        JSONArray jsonArray=null;
        T elment = null;

        try {
            jsonArray=new JSONArray(OperacionesLectoEscritura.leer(nomJs));
            for (int i = 0; i < jsonArray.length(); i++) {
               JSONObject jsonObject= jsonArray.getJSONObject(i);
               elment.fromJson(jsonObject);
            }
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        return elment;
    }






}
