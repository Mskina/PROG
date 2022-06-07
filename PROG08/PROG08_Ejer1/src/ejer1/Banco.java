package ejer1;

import java.util.*;

/**
 * Representa la creación de un objeto Banco. Permite consultar y actualizar sus
 * parámetros, que deberán venir validados previamente.
 *
 * @author Iván Estévez Sabucedo
 */
public class Banco {

    /* No se van a repetir elementos, pero sí agregar, eliminar y, sobre todo, consultar.
    Opto por ArrayList ya que las consultas van a ser mucho más numerosas que las eliminaciones
    Además, sé que va a haber pocos elementos almacenados, por lo que el espacio no llega a ser un problema
     */
    ArrayList<CuentaBancaria> cuentas; // ArrayList de cuentas bancarias

    /**
     * Método constructor del banco, en el que se crea la LinkedList de cuentas.
     */
    public Banco() {
        cuentas = new ArrayList<CuentaBancaria>();
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
        while (i < cuentas.size()) {
            if (cuentas.get(i).getIban().equals(cuenta.getIban())) {
                abrirCuenta = false; // Ya existe ese IBAN
            }
            i++;
        }
        if (abrirCuenta) {
            cuentas.add(cuenta); // Éxito
        }
        return abrirCuenta;
    }

    /**
     * Genera un array con la información de todas las cuentas almacenadas
     *
     * @return un array de Strings
     */
    public String[] listadoCuentas() {
        ArrayList<String> infoCuentas = new ArrayList<String>();
        for (CuentaBancaria cuenta : cuentas) {
            infoCuentas.add(cuenta.devolverInfoResumida());
        }
        String[] listadoCuentas = new String[infoCuentas.size()];
        return infoCuentas.toArray(listadoCuentas);
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
        int posicion = buscarCuentaIndice(iban);
        if (posicion != -1) {
            informacionCuenta = cuentas.get(posicion).devolverInfoString();
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
        int posicion = buscarCuentaIndice(iban);
        if (posicion != -1) {
            cuentas.get(posicion).hacerIngreso(ingreso);
            ingresado = true;
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
        int posicion = buscarCuentaIndice(iban);
        if (posicion != -1) {
            if (cuentas.get(posicion).hacerRetirada(retirada)) {
                retirado = true;
            }
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
        int posicion = buscarCuentaIndice(iban);
        if (posicion != -1) {
            saldo = cuentas.get(posicion).getSaldo();
        }
        return saldo;
    }

    /**
     * Recibe como parámetro un IBAN, busca la cuenta asociada y, si su saldo es
     * 0, la elimina.
     *
     * @param iban número de cuenta sobre el que se opera
     * @return <code>true</code> si se ha eliminado y <code>false </code> en
     * caso contrario
     */
    public boolean eliminarCuenta(String iban) {
        boolean eliminada = false;
        int posicion = buscarCuentaIndice(iban);
        if (posicion != -1) {
            if (cuentas.get(posicion).getSaldo() == 0) { // Considero que no se deben eliminar cuentas con saldo negativo ya que el "banco" perdería las deudas.
                cuentas.remove(posicion);
                eliminada = true;
            }
        }
        return eliminada;
    }

    /**
     * Recibe como parámetro un IBAN, busca la cuenta asociada y, si existe,
     * devuelve su posición
     *
     * @param iban número de cuenta sobre el que se opera
     * @return  <code>-1</code> si no existe y <code>int</code> para indicar la
     * posición del elemento.
     */
    private int buscarCuentaIndice(String iban) {
        boolean encontrado = false;
        int indice = -1;
        int i = 0;
        while (i < cuentas.size() && !encontrado) {
            if (cuentas.get(i).getIban().equals(iban)) {
                indice = i;
                encontrado = true;
            }
        }
        return indice;
    }
}
