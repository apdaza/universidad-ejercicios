/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package personajes;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author made
 */
public class Universo implements Personaje {
    Image imagen;
    
    public Universo(){
        imagen = new ImageIcon(getClass().getResource(
                "/imagenes/space.png")).getImage();
    }
    
    @Override
    public void draw(Graphics g){
        g.drawImage(imagen, 0, 0, null);
    }

    @Override
    public void update() {
        
    }
    
}
