/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.productos;

import logica.productos.Personaje;

/**
 *
 * @author alejandro
 */
public class Esqueleto extends Personaje{

    public Esqueleto() {
        String[] imagenes = {"imagenes/SB1.png","imagenes/SB2.png","imagenes/SB3.png",
                             "imagenes/SF1.png","imagenes/SF2.png","imagenes/SF3.png",
                             "imagenes/SD1.png","imagenes/SD2.png","imagenes/SD3.png",
                             "imagenes/SI1.png","imagenes/SI2.png","imagenes/SI3.png"};
        this.setImages(imagenes);
    }
    
}
