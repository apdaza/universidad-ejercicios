/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perseguido.gui;

import java.awt.Canvas;
import java.awt.Graphics;
import perseguido.logica.Laberinto;

/**
 *
 * @author daza
 */
public class Lienzo extends Canvas{
    Laberinto laberinto = new Laberinto();

       

    public void iniciarLienzo(String[][] matriz) {
        laberinto.setMatriz(matriz);
    }
    
    

    @Override
    public void paint(Graphics g) {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.
        laberinto.draw(g);
    }
    
    
}
