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
public class Humano extends Personaje{

    public Humano() {
        String[] imagenes = {"imagenes/B1.png","imagenes/B2.png","imagenes/B3.png",
                             "imagenes/F1.png","imagenes/F2.png","imagenes/F3.png",
                             "imagenes/D1.png","imagenes/D2.png","imagenes/D3.png",
                             "imagenes/I1.png","imagenes/I2.png","imagenes/I3.png"};
        this.setImages(imagenes);
    }
    
    
}
