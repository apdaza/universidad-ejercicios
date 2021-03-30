/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.apdaza.laberinto.gui;

import java.awt.Canvas;
import java.awt.Graphics;

/**
 *
 * @author alejandro
 */
public class Lienzo extends Canvas{

    @Override
    public void paint(Graphics g) {
        super.paint(g); 
        g.drawImage(image, WIDTH, WIDTH, this)
        
    }
    
    
}
