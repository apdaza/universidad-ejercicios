package Graficas;

import javax.swing.*;


import java.awt.*;
import java.awt.event.*;

public class AppRectanguloJava implements ActionListener{
	
	JFrame frame;
	JPanel panel;
	JLabel lblLado1, lblLado2, lblArea, lblPerimetro;
	JTextField txtLado1, txtLado2, txtArea, txtPerimetro;
	JButton btnAceptar;
	
	Rectangulo r;
	public AppRectanguloJava(){
		r=new Rectangulo();
		
		frame = new JFrame("AppRectangulo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel=new JPanel(new GridLayout(4,2));
		
		lblLado1=new JLabel("Lado 1 : ",SwingConstants.RIGHT);
		lblLado2=new JLabel("Lado 2 : ",SwingConstants.RIGHT);
		lblArea=new JLabel("Area : ",SwingConstants.RIGHT);
		lblPerimetro=new JLabel("Perimetro : ",SwingConstants.RIGHT);
		
		txtLado1 = new JTextField(2);
		txtLado2 = new JTextField(2);
		txtArea = new JTextField(20);
		txtPerimetro = new JTextField(20);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		
		frame.getRootPane().setDefaultButton(btnAceptar);
		
		panel.add(lblLado1);
		panel.add(txtLado1);
		panel.add(lblLado2);
		panel.add(txtLado2);
		panel.add(lblPerimetro);
		panel.add(txtPerimetro);
		panel.add(lblArea);
		panel.add(txtArea);
		
		frame.getContentPane().add(panel,BorderLayout.NORTH);
		frame.getContentPane().add(btnAceptar,BorderLayout.SOUTH);
		
		frame.pack();
		frame.setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		r.setLado1((double)Double.parseDouble(txtLado1.getText()));
		r.setLado2((double)Double.parseDouble(txtLado2.getText()));
		r.setArea();
		r.setPerimetro();
		
		txtPerimetro.setText(String.valueOf(r.getPerimetro()));
		txtArea.setText(String.valueOf(r.getArea()));
		
	}
	
	public static void main (String[]args){
		
		JFrame.setDefaultLookAndFeelDecorated(true);
		AppRectanguloJava a =new AppRectanguloJava();
		
	}
	
	
}

