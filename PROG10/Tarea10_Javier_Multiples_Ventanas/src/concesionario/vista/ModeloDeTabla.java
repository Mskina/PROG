/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concesionario.vista;

import concesionario.clases.Vehiculo;
import java.time.LocalDate;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author Javip
 */

//esta clase é un TabmeModel, unha clase que lle indica á unha tabla
//cómo mostrar os datos dos obxetos que queremos mostrar
public class ModeloDeTabla implements TableModel {

    private Vehiculo[] vehiculos;

    public ModeloDeTabla(Vehiculo[] vehiculos) {

        this.vehiculos = vehiculos;

    }
    //indicamos número de filas, serán tantas como vehículas
    @Override
    public int getRowCount() {

        return vehiculos.length;

    }
    //indicamos número de columnas, unha por cada dato do vehiculo
    @Override
    public int getColumnCount() {

        return 8;

    }
    //indicamos o nome das columnas
    @Override
    public String getColumnName(int columnIndex) {

        String titulo = null;

        switch (columnIndex) {

            case 0:

                titulo = "Marca";

                break;


            case 1:

                titulo = "Matricula";

                break;
            case 2:

                titulo = "Kilometraje";

                break;
            case 3:

                titulo = "Fecha matricula";

                break;
            case 4:

                titulo = "Descripción";

                break;
            case 5:

                titulo = "Precio";

                break;
            case 6:

                titulo = "Propietario";

                break;
            case 7:

                titulo = "DNI propietario";

                break;

        }

        return titulo;

    }
    //indicamos o tipo que van a ter as columnas
    @Override
    public Class<?> getColumnClass(int columnIndex) {

        Class clase = null;

        switch (columnIndex) {

            case 0:

                clase = String.class;

                break;

            case 1:

                clase = String.class;

                break;
            case 2:

                clase = Integer.class;

                break;
            case 3:

                clase = LocalDate.class;

                break;
            case 4:

                clase = String.class;

                break;
            case 5:

                clase = Double.class;

                break;
            case 6:

                clase = String.class;

                break;
            case 7:

                clase = String.class;

                break;

        }

        return clase;

    }
    //decimos se as columnas son editables (modificará os valores do obxeto se se cambian
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {

        boolean editable = false;

        switch (columnIndex) {

            case 0:

                editable = false;

                break;

            case 1:

                editable = false;

                break;
            case 2:
                //permitimos editar os kilometros
                editable = true;

                break;
            case 3:

                editable = true;

                break;
            case 4:

                editable = false;

                break;
            case 5:

                editable = false;

                break;
            case 6:

                editable = false;

                break;
            case 7:

                editable = false;

                break;
 

        }

        return editable;

    }
    //neste método indicamos cómo se rellenan as columnas
    //cada unha mostrará un dos atrigutos
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        Vehiculo v = vehiculos[rowIndex];

        Object valor = null;

        if (v != null) {

            switch (columnIndex) {

                case 0:

                    valor = v.getMarca();

                    break;

                case 1:

                    valor = v.getMatricula();

                    break;
                case 2:

                    valor = v.getNumKms();

                    break;
                case 3:

                    valor = v.getFechaMatricula();

                    break;
                case 4:

                    valor = v.getDescripcion();

                    break;
                case 5:

                    valor = v.getPrecio();

                    break;
    
                case 6:

                    valor = v.getPropietario();

                    break;
                case 7:

                    valor = v.getDniPropietario();

                    break;

            }

        }

        return valor;

    }
    //indicamos dónde se gardan os datos cando modificamos unha columna
    //no caso que sean modificables
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

        Vehiculo v = vehiculos[rowIndex];

        switch (columnIndex) {

            case 0:

                v.setMarca(aValue.toString());

                break;

            case 1:

                v.setMatricula(aValue.toString());

                break;
            case 2:

                v.setNumKms((Integer) aValue);

                break;
            case 3:

                v.setFechaMatricula(LocalDate.parse(aValue.toString()));

                break;
            case 4:

                v.setDescripcion(aValue.toString());

                break;
            case 5:

                v.setPrecio((Double) aValue);

                break;

            case 6:

                v.setPropietario(aValue.toString());

                break;
            case 7:

                v.setDniPropietario(aValue.toString());

                break;

        }

    }

    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {

    }

}
