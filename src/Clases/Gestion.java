package Clases;

import com.sun.source.tree.WhileLoopTree;

import java.sql.SQLOutput;
import java.util.*;

public class Gestion {
    private Map<String, Administrador> Administradores;
    private Map<String, Cliente> Clientes;
    private Map<String, Anfitrion> Anfitriones;
    private Set<Reserva> Reservas;
    private Set<Alojamiento> Alojamientos;

    ///CONSTRUCTOR
    public Gestion() {
        this.Anfitriones = new Hashtable<>();
        this.Administradores = new Hashtable<>();
        this.Clientes = new Hashtable<>();
        this.Reservas = new TreeSet<>();
        this.Alojamientos = new TreeSet<>();
    }

    Scanner scanner = new Scanner(System.in);

    ///INICIO DE SESION
    public void inicio_de_sesion() throws UsuarioNoExisteException, ContraseñaIncorrectaException{
        System.out.println("\n\n¡Bienvenido a Alquileres Patagonia!");
        boolean programa = true;
        while (programa) {
            System.out.println("\nSeleccione la una de las siguientes opciones:\n" +
                    "\n1- Iniciar sesion como administrador." +
                    "\n2- Iniciar sesion como cliente." +
                    "\n3- Iniciar sesion como anfitrion." +
                    "\n4- Registrarse como cliente." +
                    "\n5- Registrarse como anfitrion." +
                    "\n6- Cerrar programa.");

            int opcion = scanner.nextInt();
            scanner.nextLine();
            String usuario = "", contrasenia = "", nombreUsuario = "";
            boolean flag = false, usuarioExistente = true;
            switch (opcion) {

                ///INICIO DE SESION DE ADMINISTRADOR
                case 1:
                    System.out.println("------ADMINISTRADOR------");
                    Administrador adminLogeado = new Administrador();
                    while (!flag) {
                        try {
                            System.out.print("\nIngrese su nombre de usuario o ingrese 1 para volver al menu principal: ");
                            usuario = scanner.nextLine();
                            if(usuario.compareTo("1") == 0){
                                flag = true;
                                break;
                            }else if (!Administradores.containsKey(usuario)) {
                                throw new UsuarioNoExisteException("Su usuario no se encuentra en nuestra base de datos de administradores.");
                            }
                            adminLogeado = Administradores.get(usuario);
                            System.out.println("Ingrese su contraseña:");
                            contrasenia = scanner.nextLine();
                            if (adminLogeado.getContrasenia().compareTo(contrasenia) != 0) {
                                throw new ContraseñaIncorrectaException("Su contraseña es incorrecta.");
                            } else {
                                System.out.println("\n--------¡Sesion iniciada con éxito!--------\n");
                                flag = true;
                            }
                        } catch (UsuarioNoExisteException ex) {
                            System.out.println(ex.getMessage());
                        } catch (ContraseñaIncorrectaException ex2) {
                            System.out.println(ex2.getMessage());
                        }
                    }

                    //MENU DE ADMINISTRADORES
                    if (usuario.compareTo("1") != 0) {

                    }

                    break;

                ///INICIO DE SESION DE CLIENTE
                case 2:
                    System.out.println("------CLIENTE------");
                    Cliente clienteLogeado = new Cliente();
                    while (!flag) {
                        try {
                            System.out.print("\nIngrese su nombre de usuario o ingrese 1 para volver al menu principal: ");
                            usuario = scanner.nextLine();
                            if(usuario.compareTo("1") == 0){
                                flag = true;
                                break;
                            }else if (!Clientes.containsKey(usuario)) {
                                throw new UsuarioNoExisteException("Su usuario no se encuentra en nuestra base de datos de clientes.");
                            }
                            clienteLogeado = Clientes.get(usuario);
                            System.out.println("Ingrese su contraseña:");
                            contrasenia = scanner.nextLine();
                            if (clienteLogeado.getContrasenia().compareTo(contrasenia) != 0) {
                                throw new ContraseñaIncorrectaException("Su contraseña es incorrecta.");
                            } else {
                                System.out.println("\n--------¡Sesion iniciada con éxito!--------\n");
                                flag = true;
                            }
                        } catch (UsuarioNoExisteException ex) {
                            System.out.println(ex.getMessage());
                        } catch (ContraseñaIncorrectaException ex2) {
                            System.out.println(ex2.getMessage());
                        }
                    }

                    //MENU DE CLIENTES
                    if (usuario.compareTo("1") != 0) {
                        menuCliente(clienteLogeado);
                    }
                    break;

                ///INICIO DE SESION DE ANFITRION
                case 3:
                    System.out.println("------ANFITRION------");
                    Anfitrion anfitrionLogeado = new Anfitrion();
                    while (!flag) {
                        try {
                            System.out.print("\nIngrese su nombre de usuario o ingrese 1 para volver al menu principal: ");
                            usuario = scanner.nextLine();
                            if(usuario.compareTo("1") == 0){
                                flag = true;
                                break;
                            }else if (!Anfitriones.containsKey(usuario)) {
                                throw new UsuarioNoExisteException("Su usuario no se encuentra en nuestra base de datos de anfitriones.");
                            }
                            anfitrionLogeado = Anfitriones.get(usuario);
                            System.out.println("Ingrese su contraseña:");
                            contrasenia = scanner.nextLine();
                            if (anfitrionLogeado.getContrasenia().compareTo(contrasenia) != 0) {
                                throw new ContraseñaIncorrectaException("Su contraseña es incorrecta.");
                            } else {
                                System.out.println("\n--------¡Sesion iniciada con éxito!--------\n");
                                flag = true;
                            }
                        } catch (UsuarioNoExisteException ex) {
                            System.out.println(ex.getMessage());
                        } catch (ContraseñaIncorrectaException ex2) {
                            System.out.println(ex2.getMessage());
                        }
                    }

                    //MENU DE ANFITRIONES
                    if (usuario.compareTo("1") != 0) {

                    }

                    break;

                /// CREACION DE USUARIO CLIENTE
                case 4:
                    Cliente clienteNuevo = new Cliente();
                    System.out.println("------CLIENTE NUEVO------");
                    //Pedimos los datos

                    while (usuarioExistente) {
                        try {
                            System.out.println("\nIngrese su usuario:");
                            nombreUsuario = scanner.nextLine();
                            if (Clientes.containsKey(nombreUsuario)) {
                                throw new UsuarioNoExisteException("Este usuario ya existe en nuestra base de datos, por favor seleccine otro.");
                            } else {
                                usuarioExistente = false;
                            }
                        } catch (UsuarioYaExistenteException e) {
                            System.out.println(e.getMessage());
                        }
                    }

                    System.out.println("Ingrese su dni:");
                    clienteNuevo.setDni(scanner.nextLine());

                    System.out.println("Ingrese su nombre completo:");
                    clienteNuevo.setNombreCompleto(scanner.nextLine());

                    System.out.println("Ingrese su contraseña:");
                    clienteNuevo.setContrasenia(scanner.nextLine());

                    Clientes.put(nombreUsuario, clienteNuevo);
                    System.out.println("\n--------Usuario creado con éxito--------\n");
                    break;

                /// CREACION DE USUARIO ANFITRION
                case 5:
                    Anfitrion anfitrionNuevo = new Anfitrion();
                    usuarioExistente = true;
                    System.out.println("------ANFITRION NUEVO------");
                    //Pedimos los datos

                    while (usuarioExistente) {
                        try {
                            System.out.println("\nIngrese su usuario:");
                            nombreUsuario = scanner.nextLine();
                            if (Anfitriones.containsKey(nombreUsuario)) {
                                throw new UsuarioNoExisteException("Este usuario ya existe en nuestra base de datos, por favor seleccine otro.");
                            } else {
                                usuarioExistente = false;
                            }
                        } catch (UsuarioYaExistenteException e) {
                            System.out.println(e.getMessage());
                        }
                    }

                    System.out.println("Ingrese su nombre completo:");
                    anfitrionNuevo.setNombre(scanner.nextLine());

                    System.out.println("Ingrese su contraseña:");
                    anfitrionNuevo.setContrasenia(scanner.nextLine());

                    Anfitriones.put(nombreUsuario, anfitrionNuevo);
                    System.out.println("\n--------Usuario creado con éxito--------\n");
                    break;

                case 6:
                    System.out.println("Finalizando programa...");
                    programa = false;
                    break;

                default:
                    System.out.println("Por favor ingrese una opción válida.");
                    break;
                }
            }
        }

