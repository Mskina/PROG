package ejer1;

/**
 * Representa la creación de una cuenta corriente para empresas
 *
 * @author Iván Estévez Sabucedo
 */
public class CuentaCorrienteEmpresa extends CuentaCorriente {

    private double tipoInteresDescubierto; // Interés que se cobra por estar en descubierto
    private double maximoDescubiertoPermitido; // Cantidad máxima en descubierto
    private double comisionPorDescubierto; //Cantidad fija que se cobra por cada descubierto que se tenga

    public CuentaCorrienteEmpresa(Persona titular, double saldo, String iban, String listaEntidadesAutorizadas, double tipoInteresDescubierto, double maximoDescubiertoPermitido, double comisionPorDescubierto) {
        super(titular, saldo, iban, listaEntidadesAutorizadas);
        this.tipoInteresDescubierto = tipoInteresDescubierto;
        this.maximoDescubiertoPermitido = maximoDescubiertoPermitido;
        this.comisionPorDescubierto = comisionPorDescubierto;
    }

    /**
     * Permite retirar dinero de la cuenta quedando en descubierto, siempre que
     * no se supere el máximo permitido
     *
     * @param retirada cantidad económica que queremos retirar
     */
    @Override // En las CC de Empresa puede haber descubierto
    public boolean hacerRetirada(double retirada) {
        /*
         Retirada. Supuesto: Saldo 0€ Máx Desc. 100€ Comisión 2€ - Saldo: 0€
         Si quiero retirar 100€, me quedaría con un descubierto de 102€,
         superior a la cantidad permitida. Por ello tengo en cuenta los tres valores.
         */
        boolean retiradaHecha = super.hacerRetirada(retirada);
        if (!retiradaHecha) {
            double maximaRetirada = this.saldo + this.maximoDescubiertoPermitido - this.comisionPorDescubierto; // Cantidad máxima a retirar, teniendo en cuenta la comisión
            if (maximaRetirada >= retirada) {
                this.saldo -= (retirada + this.comisionPorDescubierto);
                retiradaHecha = true;
            }
        }
        return retiradaHecha;
    }

    /**
     * Devuelve la información de la cuenta
     *
     * @return String nombre, apellidos, DNI, saldo, tipo de cuenta, interés
     * anual, entidades autorizadas para hacer domiciliaciones, cantidad máxima
     * de descubierto, tipo de interés por descubierto y comisión por
     * descubierto
     */
    @Override
    public String devolverInfoString() {
        String contenido = super.devolverInfoString();
        contenido = contenido
                + "- Tipo de cuenta: Cuenta corriente Empresa \n"
                + "- Máximo descubierto permitido: " + String.format("%.02f", maximoDescubiertoPermitido) + " € \n"
                + "- Tipo de interés por descubierto: " + String.format("%.02f", tipoInteresDescubierto) + " % \n"
                + "- Comisión por descubierto: " + String.format("%.02f", comisionPorDescubierto) + " €.";
        return contenido;
    }
}
