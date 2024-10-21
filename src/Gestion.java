import java.util.Scanner;

public class Gestion {

        public void inicio_de_sesion(){
            System.out.println("Bienvenido a - nombre de la app ;) -!");
            System.out.println();
            System.out.println("Seleccione la una de las siguientes opciones:\n\n1- Iniciar sesion como administrador.\n2- Iniciar sesion como cliente.\n3- Registrarse como cliente.");
            Scanner scanner = new Scanner(System.in);
            int opcion = scanner.nextInt();
            String usuario;
            String contrasenia;

            switch (opcion){
                case 1:
                    System.out.print("Ingrese su nombre de usuario: ");
                    usuario = scanner.nextLine();
                    System.out.println("Contrasena: ");
                    contrasenia = scanner.nextLine();

                    if (){

                    }

                    break;
            }

        }

        public void menu_principal(){

        }
    }

