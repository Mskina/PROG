package ejer1;

import java.io.Serializable;

/**
 * Representa la creación de una Cuenta Bancaria. Se trata de una clase
 * abstracta que permite crear los distintos tipos de cuentas
 *
 * @author Iván Estévez Sabucedo
 */
public abstract class CuentaBancaria implements Imprimible, Serializable {

    protected Persona titular; // Titular de la cuenta
    protected double saldo; // Saldo de la cuenta
    protected String iban; // Número de cuenta

    public CuentaBancaria(Persona titular, double saldo, String iban) {
        this.titular = titular;
        this.saldo = saldo;
        this.iban = iban;
    }

    /**
     * Devuelve el saldo de la cuenta
     *
     * @return saldo de la cuenta
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * Devuelve el IBAN de la cuenta
     *
     * @return IBAN de la cuenta
     */
    public String getIban() {
        return iban;
    }

    /**
     * Permite ingresar dinero en la cuenta
     *
     * @param ingreso cantidad económica que queremos añadir a cuenta
     */
    public void hacerIngreso(double ingreso) {
        this.saldo += ingreso;
    }

    /**
     * Permite retirar dinero de la cuenta
     *
     * @param retirada cantidad económica que queremos retirar
     * @return
     */
    public boolean hacerRetirada(double retirada) {
        boolean retiradaHecha = false;
        if (this.saldo >= retirada) {
            this.saldo -= retirada;
            retiradaHecha = true;
        }
        return retiradaHecha;
    }

    /**
     * Devuelve la información de la cuenta
     *
     * @return String nombre, apellidos, DNI y saldo de la cuenta
     */
    @Override
    public String devolverInfoString() {
        String contenido
                = titular.devolverInfoString()
                + "- Saldo: " + String.format("%.02f", saldo) + " € \n";
        return contenido;
    }

    /**
     * Devuelve la información de la cuenta
     *
     * @return String nombre, apellidos, DNI y saldo de la cuenta
     */
    public String devolverInfoResumida() {
        String contenido
                = String.format("%s \t Titular: %s %s \tSaldo: %.02f €.", getIban(), titular.getNombre(), titular.getApellidos(), getSaldo());
        return contenido;
    }
}
