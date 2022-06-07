/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog08_actividades;

import java.util.HashMap;
import java.util.Iterator;
import java.util.*;

/**
 *
 * @author mskin
 */
public class PROG08_Actividades {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        /*
        HashMap<String, String> map = new HashMap();
        map.put("ES", "Spain");
        map.put("DE", "Germany");
        map.put("FR", "France");
        map.put("CN", "China");
        String variableAlex = map.get("ES");
        System.out.println(variableAlex);
        System.out.println(variableAlex);*/
 /*
        HashMap<String, Country> map = new HashMap();

        Country c1 = new Country();
        c1.setPais("España");
            String idiomasEspaña[] = new String[2];
            idiomasEspaña[0] = "Español";
            idiomasEspaña[1] = "Catalán";
        c1.setIdiomas(idiomasEspaña);

        Country c2 = new Country();
        c2.setPais("Francia");
        c2.setIdiomas(new String[]{"Francés", "Bretón"});

        map.put("ES", c1);
        map.put("FR", c2);

        Set set = map.entrySet();
        Iterator it = set.iterator();

        while (it.hasNext()) {
            Map.Entry<String, Country> ent = (Map.Entry) it.next();
            System.out.println("Código: " + ent.getKey());
            System.out.println("País: " + ent.getValue().getPais());
            System.out.println("Idioma(s): " + Arrays.toString(ent.getValue().getIdiomas()));
        }
        System.out.println("-----------");
        System.out.println(c1.getPais());
        System.out.println(Arrays.toString(c1.getIdiomas()));
        
        System.out.println("-----------");
        System.out.println(c2.getPais());
        System.out.println(Arrays.toString(c2.getIdiomas()));
         */
        ArrayList<String> lista = new ArrayList<>();

        // Añadimos 10 Elementos en el ArrayList
        for (int i = 1; i <= 10; i++) {
            lista.add("Elemento " + i);
        }

        //mostrar el arrayList completo usando el toString de ArrayList
        System.out.println(lista);

        //O también, recorrido usando un iterador para mostrar un elemento por línea
        Iterator<String> iterador = lista.iterator();
        int i = 0;
        while (iterador.hasNext()) {
            System.out.println("[" + i + "]: " + iterador.next());
            i++;
        }

        // Añadimos un nuevo elemento al ArrayList en la posición 2
        System.out.println("\nAñadimos un nuevo elemento en la posición 2");
        lista.add(2, "Elemento 3");

        // Imprimimos los Elementos del ArrayList   
        System.out.println("\nImprimimos la lista");
        i = 0;
        iterador = lista.iterator();
        while (iterador.hasNext()) {
            System.out.println("[" + i + "]: " + iterador.next());
            i++;
        }

        //Eliminamos el primer elemento del ArrayList, posición '0'
        System.out.println("\nEliminamos el primer elemento del ArrayList");
        lista.remove(0);

        // Eliminamos los elementos de ArrayList que sean iguales a "Elemento 3"
        System.out.println("Eliminamos los elementos de ArrayList que sean iguales a 'Elemento 3'");
        iterador = lista.iterator();
        while (iterador.hasNext()) {
            String elemento = iterador.next();
            if (elemento.equals("Elemento 3")) {
                iterador.remove();// Eliminamos el Elemento que hemos obtenido del Iterator
            }
        }

        // Imprimimos el ArrayList despues de eliminar los elementos iguales a "Elemento 3"
        System.out.println("\nImprimimos tras realizar las eliminaciones: ");
        System.out.println(lista);

        System.out.println("\nInvertimos la lista");
        Collections.reverse(lista);

        System.out.println("Imprimimos nuevamente la lista");
        System.out.println(lista);
    }

}
