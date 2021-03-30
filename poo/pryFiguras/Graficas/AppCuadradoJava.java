package Graficas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AppCuadradoJava implements ActionListener{
	
	JFrame frame;
	JPanel panel;
	JLabel lblLado, lblArea, lblPerimetro;
	JTextField txtLado, txtArea, txtPerimetro;
	JButton btnAceptar;
	
	Cuadrado c;
	public AppCuadradoJava(){
		c = new Cuadrado();
		
		frame = new JFrame("AppCuadrado");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel=new JPanel(new GridLayout(3,2));
		
		lblLado=new JLabel("Lado : ",SwingConstants.RIGHT);
		lblArea=new JLabel("Area : ",SwingConstants.CENTER);
		lblPerimetro=new JLabel("Perimetro : ",SwingConstants.CENTER);
		
		txtLado = new JTextField(2);
		txtArea = new JTextField(20);
		txtPerimetro = new JTextField(20);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		
		frame.getRootPane().setDefaultButton(btnAceptar);
		
		panel.add(lblLado);
		panel.add(txtLado);
		panel.add(lblPerimetro);
		panel.add(lblArea);
		panel.add(txtPerimetro);
		panel.add(txtArea);
		
		frame.getContentPane().add(panel,BorderLayout.NORTH);
		frame.getContentPane().add(btnAceptar,BorderLayout.SOUTH);
		
		frame.pack();
		frame.setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		c.setLado((double)Double.parseDouble(txtLado.getText()));
		c.setArea();
		c.setPerimetro();
		
		txtPerimetro.setText(String.valueOf(c.getPerimetro()));
		txtArea.setText(String.valueOf(c.getArea()));
		
	}
	
	public static void main (String[]args){
		
		JFrame.setDefaultLookAndFeelDecorated(true);
		AppCuadradoJava a =new AppCuadradoJava();
		
	}
	
	
}

