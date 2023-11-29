package monitores;

class banco {
    private int clientesEnBanco = 0;
    private int clientesTotales = 0;

    public synchronized void ingresarBanco(int idCliente) {
        while (clientesEnBanco >= 2) {
            try {
                System.out.println("Cliente " + idCliente + " esperando para ingresar al banco. Clientes en el banco: " + clientesEnBanco);
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        clientesEnBanco++;
        clientesTotales++;
        System.out.println("Cliente " + idCliente + " ha ingresado al banco. Clientes en el banco: " + clientesEnBanco);
    }

    public synchronized void salirBanco(int idCliente) {
        clientesEnBanco--;
        System.out.println("Cliente " + idCliente + " ha salido del banco. Clientes en el banco: " + clientesEnBanco);
        notifyAll();
    }

    public synchronized int obtenerClientesTotales() {
        return clientesTotales;
    }
}


