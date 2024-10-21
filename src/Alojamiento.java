import java.util.Objects;
import java.util.UUID;

public abstract class Alojamiento {
    private UUID id;
    private String nombre;
    private String ubicacion;
    private double precioXnoche;
    private int aforo;
    private boolean tiene_wifi;
    private boolean es_compartible;

    public Alojamiento(String nombre, String ubicacion, double precioXnoche, int aforo, boolean tiene_wifi, boolean es_compartible) {
        this.id = UUID.randomUUID();
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.precioXnoche = precioXnoche;
        this.aforo = aforo;
        this.tiene_wifi = tiene_wifi;
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

    public boolean isTiene_wifi() {
        return tiene_wifi;
    }

    public void setTiene_wifi(boolean tiene_wifi) {
        this.tiene_wifi = tiene_wifi;
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
}
