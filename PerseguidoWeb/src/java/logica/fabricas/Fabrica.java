/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.fabricas;

import logica.productos.Esqueleto;
import logica.productos.Humano;
import logica.productos.Personaje;
import logica.productos.Zombie;

/**
 *
 * @author alejandro
 */
public class Fabrica {
    public static Personaje crearPersonaje(int tipo){
        Personaje personaje;
        switch (tipo) {
            case 0:
                personaje = new Esqueleto();
                break;
            case 1:
                personaje = new Zombie();
                break;
            default:
                personaje = new Humano();
                break;
        }
        return personaje;
    }
    
}
