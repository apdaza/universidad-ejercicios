/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.composite;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author alejandro
 */
public class Poblacion extends Componente{
    ArrayList<Componente> miembros = new ArrayList<>();

    public ArrayList<Componente> getMiembros() {
        return miembros;
    }
    
    
    
    public void addMiembro(Componente c){
        miembros.add(c);
    }
    
    @Override
    public void actualizar(int x, int y) {
        for (Iterator<Componente> iterator = miembros.iterator(); iterator.hasNext();) {
            Componente next = iterator.next();
            next.actualizar(x, y);
        }
    }
    
}
