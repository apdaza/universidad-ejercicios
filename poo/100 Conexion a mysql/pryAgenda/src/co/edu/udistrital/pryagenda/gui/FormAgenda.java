/*
 * FormAgenda.java
 * 
 * Created on 15/04/2008, 07:58:48 AM
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.udistrital.pryagenda.gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import co.edu.udistrital.pryagenda.datos.*;
import co.edu.udistrital.pryagenda.logica.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alejo
 */
public class FormAgenda implements ActionListener{
    JFrame frame;
    JPanel panel;
    JMenuBar menuBar;
    JMenu menu, subMenu;
    JMenuItem menuItem;
    JScrollPane scrollPanel,scrollPanelCitas;
    DefaultTableModel modeloTabla,modeloTablaCitas;
    JTable tablaContactos,tablaCitas;
    JTabbedPane pestana;
    Container panelInformacion,panelCitas;
    JLabel labelId,
            labelNombre,
            labelApellido,
            labelTelefonoDomicilio,
            labelTelefonoOficina,
            labelDireccionDomicilio,
            labelDireccionOficina,
            labelCelular,
            labelCorreo;
    JTextField textId,
            textNombre,
            textApellido,
            textTelefonoDomicilio,
            textTelefonoOficina,
            textDireccionDomicilio,
            textDireccionOficina,
            textCelular,
            textCorreo;
    
    JButton botonNuevoContacto,
            botonGuardarContacto,
            botonEditarContacto,
            botonBorrarContacto,
            botonNuevaCita,
            botonEditarCita,
            botonBorrarCita;
    
    DBContactos dbc = new DBContactos();
    DBCitas dbcit =new DBCitas();
    Contacto[] contactos;
    Cita[] citas;
    Contacto contacto;
    Cita cita;
    
    int estado=0;
    int fila;
    int filaCitas;
    
    public FormAgenda() {
        initComponents();
    }
    
    public void initComponents(){
        frame = new JFrame("Agenda de Contactos");
                
        //creacion del menu
        menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);
        //opciones de app
        menu = new JMenu("Opciones");
        menuBar.add(menu);
        menuItem = new JMenuItem("Acerca de ...");
        menuItem.addActionListener(this);
        menu.add(menuItem);
        menuItem = new JMenuItem("Salir");
        menuItem.addActionListener(this);
        menu.add(menuItem);
        
        //pestanas
        panelInformacion = new JPanel(null);
        panelInformacion.setLayout(null);
        panelCitas = new JPanel(null);
        panelCitas.setLayout(null);
        
        pestana = new JTabbedPane();
        pestana.addTab("Información de contacto", panelInformacion);
        pestana.addTab("Citas",panelCitas);
        
        int y = 5;
        int x = 10;
        int labelAncho = 150;
        int labelAlto = 20;
        int textAncho = 200;
        int textAlto = 20;
        labelId = new JLabel("Id");
        labelId.setBounds(x,y,20,20);
        panelInformacion.add(labelId);
        
        textId = new JTextField();
        textId.setBounds(x+30,y,50,20);
        panelInformacion.add(textId);
        
        y+=30;
        labelNombre = new JLabel("Nombre",SwingConstants.RIGHT);
        labelNombre.setBounds(x,y,labelAncho,labelAlto);
        panelInformacion.add(labelNombre);
        
        textNombre = new JTextField();
        textNombre.setBounds(x+160,y,textAncho,textAlto);
        panelInformacion.add(textNombre);
        
        labelApellido = new JLabel("Apellido",SwingConstants.RIGHT);
        labelApellido.setBounds(x+350,y,labelAncho,labelAlto);
        panelInformacion.add(labelApellido);
        
        textApellido = new JTextField();
        textApellido.setBounds(x+510,y,textAncho,textAlto);
        panelInformacion.add(textApellido);
        
        y+=30;
        labelTelefonoDomicilio = new JLabel("Telefono Domicilio",SwingConstants.RIGHT);
        labelTelefonoDomicilio.setBounds(x,y,labelAncho,labelAlto);
        panelInformacion.add(labelTelefonoDomicilio);
        
