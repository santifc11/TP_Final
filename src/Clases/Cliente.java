package Clases;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.*;

public final class Cliente implements Sesion, JsonConvertible{
    private String usuario = "", contrasenia = "", dni = "", nombreCompleto = "";

    ///CONSTRUCTOR
    public Cliente(String usuario, String contrasenia, String dni, String nombreCompleto) {
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.dni = dni;
        this.nombreCompleto = nombreCompleto;

    }

    public Cliente() {
    }

    ///SETTER Y GETTER
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }
    ///METODOS
    @Override
    public void cambiarContrasenia() {
        boolean flag = false;
        Scanner scanner = new Scanner(System.in);
        String contraseniaActual = "";
        int cantIntentos = 0;
        while (!flag && cantIntentos < 3) {
            try {
                System.out.println("Ingrese su contraseña actual:");
                contraseniaActual = scanner.nextLine();
                if (contraseniaActual.compareTo(contrasenia) != 0) {
                    throw new ContraseniaIncorrectaException("La contraseña ingresada no coincide con la de este usuario.");
                }else{
                    flag = true;
                }
            } catch (ContraseniaIncorrectaException ex) {
                System.out.println(ex.getMessage());
                cantIntentos++;
            }
        }
        if(cantIntentos == 3){
            System.out.println("Has alcanzado el limite de intentos fallidos.");
        }else{
            System.out.println("Ingrese su nueva contraseña:");
            contrasenia = scanner.nextLine();
            System.out.println("Contraseña cambiada con éxito");
        }
    }

    ///TO JSONObject

   public JSONObject toJson(){
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("usuario", this.usuario);
        jsonObject.put("contrasenia",this.contrasenia);
        jsonObject.put("dni", this.dni);
        jsonObject.put("nombreCompleto", this.nombreCompleto);

        return jsonObject;
   }

    @Override
    public void fromJson(JSONObject jsonObject) {
        try {
            this.setUsuario(jsonObject.getString("usuario"));
            this.setContrasenia(jsonObject.getString("contrasenia"));
            this.setDni(jsonObject.getString("dni"));
            this.setNombreCompleto(jsonObject.getString("nombreCompleto"));
        } catch (JSONException e) {
            System.out.println(e.getMessage());
        }
    }

    ///EQUALS, HASHCODE Y TO STRING
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(dni, cliente.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(dni);
    }

    @Override
    public String toString() {
        return "Cliente:" +
                "usuario='" + usuario + '\'' +
                ", dni='" + dni + '\'' +
                ", nombreCompleto='" + nombreCompleto + '\'' +
                '.';
    }


    public void pagarReserva(Reserva reserva){
        reserva.setEstado("Pagado");
    }




}