        ///METODOS DE LISTAS

        //ALOJAMIENTOS
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

                Casa casa = new Casa(nombre, ubicacion, precioXnoche, aforo, compartible,true);

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

                Departamento depto = new Departamento(nombre, ubicacion, precioXnoche, aforo, compartible, true,piso);

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

        //ADMINISTRADORES
        public void cargarAdministrador(Administrador administrador){
            Administradores.put(administrador.getUsuario(), administrador);
        }

        public void bajaAdministrador(String usuario){
            Administradores.remove(usuario);
        }

        //CLIENTES
        public void cargarCliente(Cliente cliente){
            Clientes.put(cliente.getUsuario(), cliente);
        }

        public void bajaCliente(String usuario){
            Clientes.remove(usuario);
        }

        //ANFITRIONES
        public void cargarAnfitrion(Anfitrion anfitrion){
            Anfitriones.put(anfitrion.getUsuario(), anfitrion);
        }

        public void bajaAnfitrion(String usuario){
            Anfitriones.remove(usuario);
        }

        ///METODOS DE MENU
        //MENU CLIENTE
        public void mostrar_casa(){
            for (Alojamiento alojamiento:Alojamientos){
                if(alojamiento instanceof Casa){
                    System.out.println(((Casa)alojamiento).toString());
                }
            }

        }

        public void mostrar_departamentos(){
            for (Alojamiento alojamiento:Alojamientos){
                if(alojamiento instanceof Departamento){
                    System.out.println(((Departamento)alojamiento).toString());
                }
            }
        }

        public void menuCliente(Cliente cliente){
            boolean sesion = true;
            int opcion = 0;
            while(sesion){
                System.out.println("1 - HACE TU RESERVA." +
                        "2 - ALOJAMIENTOS." +
                        "3 - PERSONAL." +
                        "4 - CAMBIAR CONTRASEÑA." +
                        "5 - CERRAR SESION.");
                opcion = scanner.nextInt();

                switch (opcion){
                    case 1:
                        int tipo;
                        System.out.println("¿Donde te queres hospedar hoy?  1-CASA | 2-DEPARTAMENTO");
                        tipo= scanner.nextInt();
                        if(tipo==1){
                            mostrar_casa();
                        }else {
                            mostrar_departamentos();
                        }

                        break;
                    case 2:

                        break;
                    case 3:

                        break;
                    case 4:

                        break;
                    case 5:
                        System.out.println("Cerrando sesion...");
                        sesion = false;
                        break;

                }


            }
        }
        //MENU ANFITRION

    }

