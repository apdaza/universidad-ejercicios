package co.madesoft.db;

import java.sql.*;

public class DbEstudiante {
	DbConnection cn;
	
    /** Constructor de DbUser */
    public DbEstudiante() {
        cn = new DbConnection();
    }
    
    /** Obtiene las notas de un estudiante por su codigo */
    public Object[][] getNotasByEstudiante(String cod){
    	int registros = 0;

        try{
            Statement stm = cn.getConnection().createStatement();
            PreparedStatement pstm = cn.getConnection().prepareStatement("SELECT count(1) as cont" +
            " FROM asignatura a " +
            " inner join nota n on a.asi_codigo = n.asi_codigo" +
            " where n.est_codigo = ? ");
            
            pstm.setString(1, cod);
            ResultSet res = pstm.executeQuery();

            res.next();
            registros = res.getInt("cont");
            res.close();	
            
            
        }catch(SQLException e){
            System.out.println(e);
        }
        Object [][] data = new Object[registros][5];
        try{
            Statement stm = cn.getConnection().createStatement();
            PreparedStatement pstm = cn.getConnection().prepareStatement("SELECT n.asi_codigo, " +
            		" a.asi_nombre, " +
            		" n.nota " +
            		" FROM asignatura a " +
            		" inner join nota n on a.asi_codigo = n.asi_codigo " +
            		" where n.est_codigo = ? order by n.asi_codigo ");
            
            pstm.setString(1, cod);
            ResultSet res = pstm.executeQuery();
            int i = 0;
            while(res.next()){
                String asiCodigo = res.getString("asi_codigo");
                String asiNombre = res.getString("asi_nombre");
                Double asiNota = res.getDouble("nota");
                

                data[i][0] = asiCodigo;
                data[i][1] = asiNombre;
                data[i][2] = asiNota;
                
                i++;
            }
            res.close();	
            
            
        }catch(SQLException e){
         System.out.println(e);
        }
        return data;

    }
    /** trae todos los estudiantes */
    public Object[][] getEstudiantes(){
       int registros = 0;

       try{
           Statement stm = cn.getConnection().createStatement();
           PreparedStatement pstm = cn.getConnection().prepareStatement("SELECT count(1) as cont" +
           " FROM estudiante ");
           

           ResultSet res = pstm.executeQuery();

           res.next();
           registros = res.getInt("cont");
           res.close();	
           
           
       }catch(SQLException e){
           System.out.println(e);
       }
       Object [][] data = new Object[registros][5];
       try{
           Statement stm = cn.getConnection().createStatement();
           PreparedStatement pstm = cn.getConnection().prepareStatement("SELECT est_codigo, " +
                                                                       " est_nombre " +
                                                                       " FROM estudiante " + 
                                                                       " ORDER BY est_codigo ");
           

           ResultSet res = pstm.executeQuery();
           int i = 0;
           while(res.next()){
               String estCodigo = res.getString("est_codigo");
               String estNombre = res.getString("est_nombre");
               

               data[i][0] = estCodigo;
               data[i][1] = estNombre;
               
               i++;
           }
           res.close();	
           
           
       }catch(SQLException e){
        System.out.println(e);
       }
       return data;
   }
}
