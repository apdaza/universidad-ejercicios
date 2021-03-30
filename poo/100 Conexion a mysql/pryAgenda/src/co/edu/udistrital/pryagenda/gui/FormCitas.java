/*
 * FormCitas.java
 * 
 * Created on 15/05/2008, 07:53:02 AM
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.udistrital.pryagenda.gui;

import co.edu.udistrital.pryagenda.datos.DBCitas;
import co.edu.udistrital.pryagenda.datos.DBContactos;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import co.edu.udistrital.pryagenda.logica.*;

/**
 *
 * @author alejandro
 */
public class FormCitas implements ActionListener {
    FormAgenda padre;
    JFrame frame;
    Container contenedor;
    
    JLabel labelId,labelContacto,labelLugar,labelAsunto,labelFecha,labelHora;
    JTextField textId,textContacto,textLugar,textAsunto,textFecha,textHora;
    
    JButton botonAceptar, botonCancelar;
    
    Cita cita;
    Contacto contacto;
    DBContactos dbc = new DBContactos();
    DBCitas dbcit =new DBCitas();
    String estado;

    public FormCitas(Cita c,FormAgenda f) {
        initComponents(c);
        estado = "edit";
        padre = f;
    }
    public FormCitas(Contacto c,FormAgenda f) {
        initComponents(c);
        estado = "add";
        padre = f;
    }
    
    public void initComponents(Cita c){
        cita = c;
        frame = new JFrame("Editar citas");
        contenedor = frame.getContentPane();
        contenedor.setLayout(null);
        
        int x = 10;
        int y = 5;
        
        int labelAncho = 150;
        int labelAlto = 20;
        int textAncho = 200;
        int textAlto = 20;
        labelId = new JLabel("Id");
        labelId.setBounds(x,y,20,20);
        contenedor.add(labelId);
        
        textId = new JTextField();
        textId.setBounds(x+30,y,50,20);
        textId.setEditable(false);
        textId.setText(String.valueOf(cita.getId()));
        contenedor.add(textId);
        
        y+=30;
        labelContacto = new JLabel("Contacto",SwingConstants.RIGHT);
        labelContacto.setBounds(x,y,labelAncho,labelAlto);
        contenedor.add(labelContacto);
        
        textContacto = new JTextField();
        textContacto.setBounds(x+160,y,textAncho,textAlto);
        textContacto.setText(cita.getContacto().getNombre()+" "+cita.getContacto().getApellido());
        textContacto.setEditable(false);
        contenedor.add(textContacto);
        
        y+=30;
        labelFecha = new JLabel("Fecha",SwingConstants.RIGHT);
        labelFecha.setBounds(x,y,labelAncho,labelAlto);
        contenedor.add(labelFecha);
        
        textFecha = new JTextField();
        textFecha.setBounds(x+160,y,textAncho,textAlto);
        textFecha.setText(cita.getFecha());
        contenedor.add(textFecha);
        
         y+=30;
        labelHora = new JLabel("Hora",SwingConstants.RIGHT);
        labelHora.setBounds(x,y,labelAncho,labelAlto);
        contenedor.add(labelHora);
        
        textHora = new JTextField();
        textHora.setBounds(x+160,y,textAncho,textAlto);
        textHora.setText(cita.getHora());
        contenedor.add(textHora);
        
         y+=30;
        labelLugar = new JLabel("Lugar",SwingConstants.RIGHT);
        labelLugar.setBounds(x,y,labelAncho,labelAlto);
        contenedor.add(labelLugar);
        
        textLugar = new JTextField();
        textLugar.setBounds(x+160,y,textAncho,textAlto);
        textLugar.setText(cita.getLugar());
        contenedor.add(textLugar);
        
         y+=30;
        labelAsunto = new JLabel("Asunto",SwingConstants.RIGHT);
        labelAsunto.setBounds(x,y,labelAncho,labelAlto);
        contenedor.add(labelAsunto);
        
        textAsunto = new JTextField();
        textAsunto.setBounds(x+160,y,textAncho,textAlto);
        textAsunto.setText(cita.getAsunto());
        contenedor.add(textAsunto);
        
         y+=50;
        botonAceptar = new JButton("Aceptar");
        botonAceptar.setBounds(x,y,labelAncho,50);
        contenedor.add(botonAceptar);
        botonAceptar.addActionListener(this);
        
        botonCancelar = new JButton("Cancelar");
        botonCancelar.setBounds(x+310,y,labelAncho,50);
        contenedor.add(botonCancelar);
        botonCancelar.addActionListener(this);
        
        frame.pack();
        frame.setBounds(200, 200, 500, 300);
        frame.setResizable(false);
        frame.setVisible(true);
    }
    
