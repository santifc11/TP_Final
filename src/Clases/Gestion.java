package Clases;

import ArchivosYJSON.OperacionesLectoEscritura;
import org.json.JSONArray;
import org.json.JSONObject;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.*;

public class Gestion implements JsonConvertible{
    ///USAMOS MAP PARA UTILIZAR EL USUARIO COMO CLAVE
    private Map<String, Administrador> Administradores;
    private Map<String, Cliente> Clientes;
    private Map<String, Anfitrion> Anfitriones;
    ///USAMOS SET PARA NO REPETIR ALOJAMIENTOS NI RESERVAS
    private Set<Reserva> Reservas;
    private Set<Alojamiento> Alojamientos;


    ///CONSTRUCTOR
    public Gestion() {
        this.Anfitriones = new Hashtable<>();
        this.Administradores = new Hashtable<>();
        this.Clientes = new Hashtable<>();
        this.Reservas = new LinkedHashSet<>();
        this.Alojamientos = new LinkedHashSet<>();
    }
    Scanner scanner = new Scanner(System.in);

    ///INICIO DE SESION
    public void inicio_de_sesion() throws UsuarioNoExisteException, ContraseniaIncorrectaException {
        OperacionesLectoEscritura operaciones = new OperacionesLectoEscritura();
        JSONObject lecturaDeListas = new JSONObject(operaciones.leer("Base de datos.json"));

        fromJson(lecturaDeListas);

        System.out.println("\n\n------------------------------------");
        System.out.println("¡Bienvenido a Alquileres Patagonia!");
        boolean programa = true;
        while (programa) {
            System.out.println("------------------------------------");
            System.out.println("\n--------INICIO DE SESION--------\n");
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
                    System.out.println("--------ADMINISTRADOR--------");
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
                            System.out.print("Ingrese su contraseña:");
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
                    System.out.println("--------CLIENTE--------");
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
                    System.out.println("--------ANFITRION--------");
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
                                System.out.println("\n---------¡Sesion iniciada con éxito!--------\n");
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
                        menu_anfitrion(anfitrionLogeado);
                    }

                    break;

                /// CREACION DE USUARIO CLIENTE
                case 4:
                    Cliente clienteNuevo = new Cliente();
                    usuarioExistente = true;
                    System.out.println("\n------------------------------------");
                    System.out.println("--------CLIENTE NUEVO--------");
                    //Pedimos los datos

                    while (usuarioExistente) {
                        try {
                            System.out.println("\nIngrese su usuario sin espacios:");
                            nombreUsuario = scanner.nextLine();
                            if (Clientes.containsKey(nombreUsuario)) {
                                throw new UsuarioYaExistenteException("Este usuario ya existe en nuestra base de datos, por favor seleccine otro.");
                            } else {
                                usuarioExistente = false;
                                clienteNuevo.setUsuario(nombreUsuario);
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
                    System.out.println("--------ANFITRION NUEVO--------");
                    //Pedimos los datos

                    while (usuarioExistente) {
                        try {
                            System.out.println("\nIngrese su usuario sin espacios:");
                            nombreUsuario = scanner.nextLine();
                            if (Anfitriones.containsKey(nombreUsuario)) {
                                throw new UsuarioYaExistenteException("Este usuario ya existe en nuestra base de datos, por favor seleccine otro.");
                            } else {
                                usuarioExistente = false;
                                anfitrionNuevo.setUsuario(nombreUsuario);
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

        ///Grabar nuevamente las listas
        operaciones.grabar("Base de datos.json", this.toJson());
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

        if (Alojamientos.isEmpty()){
            System.out.println("\nNo hay ningun alojamiento disponible por el momento.\n");
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
        }catch (UsuarioNoExisteException e){
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

    public void agregarAlojamiento(String nombre_anfitrion){
        Scanner scanner = new Scanner(System.in);
        System.out.println("El alojamiento que desea ingresar es:\n1-Casa\n2-Departamento\n0-Cancelar.");
        try {
            int tipo_alojamiento = scanner.nextInt();
            scanner.nextLine();
            switch (tipo_alojamiento) {
                case 1:
                    //Pido los datos de la Casa.
                    try {
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
                        System.out.println("Ingrese una descripcion de la propiedad:");
                        scanner.nextLine();
                        String descripcion = scanner.nextLine();

                        //Creo el objeto con los atributos que ingreso el admin o el anfitrion.

                        Alojamiento casa = new Casa(nombre, ubicacion, precioXnoche, aforo, descripcion, nombre_anfitrion);

                        //Guardo el alojamiento en la Lista.

                        Alojamientos.add(casa);
                        System.out.println("Alojamiento creado y listado exitosamente!");
                    } catch (InputMismatchException e) {
                        System.out.println("Tipo de valor incorrecto.");
                    } catch (Exception e) {
                    }
                    break;
                case 2:
                    //Pido los datos del Clases.Departamento
                    try {
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
                        System.out.println("Ingrese una descripción a la propiedad:");
                        scanner.nextLine();
                        String descripcion = scanner.nextLine();
                        System.out.print("Ingrese el piso en el que esta ubicada la propiedad: ");
                        int piso = scanner.nextInt();
                        System.out.println();

                        //Creo el objeto Clases.Departamento.

                        Alojamiento depto = new Departamento(nombre, ubicacion, precioXnoche, aforo, descripcion, nombre_anfitrion, piso);

                        //Guardo el alojamiento en la Lista

                        Alojamientos.add(depto);
                        System.out.println("Alojamiento creado y listado exitosamente!");
                    } catch (InputMismatchException e) {
                        System.out.println("Tipo de valor incorrecto.");
                    } catch (Exception e) {
                    }
                    break;
                default:
                    System.out.println("Cancelado.");
                    break;
            }
        }catch (InputMismatchException e){
            System.out.println("Tipo de valor incorrecto.");
        }
    }

    public void eliminarAlojamiento(int id) {
        Alojamiento alojamientoAEliminar = null;

        for (Alojamiento alojamiento : Alojamientos) {
            if (alojamiento.getIdentificador() == id) {
                alojamientoAEliminar = alojamiento;
                break;
            }
        }

        if (alojamientoAEliminar != null) {
            Alojamientos.remove(alojamientoAEliminar);
            System.out.println("El alojamiento ha sido eliminado.");
        } else {
            System.out.println("No se encontró un alojamiento con el ID especificado.");
        }
    }

    public void mostrar_alojamientos_propios(Anfitrion anfitrion){
        boolean flag = false;
        System.out.println("--------ALOJAMIENTOS PROPIOS--------");
        for (Alojamiento alojamiento : Alojamientos){
            if (alojamiento.getNombre_anfitrion().compareTo(anfitrion.getUsuario()) == 0){
                System.out.println(alojamiento.toString());
                flag = true;
            }
        }

        if (!flag){
            System.out.println("No tenemos registrado ningun alojamiento a nombre de este usuario.");
        }
    }

    public void mostrar_reservas() {
        System.out.println("--------RESERVAS--------");
        if (Reservas.isEmpty()){
            System.out.println("\nNo hay ninguna reserva registrada por el momento.\n");
        }else {
            for (Reserva reserva : Reservas) {
                System.out.println(reserva.toString());
            }
        }
    }

    //MENU ANFITRION

    public void menu_anfitrion(Anfitrion anfitrion){
        System.out.println("--------MENU ANFITRION--------");
        boolean sesion = true;
        while(sesion) {
            System.out.println("Seleccione una de las siguientes opciones: \n" +
                    "\n1 - Agregar alojamiento." +
                    "\n2 - Eliminar alojamiento." +
                    "\n3 - Ver alojamientos propios." +
                    "\n4 - Ver todos los alojamientos." +
                    "\n5 - Información personal."+
                    "\n6 - Cerrar sesión.");

            try {
                int opcionanf = scanner.nextInt();

                switch (opcionanf) {
                    case 1:
                        agregarAlojamiento(anfitrion.getUsuario());
                        break;
                    case 2:
                        mostrar_alojamientos_propios(anfitrion);
                        System.out.print("Ingrese el ID del alojamiento que desea eliminar: ");
                        int id = scanner.nextInt();
                        eliminarAlojamiento(id);
                        break;
                    case 3:
                        System.out.println("Los alojamientos propios de este anfitrion son: \n");
                        mostrar_alojamientos_propios(anfitrion);
                        break;
                    case 4:
                        System.out.println("Listado de todos los alojamientos: \n\n");
                        mostrar_alojamientos();
                        break;
                    case 5:
                        System.out.println("--------PERSONAL--------");
                        System.out.println(anfitrion.toString());
                        break;
                    case 6:
                        System.out.println("Cerrando sesion...");
                        sesion = false;
                        break;
                    default:
                        System.out.println("Por favor ingrese una opción válida.");
                }
            }catch (InputMismatchException e){
                System.out.println("Tipo de valor incorrecto.");
            }
        }
    }


    //MENU CLIENTE

    public void menuCliente(Cliente cliente)throws NoSeEncontroExeption {
        boolean sesion = true;
        int opcion = 0;
        while (sesion) {
            System.out.println("------------------------------------" +
                    "\n1 - ¡HACE TU RESERVA!" +
                    "\n2 - VER ALOJAMIENTOS." +
                    "\n3 - INFORMACIÓN PERSONAL." +
                    "\n4 - CAMBIAR CONTRASEÑA." +
                    "\n5 - CERRAR SESION.");
            try {
                opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                        System.out.println("--------HACER RESERVA--------");
                        hacerReserva(cliente);
                        break;
                    case 2:
                        mostrar_alojamientos();
                        break;
                    case 3:
                        System.out.println("--------PERSONAL--------");
                        System.out.println(cliente.toString());
                        break;
                    case 4:
                        System.out.println("--------CAMBIAR CONTRASEÑA--------");
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
            }catch (InputMismatchException e){
                System.out.println("Tipo de valor incorrecto.");
            }
        }
    }

    public boolean mostrar_departamentos(int cantPersonas) {
        boolean disponible = false;
        for (Alojamiento alojamiento : Alojamientos) {
            if (alojamiento instanceof Departamento && alojamiento.puedeHospedar(cantPersonas)) {
                System.out.println(((Departamento) alojamiento).toString());
                disponible = true;
            }
        }
        if (!disponible){
            System.out.println("No hay ningun departamento disponible para hospedar la cantidad ingresada de personas.");
            return false;
        }else{
            return true;
        }
    }

    public boolean mostrar_casa(int cantPersonas) {
        boolean disponible = false;
        for (Alojamiento alojamiento : Alojamientos) {
            if (alojamiento instanceof Casa && alojamiento.puedeHospedar(cantPersonas)) {
                System.out.println(((Casa) alojamiento).toString());
                disponible = true;
            }
        }
        if (!disponible){
            System.out.println("No hay ninguna casa disponible para hospedar la cantidad ingresada de personas.");
            return false;
        }else{
            return true;
        }
    }

    public void hacerReserva(Cliente cliente){
        int tipo = 0, cantPersonas = 0, numA = 0, finalizar = 0;
        boolean hacerReserva = true, alojamientoEncontrado = false, formatoFecha = false, hayAlojamientoCasa = false, hayAlojamientoDepto = false;
        LocalDate inicio = LocalDate.now(), fin = LocalDate.now();

        while(!formatoFecha) {
            try {
                System.out.println("DESDE: (AAAA-MM-DD)");
                inicio = LocalDate.parse(scanner.nextLine());
                System.out.println("HASTA: (AAAA-MM-DD)");
                fin = LocalDate.parse(scanner.nextLine());
                if (fin.isBefore(inicio)){
                    System.out.println("Fechas ingresadas incorrectamente.");
                }else{
                    formatoFecha = true;
                }
            }catch (DateTimeParseException e) {
                System.out.println("Formato de fecha incorrecto.");
            }

        }
        System.out.println("CANTIDAD DE PERSONAS:");
        cantPersonas = scanner.nextInt();
        scanner.nextLine();
        System.out.println("--------CASAS--------");
        hayAlojamientoCasa = mostrar_casa(cantPersonas);
        System.out.println("--------DEPARTAMENTOS--------");
        hayAlojamientoDepto = mostrar_departamentos(cantPersonas);
        if(hayAlojamientoCasa || hayAlojamientoDepto) {
            try {
                System.out.println("Ingrese el id del alojamiento");
                numA = scanner.nextInt();
                scanner.nextLine();
                for (Alojamiento alojamiento : Alojamientos) {
                    if (alojamiento.getIdentificador() == numA) {
                        alojamientoEncontrado = true;
                        if(!alojamiento.puedeHospedar(cantPersonas)){
                            System.out.println("El alojamiento elegido no tiene capacidad suficiente para hospedar a " + cantPersonas + " personas.");
                            hacerReserva = false;
                        }else if(!alojamiento.verificaDisponibilidad(inicio, fin, alojamiento)){
                            System.out.println("Este alojamiento ya se encuentra reservado para las fechas ingresadas.");
                        }
                        if (hacerReserva && alojamiento.verificaDisponibilidad(inicio, fin, alojamiento)) { ///si hay espacio y el alojamiento está disponible en esas fechas, se finaliza.
                            System.out.println();
                            System.out.println(" 1-FINALIZAR Y PAGAR | 2-CANCELAR");
                            finalizar = scanner.nextInt();
                            scanner.nextLine();

                            if (finalizar == 1) {
                                Reserva reservaNueva = new Reserva(alojamiento, cliente, inicio, fin, cantPersonas);
                                cliente.pagarReserva(reservaNueva);//se confirma pago y se guarda en historial del cliente
                                Reservas.add(reservaNueva);//se carga reserva a base de datos
                                alojamiento.setEstado(false); //pasa a estar ocupado
                                alojamiento.agregarReserva(reservaNueva); //se agrega a la lista de reservas.
                                System.out.println("Reserva creada con exito");
                                System.out.println(reservaNueva.toString());
                            } else {
                                System.out.println("Su reserva fue cancelada");
                            }
                            break;
                        }
                    }
                }
                if (!alojamientoEncontrado) {
                    throw new NoSeEncontroExeption("No se encontro el alojamiento");
                }
            } catch (NoSeEncontroExeption ex) {
                System.out.println(ex.getMessage());
            } catch (Exception e) {
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
                    "\n2 - VER RESERVAS." +
                    "\n3 - AGREGAR ALOJAMIENTO." +
                    "\n4 - ELIMINAR ALOJAMIENTO." +
                    "\n5 - ELIMINAR CLIENTE." +
                    "\n6 - ELIMINAR ANFITRION." +
                    "\n7 - CAMBIAR CONTRASEÑA." +
                    "\n8 - CERRAR SESION.");
            try {
                opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                        mostrar_alojamientos();
                        break;

                    case 2:
                        mostrar_reservas();
                        break;

                    case 3:
                        agregarAlojamiento(administrador.getUsuario());
                        break;

                    case 4:
                        mostrar_alojamientos();
                        if (!Alojamientos.isEmpty()) {
                            System.out.print("Ingrese el ID del alojamiento que desea eliminar: ");
                            int id = scanner.nextInt();
                            eliminarAlojamiento(id);
                        }
                        break;

                    case 5:
                        bajaCliente();
                        break;

                    case 6:
                        bajaAnfitrion();
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
            }catch (InputMismatchException e){
                System.out.println("Tipo de valor incorrecto.");
            }
        }
    }

    @Override
    public JSONObject toJson() {
        JSONObject jsonObject = new JSONObject();

        ///Convertir Anfitriones a JSON
        JSONArray anfitrionesArray = new JSONArray();
        for (Anfitrion anfitrion : Anfitriones.values()) {
            anfitrionesArray.put(anfitrion.toJson());
        }
        jsonObject.put("Anfitriones", anfitrionesArray);

        ///Convertir Administradores a JSON
        JSONArray administradoresArray = new JSONArray();
        for (Administrador administrador : Administradores.values()) {
            administradoresArray.put(administrador.toJson());
        }
        jsonObject.put("Administradores", administradoresArray);

        /// Convertir Clientes a JSON
         JSONArray clientesArray = new JSONArray();
         for (Cliente cliente : Clientes.values()) {
         clientesArray.put(cliente.toJson());
         }
         jsonObject.put("Clientes", clientesArray);

        ///Convertir Reservas a JSON
         JSONArray reservasArray = new JSONArray();
         for (Reserva reserva : Reservas) {
         reservasArray.put(reserva.toJson());
         }
         jsonObject.put("Reservas", reservasArray);

        ///Convertir Alojamientos a JSON
         JSONArray alojamientosArray = new JSONArray();
         for (Alojamiento alojamiento : Alojamientos) {
             if (alojamiento instanceof Casa){
                 alojamientosArray.put(((Casa) alojamiento).toJson());
             }
             else {
                 alojamientosArray.put(((Departamento)alojamiento).toJson());
             }
         }
         jsonObject.put("Alojamientos", alojamientosArray);

         return jsonObject;

    }

    @Override
    public void fromJson(JSONObject jsonObject) {
        /// Convertir Anfitriones desde JSON
        JSONArray anfitrionesArray = jsonObject.getJSONArray("Anfitriones");
        for (int i = 0; i < anfitrionesArray.length(); i++) {
            JSONObject anfitrionJson = anfitrionesArray.getJSONObject(i);
            Anfitrion anfitrion = new Anfitrion();
            anfitrion.fromJson(anfitrionJson);
            this.Anfitriones.put(anfitrion.getUsuario(), anfitrion);
        }

        // Convertir Administradores desde JSON
        JSONArray administradoresArray = jsonObject.getJSONArray("Administradores");
        for (int i = 0; i < administradoresArray.length(); i++) {
            JSONObject administradorJson = administradoresArray.getJSONObject(i);
            Administrador administrador = new Administrador();
            administrador.fromJson(administradorJson);
            this.Administradores.put(administrador.getUsuario(), administrador);

        }
        // Convertir Clientes desde JSON
        JSONArray clientesArray = jsonObject.getJSONArray("Clientes");
        for (int i = 0; i < clientesArray.length(); i++) {
            JSONObject clienteJson = clientesArray.getJSONObject(i);
            Cliente cliente = new Cliente();
            cliente.fromJson(clienteJson);
            this.Clientes.put(cliente.getUsuario(), cliente);
       }

        // Convertir Reservas desde JSON
        JSONArray reservasArray = jsonObject.getJSONArray("Reservas");
        for (int i = 0; i < reservasArray.length(); i++) {
            JSONObject reservaJson = reservasArray.getJSONObject(i);
            Reserva reserva = new Reserva(); reserva.fromJson(reservaJson);
            this.Reservas.add(reserva);
        }

        // Convertir Alojamientos desde JSON
        JSONArray alojamientosArray = jsonObject.getJSONArray("Alojamientos");
        for (int i = 0; i < alojamientosArray.length(); i++) {
            JSONObject alojamientoJson = alojamientosArray.getJSONObject(i);

            if(alojamientoJson.has("piso")){
                Departamento departamento=new Departamento();
                departamento.fromJson(alojamientoJson);
                this.Alojamientos.add(departamento);
            }else {
                Casa casa=new Casa();
                casa.fromJson(alojamientoJson);
                this.Alojamientos.add(casa);
            }
        }

    }
}
