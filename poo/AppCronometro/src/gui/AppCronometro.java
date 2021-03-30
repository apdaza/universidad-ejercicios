/*
 * AppCronometro.java
 *
 * Created on 7/09/2007, 08:48:55 AM
 *
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import logic.Cronometro;

/**
 *
 * @author alejo
 */
public class AppCronometro implements ActionListener{
    
    
    JFrame frame;
    JPanel panel;
    JButton btnIniciar,btnParar,btnReset,btnRetroceder,btnMemoria;
    JLabel lblTime;
    JLabel[] lblMemoria;
    Timer timer;
    
    boolean frozen;
    boolean forward;
    
    Font font;
    
    Cronometro crn;
    
    int contador;
    
    public AppCronometro() {
        contador = 0;
        font = new Font("Arial",font.BOLD,80);
        crn = new Cronometro();
        frame = new JFrame("Cronometro");
        panel = new JPanel(new GridLayout(2,5));
        btnIniciar = new JButton("Iniciar");
        btnIniciar.addActionListener(this);
        btnRetroceder = new JButton("Retroceder");
        btnRetroceder.addActionListener(this);
        btnParar = new JButton("Parar");
        btnParar.addActionListener(this);
        btnReset = new JButton("Reset");
        btnReset.addActionListener(this);
        btnMemoria = new JButton("Memoria");
        btnMemoria.addActionListener(this);
        lblTime = new JLabel("0 : 0 : 0",SwingConstants.CENTER);
        lblTime.setFont(font);
        lblTime.setForeground(new Color(128,128,250));
        lblMemoria = new JLabel[5];
        
        for(int i=0;i<lblMemoria.length;i++){
            lblMemoria[i]=new JLabel("0 : 0 : 0",SwingConstants.CENTER);
            panel.add(lblMemoria[i]);
        }
        
        panel.add(btnIniciar);
        panel.add(btnRetroceder);
        panel.add(btnParar);
        panel.add(btnReset);
        panel.add(btnMemoria);
        
        frame.getContentPane().add(lblTime, BorderLayout.NORTH);
        frame.getContentPane().add(panel, BorderLayout.SOUTH);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        frame.pack();
        frame.setVisible(true);
        
        frozen = true;
        forward = false;
    }
    
    class RemindTask extends TimerTask {
        public void run() {
            
            if(frozen){
                System.out.println("Terminamos la ejecucion del timer");
                timer.cancel();
            }else{
                if(forward){
                    lblTime.setText(crn.avanzar());
                }else{
                    lblTime.setText(crn.retroceder());
                }
            }
        }
    }
    
    public void actionPerformed(ActionEvent a) {
        System.out.println(a.getActionCommand());
        if(a.getActionCommand().equals("Iniciar")){
            frozen = false;
            forward = true;
            timer = new Timer();
            timer.schedule(new RemindTask(),0, 1*100);
            btnRetroceder.setEnabled(false);
        }
        if(a.getActionCommand().equals("Retroceder")){
            frozen = false;
            forward = false;
            timer = new Timer();
            timer.schedule(new RemindTask(),0, 1*100);
            btnIniciar.setEnabled(false);
        }
        if(a.getActionCommand().equals("Parar")){
            frozen = true;
            btnIniciar.setEnabled(true);
            btnRetroceder.setEnabled(true);
        }
        if(a.getActionCommand().equals("Reset")){
            frozen = true;
            lblTime.setText(crn.reset());
            for(int x=0;x<lblMemoria.length;x++){
                lblMemoria[x].setText(crn.generarMemoria());
            }
            btnIniciar.setEnabled(true);
            btnRetroceder.setEnabled(true);
            btnMemoria.setEnabled(true);
        }
        if(a.getActionCommand().equals("Memoria")){
            lblMemoria[contador].setText(crn.generarMemoria());
            if(contador<lblMemoria.length-1){
                contador++;
            }else{
                contador = 0;
                btnMemoria.setEnabled(false);
            }
        }
    }
    
    public static void main(String[] args){
        JFrame.setDefaultLookAndFeelDecorated(true);
        AppCronometro c = new AppCronometro();
    }
    
    
    
    
}
