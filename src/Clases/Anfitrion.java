package Clases;

import org.json.JSONException;
import org.json.JSONObject;

import javax.swing.plaf.basic.BasicDesktopIconUI;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

public final class Anfitrion implements Sesion,JsonConvertible{
    private String usuario, nombre, contrasenia;

    ///CONSTRUCTOR
    public Anfitrion() {
    }

    public Anfitrion(String usuario, String nombre, String contrasenia) {
        this.usuario = usuario;
        this.nombre = nombre;
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

    ///SETTER Y GETTERS
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    ///EQUALS, HASHCODE Y TO STRING
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Anfitrion anfitrion = (Anfitrion) o;
        return Objects.equals(usuario, anfitrion.usuario);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(usuario);
    }

    @Override
    public String toString() {
        return "Anfitrion{" +
                "nombre='" + nombre + '\'' +
                ", usuario='" + usuario + '\'' +
                '}';
    }

    @Override
    public JSONObject toJson() {
        JSONObject jsonObject=new JSONObject();

        jsonObject.put("usuario", this.usuario);
        jsonObject.put("contrasenia", this.contrasenia);
        jsonObject.put("nombre", this.nombre);

        return jsonObject;
    }

    @Override
    public void fromJson(JSONObject jsonObject) {
        try {
            this.setUsuario(jsonObject.getString("usuario"));
            this.setContrasenia(jsonObject.getString("contrasenia"));
            this.setNombre(jsonObject.getString("nombre"));
        } catch (JSONException e) {
            System.out.println(e.getMessage());
        }
    }
}
