/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package personajes;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;



/**
 *
 * @author made
 */
public class MiCanvas extends Canvas implements KeyListener{
    Universo universo;
    Nave nave;
    ArrayList<Personaje> rocas;
    Image imgBuffer;
    Graphics miG;
    Timer timer;
    
    public MiCanvas(){
        universo = new Universo();
        nave = new Nave();
        rocas = new ArrayList<Personaje>();
        
        for(int i=0; i<10; i++)
            rocas.add(new Roca());
        
        timer = new Timer();
        setBounds(0, 0, 600, 400);
        imgBuffer = new BufferedImage(600, 400, BufferedImage.OPAQUE);
        timer.schedule(new Actualizador(), 0, 100);
        
    }
    
    @Override
    public void update(Graphics g){
        paint(g);
    }
    
    @Override
    public void paint(Graphics g){
        Iterator<Personaje> it = rocas.iterator();
        miG = imgBuffer.getGraphics();
	universo.draw(miG);
        	
        while(it.hasNext()){
            it.next().draw(miG);
            
        }
        
        nave.draw(miG);
        
        g.drawImage(imgBuffer, 0, 0, this);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        nave.update(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private class Actualizador extends TimerTask{

        @Override
        public void run() {
            Iterator<Personaje> it = rocas.iterator();
            nave.update();           
            while(it.hasNext()){
                Personaje r = it.next();
                r.update();
            }
            
            Iterator<Personaje> it2 = rocas.iterator();
            while(it2.hasNext()){
                Personaje r = it2.next();
                if(r.getRect().intersects(nave.getRect())){
                    rocas.remove(r);
                    break;
                }
            }
            repaint();
        }
        
    }
    
}
