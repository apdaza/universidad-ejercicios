/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oso.gui;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import oso.logica.Circulo;
import oso.logica.Componente;
import oso.logica.Oso;

/**
 *
 * @author estudiantes
 */
public class Lienzo extends Canvas{
    Oso oso = new Oso();
    @Override
      
    public void paint(Graphics g) {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.
        g.setColor(Color.red);
        oso.dibujar(g);
    }

    public Lienzo() {
        oso.addParte(new Circulo(0, 0, 20, false));
        oso.addParte(new Circulo(25, 0, 20, false));
        oso.addParte(new Circulo(10, 10, 8, false));
        oso.addParte(new Circulo(25, 10, 8, false));
        oso.addParte(new Circulo(0, 18, 45, false));
        oso.addParte(new Circulo(10, 35, 25, false));
        oso.addParte(new Circulo(18, 40, 10, true));
        oso.addParte(new Circulo(10, 25, 10, false));
        oso.addParte(new Circulo(12, 30, 5, true));
        oso.addParte(new Circulo(25, 25, 10, false));
        oso.addParte(new Circulo(27, 30, 5, true));
    }
    
}
