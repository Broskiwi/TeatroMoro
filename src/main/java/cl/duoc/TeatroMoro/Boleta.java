package cl.duoc.TeatroMoro;

public class Boleta {

    //Variables estáticas y constantes (finales)
    private static final double precioEntrada = 150.0;
    private static final String nombreTeatro = "Teatro Moro";
    private static final String nombreObra = "El Principito";

    public static void imprimirBoleta (TeatroMoro sistemaMoro){

        //Verificando que se llama la funcionalidad de imprimir boleta con un número
        System.out.println("DEBUG: Se está generando boleta para asiento número " + sistemaMoro.getNumeroAsiento());

        //Verificando estado del asiento
        System.out.println("DEBUG: El estado del asiento es - Reservado:  " + sistemaMoro.isReservado() + ", Comprado: " + sistemaMoro.isComprado());

        //Se asocia un estado para mejor entendimiento
        String estadoAsiento;
        if (sistemaMoro.isComprado()){
            estadoAsiento = "Comprado";
        } else if (sistemaMoro.isReservado()) {
            estadoAsiento = "Reservado";
        } else {
            estadoAsiento = "Disponible";
        }

        //Se muestra la boleta con infromación relevante de la compra
        System.out.println("=============================== \n" +
                "===== " + nombreTeatro + " - BOLETA ==== \n" +
                "=============================== \n" +
                "Obra: " + nombreObra + "\n" +
                "Número de Asiento: " + sistemaMoro.getNumeroAsiento() + "\n" +
                "Precio de la entrada: $" + precioEntrada + "\n" +
                "Estado : " + estadoAsiento + " \n" +
                "===============================");

        //Se confirma que la boleta fue impresa correctamente
        System.out.println("DEBUG: Boleta impresa con éxito.");
    }
}
