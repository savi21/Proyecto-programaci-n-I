package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Sesion {
	private PreparedStatement ps;
	private ResultSet rs;
	
	public Ini_se buscaUsr(Ini_se in){
	try { 
		
		 Conexion.meConecto();	
	   	 ps=Conexion.getCone().prepareStatement("Select Usuario,Nombre,Contraseña,Perfil_de_Usuario from usuarios Where Usuario=? and Perfil_de_Usuario=? and Contraseña=?;");
	     ps.setString(1,in.getNombre());
	     ps.setString(2,in.getPerfil());
	     ps.setString(3,in.getContra());
	     rs=ps.executeQuery();
	     rs.next();
	     in.setNombre(rs.getString("Usuario"));
	     in.setContra(rs.getString("Contraseña"));
	     in.setPerfil(rs.getString("Perfil_de_Usuario"));
	     JOptionPane.showMessageDialog(null, "Bienvenidos "+rs.getString("Nombre")+"!");
	     in.setComo(true);
	     return in;
	    
	    } catch (SQLException e) {
	    	//e.printStackTrace();
	       JOptionPane.showMessageDialog(null,"Datos erroneos, intente de nuevo","Error", JOptionPane.ERROR_MESSAGE);  
	    	 in.setComo(false);
	    }
		
	     finally{
	    	 Conexion.meDesconecto();
		}
	return in;
	}
}
