/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import javax.swing.JFrame;
import personajes.MiCanvas;

/**
 *
 * @author made
 */
public class FormularioPrincipal extends JFrame{
    MiCanvas canvas;
    
    public FormularioPrincipal(){
        canvas = new MiCanvas();
        
        setLayout(null);
        getContentPane().add(canvas);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        addKeyListener(canvas);
        setBounds(0, 0, 600, 400);
        setVisible(true);

    }


}
