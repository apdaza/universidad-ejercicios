/*
 * UnidadTiempo.java
 * 
 * Created on 6/09/2007, 10:43:46 PM
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package logic;

/**
 *
 * @author alejo
 */
public class UnidadTiempo {
    int valor;
    int tope;
    
    public int forward(){
        if(valor < tope)valor++;
        else valor=0;
        return valor;
    }

    public int back(){
        if(valor > 0)valor--;
        else valor=tope;
        return valor;
    }
    
    public int reset(){
        valor=0;
        return valor;
    }
}
