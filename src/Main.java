import Clases.Gestion;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Gestion admin1 = new Gestion();
        System.out.print("Desea cargar un alojamiento? (s/n): ");
        char carga = scanner.next().charAt(0);
        if (carga == 's'){
            admin1.agregar_alojamiento();
        }
        else {
            System.out.println("Fin de la carga.");
        }

        System.out.print("Desea mostrar los alojamientos cargados? (s/n): ");
        char mostrar = scanner.next().charAt(0);
        if (mostrar == 's'){
            admin1.mostrar_alojamientos();
        }
    }

    // prueba actualizacion branch.
}
