package gui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import logica.Matematicas;

public class AppCalculadoraSwing implements ActionListener{
	JFrame frame;
	JPanel pnlBotones;
	JButton[] btnBotones;
	JTextField txtPantalla;
	char operacion;
	Matematicas m;
	
	public AppCalculadoraSwing(){
		frame = new JFrame("Mi Calculadora");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pnlBotones = new JPanel(new GridLayout(4,5));
		btnBotones = new JButton[20];
		txtPantalla = new JTextField(10);
		m = new Matematicas();
		int cont=0;
		btnBotones[cont++]=new JButton("7");
		btnBotones[cont++]=new JButton("8");
		btnBotones[cont++]=new JButton("9");
		btnBotones[cont++]=new JButton("+");
		btnBotones[cont++]=new JButton("^");
		btnBotones[cont++]=new JButton("4");
		btnBotones[cont++]=new JButton("5");
		btnBotones[cont++]=new JButton("6");
		btnBotones[cont++]=new JButton("-");
		btnBotones[cont++]=new JButton("!");
		btnBotones[cont++]=new JButton("1");
		btnBotones[cont++]=new JButton("2");
		btnBotones[cont++]=new JButton("3");
		btnBotones[cont++]=new JButton("*");
		btnBotones[cont++]=new JButton("CE");
		btnBotones[cont++]=new JButton(".");
		btnBotones[cont++]=new JButton("0");
		btnBotones[cont++]=new JButton("=");
		btnBotones[cont++]=new JButton("/");
		btnBotones[cont++]=new JButton("clr");
		
		for(int i=0;i<20;i++){
			btnBotones[i].addActionListener(this);
			pnlBotones.add(btnBotones[i]);
		}
		
		frame.getContentPane().add(txtPantalla,BorderLayout.NORTH);
		frame.getContentPane().add(pnlBotones,BorderLayout.SOUTH);
		
		frame.pack();
		frame.setVisible(true);
		
		
		
	}
	
	public static void main(String[] args){
		AppCalculadoraSwing a = new AppCalculadoraSwing();
		JFrame.setDefaultLookAndFeelDecorated(true);
	}
	
	public void actionPerformed(ActionEvent e){
		
		
		if(e.getActionCommand()!= "+" && e.getActionCommand()!= "-" &&
		   e.getActionCommand()!= "*" && e.getActionCommand()!= "/" &&
		   e.getActionCommand()!= "^" && e.getActionCommand()!= "!" &&
		   e.getActionCommand()!= "CE" && e.getActionCommand()!= "clr" && 
		   e.getActionCommand()!= "="){
			txtPantalla.setText(txtPantalla.getText()+e.getActionCommand()); 
		}else{
			if(e.getActionCommand()!="CE" && e.getActionCommand()!="clr" 
				&& e.getActionCommand()!="="&& e.getActionCommand()!="!"){
				m.setOperandoUno(Double.parseDouble(txtPantalla.getText()));
				operacion = e.getActionCommand().charAt(0);
				txtPantalla.setText("");
			}else{
				if(e.getActionCommand()=="="){
					System.out.println(txtPantalla.getText().length());
					if(txtPantalla.getText().length()!=0){
						m.setOperandoDos(Double.parseDouble(txtPantalla.getText()));
					}else{
						if(operacion=='/' || operacion=='*'){
							m.setOperandoDos(1.0);
						}else{
							m.setOperandoDos(0.0);
						}
					}
					switch(operacion){
						case '+':
							m.suma();
							break;
						case '-':
							m.resta();
							break;
						case '*':
							m.producto();
							break;
						case '/':
							m.division();
							break;
						case '^':
							m.potencia();
							break;
					}
					txtPantalla.setText(String.valueOf(m.getResultado()));
				}
				if(e.getActionCommand()=="!"){
					m.setOperandoUno(Double.parseDouble(txtPantalla.getText()));
					m.factorial();
					txtPantalla.setText(String.valueOf(m.getResultado()));
				}
				
			}
		}
		
	}

}
