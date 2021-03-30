/*
 * 1.1 Swing version.
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/* 
 * Based on Arthur van Hoff's animation examples, this application
 * can serve as a template for all animation applications.
 */
public class AnimatorApplicationTimer extends JFrame 
                                      implements ActionListener {
    int frameNumber = -1;
    int delay;
    boolean frozen = false;
    JLabel label;
    Timer timer; //Is the priority of this thread too high?
                 //Sometimes I can't interrupt the program easily.

    AnimatorApplicationTimer(int fps, String windowTitle) {
        super(windowTitle);
        delay = (fps > 0) ? (1000 / fps) : 100;

        //Set up a timer that calls this object's action handler.
        timer = new Timer(delay, this);
        timer.setInitialDelay(0);
        timer.setCoalesce(true);

        addWindowListener(new WindowAdapter() {
            public void windowIconified(WindowEvent e) {
                stopAnimation();
            }
            public void windowDeiconified(WindowEvent e) {
                startAnimation();
            }
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }  
        });

        Container contentPane = getContentPane();
        contentPane.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if (frozen) {
                    frozen = false;
                    startAnimation();
                } else {
                    frozen = true;
                    stopAnimation();
                }
            }
        });

        label = new JLabel("Frame       ", JLabel.CENTER);
        contentPane.add(label, BorderLayout.CENTER);
    }

    public void startAnimation() {
        if (frozen) {
            //Do nothing.  The user has requested that we
            //stop changing the image.
        } else {
            //Start (or restart) animating!
            timer.start();
        }
    }

    public void stopAnimation() {
        //Stop the animating thread.
        timer.stop();
    }

    public void actionPerformed(ActionEvent e) {
        //Advance the animation frame.
        frameNumber++;
        label.setText("Frame " + frameNumber);
    }

    public static void main(String args[]) {
        AnimatorApplicationTimer animator = null;
        int fps = 10;

        // Get frames per second from the command line argument
        if (args.length > 0) {
            try {
                fps = Integer.parseInt(args[0]);
            } catch (Exception e) {}
        }
        animator = new AnimatorApplicationTimer(fps, "Animator with Timer");
        animator.pack();
        animator.setVisible(true);
        animator.startAnimation();
    }
}