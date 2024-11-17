package Clases;

import com.sun.source.tree.WhileLoopTree;

import java.util.*;

public class Gestion {
    private Map<String, Administrador> Administradores;
    private Map<String, Cliente> Clientes;
    private Map<String, Anfitrion> Anfitriones;
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
    public void inicio_de_sesion() throws UsuarioNoExisteException, ContraseñaIncorrectaException{
            System.out.println("¡Bienvenido a (nombre de la app)!");
            System.out.println("Seleccione la una de las siguientes opciones:\n" +
                    "\n1- Iniciar sesion como administrador." +
                    "\n2- Iniciar sesion como cliente." +
                    "\n3- Iniciar sesion como anfitrion." +
                    "\n4- Registrarse como cliente." +
                    "\n5- Registrarse como anfitrion.");

            int opcion = scanner.nextInt();
            String usuario, contrasenia;
            boolean flag = false;
            switch (opcion){

                ///INICIO DE SESION DE ADMINISTRADOR
                case 1:
                    System.out.println("------ADMINISTRADOR------");
                    while (!flag){
                        try {
                            System.out.print("Ingrese su nombre de usuario: ");
                            usuario = scanner.nextLine();
                            if(!Administradores.containsKey(usuario)){
                                throw new UsuarioNoExisteException("Su usuario no se encuentra en nuestra base de datos de administradores.");
                            }
                            Administrador adminLogeado = Administradores.get(usuario);
                            System.out.println("Ingrese su contraseña:");
                            contrasenia = scanner.nextLine();
                            if(adminLogeado.getContrasenia().compareTo(contrasenia) != 0){
                                throw new ContraseñaIncorrectaException("Su contraseña es incorrecta.");
                            }else {
                                flag = true;
                            }
                        }catch (UsuarioNoExisteException ex){
                            System.out.println(ex.getMessage());
                        }catch (ContraseñaIncorrectaException ex2){
                            System.out.println(ex2.getMessage());
                        }
                    }
                    System.out.println("¡Sesion iniciada con éxito!");
                    //MENU DE ADMINISTRADORES

                    break;

                ///INICIO DE SESION DE CLIENTE
                case 2:
                    System.out.println("------CLIENTE------");
                    while (!flag){
                        try {
                            System.out.print("Ingrese su nombre de usuario: ");
                            usuario = scanner.nextLine();
                            if(!Clientes.containsKey(usuario)){
                                throw new UsuarioNoExisteException("Su usuario no se encuentra en nuestra base de datos de clientes.");
                            }
                            Cliente clienteLogeado = Clientes.get(usuario);
                            System.out.println("Ingrese su contraseña:");
                            contrasenia = scanner.nextLine();
                            if(clienteLogeado.getContrasenia().compareTo(contrasenia) != 0){
                                throw new ContraseñaIncorrectaException("Su contraseña es incorrecta.");
                            }else {
                                flag = true;
                            }
                        }catch (UsuarioNoExisteException ex){
                            System.out.println(ex.getMessage());
                        }catch (ContraseñaIncorrectaException ex2){
                            System.out.println(ex2.getMessage());
                        }
                    }
                    System.out.println("¡Sesion iniciada con éxito!");
                    //MENU DE CLIENTES

                    break;

                ///INICIO DE SESION DE ANFITRION
                case 3:
                    System.out.println("------ANFITRION------");
                    while (!flag){
                        try {
                            System.out.print("Ingrese su nombre de usuario: ");
                            usuario = scanner.nextLine();
                            if(!Anfitriones.containsKey(usuario)){
                                throw new UsuarioNoExisteException("Su usuario no se encuentra en nuestra base de datos de anfitriones.");
                            }
                            Anfitrion anfitrionLogeado = Anfitriones.get(usuario);
                            System.out.println("Ingrese su contraseña:");
                            contrasenia = scanner.nextLine();
                            if(anfitrionLogeado.getContrasenia().compareTo(contrasenia) != 0){
                                throw new ContraseñaIncorrectaException("Su contraseña es incorrecta.");
                            }else {
                                flag = true;
                            }
                        }catch (UsuarioNoExisteException ex){
                            System.out.println(ex.getMessage());
                        }catch (ContraseñaIncorrectaException ex2){
                            System.out.println(ex2.getMessage());
                        }
                    }
                    System.out.println("¡Sesion iniciada con éxito!");
                    //MENU DE ANFITRIONES

                    break;
            }

        }

        public void cargarAdministrador(Administrador administrador){
            Administradores.put(administrador.getUsuario(), administrador);
        }

        public void bajaAdministrador(String usuario){
        Administradores.remove(usuario);
        }

        public void cargarCliente(Cliente cliente){
            Clientes.put(cliente.getUsuario(), cliente);
        }

        public void bajaCliente(String usuario){
            Clientes.remove(usuario);
        }

        public void cargarAnfitrion(Anfitrion anfitrion){
            Anfitriones.put(anfitrion.getUsuario(), anfitrion);
        }

        public void bajaAnfitrion(String usuario){
            Anfitriones.remove(usuario);
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

                Alojamientos.add(casa);
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

                Alojamientos.add(depto);
                System.out.println("Clases.Alojamiento creado y listado exitosamente!");
            }
            else {
                System.out.println("Cancelado.");
            }
        }

        public void mostrar_alojamientos(){
            for (Alojamiento alojamiento:Alojamientos){
                if (alojamiento instanceof Casa) {
                    System.out.println(((Casa) alojamiento).toString());
                }
                else {
                    System.out.println(((Departamento) alojamiento).toString());
                }
            }
        }
    }

