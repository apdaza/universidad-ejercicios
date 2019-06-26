/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oso.logica;

import java.awt.Graphics;

/**
 *
 * @author estudiantes
 */
public class Circulo implements Componente{
    private int x;
    private int y;
    private int diametro;
    private boolean lleno;

    public Circulo(int x, int y, int diametro, boolean lleno) {
        this.x = x;
        this.y = y;
        this.diametro = diametro;
        this.lleno = lleno;
    }
        
    @Override
    public void dibujar(Graphics g) {
        if(lleno){
            g.fillOval(x, y, diametro, diametro);
        }else{
            g.drawOval(x, y, diametro, diametro);
        }
    }
    
}
