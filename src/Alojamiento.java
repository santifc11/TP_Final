import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
import java.util.UUID;

public abstract class Alojamiento {
    private final UUID id;
    private String nombre;
    private String ubicacion;
    private double precioXnoche;
    private int aforo;
    private static String[] descripcion;
    private boolean es_compartible;

    public Alojamiento(String nombre, String ubicacion, double precioXnoche, int aforo, String[] descripcion, boolean es_compartible) {
        this.id = UUID.randomUUID();
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.precioXnoche = precioXnoche;
        this.aforo = aforo;
        this.descripcion = descripcion;
        this.es_compartible = es_compartible;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public double getPrecioXnoche() {
        return precioXnoche;
    }

    public void setPrecioXnoche(double precioXnoche) {
        this.precioXnoche = precioXnoche;
    }

    public int getAforo() {
        return aforo;
    }

    public void setAforo(int aforo) {
        this.aforo = aforo;
    }

    public String[] getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String[] descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isEs_compartible() {
        return es_compartible;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Alojamiento that)) return false;
        return Objects.equals(id, that.id) && Objects.equals(nombre, that.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return  "Nombre :'" + nombre + "\n" +
                "Ubicacion: '" + ubicacion + "\n" +
                "Precio por noche: " + precioXnoche +"\n"+
                "Aforo: " + aforo +"\n"+
                "Descripcion y Caracteristicas: " + Arrays.toString(descripcion)+"\n";
    }

    //Metodos propios

    Scanner scanner = new Scanner(System.in);

    public void pedir_descripcion(){

        int control = 0, validos = 0;
        System.out.println("Ingrese las caracteristicas del alojamiento.");
        do {
            descripcion[validos] = scanner.nextLine();                      //VER SI SE PUEDE HACER CON UN StringBuilder
            validos++;
            System.out.println("Desea continuar cargando caracteristicas? (0 para finalizar)");
            control = scanner.nextInt();
        } while(control!=0);
    }
}
