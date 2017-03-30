/*
 * Memoria.java
 *
 * Created on 6 de octubre de 2007, 01:22 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package logic;

/**
 *
 * @author apdaza
 */
public class Memoria {
    Horas h;
    Minutos m;
    Segundos s;
    
    public Memoria(){
        h = new Horas();
        m = new Minutos();
        s = new Segundos();
    }
    
    public void setMemoria(int h, int m, int s){
        this.h.valor=h;
        this.m.valor=m;
        this.s.valor=s;
    }
    
    public String getMemoria(){
        String cadena = this.h.valor + " : " +
                        this.m.valor + " : " +
                        this.s.valor;
        return cadena;
    }
    
}
