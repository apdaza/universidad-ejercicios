/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tet;

import logica.Ensalada;
import logica.Plato;
import logica.Proteina;

/**
 *
 * @author Estudiantes
 */
public class Test {
    public static void main(String[] args) {
        Plato p = new Plato();
        p.addComponente(new Proteina());
        p.addComponente(new Ensalada());
        
        System.out.println(p.mostrarPlato());
    }
    
}
