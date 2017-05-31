/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.productos;

/**
 *
 * @author alejandro
 */
public class Zombie extends Personaje{

    public Zombie() {
        String[] imagenes = {"imagenes/ZB1.png","imagenes/ZB2.png","imagenes/ZB3.png",
                             "imagenes/ZF1.png","imagenes/ZF2.png","imagenes/ZF3.png",
                             "imagenes/ZD1.png","imagenes/ZD2.png","imagenes/ZD3.png",
                             "imagenes/ZI1.png","imagenes/ZI2.png","imagenes/ZI3.png"};
        this.setImages(imagenes);
    }
    
}
