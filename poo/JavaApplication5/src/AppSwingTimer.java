/*
 * AppSwingTimer.java
 *
 * Created on 4 de septiembre de 2007, 08:25 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

/**
 *
 * @author alejo
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AppSwingTimer implements ActionListener{
    JFrame frame;
    JLabel label;
    JButton button;
    Timer timer;
    int delay,cont;
    boolean frozen = false;
    
    /** Creates a new instance of AppSwingTimer */
    public AppSwingTimer() {
        delay = 100;
        cont = 0;
        frame = new JFrame("Timer");
        label = new JLabel();
        
        button = new JButton("Start");
        button.addActionListener(this);
        timer = new Timer(delay, this);
        timer.setInitialDelay(0);
        timer.setCoalesce(true);
        
        button.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if (frozen) {
                    frozen = false;
                    if (frozen) {
                        //Do nothing.  The user has requested that we
                        //stop changing the image.
                    } else {
                        //Start (or restart) animating!
                        timer.start();
                    }
                } else {
                    frozen = true;
                    timer.stop();
                }
            }
        });
        
        frame.setSize(new Dimension(200,300));
        frame.getContentPane().add(label,BorderLayout.NORTH);
        //frame.getContentPane().add(label,BorderLayout.CENTER);
        frame.getContentPane().add(button,BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        frame.setVisible(true);
        frame.pack();
    }
    
    
    public void actionPerformed(ActionEvent e){
        if(button.getText().equals("Start")){
            cont++;
            
            label.setText("tiempo "+cont);
        
        }
    
    }
    
    public static void main(String[] args){
        AppSwingTimer a = new AppSwingTimer(); 
    }
    
}
