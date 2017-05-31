/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.composite.Enemigo;
import logica.composite.Poblacion;
import logica.fabricas.Fabrica;
import logica.productos.Esqueleto;
import logica.productos.Humano;
import logica.productos.Personaje;
import logica.productos.Zombie;

/**
 *
 * @author alejandro
 */
public class Inicio extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //response.setContentType("text/html;charset=UTF-8");
        try {
            Random r = new Random();
            int opcion = r.nextInt(3);
            Personaje personaje = Fabrica.crearPersonaje(opcion);
            
            request.getSession().setAttribute("B1", personaje.getImages()[0]);
            request.getSession().setAttribute("B2", personaje.getImages()[1]);
            request.getSession().setAttribute("B3", personaje.getImages()[2]);
            request.getSession().setAttribute("F1", personaje.getImages()[3]);
            request.getSession().setAttribute("F2", personaje.getImages()[4]);
            request.getSession().setAttribute("F3", personaje.getImages()[5]);
            request.getSession().setAttribute("D1", personaje.getImages()[6]);
            request.getSession().setAttribute("D2", personaje.getImages()[7]);
            request.getSession().setAttribute("D3", personaje.getImages()[8]);
            request.getSession().setAttribute("I1", personaje.getImages()[9]);
            request.getSession().setAttribute("I2", personaje.getImages()[10]);
            request.getSession().setAttribute("I3", personaje.getImages()[11]);
            
            Poblacion enemigos = new Poblacion();
            for(int i=0; i<20; i++){
                enemigos.addMiembro(new Enemigo());
            }
            
            request.getSession().setAttribute("enemigos", enemigos);
            
            response.sendRedirect("index.jsp");
        }catch(Exception e){
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
