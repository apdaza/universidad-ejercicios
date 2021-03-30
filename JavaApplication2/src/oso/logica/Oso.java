/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oso.logica;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author estudiantes
 */
public class Oso implements Componente{
    public ArrayList<Componente> partes = new ArrayList<Componente>();

    @Override
    public void dibujar(Graphics g) {
        for (Componente next : partes) {
            next.dibujar(g);
        }
    }
    
    public void addParte(Componente c){
        partes.add(c);
    }
    
}
