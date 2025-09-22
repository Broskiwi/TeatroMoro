package cl.duoc.TeatroMoro;

import java.util.Scanner;

public class Main {

    private static final int TOTAL_ASIENTOS = 10;
    private static Scanner input = new Scanner(System.in);
    private static TeatroMoro[] asientos = new TeatroMoro[TOTAL_ASIENTOS];

    public static void main(String[] args) {
        inicializarAsientos();
        ejecutarSistemaReservas();
        input.close();
    }

    //Inicializar asientos
    private static void inicializarAsientos(){
        for (int i = 0; i < TOTAL_ASIENTOS; i++){
            asientos[i] = new TeatroMoro(i+1);
        }
    }

    // Lógica principal del sistema
    private static void ejecutarSistemaReservas(){
        int opcion;
        do {
            mostrarMenu();
            opcion = input.nextInt();
            if (opcion < 1 || opcion > 5){
                System.out.println("Opción inválida. Elija un valor entre 1 y 5.");
                continue;
            }
            switch (opcion){
                case 1:
                    opcionReservarAsiento();
                    break;
                case 2:
                    opcionModificarReserva();
                    break;
                case 3:
                    opcionComprarEntradas();
                    break;
                case 4:
                    opcionImprimirBoleta();
                    break;
                case 5:
                    System.out.println("Saliendo del sistema.");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 5);
    }

    //Metodo que almacena la lógica de reservar asiento
    private static void opcionReservarAsiento(){
        System.out.println("Ingrese número de entrada que desee reservar (1-" + TOTAL_ASIENTOS + ")");
        int numReserva = input.nextInt();

        if (numReserva < 1 || numReserva > TOTAL_ASIENTOS){
            System.out.println("Número de asiento fuera de rango. Intente con un número entre 1 y 10.");
            return;
        }

        if (asientos[numReserva - 1].reservarAsiento()){
            System.out.println("Se ha reservado el asiento con éxito.");
        } else {
            System.out.println("El asiento ya está reservado u ocupado. Por favor elija otro asiento.");
        }
    }

    //Metodo que almacena la lógica de modificar asiento
    private static void opcionModificarReserva(){
        System.out.println("Ingrese número de entrada que desea modificar (1-" + TOTAL_ASIENTOS + ")");
        int numMod = input.nextInt();

        if (numMod < 1 || numMod > TOTAL_ASIENTOS){
            System.out.println("Número de asiento fuera de rango. Intente con un número entre 1 y 10.");
            return;
        }

        if (asientos[numMod - 1].modificarReserva()){
            System.out.println("Se ha cancelado su reserva del asiento con éxito. Puede elegir otro asiento.");
        } else {
            System.out.println("No existe una reserva para modificar");
        }
    }

    //Metodo que almacena la lógica de comprar entrada
    private static void opcionComprarEntradas(){
        System.out.println("Ingrese número de reserva que desea comprar (1-" + TOTAL_ASIENTOS + ")");
        int numComprar = input.nextInt();

        if (numComprar < 1 || numComprar > TOTAL_ASIENTOS){
            System.out.println("Número de asiento fuera de rango. Intente con un número entre 1 y 10.");
            return;
        }

        if (asientos[numComprar - 1].comprarAsiento()){
            System.out.println("Ha comprado el asiento reservado con éxito.");
        } else {
            System.out.println("No se pudo comprar la entrada reservada");
        }
    }

    //Metodo que almacena la lógica para imprimir boleta
    private static void opcionImprimirBoleta(){
        System.out.println("Ingrese número de asiento para ver su boleta (1-" + TOTAL_ASIENTOS + ")");
        int numBoleta = input.nextInt();

        if (numBoleta < 1 || numBoleta > TOTAL_ASIENTOS){
            System.out.println("Número de asiento fuera de rango. Intente con un número entre 1 y 10.");
            return;
        }

        Boleta.imprimirBoleta(asientos[numBoleta - 1]);
    }

    //Metodo que muestra el menú
    private static void mostrarMenu(){
        System.out.println("===== MENU RESERVAS - TEATRO MORO ===== \n" +
                "1. Reservar un asiento.\n" +
                "2. Modificar una reserva.\n" +
                "3. Comprar entradas.\n" +
                "4. Imprimir Boleta.\n" +
                "5. Salir.\n" +
                "Seleccione una opción: ");
    }
}