    public void initComponents(Contacto c){
        contacto = c;
        frame = new JFrame("Agregar citas");
        contenedor = frame.getContentPane();
        contenedor.setLayout(null);
        
        int x = 10;
        int y = 5;
        
        int labelAncho = 150;
        int labelAlto = 20;
        int textAncho = 200;
        int textAlto = 20;
        labelId = new JLabel("Id");
        labelId.setBounds(x,y,20,20);
        contenedor.add(labelId);
        
        textId = new JTextField();
        textId.setBounds(x+30,y,50,20);
        textId.setEditable(false);
        contenedor.add(textId);
        
        y+=30;
        labelContacto = new JLabel("Contacto",SwingConstants.RIGHT);
        labelContacto.setBounds(x,y,labelAncho,labelAlto);
        contenedor.add(labelContacto);
        
        textContacto = new JTextField();
        textContacto.setBounds(x+160,y,textAncho,textAlto);
        textContacto.setText(contacto.getNombre()+" "+contacto.getApellido());
        textContacto.setEditable(false);
        contenedor.add(textContacto);
        
        y+=30;
        labelFecha = new JLabel("Fecha",SwingConstants.RIGHT);
        labelFecha.setBounds(x,y,labelAncho,labelAlto);
        contenedor.add(labelFecha);
        
        textFecha = new JTextField();
        textFecha.setBounds(x+160,y,textAncho,textAlto);
        contenedor.add(textFecha);
        
         y+=30;
        labelHora = new JLabel("Hora",SwingConstants.RIGHT);
        labelHora.setBounds(x,y,labelAncho,labelAlto);
        contenedor.add(labelHora);
        
        textHora = new JTextField();
        textHora.setBounds(x+160,y,textAncho,textAlto);
        contenedor.add(textHora);
        
         y+=30;
        labelLugar = new JLabel("Lugar",SwingConstants.RIGHT);
        labelLugar.setBounds(x,y,labelAncho,labelAlto);
        contenedor.add(labelLugar);
        
        textLugar = new JTextField();
        textLugar.setBounds(x+160,y,textAncho,textAlto);
        contenedor.add(textLugar);
        
         y+=30;
        labelAsunto = new JLabel("Asunto",SwingConstants.RIGHT);
        labelAsunto.setBounds(x,y,labelAncho,labelAlto);
        contenedor.add(labelAsunto);
        
        textAsunto = new JTextField();
        textAsunto.setBounds(x+160,y,textAncho,textAlto);
        contenedor.add(textAsunto);
        
         y+=50;
        botonAceptar = new JButton("Aceptar");
        botonAceptar.setBounds(x,y,labelAncho,50);
        contenedor.add(botonAceptar);
        botonAceptar.addActionListener(this);
        
        botonCancelar = new JButton("Cancelar");
        botonCancelar.setBounds(x+310,y,labelAncho,50);
        contenedor.add(botonCancelar);
        botonCancelar.addActionListener(this);
        
        frame.pack();
        frame.setBounds(200, 200, 500, 300);
        frame.setResizable(false);
        frame.setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        String accion = e.getActionCommand();
        if(accion.equals("Aceptar")){
            if(estado.equals("add")){
                cita = new Cita();
                cita.setContacto(contacto);
                cita.setFecha(textFecha.getText());
                cita.setHora(textHora.getText());
                cita.setLugar(textLugar.getText());
                cita.setAsunto(textAsunto.getText());
                
                dbcit.insertarCita(cita);
                JOptionPane.showMessageDialog(null, "Cita Agregada");
                padre.llenarTablaCitas();
            }else{
                cita.setFecha(textFecha.getText());
                cita.setHora(textHora.getText());
                cita.setLugar(textLugar.getText());
                cita.setAsunto(textAsunto.getText());
                
                dbcit.actualizarCita(cita);
                JOptionPane.showMessageDialog(null, "Cita Actualizada");
                padre.llenarTablaCitas();
            }
            
        }
        frame.setVisible(false);
    }
    
}