        textTelefonoDomicilio = new JTextField();
        textTelefonoDomicilio.setBounds(x+160,y,textAncho,textAlto);
        panelInformacion.add(textTelefonoDomicilio);
        
        labelTelefonoOficina = new JLabel("Telefono Oficina",SwingConstants.RIGHT);
        labelTelefonoOficina.setBounds(x+350,y,labelAncho,labelAlto);
        panelInformacion.add(labelTelefonoOficina);
        
        textTelefonoOficina = new JTextField();
        textTelefonoOficina.setBounds(x+510,y,textAncho,textAlto);
        panelInformacion.add(textTelefonoOficina);
        
        y+=30;
        labelDireccionDomicilio = new JLabel("Dirreción Domicilio",SwingConstants.RIGHT);
        labelDireccionDomicilio.setBounds(x,y,labelAncho,labelAlto);
        panelInformacion.add(labelDireccionDomicilio);
        
        textDireccionDomicilio = new JTextField();
        textDireccionDomicilio.setBounds(x+160,y,textAncho,textAlto);
        panelInformacion.add(textDireccionDomicilio);
        
        labelDireccionOficina = new JLabel("Dirección Oficina",SwingConstants.RIGHT);
        labelDireccionOficina.setBounds(x+350,y,labelAncho,labelAlto);
        panelInformacion.add(labelDireccionOficina);
        
        textDireccionOficina = new JTextField();
        textDireccionOficina.setBounds(x+510,y,textAncho,textAlto);
        panelInformacion.add(textDireccionOficina);
        
        y+=30;
        labelCelular = new JLabel("Celular",SwingConstants.RIGHT);
        labelCelular.setBounds(x,y,labelAncho,labelAlto);
        panelInformacion.add(labelCelular);
        
        textCelular = new JTextField();
        textCelular.setBounds(x+160,y,textAncho,textAlto);
        panelInformacion.add(textCelular);
        
        labelCorreo = new JLabel("Correo",SwingConstants.RIGHT);
        labelCorreo.setBounds(x+350,y,labelAncho,labelAlto);
        panelInformacion.add(labelCorreo);
        
        textCorreo = new JTextField();
        textCorreo.setBounds(x+510,y,textAncho,textAlto);
        panelInformacion.add(textCorreo);
        
        y+=60;
        botonNuevoContacto = new JButton("Nuevo Contacto");
        botonNuevoContacto.setBounds(x,y,labelAncho,50);
        panelInformacion.add(botonNuevoContacto);
        botonNuevoContacto.addActionListener(this);
        
        botonGuardarContacto = new JButton("Guardar Contacto");
        botonGuardarContacto.setBounds(x+200,y,labelAncho,50);
        panelInformacion.add(botonGuardarContacto);
        botonGuardarContacto.addActionListener(this);
        
        botonEditarContacto = new JButton("Editar Contacto");
        botonEditarContacto.setBounds(x+400,y,labelAncho,50);
        panelInformacion.add(botonEditarContacto);
        botonEditarContacto.addActionListener(this);
        
        botonBorrarContacto = new JButton("Borrar Contacto");
        botonBorrarContacto.setBounds(x+600,y,labelAncho,50);
        panelInformacion.add(botonBorrarContacto);
        botonBorrarContacto.addActionListener(this);
        
        contactos = dbc.getContactos();
        Object[][] data = new Object[contactos.length][5];
        for (int c=0;c<contactos.length;c++){
            data[c][0]=contactos[c].getId();
            data[c][1]=contactos[c].getNombre();
            data[c][2]=contactos[c].getApellido();
            data[c][3]=contactos[c].getCelular();
            data[c][4]=contactos[c].getCorreo(); 
        }
        
        String[] columNames = {"id","nombres","apellidos","celular","correo"};
        
        modeloTabla= new DefaultTableModel(data, columNames);
                
        tablaContactos = new JTable(modeloTabla);
        tablaContactos.setPreferredScrollableViewportSize(new Dimension(500, 150));
                
        scrollPanel = new JScrollPane(tablaContactos);
        
