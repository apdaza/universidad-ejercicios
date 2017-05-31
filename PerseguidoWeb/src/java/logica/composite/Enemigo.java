/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.composite;

import java.util.Random;

/**
 *
 * @author alejandro
 */
public class Enemigo extends Componente {

    public Enemigo() {
        Random r = new Random();
        this.x = r.nextInt(620);
        this.y = r.nextInt(220)+100;
        this.sprite = 0;
        this.velocidadX = r.nextInt(10)-5;
        this.velocidadY = r.nextInt(10)-5;
    }
    
    

    @Override
    public void actualizar(int x, int y) {
        /*if (x < this.x) {
            this.x -= this.velocidad;
            this.sprite = 0;
        }
        if (x > this.x) {
            this.x += this.velocidad;
            this.sprite = 1;
        }
        if (y < this.y) {
            this.y -= this.velocidad;
        }
        if (y > this.y) {
            this.y += this.velocidad;
        }*/
        this.x += this.velocidadX;
        this.y += this.velocidadY;
        this.sprite += 1;
        this.sprite %= 2;
        this.x = (640 + this.x) % 640;
        this.y = (480 + this.y) % 480;
    }

}
