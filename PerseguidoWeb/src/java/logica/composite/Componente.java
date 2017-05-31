/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.composite;

/**
 *
 * @author alejandro
 */
public abstract class Componente {
    protected int x;
    protected int y;
    protected int velocidadX;
    protected int velocidadY;
    protected int sprite;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getVelocidadX() {
        return velocidadX;
    }
    
    public int getVelocidadY() {
        return velocidadY;
    }

    public int getSprite() {
        return sprite;
    }
    
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setVelocidadX(int velocidad) {
        this.velocidadX = velocidad;
    }

    public void setVelocidadY(int velocidad) {
        this.velocidadY = velocidad;
    } 
    
    public void setSprite(int sprite) {
        this.sprite = sprite;
    }
    
    
       
    public abstract void actualizar(int x, int y);
    
}
