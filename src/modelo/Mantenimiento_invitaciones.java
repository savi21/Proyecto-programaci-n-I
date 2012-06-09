package modelo;
import java.util.HashSet;
import java.util.Set;
import controlador.Usuario;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Mantenimiento_invitaciones {
/**
    * <pre>
    *           0..*     0..*
    * Mantenimiento_invitaciones ------------------------> Usuario
    *           mantenimiento_invitaciones        &gt;       usuario
    * </pre>
    */
   private Set<Usuario> usuario;
   
   public Set<Usuario> getUsuario() {
      if (this.usuario == null) {
         this.usuario = new HashSet<Usuario>();
      }
      return this.usuario;
   }
   
	private PreparedStatement ps;
	private ResultSet rs;
	
	public boolean introData(Entity_Invitaciones a){
		
		
		try {
			Conexion.meConecto();
			
			if(validaData(a)){
			   
			   //(a.getAsistencia()?"Si" : "No");  
				
			   ps=Conexion.getCone().prepareStatement("Insert into Invitaciones (ID_Evento,ID_Invitado, Asistencia)" + " values(?,?,?);");
			   ps.setInt(1, a.getID_Evento());
			   ps.setInt(2, a.getID_Invitado());
			   ps.setString(3,a.getAsistencia());
			   ps.executeUpdate();
			   JOptionPane.showMessageDialog(null,"Invitacion añadida con exito"); 
			   return false;
			   }
			   
			
			   
		   } catch (SQLException e) {
			  //JOptionPane.showMessageDialog(null,"Error al añadir la Invitacion","Error", JOptionPane.ERROR_MESSAGE);
			   e.printStackTrace();
			  return true;
		}
		finally{
			Conexion.meDesconecto();
		}
	
		return true;

	}
	

	public Entity_Invitaciones buscaData(Entity_Invitaciones f){ 
		
		try { 
			
		 Conexion.meConecto();	
	   	 ps=Conexion.getCone().prepareStatement("Select Asistencia from Invitaciones Where ID_Evento=? and ID_Invitado=?;");
	     ps.setInt(1,f.getID_Evento());
	     ps.setInt(2, f.getID_Invitado());
	     rs=ps.executeQuery();
	     rs.next();// etse metodo lo k hace devuelve 1er resultado de la consulta
	     f.setAsistencia(rs.getString("Asistencia"));//este metodo setea el valor desde la tabla asistencia.
	
	    
	    } catch (SQLException e) {
	    	JOptionPane.showMessageDialog(null,"La invitacion no existe","Error", JOptionPane.ERROR_MESSAGE);  
	    	 
	    }
		
	     finally{
	    	 Conexion.meDesconecto();
		}
		return null;
	}
		
		
	

	public boolean editaData(Entity_Invitaciones ed){	
		
		try { 
			Conexion.meConecto();	
			 
				if(validaData(ed)){
		   	 ps=Conexion.getCone().prepareStatement("Update Invitaciones Set Asistencia=? Where ID_Evento=? and ID_Invitado=?; ");	// se borra la asistencia, pues  no buscare por ella   
		   	 ps.setString(1,ed.getAsistencia());
		   	 ps.setInt(2, ed.getID_Evento());
		   	 ps.setInt(3, ed.getID_Invitado());
		     ps.executeUpdate(); 
		     

		
				   JOptionPane.showMessageDialog(null,"Invitacion actualizada con exito");
				   return false;
			   
			 }
			  
		
		   	
		    } catch (SQLException e) {
		    	e.printStackTrace();
			}
		  return true;
		
		
	}
	


	public boolean borraData(Entity_Invitaciones d){
		try { 
				
				
			 Conexion.meConecto();	
		   	 ps=Conexion.getCone().prepareStatement("Delete from Invitaciones Where ID_Evento=? and ID_Invitado=?;");
		     ps.setInt(1,d.getID_Evento());
		     ps.setInt(2, d.getID_Invitado());
		     ps.executeUpdate();
		     
		
				
				   JOptionPane.showMessageDialog(null,"Invitacion eliminada con exito");
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
		        ps = Conexion.getCone().prepareStatement("Select ID_Evento,ID_Invitado,Asistencia from Invitaciones Order By Nombre");
		        rs=ps.executeQuery();
		        while(rs.next())
		            md.addElement(rs.getString("ID_Evento")+ " "+rs.getString("ID_Invitado")+" ,"+ rs.getString("Asistencia"));
		          
		    } catch (SQLException e) {
		        // TODO Auto-generated catch block
		        e.printStackTrace();
		    }
		return md;
		
		
	}
	
	public void listaData(DefaultTableModel md){
		try {
			Conexion.meConecto();	
			ps = Conexion.getCone().prepareStatement("Select * from Invitaciones Order By ID_Evento");
			rs=ps.executeQuery();
			md.setNumRows(0);// aqui estoy diciendo que la cantidad de elementos es 0, y no lo duplicara en la tabla de usuarios
			
			while(rs.next()){	
				Entity_Eventos ev=new Entity_Eventos();
				Mantenimiento_Eventos me=new Mantenimiento_Eventos();
				Entity_Invitados einv=new Entity_Invitados();
				Mantenimiento_Invitados minv=new Mantenimiento_Invitados();//Esto llena la tabla con las invitaciones
				ev.setID_Eventos(rs.getInt("ID_Evento"));	//
				me.buscaData(ev);							//se busca el evento y en ves de ID se muestra el nombre al cual pertenece dicho id	
				einv.setID_invitado(rs.getInt("ID_Invitado"));//
				minv.buscaData(einv);							//se busca el invitado y en ves de ID se muestra el nombre al cual pertenece dicho id	
				md.addRow(new Object[]{ev,einv,rs.getString("Asistencia")});
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void listaEventos(JComboBox md){
		   try {
			   Conexion.meConecto();	
		        ps = Conexion.getCone().prepareStatement("Select * from Eventos");
		        rs=ps.executeQuery();
		        DefaultComboBoxModel modelo=new DefaultComboBoxModel();
		        while(rs.next()){
		        	Entity_Eventos evento=new Entity_Eventos();
		        	evento.setID_Eventos(rs.getInt("ID_Evento"));
		        	Mantenimiento_Eventos me=new Mantenimiento_Eventos();
		        	me.buscaData(evento);
		            modelo.addElement(evento);
		        }
		        md.setModel(modelo);
		        
		    } catch (SQLException e) {
		        // TODO Auto-generated catch block
		        e.printStackTrace();
		    }
		
		
	}
	
	public void listaInvitados(JComboBox md){
		   try {
			   Conexion.meConecto();	
		        ps = Conexion.getCone().prepareStatement("Select * from Invitados");
		        rs=ps.executeQuery();
		        DefaultComboBoxModel modelo=new DefaultComboBoxModel();
		        while(rs.next()){
		        	Entity_Invitados invitado=new Entity_Invitados();
		        	invitado.setID_invitado(rs.getInt("ID_Invitado"));
		        	Mantenimiento_Invitados mi=new Mantenimiento_Invitados();
		        	mi.buscaData(invitado);
		            modelo.addElement(invitado);
		        }
		        md.setModel(modelo);
		    } catch (SQLException e) {
		        // TODO Auto-generated catch block
		        e.printStackTrace();
		    }
		
		
	}
	
	public boolean validaData(Entity_Invitaciones a){
		if(a.getID_Evento()>0 && a.getID_Invitado()>0){
		       return true;
		}
		else {
			JOptionPane.showMessageDialog(null,"Debe Elegirse un Evento y un Invitado","Error", JOptionPane.ERROR_MESSAGE);  
			return false;
		}
	}
	
	
}

