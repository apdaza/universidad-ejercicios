/*
 * AppCalculadora.java
 *
 * Created on 6 de octubre de 2007, 07:18 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package gui;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import logica.*;

/**
 *
 * @author apdaza
 */
public class AppCalculadora implements ActionListener {
    private JFrame frame;
    private ButtonGroup btgSistema;
    private JButton[] btnBotones;
    private JRadioButton[] jrbSistemas;
    private JTextField txtResultado;
    private Container cpane;
    Decimal d;
    Conversion c;
    int s;
    /**
     * Creates a new instance of AppCalculadora
     */
    public AppCalculadora() {
        initComponents();
    }
    
    
    
    private void initComponents(){
        d = new Decimal();
        c = new Conversion();
        s=10;
        frame = new JFrame("Calculadora de Cuatro Sistemas") ;
        btgSistema = new ButtonGroup();
        btnBotones = new JButton[24];
        jrbSistemas = new JRadioButton[4] ;
        txtResultado = new JTextField(0);
        
        int cont=0;
        btnBotones[cont++]=new JButton("D");
        btnBotones[cont++]=new JButton("E");
        btnBotones[cont++]=new JButton("F");
        btnBotones[cont++]=new JButton("/");
        btnBotones[cont++]=new JButton("A");
        btnBotones[cont++]=new JButton("B");
        btnBotones[cont++]=new JButton("C");
        btnBotones[cont++]=new JButton("*");
        btnBotones[cont++]=new JButton("7");
        btnBotones[cont++]=new JButton("8");
        btnBotones[cont++]=new JButton("9");
        btnBotones[cont++]=new JButton("-");
        btnBotones[cont++]=new JButton("4");
        btnBotones[cont++]=new JButton("5");
        btnBotones[cont++]=new JButton("6");
        btnBotones[cont++]=new JButton("+");
        btnBotones[cont++]=new JButton("1");
        btnBotones[cont++]=new JButton("2");
        btnBotones[cont++]=new JButton("3");
        btnBotones[cont++]=new JButton("=");
        btnBotones[cont++]=new JButton("0");
        btnBotones[cont++]=new JButton(".");
        btnBotones[cont++]=new JButton("Cl");
        btnBotones[cont++]=new JButton("CE");
        
        cont=0;
        jrbSistemas[cont++]=new JRadioButton("BIN");
        jrbSistemas[cont++]=new JRadioButton("OCT");
        jrbSistemas[cont++]=new JRadioButton("DEC");
        jrbSistemas[cont++]=new JRadioButton("HEX");
        
        for(int i=0;i<jrbSistemas.length;i++){
            btgSistema.add(jrbSistemas[i]);
        }
        
        cpane = frame.getContentPane();
        cpane.setLayout(null);
        
        txtResultado.setBounds(10,10,260,30);
        txtResultado.setEditable(false);
        txtResultado.setBackground(Color.white);
        txtResultado.setHorizontalAlignment(JTextField.RIGHT);
        cpane.add(txtResultado);
        
        int x=10;
        int y=45;
        for(int i=0;i<jrbSistemas.length;i++){
            x=i*70+10;
            jrbSistemas[i].setBounds(x,y,60,20);
            jrbSistemas[i].addActionListener(this);
            cpane.add(jrbSistemas[i]);
            
        }
        x=10;
        y=35;
        for(int i=0;i<btnBotones.length;i++){
            if(i%4==0){
                x=10;
                y+=35;
            }else{
                x+=70;
            }
            
            btnBotones[i].setBounds(x,y,50,30);
                        
            btnBotones[i].addActionListener(this);
            cpane.add(btnBotones[i]);
        }
        
        jrbSistemas[2].setSelected(true);
        elegirSistema(10);
        
        frame.pack();
        frame.setSize(290,320);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private void elegirSistema(int sistema){
        s=sistema;
        for(int i=0;i<btnBotones.length;i++){
            if(!btnBotones[i].getText().equals("+")&&
                    !btnBotones[i].getText().equals("-")&&
                    !btnBotones[i].getText().equals("*")&&
                    !btnBotones[i].getText().equals("/")&&
                    !btnBotones[i].getText().equals("=")){
                btnBotones[i].setEnabled(false);
            }
        }
        switch(sistema){
            case 2:
                for(int i=0;i<btnBotones.length;i++){
                    if(!btnBotones[i].getText().equals("A")&&
                            !btnBotones[i].getText().equals("B")&&
                            !btnBotones[i].getText().equals("C")&&
                            !btnBotones[i].getText().equals("D")&&
                            !btnBotones[i].getText().equals("E")&&
                            !btnBotones[i].getText().equals("F")&&
                            !btnBotones[i].getText().equals("9")&&
                            !btnBotones[i].getText().equals("8")&&
                            !btnBotones[i].getText().equals("7")&&
                            !btnBotones[i].getText().equals("6")&&
                            !btnBotones[i].getText().equals("5")&&
                            !btnBotones[i].getText().equals("4")&&
                            !btnBotones[i].getText().equals("3")&&
                            !btnBotones[i].getText().equals("2")){
                        btnBotones[i].setEnabled(true);
                    }
                }
                break;
            case 8:
                for(int i=0;i<btnBotones.length;i++){
                    if(!btnBotones[i].getText().equals("A")&&
                            !btnBotones[i].getText().equals("B")&&
                            !btnBotones[i].getText().equals("C")&&
                            !btnBotones[i].getText().equals("D")&&
                            !btnBotones[i].getText().equals("E")&&
                            !btnBotones[i].getText().equals("F")&&
                            !btnBotones[i].getText().equals("9")&&
                            !btnBotones[i].getText().equals("8")){
                        btnBotones[i].setEnabled(true);
                    }
                }
                break;
            case 10:
                for(int i=0;i<btnBotones.length;i++){
                    if(!btnBotones[i].getText().equals("A")&&
                            !btnBotones[i].getText().equals("B")&&
                            !btnBotones[i].getText().equals("C")&&
                            !btnBotones[i].getText().equals("D")&&
                            !btnBotones[i].getText().equals("E")&&
                            !btnBotones[i].getText().equals("F")){
                        btnBotones[i].setEnabled(true);
                    }
                }
                break;
            case 16:
                for(int i=0;i<btnBotones.length;i++){
                    btnBotones[i].setEnabled(true);
                }
                break;
        }
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getActionCommand().equals("Cl")||e.getActionCommand().equals("CE")){
            txtResultado.setText("");
        }
        if(e.getActionCommand().equals("BIN")){
            elegirSistema(2);
        }
        if(e.getActionCommand().equals("OCT")){
            elegirSistema(8);
        }
        if(e.getActionCommand().equals("DEC")){
            elegirSistema(10);
        }
        if(e.getActionCommand().equals("HEX")){
            elegirSistema(16);
        }
        if(!e.getActionCommand().equals("+")&&
                !e.getActionCommand().equals("-")&&
                !e.getActionCommand().equals("*")&&
                !e.getActionCommand().equals("/")&&
                !e.getActionCommand().equals("=")&&
                !e.getActionCommand().equals(".")&&
                !e.getActionCommand().equals("Cl")&&
                !e.getActionCommand().equals("CE")&&
                !e.getActionCommand().equals("BIN")&&
                !e.getActionCommand().equals("OCT")&&
                !e.getActionCommand().equals("DEC")&&
                !e.getActionCommand().equals("HEX")){
            txtResultado.setText(txtResultado.getText()+e.getActionCommand());
        }
        
        if(e.getActionCommand().equals("+")||
                e.getActionCommand().equals("-")||
                e.getActionCommand().equals("*")||
                e.getActionCommand().equals("/")){
            d.setOperacion(e.getActionCommand().charAt(0));
            switch(s){
                case 2:
                    d.setNumeroA(c.fromBinario(txtResultado.getText()));
                    break;
                case 8:
                    d.setNumeroA(c.fromOctal(txtResultado.getText()));
                    break;
                case 10:
                    d.setNumeroA(Integer.parseInt(txtResultado.getText()));
                    break;
                case 16:
                    d.setNumeroA(c.fromHexadecimal(txtResultado.getText()));
                    break;
            }
            txtResultado.setText("");
        }
        
        if(e.getActionCommand().equals("=")){
            switch(s){
                case 2:
                    d.setNumeroB(c.fromBinario(txtResultado.getText()));
                    break;
                case 8:
                    d.setNumeroB(c.fromOctal(txtResultado.getText()));
                    break;
                case 10:
                    d.setNumeroB(Integer.parseInt(txtResultado.getText()));
                    break;
                case 16:
                    d.setNumeroB(c.fromHexadecimal(txtResultado.getText()));
                    break;
            }
            switch(d.getOperacion()){
                case '+':
                    d.suma();
                    break;
                case '-':
                    d.resta();
                    break;
                case '*':
                    d.multiplicacion();
                    break;
                case '/':
                    d.division();
                    break;
            }
            switch(s){
                case 2:
                    txtResultado.setText(c.toBinario(d.getResultado()));
                    break;
                case 8:
                    txtResultado.setText(c.toOctal(d.getResultado()));
                    break;
                case 10:
                    txtResultado.setText(String.valueOf(d.getResultado()));
                    break;
                case 16:
                    txtResultado.setText(c.toHexadecimal(d.getResultado()));
                    break;
            }
        }
    }
    
    public static void main(String[] args){
        new AppCalculadora();
    }
    
}
