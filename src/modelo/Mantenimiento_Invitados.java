package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Mantenimiento_Invitados {
	private PreparedStatement ps;
	private ResultSet rs;
	
	public boolean introData(Entity_Invitados a){
		
		
		try {
			Conexion.meConecto();
			
			if(validaData(a)){
			   	
			   ps=Conexion.getCone().prepareStatement("Insert into Invitados (Nombre,Apellido,Sexo,Direccion,telefono)" + " values(?,?,?,?,?);");
			   ps.setString(1, a.getNombre());
			   ps.setString(2, a.getApellido());
			   ps.setString(3, a.getSexo());
			   ps.setString(4, a.getDireccion());
			   ps.setString(5, a.getTelefono());
			   ps.executeUpdate();
			   JOptionPane.showMessageDialog(null,"Invitado añadido con exito"); 
			   return false;
			   }
			   
			
			   
		   } catch (SQLException e) {
			  //JOptionPane.showMessageDialog(null,"Error al añadir Invitado","Error", JOptionPane.ERROR_MESSAGE);
			   e.printStackTrace();
			  return true;
		}
		finally{
			Conexion.meDesconecto();
		}
	
		return true;

	}
	

	public Mantenimiento_Invitados buscaData(Entity_Invitados f){
		
		try { 
			
		 Conexion.meConecto();	
	   	 ps=Conexion.getCone().prepareStatement("Select * from Invitados Where ID_invitado=?;");
	     ps.setInt(1,f.getID_invitado());
	     rs=ps.executeQuery();
	     rs.next();
	     f.setNombre(rs.getString("Nombre"));
	     f.setApellido(rs.getString("Apellido"));
	     f.setSexo(rs.getString("Sexo"));
	     f.setDireccion(rs.getString("Direccion"));
	     f.setTelefono(rs.getString("Telefono"));
	     
		
	 	
	    
	    } catch (SQLException e) {
	    	JOptionPane.showMessageDialog(null,"El Invitado no existe","Error", JOptionPane.ERROR_MESSAGE);  
	    	
	    }
		
	     finally{
	    	 Conexion.meDesconecto();
		}
		return null;
	}
		
		
	

	public boolean editaData(Entity_Invitados ed){	
		
		try { 
			Conexion.meConecto();	
			
			 if( validaData(ed)){
		   	 ps=Conexion.getCone().prepareStatement("Update Invitados Set Nombre=?, Apellido=?, Sexo=?, Direccion=?, Telefono=? Where ID_Invitado=? ; ");//revisar esta parte
		     ps.setString(1, ed.getNombre());
		   	 ps.setString(2, ed.getApellido());
		     ps.setString(3, ed.getSexo());
		     ps.setString(4, ed.getDireccion());
		     ps.setString(5, ed.getTelefono());
		     ps.setInt(6, ed.getID_invitado());
		     ps.executeUpdate(); 
			   
			 
				   JOptionPane.showMessageDialog(null,"Invitado actualizado con exito");
				   return false;
			   
			 }
			  
		
		   	
		    } catch (SQLException e) {
		    	e.printStackTrace();
			}
		  return true;
		
		
	}
	
	
	
	public boolean borraData(Entity_Invitados d){
		try { 
			 Conexion.meConecto();	
		   	 ps=Conexion.getCone().prepareStatement("Delete from Invitados Where ID_Invitado=?;");
		     ps.setInt(1,d.getID_invitado());
		     ps.executeUpdate();
				   JOptionPane.showMessageDialog(null,"Invitado eliminado con exito");
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
		        ps = Conexion.getCone().prepareStatement("Select Nombre,Apellido,Sexo,Direccion,Telefono from Invitados Order By Nombre");
		        rs=ps.executeQuery();
		        while(rs.next())
		            md.addElement(rs.getString("nombre")+ " "+rs.getString("Apellido")+" ,"+ rs.getString("Sexo")+" ,"+ rs.getString("Direccion")+" ,"+ rs.getString("telefono"));
		          
		    } catch (SQLException e) {
		        // TODO Auto-generated catch block
		        e.printStackTrace();
		    }
		return md;
		
		
	}
	
	public void listaData(DefaultTableModel md){
		try {
			Conexion.meConecto();	
			ps = Conexion.getCone().prepareStatement("Select * from Invitados Order By ID_Invitado");
			rs=ps.executeQuery();
			md.setNumRows(0);// aqui estoy diciendo que la cantidad de elementos es 0, y no lo duplicara en la tabla de usuarios
			while(rs.next())
				md.addRow(new Object[]{rs.getInt("ID_Invitado"),rs.getString("Nombre"),rs.getString("Apellido"),rs.getString("Sexo") ,rs.getString("Direccion"),rs.getString("Telefono")});
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public boolean validaData(Entity_Invitados a){
		if(validaCampo(a.getNombre()) && validaCampo(a.getApellido()) && validaCampo(a.getSexo()) &&  validaCampo(a.getDireccion()) && validaCampo(a.getTelefono())){
			   
		       return true;
		   } 
		else{JOptionPane.showMessageDialog(null,"Debe insertar el nombre del invitado","Error", JOptionPane.ERROR_MESSAGE); 
		return false;
		   }
		
		
	}
	
	public boolean validaCampo(String campo){ 
		return !(campo==null || campo.isEmpty());// ! esto significa no. esto empide que si  el campo esta lleno debidamente 
	}
	
}

