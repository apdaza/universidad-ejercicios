/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perseguido.logica;

import java.awt.Graphics;
import javax.swing.ImageIcon;

/**
 *
 * @author daza
 */
public class Laberinto {
    String[][] matriz;

    public void setMatriz(String[][] matriz) {
        this.matriz = matriz;
    }
    
    
    public void draw(Graphics g){
        g.drawImage(new ImageIcon(getClass().getResource("../imagenes/fondo.png")).getImage(), 0, 0, null);
        for(int f = 0; f < matriz.length; f++){
            for(int c = 0; c < matriz[f].length; c++){
                if(matriz[f][c].equals("1"))
                g.drawImage(new ImageIcon(getClass().getResource("../imagenes/wall2.jpg")).getImage(), f*32, c*32, null);
            }
        }
        
    }
    
}
