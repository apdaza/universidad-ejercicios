/*
 * Minutos.java
 * 
 * Created on 6/09/2007, 10:48:18 PM
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package logic;

/**
 *
 * @author alejo
 */
public class Minutos extends UnidadTiempo {

    public Minutos() {
        this.valor=0;
        this.tope=59;
    }
    
    public Minutos(int m){
        Minutos min = this;
        min.valor = m;
    }

}
