package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Mantenimiento_Usuarios {
	private PreparedStatement ps;
	private ResultSet rs;
	
	public boolean introData(Entity_Usuarios a){
		
		
		try {
			Conexion.meConecto();
			
			if(validaData(a)){
			   	
			   ps=Conexion.getCone().prepareStatement("Insert into Usuarios (Nombre,Apellido,Usuario,Contraseña,Perfil_de_Usuario )" + " values(?,?,?,?,?);");
			   ps.setString(1, a.getNombre());
			   ps.setString(2, a.getApellido());
			   ps.setString(3, a.getUsuario());
			   ps.setString(4, a.getContraseña());
			   ps.setString(5, a.getPerfil_usuario());
			   ps.executeUpdate();
			   JOptionPane.showMessageDialog(null,"Usuario añadido con exito"); //tengo que ver si realmente se quiere agregar el contacto
			   return false;
			   }
	 
		   } catch (SQLException e) {
			  JOptionPane.showMessageDialog(null,"Error al añadir Usuario","Error", JOptionPane.ERROR_MESSAGE);
			  
			  return true;
		}
		finally{
			Conexion.meDesconecto();
		}
	
		return true;

	}
	

	public Entity_Usuarios buscaData(Entity_Usuarios f){
		
		try { 
			
		 Conexion.meConecto();	
	   	 ps=Conexion.getCone().prepareStatement("Select * from Usuarios Where ID_Usuarios=?;");
	     ps.setInt(1,f.getID_Usuarios());
	     rs=ps.executeQuery();
	     rs.next();
	     f.setNombre(rs.getString("Nombre"));
	     f.setApellido(rs.getString("Apellido"));
	     f.setUsuario(rs.getString("Usuario"));
	     f.setContraseña(rs.getString("Contraseña"));
	     f.setPerfil_usuario(rs.getString("Perfil_de_Usuario"));
	    
	    } catch (SQLException e) {
	    	JOptionPane.showMessageDialog(null,"El Usuario no existe","Error", JOptionPane.ERROR_MESSAGE);  
	    	
	    }
		
	     finally{
	    	 Conexion.meDesconecto();
		}
		return null;
	}
		
		
	

	public boolean editaData(Entity_Usuarios ed){	//que quiere decir conlos parametros que se le estan pasando?
		
		try { 
			Conexion.meConecto();	
				if( validaData(ed)){
		   	 ps=Conexion.getCone().prepareStatement("Update Usuarios Set Nombre=?, Apellido=?, Usuario=?, Contraseña=?, Perfil_de_Usuario=?  Where ID_Usuarios=? ; ");//revisar esta parte
		     ps.setString(1, ed.getNombre());
		   	 ps.setString(2, ed.getApellido());
		     ps.setString(3, ed.getUsuario());
		     ps.setString(4, ed.getContraseña());
		     ps.setString(5, ed.getPerfil_usuario());
		     ps.setInt(6, ed.getID_Usuarios());
		     ps.executeUpdate(); 
			   
			 
				   JOptionPane.showMessageDialog(null,"Usuario actualizado con exito");
				   return false;
			   
			 }
			  
		
		   	
		    } catch (SQLException e) { // aqui se duplico el parametro
		    	e.printStackTrace();
			}
		  return true;
		
		
	}
	
	public boolean borraData(Entity_Usuarios d){
		try { 
				
			 Conexion.meConecto();	
		   	 ps=Conexion.getCone().prepareStatement("Delete from Usuarios Where ID_Usuarios=?;");
		     ps.setInt(1,d.getID_Usuarios());
		   
		     
		     ps.executeUpdate();
				   JOptionPane.showMessageDialog(null,"Usuario eliminado con exito");
				   return false;
			}
			catch (SQLException e) {
		    	e.printStackTrace();
		    	return true;
			}
		
		
	}
	//este es para si se quiere hacer una lista en el reporte aun no se esta usando
	
	public DefaultListModel recibeModellist(DefaultListModel md){
		   try {
			   Conexion.meConecto();	
		        ps = Conexion.getCone().prepareStatement("Select Nombre,Apellido,usuario,Contraseña,Perfil_usuario from Usuarios Order By Nombre");
		        rs=ps.executeQuery();
		        while(rs.next())
		            md.addElement(rs.getString("Nombre")+ " "+rs.getString("Apellido")+" ,"+ rs.getString("Usuario")+" ,"+ rs.getString("Contraseña")+" ,"+ rs.getString("Perfil_usuario"));
		          
		    } catch (SQLException e) {
		        // TODO Auto-generated catch block
		        e.printStackTrace();
		    }
		return md;
		
		
	}
	//duplicado este es para tabla
	public void listaUsuarios(DefaultTableModel md){
		try {
			Conexion.meConecto();	
			ps = Conexion.getCone().prepareStatement("Select * from Usuarios Order By ID_Usuarios");
			rs=ps.executeQuery();
			md.setNumRows(0);// aqui estoy diciendo que la cantidad de elementos es 0, y no lo duplicara en la tabla de usuarios
			while(rs.next())
				md.addRow(new Object[]{rs.getInt("ID_Usuarios"),rs.getString("Nombre"),rs.getString("Apellido"), rs.getString("Usuario"), rs.getString("Perfil_de_Usuario")});
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	
	public boolean validaData(Entity_Usuarios a){
		   if(validaCampo(a.getNombre()) && validaCampo(a.getApellido())  && validaCampo(a.getUsuario())  && validaCampo(a.getContraseña())  && validaCampo(a.getPerfil_usuario())){
		       return true;
		   }
		   else{
			   JOptionPane.showMessageDialog(null,"Debe insertar todos los campos del usuario","Error", JOptionPane.ERROR_MESSAGE);  
			   return false;
		   }
		  
	
		
	}
	
	// este metodo meAYUDARA A EVALUAR SI TODOS LOS CAMPOS ESTAN VACIOS, validandolos.
	public boolean validaCampo(String campo){ 
		return !(campo==null || campo.isEmpty());// ! esto significa no. esto empide que si  el campo esta lleno debidamente 
	}
	
}
