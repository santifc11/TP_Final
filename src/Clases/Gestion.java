package Clases;

import java.util.*;

public class Gestion {
    private Set<Alojamiento> alojamientos;

    public Gestion() {
        this.alojamientos = new HashSet<>();
    }

    Scanner scanner = new Scanner(System.in);

    /*public void inicio_de_sesion(){
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
                                        //inicio de sesion
                    }

                    break;
            }

        }*/

        public void agregar_alojamiento(){
            //pedir los atributos al usuario. Saber si es Clases.Casa o Clases.Departamento.
            int tipo_alojamiento;
            do {
                System.out.println("El alojamiento que desea ingresar es:\n1-Casa.\n2-Departamento\n0-Cancelar.");
                tipo_alojamiento= scanner.nextInt();
                scanner.nextLine();
            } while ((tipo_alojamiento>2)&&(tipo_alojamiento<0));
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
                scanner.nextLine();
                System.out.println();
                System.out.print("Ingrese el aforo de la propiedad: ");
                int aforo = scanner.nextInt();
                scanner.nextLine();
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

                //Pido los datos del Departamento

                System.out.print("Nombre de la propiedad: ");
                String nombre = scanner.nextLine();
                System.out.println();
                System.out.print("Ingrese la ubicacion: ");
                String ubicacion = scanner.nextLine();
                System.out.println();
                System.out.print("Ingrese el precio por noche: ");
                double precioXnoche = scanner.nextDouble();
                scanner.nextLine();
                System.out.println();
                System.out.print("Ingrese el aforo de la propiedad: ");
                int aforo = scanner.nextInt();
                scanner.nextLine();
                System.out.println();
                System.out.print("La propiedad es apta para ser compartida? (true/false): ");
                boolean compartible = scanner.nextBoolean();
                scanner.nextLine();
                System.out.println();
                System.out.print("Ingrese el piso en el que esta ubicada la propiedad: ");
                int piso = scanner.nextInt();
                scanner.nextLine();
                System.out.println();

                //Creo el objeto Departamento.

                Departamento depto = new Departamento(nombre, ubicacion, precioXnoche, aforo, compartible, piso);

                //Pido la descripcion del Departamento

                depto.pedir_descripcion();

                //Guardo el alojamiento en la Lista

                alojamientos.add(depto);
                System.out.println("Clases.Alojamiento creado y listado exitosamente!");
            }
            else {
                System.out.println("Cancelado.");
            }
        }

        public void mostrar_alojamientos(){
            for (Alojamiento alojamiento:alojamientos){
                if (alojamiento instanceof Casa) {
                    System.out.println(((Casa) alojamiento).toString());
                }
                else {
                    System.out.println(((Departamento) alojamiento).toString());
                }
            }
        }
    }

