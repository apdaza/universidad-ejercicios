/*
 * Cita.java
 * 
 * Created on 7/04/2008, 10:40:35 PM
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package logica;

/**
 *
 * @author alejo
 */
public class Cita {
    int id;
    Contacto contacto;
    String lugar;
    String fecha;
    String hora;
    String asunto;

    public Cita() {
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public Contacto getContacto() {
        return contacto;
    }

    public void setContacto(Contacto contacto) {
        this.contacto = contacto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    
    

}
