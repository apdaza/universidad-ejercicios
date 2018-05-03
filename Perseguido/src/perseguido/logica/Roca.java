/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package perseguido.logica;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.util.Random;
import javax.swing.ImageIcon;

/**
 *
 * @author daza
 */
public class Roca implements Personaje {
    Image imagen = new ImageIcon(getClass().getResource("../imagenes/wall2.jpg")).getImage();
    int xPos = 0;
    int yPos = 0;
    
    public Roca(int x, int y){
        xPos = x;
        yPos = y;
    }

    @Override
    public void draw(Graphics g) {
       
        g.drawImage(imagen, xPos, yPos, null);
    }
    
    
    @Override
    public void update(){ 
        
    }
    
    @Override
    public Rectangle getRect(){
        Rectangle rect = null;
        rect = new Rectangle(xPos, yPos, imagen.getWidth(null), imagen.getHeight(null));
        return rect;
    }

    @Override
    public void update(int c) {
        
    }

    @Override
    public void cambiarSentido() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
