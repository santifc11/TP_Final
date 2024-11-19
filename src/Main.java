import Clases.*;

public class Main {
    public static void main(String[] args) {
        Administrador admin1 = new Administrador("TiagoJaen", "1234");
        Administrador admin2 = new Administrador("FelipeCliment", "1234");
        Administrador admin3 = new Administrador("SantiagoFernandez", "1234");
        Administrador admin4 = new Administrador("CarolinaArchuby", "1234");
        Administrador admin5 = new Administrador("NahuelBianca", "1234");

        Casa casa1 =new Casa("Campestre","San Manuel",30000,6,true);
        Casa casa2 =new Casa("Moderna","Bs.As",80000,5,false);
        Casa casa3 =new Casa("Playera","Necochea",40000,2,true);

        Departamento departamento1=new Departamento("prueba","mardel",12000,5,true,19);

        Gestion gestion = new Gestion();

        gestion.cargarAdministrador(admin1);
        gestion.cargarAdministrador(admin2);
        gestion.cargarAdministrador(admin3);
        gestion.cargarAdministrador(admin4);
        gestion.cargarAdministrador(admin5);

        

        gestion.inicio_de_sesion();

    }
}
