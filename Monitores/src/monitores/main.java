package monitores;

public class main {
    public static void main(String[] args) {
        banco b1 = new banco();

        for (int i = 1; i <= 5; i++) {
            cliente c1 = new cliente(b1, i);
            c1.start();
        }

        // Espera a que todos los clientes terminen
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Cantidad total de clientes que ingresaron al banco: " + b1.obtenerClientesTotales());
    }
}


