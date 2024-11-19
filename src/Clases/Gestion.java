package Clases;

import java.time.LocalDate;
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
    public void inicio_de_sesion() throws UsuarioNoExisteException, ContraseniaIncorrectaException {
        System.out.println("\n\n------------------------------------");
        System.out.println("¡Bienvenido a Alquileres Patagonia!");
        boolean programa = true;
        while (programa) {
            System.out.println("------------------------------------");
            System.out.println("\n------INICIO DE SESION------\n");
            System.out.println("Seleccione una de las siguientes opciones:" +
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
                    System.out.println("------------------------------------");
                    System.out.println("------ADMINISTRADOR------");
                    Administrador adminLogeado = new Administrador();
                    while (!flag) {
                        try {
                            System.out.print("\nIngrese su nombre de usuario o ingrese 1 para volver al menu principal: ");
                            usuario = scanner.nextLine();
                            if (usuario.compareTo("1") == 0) {
                                flag = true;
                                break;
                            } else if (!Administradores.containsKey(usuario)) {
                                throw new UsuarioNoExisteException("Su usuario no se encuentra en nuestra base de datos de administradores.");
                            }
                            adminLogeado = Administradores.get(usuario);
                            System.out.println("Ingrese su contraseña:");
                            contrasenia = scanner.nextLine();
                            if (adminLogeado.getContrasenia().compareTo(contrasenia) != 0) {
                                throw new ContraseniaIncorrectaException("Su contraseña es incorrecta.");
                            } else {
                                System.out.println("\n--------¡Sesion iniciada con éxito!--------\n");
                                flag = true;
                            }
                        } catch (UsuarioNoExisteException ex) {
                            System.out.println(ex.getMessage());
                        } catch (ContraseniaIncorrectaException ex2) {
                            System.out.println(ex2.getMessage());
                        }
                    }

                    //MENU DE ADMINISTRADORES
                    if (usuario.compareTo("1") != 0) {
                        menuAdministrador(adminLogeado);
                    }

                    break;

                ///INICIO DE SESION DE CLIENTE
                case 2:
                    System.out.println("------------------------------------");
                    System.out.println("------CLIENTE------");
                    Cliente clienteLogeado = new Cliente();
                    while (!flag) {
                        try {
                            System.out.print("\nIngrese su nombre de usuario o ingrese 1 para volver al menu principal: ");
                            usuario = scanner.nextLine();
                            if (usuario.compareTo("1") == 0) {
                                flag = true;
                                break;
                            } else if (!Clientes.containsKey(usuario)) {
                                throw new UsuarioNoExisteException("Su usuario no se encuentra en nuestra base de datos de clientes.");
                            }
                            clienteLogeado = Clientes.get(usuario);
                            System.out.println("Ingrese su contraseña:");
                            contrasenia = scanner.nextLine();
                            if (clienteLogeado.getContrasenia().compareTo(contrasenia) != 0) {
                                throw new ContraseniaIncorrectaException("Su contraseña es incorrecta.");
                            } else {
                                System.out.println("\n--------¡Sesion iniciada con éxito!--------\n");
                                flag = true;
                            }
                        } catch (UsuarioNoExisteException ex) {
                            System.out.println(ex.getMessage());
                        } catch (ContraseniaIncorrectaException ex2) {
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
                    System.out.println("------------------------------------");
                    System.out.println("------ANFITRION------");
                    Anfitrion anfitrionLogeado = new Anfitrion();
                    while (!flag) {
                        try {
                            System.out.print("\nIngrese su nombre de usuario o ingrese 1 para volver al menu principal: ");
                            usuario = scanner.nextLine();
                            if (usuario.compareTo("1") == 0) {
                                flag = true;
                                break;
                            } else if (!Anfitriones.containsKey(usuario)) {
                                throw new UsuarioNoExisteException("Su usuario no se encuentra en nuestra base de datos de anfitriones.");
                            }
                            anfitrionLogeado = Anfitriones.get(usuario);
                            System.out.println("Ingrese su contraseña:");
                            contrasenia = scanner.nextLine();
                            if (anfitrionLogeado.getContrasenia().compareTo(contrasenia) != 0) {
                                throw new ContraseniaIncorrectaException("Su contraseña es incorrecta.");
                            } else {
                                System.out.println("\n--------¡Sesion iniciada con éxito!--------\n");
                                flag = true;
                            }
                        } catch (UsuarioNoExisteException ex) {
                            System.out.println(ex.getMessage());
                        } catch (ContraseniaIncorrectaException ex2) {
                            System.out.println(ex2.getMessage());
                        }
                    }

                    //MENU ANFITRIONES
                    if (usuario.compareTo("1") != 0) {
                        System.out.println("-----MENU ANFITRION-----");
                        System.out.println("Seleccione una de las siguientes opciones: \n" +
                                "\n1- Agregar alojamiento." +
                                "\n2- Eliminar alojamiento." +
                                "\n3- Ver alojamientos propios." +
                                "\n4- Ver todos los alojamientos.");

                        int opcionanf = scanner.nextInt();

                        switch (opcionanf) {
                            case 1:
                                anfitrionLogeado.agregarAlojamiento(Alojamientos);
                                break;
                            case 2:

                                break;
                        }
                    }

                    break;

                /// CREACION DE USUARIO CLIENTE
                case 4:
                    Cliente clienteNuevo = new Cliente();
                    System.out.println("\n------------------------------------");
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
                    System.out.println("\n------------------------------------");
                    System.out.println("------ANFITRION NUEVO------");
                    //Pedimos los datos

                    while (usuarioExistente) {
                        try {
                            System.out.println("\nIngrese su usuario:");
                            nombreUsuario = scanner.nextLine();
                            if (Anfitriones.containsKey(nombreUsuario)) {
                                throw new UsuarioYaExistenteException("Este usuario ya existe en nuestra base de datos, por favor seleccine otro.");
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
    public void mostrar_alojamientos() {
        System.out.println("---------ALOJAMIENTOS---------");

        for (Alojamiento alojamiento : Alojamientos) {
            if (alojamiento instanceof Casa) {
                System.out.println(((Casa) alojamiento).toString());
            } else {
                System.out.println(((Departamento) alojamiento).toString());
            }
        }
    }

    //ADMINISTRADORES
    public void cargarAdministrador(Administrador administrador) {
        Administradores.put(administrador.getUsuario(), administrador);
    }

    public void bajaAdministrador() {
        String usuario = "";
        try {
            System.out.println("Ingrese el nombre del usuario que desea eliminar:");
            usuario = scanner.nextLine();
            if (!Administradores.containsKey(usuario)) {
                throw new UsuarioNoExisteException("Este usuario no existe en nuestra base de datos.");
            }else{
                Administradores.remove(usuario);
                System.out.println("Usuario eliminado con éxito.");
            }
        }catch (UsuarioNoExisteException e){
            System.out.println(e.getMessage());
        }
    }

    //CLIENTES
    public void cargarCliente(Cliente cliente) {
        Clientes.put(cliente.getUsuario(), cliente);
    }

    public void bajaCliente() {
        String usuario = "";
        try {
            System.out.println("Ingrese el nombre del usuario que desea eliminar:");
            usuario = scanner.nextLine();
            if (!Clientes.containsKey(usuario)) {
                throw new UsuarioNoExisteException("Este usuario no existe en nuestra base de datos.");
            }else{
                Clientes.remove(usuario);
                System.out.println("Usuario eliminado con éxito.");
            }
        }catch (UsuarioYaExistenteException e){
            System.out.println(e.getMessage());
        }
    }

    //ANFITRIONES
    public void cargarAnfitrion(Anfitrion anfitrion) {
        Anfitriones.put(anfitrion.getUsuario(), anfitrion);
    }

    public void bajaAnfitrion() {
        String usuario = "";
        try {
            System.out.println("Ingrese el nombre del usuario que desea eliminar:");
            usuario = scanner.nextLine();
            if (!Anfitriones.containsKey(usuario)) {
                throw new UsuarioNoExisteException("Este usuario no existe en nuestra base de datos.");
            }else{
                Anfitriones.remove(usuario);
                System.out.println("Usuario eliminado con éxito.");
            }
        }catch (UsuarioNoExisteException e){
            System.out.println(e.getMessage());
        }
    }

    ///METODOS DE MENU
    //MENU CLIENTE
    public void mostrar_departamentos(int cantPersonas, boolean comparte) {
        for (Alojamiento alojamiento : Alojamientos) {
            if (alojamiento instanceof Departamento && alojamiento.isEstado() && alojamiento.puedeHospedar(cantPersonas)&& alojamiento.isEs_compartible()== comparte) {
                System.out.println(((Departamento) alojamiento).toString());
            }
        }
    }

    public void mostrar_casa(int cantPersonas, boolean comparte) {
        for (Alojamiento alojamiento : Alojamientos) {
            if (alojamiento instanceof Casa && alojamiento.isEstado() && alojamiento.puedeHospedar(cantPersonas)&& alojamiento.isEs_compartible()== comparte) {
                    System.out.println(((Casa) alojamiento).toString());
            }
        }
    }

    public void menuCliente(Cliente cliente)throws NoSeEncontroExeption {
        boolean sesion = true;
        int opcion = 0;
        while (sesion) {
            System.out.println("1 - HACE TU RESERVA!" +
                    "\n2 - ALOJAMIENTOS." +
                    "\n3 - PERSONAL." +
                    "\n4 - CAMBIAR CONTRASEÑA." +
                    "\n5 - CERRAR SESION.");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("----HACER RESERVA----");
                    hacerReserva(cliente);
                    break;
                case 2:
                    System.out.println("----ALOJAMIENTOS----");
                    mostrar_alojamientos();
                    break;
                case 3:
                    System.out.println("----PERSONAL----");
                    cliente.toString();
                    break;
                case 4:
                    System.out.println("----CAMBIAR CONTRASEÑA----");
                    cliente.cambiarContrasenia();
                    break;
                case 5:
                    System.out.println("Cerrando sesion...");
                    sesion = false;
                    break;
                default:
                    System.out.println("Por favor, ingrese una opción válida");
                    break;
            }
        }
    }

    public void hacerReserva(Cliente cliente){
        int tipo, cantPersonas, numA, finalizar;
        boolean comparte, hacerReserva = true, alojamientoEncontrado;
        String SiNo;
        System.out.println("DESDE: (AAAA-MM-DD)");
        LocalDate inicio = LocalDate.parse(scanner.nextLine());
        System.out.println("HASTA: (AAAA-MM-DD)");
        LocalDate fin = LocalDate.parse(scanner.nextLine());
        for (Alojamiento alojamiento : Alojamientos) {
            alojamiento.verificaDisponibilidad(inicio, fin);
        }
        System.out.println("CANTIDAD DE PERSONAS:");
        cantPersonas = scanner.nextInt();
        scanner.nextLine();
        System.out.println("¿desea compartir el alojamiento?(SI/NO)");
        SiNo = scanner.nextLine();
        if(SiNo.equalsIgnoreCase("si")){
            comparte=true;
        }else {
            comparte=false;
        }
        System.out.println("\n ¿Donde se quiere hospedar? 1-CASA | 2-DEPARTAMENTO");
        tipo = scanner.nextInt();
        scanner.nextLine();
        switch (tipo) {
            case 1:
                mostrar_casa(cantPersonas, comparte);
                break;
            case 2:
                mostrar_departamentos(cantPersonas, comparte);
                break;
            default:
                System.out.println("Opcion no valida");
                hacerReserva = false;
                break;
        }
        if (hacerReserva) {
            System.out.println("Ingrese el numero del alojamiento");
            numA = scanner.nextInt();
            scanner.nextLine();
            try {

                alojamientoEncontrado = false;
                for (Alojamiento alojamiento : Alojamientos) {
                    if (alojamiento.getIdentificador() == numA) {
                        alojamientoEncontrado = true;
                        System.out.println();
                        System.out.println(" 1-FINALIZAR Y PAGAR | 2-CANCELAR");
                        finalizar = scanner.nextInt();
                        scanner.nextLine();

                        if (finalizar == 1) {
                            Reserva reservaNueva = new Reserva(alojamiento, cliente, inicio, fin, comparte, cantPersonas);
                            alojamiento.agregarReserva(reservaNueva);
                            alojamiento.agregarHuespedes(cliente,cantPersonas);
                            cliente.agregarReservaAlHistorial(reservaNueva);
                            cliente.pagarReserva(reservaNueva);
                            System.out.println("Reserva creada con exito");
                            System.out.println(reservaNueva.toString());
                        } else {
                            System.out.println("Su reserva fue cancelada");
                        }
                        break;
                    }

                }
                if (!alojamientoEncontrado) {
                    throw new NoSeEncontroExeption("No se encontro el alojamiento");
                }
            }catch (NoSeEncontroExeption ex){
                System.out.println(ex.getMessage());
            }
        }
    }
    
    //MENU ADMINISTRADORES
    public void menuAdministrador(Administrador administrador) {
        boolean sesion = true;
        int opcion = 0;
        while (sesion) {
            System.out.println("------------------------------------");
            System.out.println("\n1 - VER ALOJAMIENTOS." +
                    "\n2 - AGREGAR ALOJAMIENTO." +
                    "\n3 - ELIMINAR ALOJAMIENTO." +
                    "\n4 - ELIMINAR CLIENTE." +
                    "\n5 - ELIMINAR ANFITRION." +
                    "\n6 - ELIMINAR RESERVA." +
                    "\n7 - CAMBIAR CONTRASEÑA." +
                    "\n8 - CERRAR SESION.");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    mostrar_alojamientos();
                    break;

                case 2:

                    break;

                case 3:

                    break;

                case 4:
                    bajaCliente();
                    break;

                case 5:
                    bajaAnfitrion();
                    break;

                case 6:

                    break;

                case 7:
                    administrador.cambiarContrasenia();
                    break;

                case 8:
                    System.out.println("Cerrando sesion...");
                    sesion = false;
                    break;

                default:
                    System.out.println("Por favor, ingrese una opción válida");
                    break;
            }
        }
    }
}
