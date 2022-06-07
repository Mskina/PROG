/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concesionario.clases;
import concesionario.vista.*;
import javax.swing.JFrame;

/**
 *
 * @author javip
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //creamos o conesionario
        Concesionario concesionario = new Concesionario();
        //creamos a clase do menú
        JFrame menu = new Menu(concesionario);
        //asignamos a operación de cerrado
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //centramos a ventana
        menu.setLocationRelativeTo(null);
        //mostramos a ventá do menú
        menu.setVisible(true);
        
        
    }
    
}
