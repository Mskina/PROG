package concesionario.clases;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author
 */
public class Concesionario {

    private final static int TAM_CONCESIONARIO = 50;
    private Vehiculo concesionario[];
    private int numVehiculos;

    public Concesionario() {
        concesionario = new Vehiculo[TAM_CONCESIONARIO];
        numVehiculos = 0;
        this.insertarVehículos();
    }

    
    public Vehiculo [] devolverVehiculos() {
        return concesionario;
    }
    
    //modificado buscarVehiculo para devolver o toString do vehiculo atopado
    public String buscarVehiculo(String matricula) {
        String resultado = null;
        for (int i = 0; i < numVehiculos; i++) {
            if (concesionario[i].getMatricula().equals(matricula)) {
                Vehiculo v = concesionario[i];
                resultado = v.toString();
            }
        }
        return resultado;
    }
    
    //creamos un eliminar
    public int eliminarVehiculo(String matricula) {
        boolean eliminado = false;
        int resultado = -1; //non está devolve -1
        int indice = 0;
        for (int i = 0; (i < numVehiculos) && !eliminado; i++) {
            if (concesionario[i].getMatricula().equals(matricula)) {
                concesionario[i] = null;
                eliminado = true;
                indice = i;
                numVehiculos--;
                resultado = 0; //eliminación correcta devolve 0
            }
        }
        System.out.println("indice:" + indice);
        System.out.println("lengh:" + concesionario.length);
        //se eliminamos debemos quitar o oco que queda
        if (eliminado) {
            for (int i = indice; i < concesionario.length-1; i++) {
                if (concesionario[i + 1] != null) {
                    System.out.println("entro con i:" + i);
                    concesionario[i] = concesionario[i + 1];
                    concesionario[i + 1] = null;
                }

            }
        }
        return resultado;
    }
        
    public int insertarVehiculo(String marca, String matricula, int numkms, 
                                LocalDate fechaMatricula, String descripcion, 
                                double precio, String propietario, String dniPropietario) {
        int resultado = 0;
        
        if (numVehiculos >= TAM_CONCESIONARIO) 
            resultado = -1;
        else if (this.buscarVehiculo(matricula) != null)
            resultado = -2;
        else {
            concesionario[numVehiculos] = new Vehiculo(marca, matricula, numkms, 
                                                    fechaMatricula, descripcion, 
                                                    precio, propietario, dniPropietario);
            numVehiculos++;
        }
        
        return resultado;
    }
    
        public int insertarVehiculo(Vehiculo v) {
        int resultado = 0;
        
        if (numVehiculos >= TAM_CONCESIONARIO) 
            resultado = -1;
        else if (this.buscarVehiculo(v.getMatricula()) != null)
            resultado = -2;
        else {
            concesionario[numVehiculos] = v;
            numVehiculos++;
        }
        
        return resultado;
    }
    
    public void listarVehiculos (){             
        for (int i = 0; i < numVehiculos; i++) {
            if (concesionario[i] != null) {
            System.out.println ("\nVehículo:" + concesionario[i].getMarca() 
                    + "\nMatrícula: " + concesionario[i].getMatricula() 
                    + "\nKilometraje: " + concesionario[i].getNumKms()
                    + "\nPrecio: " + concesionario[i].getPrecio() 
                    + "\nDescripción: " + concesionario[i].getDescripcion()); 
            }
        }
    }
    
    public boolean actualizarKmsVehiculo (String matricula, Integer kms){
        boolean actualizado = false; 
        for (int i = 0; i < numVehiculos; i++) {
            if (concesionario[i].getMatricula().equals(matricula)) {
                concesionario[i].setNumKms(kms);
                actualizado = true;
            }
        }
        return actualizado;
    }
    private void insertarVehículos(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.insertarVehiculo(new Vehiculo("Seat",
                    "6400LLL", 
                    555, 
                    LocalDate.parse("03/03/2021",formatter), 
                    "Cochazo de la muerte", 
                    (double) 6000, 
                    "Andrés", 
                    "32843161N"));
        this.insertarVehiculo(new Vehiculo("Citroen",
                    "5555FFF", 
                    55500, 
                    LocalDate.parse("08/08/2021",formatter), 
                    "Saco", 
                    (double) 2000, 
                    "Arturo", 
                    "32856261N"));
    }
    
}
