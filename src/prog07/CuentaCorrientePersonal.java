/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog07;

/**
 * Representa la creación de una cuenta corriente para particulares
 *
 *
 * @author Iván Estévez Sabucedo
 */
public class CuentaCorrientePersonal extends CuentaCorriente {

    private double comisionMantenimiento; // Cantidad fija anual

    CuentaCorrientePersonal(Persona titular, double saldo, String iban, String listaEntidadesAutorizadas, double comisionMantenimiento) {
        super(titular, saldo, iban, listaEntidadesAutorizadas);
        this.comisionMantenimiento = comisionMantenimiento;
    }

    /**
     * Devuelve la información de la cuenta
     *
     * @return String nombre, apellidos, DNI, saldo, tipo de cuenta, interés
     * anual, entidades autorizadas para hacer domiciliaciones y comisión de
     * mantenimiento
     */
    @Override
    public String devolverInfoString() {
        String contenido = super.devolverInfoString();
        contenido = contenido
                + "- Tipo de cuenta: Cuenta corriente Personal \n"
                + "- Comisión de mantenimiento: " + String.format("%.02f", comisionMantenimiento) + " €/año";
        return contenido;
    }
}
