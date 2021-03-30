/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Estudiantes
 */
public class Plato {
    ArrayList<Componente> componentes = new ArrayList<Componente>();
    
    public void addComponente(Componente c){
        componentes.add(c);
    }
    
    public String mostrarPlato(){
        String cadena = "";
        for (Iterator<Componente> iterator = componentes.iterator(); iterator.hasNext();) {
            Componente next = iterator.next();
            cadena += next.getNombre() + "\n";
        }
        return cadena;
    }
}
