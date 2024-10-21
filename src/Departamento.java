public class Departamento extends Alojamiento{
    private boolean tiene_ascensor;
    private int piso;
    private int tiene_terraza;

    public Departamento(String nombre, String ubicacion, double precioXnoche, int aforo, boolean tiene_wifi, boolean es_compartible, int tiene_terraza, int piso, boolean tiene_ascensor) {
        super(nombre, ubicacion, precioXnoche, aforo, tiene_wifi, es_compartible);
        this.tiene_terraza = tiene_terraza;
        this.piso = piso;
        this.tiene_ascensor = tiene_ascensor;
    }

    public boolean isTiene_ascensor() {
        return tiene_ascensor;
    }

    public void setTiene_ascensor(boolean tiene_ascensor) {
        this.tiene_ascensor = tiene_ascensor;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public int getTiene_terraza() {
        return tiene_terraza;
    }

    public void setTiene_terraza(int tiene_terraza) {
        this.tiene_terraza = tiene_terraza;
    }
}
