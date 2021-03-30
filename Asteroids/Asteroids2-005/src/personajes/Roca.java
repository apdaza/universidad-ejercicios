/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package personajes;

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
    Image imagen = new ImageIcon(getClass().getResource("/imagenes/asteroid.png")).getImage();
    int xPos = 0;
    int yPos = 0;
    int rotation = 10;
    float aceleration = 2;
    int xVel = 0;
    int yVel = 0;
    
    public Roca(){
        Random r = new Random();
        xPos = r.nextInt(400);
        yPos = r.nextInt(600);
        
        xVel = -10 + r.nextInt(20);
        yVel = -10 + r.nextInt(20);
        
        //rotation = r.nextInt(100);
        rotation = -10 + r.nextInt(20);
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        int spriteHeight = imagen.getHeight(null);
        int spriteWidth = imagen.getWidth(null);

        AffineTransform affineTransform = new AffineTransform();
        affineTransform.rotate(Math.toRadians(rotation), xPos + spriteWidth / 2, yPos
                + spriteHeight / 2);
        affineTransform.translate(xPos, yPos);

        g2d.drawImage(imagen, affineTransform, null);
    }
    
    
    @Override
    public void update(){ 
        Random r = new Random();
        rotation+=r.nextInt(20);
        xPos += xVel;
        yPos += yVel;
        
        xPos = (600 + xPos) % 600;
        yPos = (400 + yPos) % 400;
    }
    
    @Override
    public Rectangle getRect(){
        Rectangle rect = null;
        rect = new Rectangle(xPos, yPos, imagen.getWidth(null), imagen.getHeight(null));
        return rect;
    }
    
}
