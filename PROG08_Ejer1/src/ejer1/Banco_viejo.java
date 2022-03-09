package ejer1;

/**
 * Representa la creación de un objeto Banco. Permite consultar y actualizar sus
 * parámetros, que deberán venir validados previamente.
 *
 * @author Iván Estévez Sabucedo
 */
public class Banco_viejo {

    private CuentaBancaria[] listaCuentas; // Array de cuentas bancarias
    private int numeroCuentas; // Contador de cuántas cuentas hay almacenadas

    /**
     * Método constructor del banco, en el que se crea el array con un tamaño
     * fijo de 100 cuentas
     */
    public Banco_viejo() {
        listaCuentas = new CuentaBancaria[100];
        numeroCuentas = 0;
    }

    /**
     * Recibe un objeto CuentaBancaria y trata de almacenarlo en la estructura
     *
     * @param cuenta objeto con la información ya validada de una cuenta
     * bancaria
     * @return <code>true</code> si se ha realizado con éxito <code>false</code>
     * en caso contrario
     */
    public boolean abrirCuenta(CuentaBancaria cuenta) {
        boolean abrirCuenta = true;
        int i = 0;
        if (numeroCuentas == 100) {
            abrirCuenta = false; // No hay espacio para almacenar más cuentas
        } else {
            while (i < numeroCuentas && abrirCuenta) {
                if (listaCuentas[i].getIban().equals(cuenta.getIban())) {
                    abrirCuenta = false; // Ya existe ese IBAN
                }
                i++;
            }
            if (abrirCuenta) {
                listaCuentas[numeroCuentas] = cuenta;
                numeroCuentas++; // Éxito
            }
        }
        return abrirCuenta;
    }

    /**
     * Genera un array con la información de todas las cuentas almacenadas
     *
     * @return un array de Strings
     */
    public String[] listadoCuentas() {
        String[] listado = new String[numeroCuentas];
        for (int i = 0; i < numeroCuentas; i++) {
            listado[i] = listaCuentas[i].devolverInfoResumida();
        }
        return listado;
    }

    /**
     * Recibe como parámetro un IBAN, busca la cuenta asociada y muestra la
     * información relativa a la misma
     *
     * @param iban número de cuenta sobre el que se opera
     * @return una cadena de texto con los datos de la cuenta y
     * <code>null</code> en caso de no existir
     */
    public String informacionCuenta(String iban) {
        String informacionCuenta = null;
        int i = 0;
        while (i < numeroCuentas && informacionCuenta == null) {
            if (listaCuentas[i].getIban().equals(iban)) {
                informacionCuenta = listaCuentas[i].devolverInfoString();
            }
            i++;
        }
        return informacionCuenta;
    }

    /**
     * Recibe como parámetro un IBAN, busca la cuenta asociada y aumenta el
     * saldo la cantidad indicada
     *
     * @param iban número de cuenta sobre el que se opera
     * @param ingreso cantidad que se desea ingresar
     * @return <code>true</code> si ha sido exitoso y <code>false</code> en caso
     * contrario
     */
    public boolean ingresoCuenta(String iban, double ingreso) {
        boolean ingresado = false;
        int i = 0;
        while (i < numeroCuentas && !ingresado) {
            if (listaCuentas[i].getIban().equals(iban)) {
                listaCuentas[i].hacerIngreso(ingreso);
                ingresado = true;
            }
            i++;
        }
        return ingresado;
    }

    /**
     * Recibe como parámetro un IBAN, busca la cuenta asociada y reduce el saldo
     * la cantidad indicada
     *
     * @param iban número de cuenta sobre el que se opera
     * @param retirada cantidad que se desea retirar
     * @return <code>true</code> si se ha retirado y <code>false </code> en caso
     * contrario
     */
    public boolean retiradaCuenta(String iban, double retirada) {
        boolean retirado = false;
        int i = 0;
        while (i < numeroCuentas && !retirado) {
            if (listaCuentas[i].getIban().equals(iban)) {
                if (listaCuentas[i].hacerRetirada(retirada)) {
                    retirado = true;
                }
            }
            i++;
        }
        return retirado;
    }

    /**
     * Dado un IBAN, permite consultar el saldo asociado
     *
     * @param iban
     * @return <code>-1</code> si no hay coincidencia y el saldo en caso de
     * haberla
     */
    public double obtenerSaldo(String iban) {
        double saldo = -1;
        int i = 0;
        while (i < numeroCuentas && saldo == -1) {
            if (listaCuentas[i].getIban().equals(iban)) {
                saldo = listaCuentas[i].getSaldo();
            }
            i++;
        }
        return saldo;
    }
}
