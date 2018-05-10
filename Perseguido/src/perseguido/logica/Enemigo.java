/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perseguido.logica;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;
import javax.swing.ImageIcon;

/**
 *
 * @author daza
 */
public class Enemigo implements Personaje {
    Image[][] imagenes = {{new ImageIcon(getClass().getResource("../imagenes/SB1.png")).getImage(),
                           new ImageIcon(getClass().getResource("../imagenes/SB2.png")).getImage(),
                           new ImageIcon(getClass().getResource("../imagenes/SB3.png")).getImage()
                          },
                          {new ImageIcon(getClass().getResource("../imagenes/SD1.png")).getImage(),
                           new ImageIcon(getClass().getResource("../imagenes/SD2.png")).getImage(),
                           new ImageIcon(getClass().getResource("../imagenes/SD3.png")).getImage()
                          },
                          {new ImageIcon(getClass().getResource("../imagenes/SF1.png")).getImage(),
                           new ImageIcon(getClass().getResource("../imagenes/SF2.png")).getImage(),
                           new ImageIcon(getClass().getResource("../imagenes/SF3.png")).getImage()
                          },
                          {new ImageIcon(getClass().getResource("../imagenes/SI1.png")).getImage(),
                           new ImageIcon(getClass().getResource("../imagenes/SI2.png")).getImage(),
                           new ImageIcon(getClass().getResource("../imagenes/SI3.png")).getImage()
                          }
                        };
    int sentido = 2;
    int cont = 0;
    Image imagen = imagenes[sentido][cont];
    int xPos = 32;
    int yPos = 32;
    int xVel = 0;
    int yVel = 10;

    public Enemigo() {
        Random r = new Random();
        xPos = r.nextInt(600);
        xPos = r.nextInt(600);
    }
    
    

    @Override
    public void draw(Graphics g) {
        
        g.drawImage(imagen, xPos, yPos, null);
    }
    
    @Override
    public void update(){
        xPos += xVel;
        yPos += yVel;
        cont ++;
        cont = cont % 3;
        imagen = imagenes[sentido][cont];
        
    }

    public void update(int c) {
        
    }
    @Override
    public void cambiarSentido(){
        Random r = new Random();
        sentido = r.nextInt(4);
        switch(sentido){
            case 0:
                xVel = 10;
                yVel = 0;
                //yPos += 10;
                break;
            case 1:
                xVel = 0;
                yVel = 10;
                //xPos -= 10;
                break;
            case 2:
                xVel = -10;
                yVel = 0;
                //yPos -= 10;
                break;
            case 3:
                xVel = 0;
                yVel = -10;
                //xPos += 10;
                break;
        }
    }
    @Override
    public Rectangle getRect() {
        Rectangle rect = null;
        rect = new Rectangle(xPos, yPos, imagen.getWidth(null), imagen.getHeight(null));
        return rect;
    }

}
