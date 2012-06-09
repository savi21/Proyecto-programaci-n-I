package modelo;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Mantenimiento_Eventos {
	private PreparedStatement ps;
	private ResultSet rs;
	
	public boolean introData(Entity_Eventos a){
		
		
		try {
			Conexion.meConecto();
			
			if(validaData(a)){
			   	
			   ps=Conexion.getCone().prepareStatement("Insert into Eventos (Nombre,Ubicacion,Fecha)" + " values(?,?,?);");
			   ps.setString(1, a.getNombre());
			   ps.setString(2, a.getUbicacion());
			   ps.setDate(3, new Date(a.getFecha().getTime()));
			   ps.executeUpdate();
			   JOptionPane.showMessageDialog(null,"Evento añadido con exito"); //tengo que ver si realmente se quiere agregar el contacto
			   return false;
			   }
			   
			
			   
		   } catch (SQLException e) {
			   
			  JOptionPane.showMessageDialog(null,"Error al añadir Evento","Error", JOptionPane.ERROR_MESSAGE);
			  return true;
		}
		finally{
			Conexion.meDesconecto();
		}
	
		return true;

	}
	

	public Entity_Eventos buscaData(Entity_Eventos f){
		
		try { 
			
		 Conexion.meConecto();	
	   	 ps=Conexion.getCone().prepareStatement("Select * from Eventos Where ID_Evento=? ;");
	     ps.setInt(1,f.getID_Eventos());
	     rs=ps.executeQuery();
	     rs.next();
	     f.setNombre(rs.getString("Nombre"));
	     f.setUbicacion(rs.getString("Ubicacion"));
	     f.setFecha(rs.getDate("Fecha"));
	     
		
	    
	    } catch (SQLException e) {
	    	JOptionPane.showMessageDialog(null,"El Evento no existe","Error", JOptionPane.ERROR_MESSAGE);  
	    	
	    }
		
	     finally{
	    	 Conexion.meDesconecto();
		}
		return null;
	}
		
		
	

	public boolean editaData(Entity_Eventos ed){	//que quiere decir conlos parametros que se le estan pasando?
		
		try { 
			Conexion.meConecto();	
			 if(validaData(ed)){
		   	 ps=Conexion.getCone().prepareStatement("Update Eventos Set Nombre=?, Ubicacion=?, Fecha=? Where ID_Evento=? ; ");//revisar esta parte
		     ps.setString(1, ed.getNombre());
		   	 ps.setString(2, ed.getUbicacion());
			   ps.setDate(3, new Date(ed.getFecha().getTime()));
			   ps.setInt(4, ed.getID_Eventos());
		     ps.executeUpdate(); 
			   
			 
				   JOptionPane.showMessageDialog(null,"Evento actualizado con exito");
				   return false;
			   
			 }
			  
		
		   	
		    } catch (SQLException e) {
		    	e.printStackTrace();
			}
		  return true;
		
		
	}
	
	public boolean borraData(Entity_Eventos d){
		try { 
				
				
			 Conexion.meConecto();	
		   	 ps=Conexion.getCone().prepareStatement("Delete from Eventos Where ID_Evento=? ;");
		     ps.setInt(1,d.getID_Eventos());
		     ps.executeUpdate();
				   JOptionPane.showMessageDialog(null,"Evento eliminado con exito");
				   return false;
			}
			catch (SQLException e) {
		    	e.printStackTrace();
		    	return true;
			}
		
		
	}
	
	public DefaultListModel recibeModellist(DefaultListModel md){
		   try {
			   Conexion.meConecto();	
		        ps = Conexion.getCone().prepareStatement("Select Nombre,Ubicacion,Fecha from Eventos Order By Nombre");
		        rs=ps.executeQuery();
		        while(rs.next())
		            md.addElement(rs.getString("nombre")+ " "+rs.getString("ubicacion")+" ,"+ rs.getString("Fecha"));
		          
		    } catch (SQLException e) {
		        // TODO Auto-generated catch block
		        e.printStackTrace();
		    }
		return md;
		
		
	}
	
	public void listaData(DefaultTableModel md){
		try {
			Conexion.meConecto();	
			ps = Conexion.getCone().prepareStatement("Select * from Eventos Order By ID_Evento");
			rs=ps.executeQuery();
			md.setNumRows(0);// aqui estoy diciendo que la cantidad de elementos es 0, y no lo duplicara en la tabla de usuarios
			DateFormat df=new SimpleDateFormat("dd/MM/yyyy");//esto es para manejar el formato de la fecha
			while(rs.next())
				md.addRow(new Object[]{rs.getInt("ID_Evento"),rs.getString("Nombre"),rs.getString("Ubicacion"), df.format(rs.getDate("Fecha"))});
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public boolean validaData(Entity_Eventos a){
		if (validaCampo(a.getNombre()) && validaCampo(a.getUbicacion()) && validaCampo(a.getFecha().toString()) ){
			  
		       return true;
		   }
		else{
			 JOptionPane.showMessageDialog(null,"Debe insertar todos los campos del Evento","Error", JOptionPane.ERROR_MESSAGE); 
			 return false;
		}
		
		
	}
	public boolean validaCampo(String campo){ 
		return !(campo==null || campo.isEmpty());// ! esto significa no. esto empide que si  el campo esta lleno debidamente 
	}
	
}
