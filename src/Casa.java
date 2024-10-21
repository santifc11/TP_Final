public class Casa extends Alojamiento{
    private int num_pisos;
    private boolean tiene_patio;

    public Casa(String nombre, String ubicacion, double precioXnoche, int aforo, boolean tiene_wifi, boolean es_compartible,int num_pisos, boolean tiene_patio) {
        super(nombre, ubicacion, precioXnoche, aforo, tiene_wifi, es_compartible);
        this.num_pisos = num_pisos;
        this.tiene_patio = tiene_patio;
    }

    public int getNum_pisos() {
        return num_pisos;
    }

    public void setNum_pisos(int num_pisos) {
        this.num_pisos = num_pisos;
    }

    public boolean isTiene_patio() {
        return tiene_patio;
    }

    public void setTiene_patio(boolean tiene_patio) {
        this.tiene_patio = tiene_patio;
    }
}
