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
import java.util.Timer;
import java.util.TimerTask;



/**
 *
 * @author made
 */
public class MiCanvas extends Canvas implements KeyListener{
    Universo universo;
    Nave nave;
    Image imgBuffer;
    Graphics miG;
    Timer timer;
    
    public MiCanvas(){
        universo = new Universo();
        nave = new Nave();
        timer = new Timer();
        setBounds(0, 0, 600, 400);
        imgBuffer = new BufferedImage(600, 400, BufferedImage.OPAQUE);
        timer.schedule(new Actualizador(), 0, 100);
        
    }
    
    public void update(Graphics g){
        paint(g);
    }
    
    public void paint(Graphics g){
        miG = imgBuffer.getGraphics();
	universo.draw(miG);
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
            nave.update();
            repaint();
        }
        
    }
    
}
