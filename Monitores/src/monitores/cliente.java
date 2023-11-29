package monitores;

class cliente extends Thread {
    private final banco Banco;
    private final int id;

    public cliente(banco Banco, int id) {
        this.Banco = Banco;
        this.id = id;
    }

    @Override
    public void run() {
        Banco.ingresarBanco(id);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        Banco.salirBanco(id);
    }
}
