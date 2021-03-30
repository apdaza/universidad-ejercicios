/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author Estudiantes
 */
public class Bebida extends Componente{
    String[] variedad = {"Jugo","Gaseosa","Papelon","Agua"}; 
    public Bebida() {
        this.seleccionarVariedad(variedad);
    }
}
