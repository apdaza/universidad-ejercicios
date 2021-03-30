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
public class Menu {
    ArrayList<Plato> platos = new ArrayList<Plato>();
    
    
    public void crearMenu(){
        for(int i = 0; i < 10; i++){
            platos.add(new Plato());
        }
        
        for (Iterator<Plato> iterator = platos.iterator(); iterator.hasNext();) {
            Plato next = iterator.next();
            next.addComponente(new Bebida());
            next.addComponente(new Carbohidratos());
            next.addComponente(new Ensalada());
            next.addComponente(new Proteina());
            
        }
        
        for (Iterator<Plato> iterator = platos.iterator(); iterator.hasNext();) {
            Plato next = iterator.next();
            System.out.println(next.mostrarPlato());
            
        }
    }
    
    
}
