package cl.duoc.TeatroMoro;

public class TeatroMoro {

    //Variables estáticas
    private static int asientosDisponibles = 10;
    private static int asientosReservados = 0;
    private static int asientosComprados = 0;

    //Variables de instancia (Atributos)

    private int numeroAsiento;
    private boolean reservado;
    private boolean comprado;

    //Constructor
    public TeatroMoro(int numeroAsiento) {
        this.numeroAsiento = numeroAsiento;
        this.reservado = false;
        this.comprado = false;
    }

    //Getters

    public int getNumeroAsiento() {
        return numeroAsiento;
    }

    public boolean isReservado() {
        return reservado;
    }

    public boolean isComprado() {
        return comprado;
    }

    //Setters

    public void setComprado(boolean comprado) {
        this.comprado = comprado;
    }

    public void setReservado(boolean reservado) {
        this.reservado = reservado;
    }

    //Métodos
    public boolean reservarAsiento(){

        //Verificar estado inicial del asiento
        System.out.println("DEBUG: Reservando asiento " + numeroAsiento);
        System.out.println("DEBUG: Estado actual - Reservado: " + reservado + ", Comprado: " + comprado);

        if (!reservado && !comprado){
            reservado = true;
            asientosReservados++;

            //Confirmar cambio de estado
            System.out.println("DEBUG: Asiento " + numeroAsiento + " reservado exitosamente");
            System.out.println("DEBUG: Total asientos reservados " + asientosReservados);

            return true;
        }
        return false;
    }

    public boolean modificarReserva(){

        //Verificar estado inicial del asiento
        System.out.println("DEBUG: Modificando asiento " + numeroAsiento);
        System.out.println("DEBUG: Estado actual - Reservado: " + reservado + ", Comprado: " + comprado);

        if (reservado && !comprado){
            reservado = false;
            asientosReservados--;

            //Confirmar cambio de estado
            System.out.println("DEBUG: Asiento " + numeroAsiento + " modificado exitosamente");

            return true;
        }
        return false;
    }

    public boolean comprarAsiento(){

        //Verificar estado inicial del asiento
        System.out.println("DEBUG: Comprando asiento " + numeroAsiento);
        System.out.println("DEBUG: Estado actual - Reservado: " + reservado + ", Comprado: " + comprado);

        if (reservado && !comprado){
            reservado = false;
            asientosReservados--;
            comprado = true;
            asientosComprados++;

            //Confirmar cambio de estado
            System.out.println("DEBUG: Asiento " + numeroAsiento + " comprado exitosamente");

            return true;
        }
        return false;
    }
}
