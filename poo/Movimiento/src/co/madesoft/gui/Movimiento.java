/*
 * Invaders.java
 *
 * Created on 24 de noviembre de 2007, 02:15 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package co.madesoft.gui;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

import java.net.URL;
import javax.imageio.ImageIO;
import java.util.HashMap;

/**
 *
 * @author apdaza
 */
public class Movimiento extends Canvas {
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    public static final int SPEED = 10;
    
    public HashMap sprites;
    public int posX,posY,vX;
    public BufferedImage buffer;
    /** Creates a new instance of Invaders */
    public Movimiento() {
        
        sprites = new HashMap();
        
        posX=WIDTH/2;
        posY=HEIGHT/2;
        
        vX=2;
        
        buffer = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
        
        JFrame ventana = new JFrame("Invaders");
        JPanel panel = (JPanel)ventana.getContentPane();
        
        setBounds(0,0,WIDTH,HEIGHT);
        panel.setPreferredSize(new Dimension(WIDTH,HEIGHT));
        panel.setLayout(null);
        panel.add(this);
        
        ventana.setBounds(0,0,WIDTH,HEIGHT);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        ventana.setVisible(true);
        ventana.setIgnoreRepaint(true);
        ventana.setResizable(false);
    }
    
    public BufferedImage loadImage(String nombre){
        URL url = null;
        try{
            url = getClass().getClassLoader().getResource(nombre);
            return ImageIO.read(url);
        }catch(Exception e){
            System.out.println("No se pudo cargar la imagen "+ nombre + " de " + url);
            System.out.println("El error fue "+getClass().getName()+" "+e.getMessage());
            System.exit(0);
            return null;
        }
    }
    
    public BufferedImage getSprite(String nombre){
        BufferedImage img = (BufferedImage)sprites.get(nombre);
        if(img==null){
            img = loadImage("res/"+nombre);
            sprites.put(nombre,img);
        }
        return img;
    }
    
    public void paintWorld(){
        Graphics g = buffer.getGraphics();
        g.setColor(getBackground());
        g.fillRect(0,0,getWidth(),getHeight());
        
        g.drawImage(getSprite("bicho.gif"),posX,posY,this);
        getGraphics().drawImage(buffer,0,0,this);
    }
    
    public void updateWorld(){
        posX += vX;
        if (posX < 0 || posX > WIDTH) vX = -vX;
    }
    
    public void game(){
        while(isVisible()){
            updateWorld();
            paintWorld();
            paint(getGraphics());
            try{
                Thread.sleep(SPEED);
            }catch (InterruptedException e){}
        }
    }
    
    public void paint(Graphics g){}
    public void update(Graphics g){}
    
    public static void main(String[] args){
        Movimiento inv = new Movimiento();
        inv.game();
    }
    
}
