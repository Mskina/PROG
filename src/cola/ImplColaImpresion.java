/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cola;

import archivo.Archivo;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Iván Estévez
 */
public class ImplColaImpresion {

    private ArrayList<Archivo> colaArray;

    public ImplColaImpresion() {
        colaArray = new ArrayList<>();
    }

    /**
     * Si en el array hay archivos, elimina el primero (índice 0)
     *
     * @return true si lo imprime y false si no
     */
    public boolean imprimir() {
        boolean hecho = false;
        if (colaArray.size() > 0) {
            colaArray.remove(0);
            System.out.println("Eliminado");
            hecho = true;
        }
        if (!hecho) {
            System.out.println("No hay archivos");
        }
        return hecho;
    }

    /**
     * Añade el archivo al Array y lo ordena
     *
     * @param archivo para añadir
     */
    public void enviarArchivo(Archivo archivo) {
        /* Si quisiésemos impedir que se repita el nombre, podríamos cambiar el método a booleano y entregar un error
        boolean existe = false;
        for (Archivo a : colaArray) {
            if (archivo.getNombre().equals(a.getNombre())) {
                existe = true;
            }
        }*/

        colaArray.add(archivo);
        Collections.sort(colaArray);
    }

    /**
     * Dado un nombre, recorre el array buscando una coincidencia. Si lo
     * encuentra, lo elimina del array.
     *
     * @param nombre del archivo a cancelar
     * @return true si lo elimina y false si no
     */
    public boolean cancelarArchivo(String nombre) {
        boolean hecho = false;
        Archivo archivoParaCancelar = null;
        for (Archivo a : colaArray) {
            if (nombre.equals(a.getNombre())) {
                archivoParaCancelar = a;
                hecho = true;
            }
        }
        colaArray.remove(archivoParaCancelar);
        return hecho;
    }

    /**
     * Genera un array con todos los ficheros
     *
     * @return el array completo
     */
    public ArrayList<Archivo> devolverLista() {
        return colaArray;
    }

    /**
     * Genera un archivo txt con el contenido del array
     */
    public void exportarTxt() {
        try {
            FileWriter archivo = new FileWriter("Lista.txt");
            PrintWriter pw = new PrintWriter(archivo);

            for (Archivo a : colaArray) {
                pw.println("Archivo ID: " + colaArray.indexOf(a)
                        + "\n\t- Nombre: " + a.getNombre() + "."
                        + "\n\t- Tamaño: " + a.getTamanho() + "bites"
                        + "\n\t- Prioridad: " + a.getPrioridad() + "."
                        + "\n\t- Color: " + a.getBnColor() + "."
                        + "\n\t- Tipo: " + a.getTipo() + "."
                        + "\n\t- Páginas: " + a.getPaginas() + ".\n");
            }
            pw.println("Archivos totales: " + colaArray.size());
            pw.close();
            archivo.close();
        } catch (IOException e) {
            System.out.println("No se ha podido exportar el archivo");
        }
    }

    /**
     * Exporta en .dat el contenido del array
     */
    public void guardarListaDisco() {
        try {
            FileOutputStream fos = new FileOutputStream("Lista.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeInt(colaArray.size());
            for (Archivo p : colaArray) {
                oos.writeObject(p);
            }
            oos.close();
            fos.close();
        } catch (IOException e) {
            System.out.println("Error al guardar el fichero");
        }
    }

    /**
     * Carga el contenido del .dat (si existe) y lo ordena, por si no lo
     * estuviese ya.
     */
    public void leerListaDisco() {
        FileInputStream fis;
        ObjectInputStream ois;

        try {
            fis = new FileInputStream("Lista.dat");
            ois = new ObjectInputStream(fis);
            int numArchivos = ois.readInt();
            System.out.println("Archivos:" + numArchivos);
            for (int i = 0; i < numArchivos; i++) {
                Archivo a = (Archivo) ois.readObject();
                colaArray.add(a);
            }
            ois.close();
            fis.close();

            Collections.sort(colaArray);

        } catch (FileNotFoundException eFNFE) {
            System.out.println("No se encuentra el fichero");
        } catch (Exception e) {
            System.out.println("Error al cargar el fichero");
        }
    }

}
