package Clases;

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

    public void agregarAlojamiento(Set<Alojamiento> alojamientos){
        Scanner scanner = new Scanner(System.in);
        System.out.println("El alojamiento que desea ingresar es:\n1-Clases.Casa.\n2-Clases.Departamento\n0-Cancelar.");
        int tipo_alojamiento = scanner.nextInt();
        scanner.nextLine();
        if (tipo_alojamiento==1){

            //Pido los datos de la Casa.

            System.out.print("Nombre de la propiedad: ");
            String nombre = scanner.nextLine();
            System.out.println();
            System.out.print("Ingrese la ubicacion: ");
            String ubicacion = scanner.nextLine();
            System.out.println();
            System.out.print("Ingrese el precio por noche: ");
            double precioXnoche = scanner.nextDouble();
            System.out.println();
            System.out.print("Ingrese el aforo de la propiedad: ");
            int aforo = scanner.nextInt();
            System.out.println();
            System.out.print("La propiedad es apta para ser compartida? (true/false): ");
            boolean compartible = scanner.nextBoolean();
            scanner.nextLine();
            System.out.println();

            //Creo el objeto con los atributos que ingreso el admin.

            Casa casa = new Casa(nombre, ubicacion, precioXnoche, aforo, compartible);

            //Pido la descripcion del alojamiento.

            casa.pedir_descripcion();

            //Guardo el alojamiento en la Lista.

            alojamientos.add(casa);
            System.out.println("Alojamiendo creado y listado exitosamente!");

        } else if (tipo_alojamiento == 2){

            //Pido los datos del Clases.Departamento

            System.out.print("Nombre de la propiedad: ");
            String nombre = scanner.nextLine();
            System.out.println();
            System.out.print("Ingrese la ubicacion: ");
            String ubicacion = scanner.nextLine();
            System.out.println();
            System.out.print("Ingrese el precio por noche: ");
            double precioXnoche = scanner.nextDouble();
            System.out.println();
            System.out.print("Ingrese el aforo de la propiedad: ");
            int aforo = scanner.nextInt();
            System.out.println();
            System.out.print("La propiedad es apta para ser compartida? (true/false): ");
            boolean compartible = scanner.nextBoolean();
            scanner.nextLine();
            System.out.println();
            System.out.print("Ingrese el piso en el que esta ubicada la propiedad: ");
            int piso = scanner.nextInt();
            System.out.println();

            //Creo el objeto Clases.Departamento.

            Departamento depto = new Departamento(nombre, ubicacion, precioXnoche, aforo, compartible,piso);

            //Pido la descripcion del Clases.Departamento

            depto.pedir_descripcion();

            //Guardo el alojamiento en la Lista

            alojamientos.add(depto);
            System.out.println("Clases.Alojamiento creado y listado exitosamente!");
        }
        else {
            System.out.println("Cancelado.");
        }
    }

    public void eliminarAlojamiento(Set<Alojamiento> alojamientos, int id) {
        Alojamiento alojamientoAEliminar = null;

        for (Alojamiento alojamiento : alojamientos) {
            if (alojamiento.getIdentificador() == id) {
                alojamientoAEliminar = alojamiento;
                break;
            }
        }

        if (alojamientoAEliminar != null) {
            alojamientos.remove(alojamientoAEliminar);
            System.out.println("El alojamiento ha sido eliminado.");
        } else {
            System.out.println("No se encontró un alojamiento con el ID especificado.");
        }
    }

    public void mostrarAlojamientos(Set<Alojamiento> Alojamientos){
        for (Alojamiento alojamiento : Alojamientos) {
            if (alojamiento instanceof Casa) {
                System.out.println(((Casa) alojamiento).toString());
            } else {
                System.out.println(((Departamento) alojamiento).toString());
            }
        }
    }

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
        return null;
    }

    @Override
    public void fromJson(JSONObject jsonObject) {

    }
}