        tablaContactos.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                fila = tablaContactos.rowAtPoint(e.getPoint());
                int columna = tablaContactos.columnAtPoint(e.getPoint());
                if ((fila > -1) && (columna > -1)){
                    contacto = dbc.getContactoById(Integer.valueOf((String.valueOf(tablaContactos.getValueAt(fila,0)))));
                    textId.setText(String.valueOf(contacto.getId()));
                    textNombre.setText(contacto.getNombre());
                    textApellido.setText(contacto.getApellido());
                    textTelefonoDomicilio.setText(contacto.getTelefonoDomicilio());
                    textTelefonoOficina.setText(contacto.getTelefonoOficina());
                    textDireccionDomicilio.setText(contacto.getDireccionResidencia());
                    textDireccionOficina.setText(contacto.getDireccionTrabajo());
                    textCelular.setText(contacto.getCelular());
                    textCorreo.setText(contacto.getCorreo());
                    estado = 2;
                    alterarEstado();
                }
            }
        });
        
        citas = dbcit.getCitas();
        Object[][] citasData = new Object[citas.length][6];
        for(int i=0;i<citas.length;i++){
            citasData[i][0]=citas[i].getId();
            citasData[i][1]=citas[i].getContacto().getApellido()+" "
                            +citas[i].getContacto().getNombre();
            citasData[i][2]=citas[i].getLugar();
            citasData[i][3]=citas[i].getFecha();
            citasData[i][4]=citas[i].getHora();
            citasData[i][5]=citas[i].getAsunto();
        }
        String[] columNamesCitas = {"id","contacto","lugar","fecha","hora","asunto"};
        modeloTablaCitas = new DefaultTableModel(citasData,columNamesCitas);
        tablaCitas = new JTable(modeloTablaCitas);
        tablaCitas.setPreferredScrollableViewportSize(new Dimension(500,150));
        scrollPanelCitas = new JScrollPane(tablaCitas);
        
        x=15;
        y=10;
        scrollPanelCitas.setBounds(x, y, 750, 150);
        panelCitas.add(scrollPanelCitas);
        
        y+=180;
        botonNuevaCita = new JButton("Nueva Cita");
        botonNuevaCita.setBounds(x,y,labelAncho,50);
        panelCitas.add(botonNuevaCita);
        botonNuevaCita.addActionListener(this);
        
        botonEditarCita = new JButton("Editar Cita");
        botonEditarCita.setBounds(x+300,y,labelAncho,50);
        panelCitas.add(botonEditarCita);
        botonEditarCita.addActionListener(this);
        
        botonBorrarCita = new JButton("Borrar Cita");
        botonBorrarCita.setBounds(x+600,y,labelAncho,50);
        panelCitas.add(botonBorrarCita);
        botonBorrarCita.addActionListener(this);
        
        //////////////////////////////////////
        tablaCitas.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                filaCitas = tablaCitas.rowAtPoint(e.getPoint());
                int columnaCitas = tablaCitas.columnAtPoint(e.getPoint());
                if ((filaCitas > -1) && (columnaCitas > -1)){
                    cita = dbcit.getCitaById(Integer.parseInt(String.valueOf(tablaCitas.getValueAt(filaCitas,0))));
                    
                    estado = 4;
                    alterarEstado();
                }
            }
        });
        //////////////////////////////////////////
        
        frame.getContentPane().add(scrollPanel,BorderLayout.NORTH);
        frame.getContentPane().add(pestana,BorderLayout.CENTER);
        
        frame.pack();
        frame.setSize(800, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        JFrame.setDefaultLookAndFeelDecorated(true);
        
        frame.setVisible(true);
        
        alterarEstado();
    }
    
    public void alterarEstado(){
        switch(this.estado){
            case 0://estado por defecto 
                botonNuevoContacto.setEnabled(true);
                botonBorrarContacto.setEnabled(false);
                botonEditarContacto.setEnabled(false);
                botonGuardarContacto.setEnabled(false);
                
                botonNuevaCita.setEnabled(false);
                botonEditarCita.setEnabled(false);
                botonBorrarCita.setEnabled(false);

                textId.setEditable(false);
                textNombre.setEditable(false);
                textApellido.setEditable(false);
                textTelefonoDomicilio.setEditable(false);
                textTelefonoOficina.setEditable(false);
                textDireccionDomicilio.setEditable(false);
                textDireccionOficina.setEditable(false);
                textCorreo.setEditable(false);
                textCelular.setEditable(false);
                break;
            case 1://estado para un nuevo contacto
                botonNuevoContacto.setEnabled(false);
                botonBorrarContacto.setEnabled(false);
                botonEditarContacto.setEnabled(false);
                botonGuardarContacto.setEnabled(true);
                
                botonNuevaCita.setEnabled(false);
                botonEditarCita.setEnabled(false);
                botonBorrarCita.setEnabled(false);

                textId.setEditable(false);
                textNombre.setEditable(true);
                textApellido.setEditable(true);
                textTelefonoDomicilio.setEditable(true);
                textTelefonoOficina.setEditable(true);
                textDireccionDomicilio.setEditable(true);
                textDireccionOficina.setEditable(true);
                textCorreo.setEditable(true);
                textCelular.setEditable(true);
                break;
            case 2://estado de carga de un contacto
                botonNuevoContacto.setEnabled(true);
                botonBorrarContacto.setEnabled(true);
                botonEditarContacto.setEnabled(true);
                botonGuardarContacto.setEnabled(false);
                
                botonNuevaCita.setEnabled(true);
                botonEditarCita.setEnabled(false);
                botonBorrarCita.setEnabled(false);

                textId.setEditable(false);
                textNombre.setEditable(false);
                textApellido.setEditable(false);
                textTelefonoDomicilio.setEditable(false);
                textTelefonoOficina.setEditable(false);
                textDireccionDomicilio.setEditable(false);
                textDireccionOficina.setEditable(false);
                textCorreo.setEditable(false);
                textCelular.setEditable(false);
                break;
            case 3://estado para editar un contacto
                botonNuevoContacto.setEnabled(true);
                botonBorrarContacto.setEnabled(false);
                botonEditarContacto.setEnabled(false);
                botonGuardarContacto.setEnabled(true);
                
                botonNuevaCita.setEnabled(false);
                botonEditarCita.setEnabled(false);
                botonBorrarCita.setEnabled(false);

                textId.setEditable(false);
                textNombre.setEditable(true);
                textApellido.setEditable(true);
                textTelefonoDomicilio.setEditable(true);
                textTelefonoOficina.setEditable(true);
                textDireccionDomicilio.setEditable(true);
                textDireccionOficina.setEditable(true);
                textCorreo.setEditable(true);
                textCelular.setEditable(true);
                break;
            case 4://estado para editar o borrar una cita
                botonNuevoContacto.setEnabled(true);
                botonBorrarContacto.setEnabled(false);
                botonEditarContacto.setEnabled(false);
                botonGuardarContacto.setEnabled(true);
                
                botonNuevaCita.setEnabled(false);
                botonEditarCita.setEnabled(true);
                botonBorrarCita.setEnabled(true);

                textId.setEditable(false);
                textNombre.setEditable(false);
                textApellido.setEditable(false);
                textTelefonoDomicilio.setEditable(false);
                textTelefonoOficina.setEditable(false);
                textDireccionDomicilio.setEditable(false);
                textDireccionOficina.setEditable(false);
                textCorreo.setEditable(false);
                textCelular.setEditable(false);
                break;
                
                
        }
    }
    
    public void limpiarCampos(){
        textId.setText("");
        textNombre.setText("");
        textApellido.setText("");
        textTelefonoDomicilio.setText("");
        textTelefonoOficina.setText("");
        textDireccionDomicilio.setText("");
        textDireccionOficina.setText("");
        textCorreo.setText("");
        textCelular.setText("");
    }
    
    public void actionPerformed(ActionEvent e) {
        String accion = e.getActionCommand();
        System.out.println(accion);
        if(accion.equals("Salir")){
            System.exit(-1);
        }
        if(accion.equals("Acerca de ...")){
            DialogAcerca a = new DialogAcerca(null,false);
            a.setVisible(true);
        }
        if(accion.equals("Nuevo Contacto")){
            limpiarCampos();
            this.estado=1;
        }
        if(accion.equals("Editar Contacto")){
            this.estado=3;
        }
        if(accion.equals("Guardar Contacto")){
            if(this.estado==1){
                Contacto c = new Contacto();
                c.setNombre(textNombre.getText());
                c.setApellido(textApellido.getText());
                c.setTelefonoDomicilio(textTelefonoDomicilio.getText());
                c.setTelefonoOficina(textTelefonoOficina.getText());
                c.setDireccionResidencia(textDireccionDomicilio.getText());
                c.setDireccionTrabajo(textDireccionOficina.getText());
                c.setCorreo(textCorreo.getText());
                c.setCelular(textCelular.getText());
                
                int r = dbc.insertarContacto(c);
                if(r>0){
                    Object[] newRow={r,c.getNombre(),c.getApellido(),c.getCelular(),c.getCorreo()};
                    modeloTabla.addRow(newRow);
                    JOptionPane.showMessageDialog(null, "Contacto agregado");
                }
            }else if(this.estado==3){
                Contacto c = new Contacto();
                c.setId(Integer.parseInt(textId.getText(),10));
                c.setNombre(textNombre.getText());
                c.setApellido(textApellido.getText());
                c.setTelefonoDomicilio(textTelefonoDomicilio.getText());
                c.setTelefonoOficina(textTelefonoOficina.getText());
                c.setDireccionResidencia(textDireccionDomicilio.getText());
                c.setDireccionTrabajo(textDireccionOficina.getText());
                c.setCorreo(textCorreo.getText());
                c.setCelular(textCelular.getText());
                
                int r = dbc.actualizarContacto(c);
                if(r>0){
                    modeloTabla.setValueAt(c.getNombre(), fila, 1);
                    modeloTabla.setValueAt(c.getApellido(), fila, 2);
                    modeloTabla.setValueAt(c.getCelular(), fila, 3);
                    modeloTabla.setValueAt(c.getCorreo(), fila, 4);
                    JOptionPane.showMessageDialog(null, "Contacto actualizado");
                }
            }
            contactos = dbc.getContactos();
            limpiarCampos();
            this.estado=0;
        }
        if(accion.equals("Borrar Contacto")){
            Contacto c = new Contacto();
            c.setId(Integer.parseInt(textId.getText(),10));
            int r = dbc.borrarContacto(c);
            if(r>0){
                modeloTabla.removeRow(fila);
                JOptionPane.showMessageDialog(null, "Contacto borrado");
                limpiarCampos();
            }
            contactos = dbc.getContactos();
            this.estado=0;
          
        }
        if(accion.equals("Nueva Cita")){
            FormCitas f = new FormCitas(contacto,this);
        }
        if(accion.equals("Editar Cita")){
            FormCitas f = new FormCitas(cita,this);
        }
        if(accion.equals("Borrar Cita")){
            dbcit.borrarCita(cita);
            JOptionPane.showMessageDialog(null, "Cita borrada");
            modeloTablaCitas.removeRow(filaCitas);
        }
        alterarEstado();
    }
    
    public void limpiarTablaCitas(){
        int contFilas = modeloTablaCitas.getRowCount();
        System.out.println(contFilas);
        for(int i=0;i<contFilas;i++){
            modeloTablaCitas.removeRow(0);
        }
    }
    
    public void llenarTablaCitas(){
        limpiarTablaCitas();
        citas = dbcit.getCitas();
        for(int i=0;i<citas.length;i++){
            Object[] newRow = {citas[i].getId(),
                     citas[i].getContacto().getApellido()+" "+citas[i].getContacto().getNombre(),
                     citas[i].getLugar(),
                     citas[i].getFecha(),
                     citas[i].getHora(),
                     citas[i].getAsunto()
                };
            modeloTablaCitas.addRow(newRow);
        }
    }
    
    

}
