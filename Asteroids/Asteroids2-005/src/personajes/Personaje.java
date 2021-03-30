/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package personajes;

import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author made
 */
public interface Personaje {
    public void draw(Graphics g);
    public void update();
    public Rectangle getRect();
    
}
