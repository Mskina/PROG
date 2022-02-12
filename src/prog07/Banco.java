package prog07;

/**
 * Representa la creación de un objeto Banco. Permite consultar y actualizar sus
 * parámetros, que deberán venir validados previamente.
 *
 * @author Iván Estévez Sabucedo
 */
public class Banco {

    private Banco[] listaCuentas;
    private int numeroCuentas;

    /**
     * Método constructor del banco, en el que se crea el array con un tamaño
     * fijo de 100 cuentas
     */
    public Banco() {
        listaCuentas = new Banco[100];
        numeroCuentas = 0;
    }

}
