package modelo;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.DefaultListModel;



public class Mantenimientos {
	private PreparedStatement ps;
	private Statement s;
	private ResultSet rs;

	
     public DefaultListModel listaEventos(DefaultListModel md){
		   try {
			   java.util.Date fech = new java.util.Date();
     		   long d = fech.getTime();
     	       java.sql.Date dat = new java.sql.Date(d);
			    Conexion.meConecto();	
		        s = Conexion.getCone().createStatement();
		        rs=s.executeQuery("Select * from eventos Where Fecha='"+dat +"'");
		        
		        while(rs.next()){
		         
		           md.addElement(rs.getInt("ID_Evento")+ "-" + rs.getString("Nombre"));		     
		           
		        }
		        } catch (SQLException e) {
		        e.printStackTrace();
		    }
		return md;	
	}
     

     public DefaultListModel listaEventosPro(DefaultListModel md){
		   try {
			   java.util.Date fech = new java.util.Date();
     		   long d = fech.getTime();
     	       java.sql.Date dat = new java.sql.Date(d);
			    Conexion.meConecto();	
		        s = Conexion.getCone().createStatement();
		        rs=s.executeQuery("Select * from eventos Where Fecha<>'"+dat+"'");
		        
		        while(rs.next()){
		         
		           md.addElement(rs.getInt("ID_Evento")+ "-" + rs.getString("Nombre"));		     
		           
		        }
		        } catch (SQLException e) {
		        e.printStackTrace();
		    }
		return md;	
	}
     
     public EntityEvento llenaCampos_de_listaEventos(int id, String nombre){
    	
    	 EntityEvento ee= new EntityEvento();  
    	 try {
			   
			    Conexion.meConecto();
		        ps=Conexion.getCone().prepareStatement("Select * from eventos Where ID_Evento=? and Nombre=?;");
		        ps.setInt(1,id);
			    ps.setString(2, nombre);
			    rs=ps.executeQuery();
		        
		        while(rs.next()){
		        
		           ee.setNombre_evento(rs.getString("Nombre"));
		           java.util.Date fech = rs.getDate("Fecha");
	     		   long d = fech.getTime();
	     	       java.sql.Date dat = new java.sql.Date(d);
	     		   ee.setFecha(dat);
	     		   ee.setUbicacion(rs.getString("Ubicacion"));
	     		   
		        }
		        } catch (SQLException e) {
		        e.printStackTrace();
		    }
		   
		return ee;
		
		
	}
     
     public EntityEvento llenaCampos_de_listaEventosPro(int id, String nombre){
     	
    	 EntityEvento ee= new EntityEvento();  
    	 try {
			   
			    Conexion.meConecto();
		        ps=Conexion.getCone().prepareStatement("Select * from eventos Where ID_Evento=? and Nombre=?;");
		        ps.setInt(1,id);
			    ps.setString(2, nombre);
			    rs=ps.executeQuery();
		        
		        while(rs.next()){
		        
		           ee.setNombre_evento(rs.getString("Nombre"));
		           java.util.Date fech = rs.getDate("Fecha");
	     		   long d = fech.getTime();
	     	       java.sql.Date dat = new java.sql.Date(d);
	     		   ee.setFecha(dat);
	     		   ee.setUbicacion(rs.getString("Ubicacion"));
	     		   
		        }
		        } catch (SQLException e) {
		        e.printStackTrace();
		    }
		   
		return ee;
		
		
	}
     
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
