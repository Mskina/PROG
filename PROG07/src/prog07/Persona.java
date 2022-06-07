package prog07;

/**
 * Representa la creación de una persona, que en este caso es titular de una
 * cuenta bancaria
 *
 * @author Iván Estévez Sabucedo
 */
public class Persona implements Imprimible {

    private String nombre; // Nombre del titular
    private String apellidos; // Apellidos del titular
    private String dni; // DNI del titular

    Persona(String nombre, String apellidos, String dni) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
    }

    /**
     * Deuelve el nombre del titular de la cuenta
     *
     * @return nombre del titular de la cuenta
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Deuelve los apellidos del titular de la cuenta
     *
     *
     * @return apellidos del titular de la cuenta
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * Devuelve el DNI del titular de la cuenta
     *
     * @return DNI del titular de la cuenta
     */
    public String getDni() {
        return dni;
    }

    @Override
    public String devolverInfoString() {
        String contenido
                = "- Nombre: " + getNombre() + "\n"
                + "- Apellidos: " + getApellidos() + "\n"
                + "- DNI: " + getDni() + "\n";
        return contenido;
    }
    
    
}
