package modelo;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;




public class Mantenimiento_Portero {
	private PreparedStatement ps;
	private Statement s;
	private ResultSet rs;
	@SuppressWarnings("rawtypes")
	private Vector vector;
	


	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Vector listaEventos(){
		   try {
			   vector= new Vector(); 
			   java.util.Date fech = new java.util.Date();
     		   long d = fech.getTime();
     	       java.sql.Date dat = new java.sql.Date(d);
			    Conexion.meConecto();	
		        s = Conexion.getCone().createStatement();
		        rs=s.executeQuery("Select * from eventos Where Fecha='"+dat+"'");
		      
					while(rs.next()){
					     
					       vector.addElement(rs.getInt("ID_Evento")+ "-" +rs.getString("Nombre"));		     
					       
					    }
				
		        } 
		   catch (SQLException e) {
		        e.printStackTrace();
		    }
		  

		return vector;	
	}
     

     @SuppressWarnings({ "unchecked", "rawtypes" })
	public Vector listaEventosPro(){
		   try {
			   vector= new Vector(); 
			   java.util.Date fech = new java.util.Date();
     		   long d = fech.getTime();
     	       java.sql.Date dat = new java.sql.Date(d);
			    Conexion.meConecto();	
		        s = Conexion.getCone().createStatement();
		        rs=s.executeQuery("Select * from eventos Where Fecha <>'"+dat+"'");
                	
					while(rs.next()){
					 
					  vector.addElement(rs.getInt("ID_Evento")+ "-" + rs.getString("Nombre"));		     
					   
					}
		        
		        } catch (SQLException e) {
		        e.printStackTrace();
		    }
		  

		return vector;	
	}
     
     public DefaultTableModel llenaTListaInvImp(DefaultTableModel md,int idE){
		   try {
		
			    Conexion.meConecto();	
		        s = Conexion.getCone().createStatement();
		        rs=s.executeQuery("Select Nombre,Apellido,Sexo,Razon_de_entrada from visita_imprevista Where ID_Evento='"+idE+"'");
              	
					while(rs.next()){
					 
						 String[] resultado ={rs.getString(1) , rs.getString(2) , rs.getString(3), rs.getString(4)};
						
						 md.addRow(resultado);
					   
					}
		        
		        } catch (SQLException e) {
		        e.printStackTrace();
		    }
		  

		return md;	
	}

     public void actualizaTEvento(int idI,int idE,String as){
		   try {
			    Conexion.meConecto();
		        s = Conexion.getCone().createStatement();
		        Conexion.meConecto();
		        ps=Conexion.getCone().prepareStatement("Update invitaciones Set Asistencia=? Where Id_Invitado=? and Id_Evento=?;");
		        ps.setString(1,as);
			    ps.setInt(2, idI);
			    ps.setInt(3, idE);
			    ps.executeUpdate();
		        
		        } catch (SQLException e) {
		        e.printStackTrace();
		    }
		  
	}
     
     public int cuentaTEvento(int IdE){
		   try {
			    int i;
			    Conexion.meConecto();
		        s = Conexion.getCone().createStatement();
		        s = Conexion.getCone().createStatement();
		        rs=s.executeQuery("SELECT COUNT( Asistencia ) FROM invitaciones WHERE Asistencia = 'No' and Id_Evento='"+IdE+"'");
		        while(rs.next()){
					 
					return i=rs.getInt(1);    
					   
					}
		        		        
		   } catch (SQLException e) {
		        e.printStackTrace();
		    }
		return (Integer) null;
	
	}
     
     public void regInvitadoImp(Entity_VisitaImp evi){
    	 try {
 			Conexion.meConecto();
 			
 			   ps=Conexion.getCone().prepareStatement("Insert into visita_imprevista(ID_Evento,Nombre,Apellido,Sexo,Usuario_portero,Razon_de_entrada)" + " values(?,?,?,?,?,?);");
 			   ps.setInt(1, evi.getId_Evento());
 			   ps.setString(2, evi.getNombre());
 			   ps.setString(3, evi.getApellido());
 			   ps.setString(4, evi.getSexo());
 			   ps.setString(5, evi.getUsuario());
 			   ps.setString(6, evi.getRazon());
 			  
 			   ps.executeUpdate();
 			   JOptionPane.showMessageDialog(null,"Visitante imprevisto añadido con exito");
 		
 			   
 		   } catch (SQLException e) {
 			    JOptionPane.showMessageDialog(null,"Error al añadir visitante","Error", JOptionPane.ERROR_MESSAGE);
 		        e.printStackTrace();
 		}
 		finally{
 			Conexion.meDesconecto();
 		}
 	
 		
    	 
     }
     
     @SuppressWarnings({ "unchecked", "rawtypes" })
	public DefaultTableModel llenaTabla_listaInvitados(DefaultTableModel dm,int idEv){
    	 Entity_Invitaciones ei= new Entity_Invitaciones(); 
    	
    	 try {
    		    Conexion.meConecto();
    		    vector= new Vector();
			    Conexion.meConecto();
		        ps=Conexion.getCone().prepareStatement("SELECT invitados.ID_Invitado,eventos.ID_Evento, invitados.Nombre, invitados.Apellido, invitados.Sexo, eventos.Nombre, invitaciones.Asistencia FROM eventos, invitados, invitaciones WHERE invitaciones.ID_Evento = eventos.ID_Evento AND invitaciones.ID_Invitado = invitados.ID_Invitado and invitaciones.ID_Evento=?;");
		        ps.setInt(1,idEv);
			    rs=ps.executeQuery();
			  
		      
		        while(rs.next()){
		        	
		        	   String[] resultado ={rs.getInt(1)+"", rs.getInt(2)+"" , rs.getString(3) , rs.getString(4) , rs.getString(5), rs.getString(6) ,rs.getString(7)};
					
		        	 
		        	    dm.addRow(resultado);
		        	   
		        	  
		        	  
		        }
		        rs.last();
			    
			    
		        } catch (SQLException e) {
		        e.printStackTrace();
		    }
		
    	 
    	 return dm;
     
     }
     
     
     
     public Entity_Eventos llenaCampos_de_listaEventos(int id, String nombre){
    	
    	 Entity_Eventos ee= new Entity_Eventos();  
    	 try {
			   
			    Conexion.meConecto();
		        ps=Conexion.getCone().prepareStatement("Select * from eventos Where ID_Evento=? and Nombre=?;");
		        ps.setInt(1,id);
			    ps.setString(2, nombre);
			    rs=ps.executeQuery();
		        
		        while(rs.next()){
		        
		           ee.setNombre(rs.getString("Nombre"));
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
     
     public Entity_Eventos llenaCampos_de_listaEventosPro(int id, String nombre){
     	
    	 Entity_Eventos ee= new Entity_Eventos();  
    	 try {
			   
			    Conexion.meConecto();
		        ps=Conexion.getCone().prepareStatement("Select * from eventos Where ID_Evento=? and Nombre=?;");
		        ps.setInt(1,id);
			    ps.setString(2, nombre);
			    rs=ps.executeQuery();
		        
		        while(rs.next()){
		        
		           ee.setNombre(rs.getString("Nombre"));
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
