/*
 * AppContadorSwing.java
 * 
 * Created on 12/09/2007, 06:42:37 PM
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alejo
 */
/*
 * AppCronometro.java
 * 
 * Created on 7/09/2007, 08:48:55 AM
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.*;

/**
 *
 * @author alejo
 */
public class AppContadorSwing implements ActionListener{
    
    
    JFrame frame;
    JPanel panel;
    JButton btnIniciar,btnParar,btnReset;
    JLabel lblTime;
    Timer timer;
    int segundos;
    boolean frozen;
    
    Font font;
    
 

    public AppContadorSwing() {   
        frame = new JFrame("Contador Swing");
        panel = new JPanel(new GridLayout(1,3));
        btnIniciar = new JButton("Iniciar");
        btnIniciar.addActionListener(this);
        btnParar = new JButton("Parar");
        btnParar.addActionListener(this);
        btnReset = new JButton("Reset");
        btnReset.addActionListener(this);
        lblTime = new JLabel("0",SwingConstants.CENTER);
        
        panel.add(btnIniciar);
        panel.add(btnParar);
        panel.add(btnReset);
        
        frame.getContentPane().add(lblTime, BorderLayout.NORTH);
        frame.getContentPane().add(panel, BorderLayout.SOUTH);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        frame.pack();
        frame.setVisible(true);
        
        frozen = true;
        segundos = 0;
    }
    
    class RemindTask extends TimerTask {
        public void run() {
                segundos++;
                lblTime.setText(String.valueOf(segundos));
                if(frozen){
                    System.out.println("Terminamos la ejecucion del timer");
                    timer.cancel(); 
                }
        }
    }

    public void actionPerformed(ActionEvent a) {
        System.out.println(a.getActionCommand());
        if(a.getActionCommand().equals("Iniciar")){
            frozen = false;
            timer = new Timer();
            timer.schedule(new RemindTask(),0, 1*100);
        }
        if(a.getActionCommand().equals("Parar")){
            frozen = true;
        }
        if(a.getActionCommand().equals("Reset")){
            frozen = true;
            segundos = 0;
            lblTime.setText(String.valueOf(segundos));
        }
    }
    
    public static void main(String[] args){
        JFrame.setDefaultLookAndFeelDecorated(true);
        AppContadorSwing c = new AppContadorSwing();
    }
    
    
    

}

