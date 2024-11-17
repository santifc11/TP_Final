package Clases;

import com.sun.source.tree.WhileLoopTree;

import java.util.*;

public class Gestion {
    private Map<String, Administrador> Administradores;
    private Map<String, Cliente> Clientes;
    private Set<Reserva> Reservas;
    private Set<Alojamiento> Alojamientos;

    ///CONSTRUCTOR
    public Gestion() {
        this.Administradores = new Hashtable<>();
        this.Clientes = new Hashtable<>();
        this.Reservas = new TreeSet<>();
        this.Alojamientos = new TreeSet<>();
    }

    Scanner scanner = new Scanner(System.in);

    ///MODELO DE PRUEBA, GESTION
    public void inicio_de_sesion(){
            System.out.println("¡Bienvenido a (nombre de la app)!");
            System.out.println("Seleccione la una de las siguientes opciones:\n" +
                    "\n1- Iniciar sesion como administrador." +
                    "\n2- Iniciar sesion como cliente." +
                    "\n3- Registrarse como cliente." +
                    "\n4- Iniciar sesion como anfitrion.");

            int opcion = scanner.nextInt();
            String usuario, contrasenia;
            switch (opcion){
                case 1:
                    boolean flag = false;
                    while (!flag){
                        try {
                            System.out.print("Ingrese su nombre de usuario: ");
                            usuario = scanner.nextLine();
                        }catch ()
                        System.out.println("Ingrese su contraseña:");
                        contrasenia = scanner.nextLine();
                        if (){
                    }
                    break;
            }

        }

        public void agregar_alojamiento(){
            //pedir los atributos al usuario. Saber si es Clases.Casa o Clases.Departamento.
            int tipo_alojamiento=0;
            System.out.println("El alojamiento que desea ingresar es:\n1-Clases.Casa.\n2-Clases.Departamento\n0-Cancelar.");
            if (tipo_alojamiento==1){

                //Pido los datos de la Clases.Casa.

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
                System.out.println();
                System.out.print("Ingrese el piso en el que esta ubicada la propiedad: ");
                int piso = scanner.nextInt();
                System.out.println();

                //Creo el objeto Clases.Departamento.

                Departamento depto = new Departamento(nombre, ubicacion, precioXnoche, aforo, compartible, piso);

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

