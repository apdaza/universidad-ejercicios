/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perseguido.gui;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TimerTask;
import java.util.Timer;
import javax.swing.ImageIcon;
import perseguido.logica.Heroe;
import perseguido.logica.Personaje;
import perseguido.logica.Roca;

/**
 *
 * @author daza
 */
public class Lienzo extends Canvas implements KeyListener{
    Personaje heroe = new Heroe();
    Timer timer;
    BufferedImage imgBuffer;
    String[][] matriz;
    ArrayList<Personaje> rocas;
    
    public Lienzo(){
        rocas = new ArrayList<Personaje>();
        timer = new Timer();
        timer.schedule(new Actualizador(), 0, 100);
        imgBuffer = new BufferedImage(600, 600, BufferedImage.TRANSLUCENT);
    }
       

    public void iniciarLienzo(String[][] matriz) {
        this.matriz = matriz;
        for (int f = 0; f < matriz.length; f++) {
            for (int c = 0; c < matriz[f].length; c++) {
                if (matriz[f][c].equals("1")) {
                    rocas.add(new Roca(f * 32, c * 32));
                }

            }
        }
    }
    
    

    @Override
    public void paint(Graphics g) {
        //super.paint(g); //To change body of generated methods, choose Tools | Templates.
    
        Graphics miG = imgBuffer.getGraphics();
        //miG.drawImage(new ImageIcon(getClass().getResource("../imagenes/fondo.png")).getImage(), 0, 0, null);
        miG.clearRect(0, 0, 800, 600);
        
        for (Iterator<Personaje> iterator = rocas.iterator(); iterator.hasNext();) {
            Personaje next = iterator.next();
            next.draw(miG);

        }
        heroe.draw(miG);
        g.drawImage(imgBuffer, 0, 0, this);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        heroe.update(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private class Actualizador extends TimerTask{

        @Override
        public void run() {
            Iterator<Personaje> it = rocas.iterator();
            heroe.update();           
            while(it.hasNext()){
                Personaje r = it.next();
                if(r.getRect().intersects(heroe.getRect())){
                    heroe.cambiarSentido();
                    break;
                }
            }
            repaint();
        }
        
    }
    
    
}
