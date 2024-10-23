public class Casa extends Alojamiento{
    public Casa(String nombre, String ubicacion, double precioXnoche, int aforo, String[] descripcion, boolean es_compartible) {
        super(nombre, ubicacion, precioXnoche, aforo, descripcion, es_compartible);
    }

    @Override
    public String toString() {
        return "Casa: " + super.toString();
    }
}
