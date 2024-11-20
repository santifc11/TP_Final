package Clases;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Objects;
import java.util.Scanner;

public class Administrador implements Sesion, JsonConvertible{
    private String usuario = "";
    private String contrasenia = "";

    ///CONSTRUCTOR
    public Administrador() {
    }

    public Administrador(String usuario, String contrasenia) {
    this.usuario = usuario;
    this.contrasenia = contrasenia;
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

    ///EQUALS, HASHCODE Y TO STRING
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Administrador that = (Administrador) o;
        return Objects.equals(usuario, that.usuario);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(usuario);
    }

    @Override
    public String toString() {
        return "Administrador{" +
                "usuario='" + usuario + '\'' +
                '}';
    }

    @Override
    public JSONObject toJson() {
        JSONObject jsonObject=new JSONObject();

        jsonObject.put("usuario", this.usuario);
        jsonObject.put("contrasenia", this.contrasenia);

        return jsonObject;
    }

    @Override
    public void fromJson(JSONObject jsonObject) {
        try {
            this.setUsuario(jsonObject.getString("usuario"));
            this.setContrasenia(jsonObject.getString("contrasenia"));
        } catch (JSONException e) {
            System.out.println(e.getMessage());
        }
    }
}
