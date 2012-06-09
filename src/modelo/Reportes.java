package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Reportes {

	public static void getCantidadEvento(DefaultTableModel modelo) {
		try {

			Conexion.meConecto();
			PreparedStatement ps = Conexion.getConexion().prepareStatement("SELECT eventos.ID_Evento,Nombre, COUNT(invitaciones.ID_Invitado) as cantidad " +
																		"FROM eventos, invitaciones WHERE eventos.ID_Evento = invitaciones.ID_Evento " +
																		"AND invitaciones.Asistencia='Si' GROUP BY eventos.ID_Evento,eventos.Nombre;");
			ResultSet rs = ps.executeQuery();
			PreparedStatement ps2 = Conexion.getConexion().prepareStatement("SELECT eventos.ID_Evento,eventos.Nombre, COUNT(visita_imprevista.ID_visita) as cantidad " +
																		"FROM eventos, visita_imprevista WHERE eventos.ID_Evento = visita_imprevista.ID_Evento " +
																		"GROUP BY eventos.ID_Evento,eventos.Nombre;");
			ResultSet rs2 = ps2.executeQuery();
			modelo.setRowCount(0);//esto vacia el modelo para que no se repitan las tablas
			while(rs.next() && rs2.next()){
				modelo.addRow(new Object[]{rs.getString("eventos.Nombre"),rs.getInt("cantidad"),rs2.getInt("cantidad")});
				//System.out.println(rs.getString("Nombre")+" | "+rs.getInt("cantidad"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getStackTrace(), "Error",JOptionPane.ERROR_MESSAGE);// el getStracktrace tira el mismo error del la bd.
		}
		finally {
			Conexion.meDesconecto();
		}
	}
	
	

	public static void getPorcientoEvento(DefaultTableModel modelo) {
		try {

			Conexion.meConecto();
			PreparedStatement ps = Conexion.getConexion().prepareStatement("SELECT eventos.ID_Evento,Nombre, COUNT(invitaciones.ID_Invitado) as cantidad " +
																		"FROM eventos, invitaciones WHERE eventos.ID_Evento = invitaciones.ID_Evento " +
																		"AND invitaciones.Asistencia='Si' GROUP BY eventos.ID_Evento,eventos.Nombre;");
			ResultSet rs = ps.executeQuery();
			PreparedStatement ps2 = Conexion.getConexion().prepareStatement("SELECT eventos.ID_Evento,Nombre, COUNT(invitaciones.ID_Invitado) as cantidad " +
																		"FROM eventos, invitaciones WHERE eventos.ID_Evento = invitaciones.ID_Evento " +
																		"GROUP BY eventos.ID_Evento,eventos.Nombre;");
			
			ResultSet rs2 = ps2.executeQuery();
			modelo.setRowCount(0);//esto vacia el modelo para que no se repitan las tablas
			while(rs.next() && rs2.next()){
				modelo.addRow(new Object[]{rs.getString("Nombre"),(100*rs.getInt("cantidad"))/rs2.getInt("cantidad")+"%"});
				//System.out.println(rs.getString("Nombre")+" | "+(100*rs.getInt("cantidad"))/rs2.getInt("cantidad")+"%");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getStackTrace(), "Error",JOptionPane.ERROR_MESSAGE);// el getStracktrace tira el mismo error del la bd.
		}
		finally {
			Conexion.meDesconecto();
		}
	}
	
	

	public static void getMasVisitados(DefaultTableModel modelo) {
		try {

			Conexion.meConecto();
			PreparedStatement ps = Conexion.getConexion().prepareStatement("SELECT eventos.ID_Evento,Nombre, COUNT(invitaciones.ID_Invitado) as cantidad " +
																		"FROM eventos, invitaciones WHERE eventos.ID_Evento = invitaciones.ID_Evento " +
																		"AND invitaciones.Asistencia='Si' GROUP BY eventos.ID_Evento,eventos.Nombre " +
																		"ORDER BY COUNT(invitaciones.ID_Invitado) DESC;");
			ResultSet rs = ps.executeQuery();
			PreparedStatement ps3 = Conexion.getConexion().prepareStatement("SELECT eventos.ID_Evento,eventos.Nombre, COUNT(visita_imprevista.ID_visita) as cantidad " +
					"FROM eventos, visita_imprevista WHERE eventos.ID_Evento = visita_imprevista.ID_Evento " +
					"GROUP BY eventos.ID_Evento,eventos.Nombre;");
			ResultSet rs3 = ps3.executeQuery();
			modelo.setRowCount(0);//esto vacia el modelo para que no se repitan las tablas
			while(rs.next()&&rs3.next()){
				modelo.addRow(new Object[]{rs.getString("Nombre"),rs.getInt("cantidad"),rs3.getInt("cantidad")});
				//System.out.println(rs.getString("Nombre")+" | "+rs.getInt("cantidad"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getStackTrace(), "Error",JOptionPane.ERROR_MESSAGE);// el getStracktrace tira el mismo error del la bd.
		}
		finally {
			Conexion.meDesconecto();
		}
	}
	
	

	public static void getEventosMujeres(DefaultTableModel modelo) {
		try {

			Conexion.meConecto();
			PreparedStatement ps = Conexion.getConexion().prepareStatement("SELECT eventos.ID_Evento,eventos.Nombre, COUNT(invitaciones.ID_Invitado) as cantidad " +
																		"FROM eventos, invitaciones, invitados WHERE eventos.ID_Evento = invitaciones.ID_Evento " +
																		"AND invitados.ID_Invitado=invitaciones.ID_Invitado AND invitados.sexo='Femenino'" +
																		"AND invitaciones.Asistencia='Si' GROUP BY eventos.ID_Evento,eventos.Nombre;");
			ResultSet rs = ps.executeQuery();
			PreparedStatement ps2 = Conexion.getConexion().prepareStatement("SELECT eventos.ID_Evento,eventos.Nombre, COUNT(invitaciones.ID_Invitado) as cantidad " +
																		"FROM eventos, invitaciones, invitados WHERE eventos.ID_Evento = invitaciones.ID_Evento " +
																		"AND invitados.ID_Invitado=invitaciones.ID_Invitado AND invitados.sexo='Masculino'" +
																		"AND invitaciones.Asistencia='Si' GROUP BY eventos.ID_Evento,eventos.Nombre;");
			ResultSet rs2 = ps2.executeQuery();
			modelo.setRowCount(0);//esto vacia el modelo para que no se repitan las tablas
			int hombres = 0;
			int mujeres = 0;
			boolean ultimo_h = false;
			boolean ultimo_m = false;
			while((ultimo_m=rs.next()) | (ultimo_h=rs2.next())){
				hombres = (!ultimo_h) ? 0 : rs2.getInt("cantidad");//es quivalente a: if(ultimo_h==true){ hombre=0; } else { hombres = rs2.getInt("cantidad"); }
				mujeres = (!ultimo_m) ? 0 : rs.getInt("cantidad");//

				if(mujeres>hombres){
					modelo.addRow(new Object[]{rs.getString("Nombre"),mujeres});
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getStackTrace(), "Error",JOptionPane.ERROR_MESSAGE);// el getStracktrace tira el mismo error del la bd.
		}
		finally {
			Conexion.meDesconecto();
		}
	}

	
	
	public static void getEventosHombres(DefaultTableModel modelo) {
		try {

			Conexion.meConecto();
			PreparedStatement ps = Conexion.getConexion().prepareStatement("SELECT eventos.ID_Evento,eventos.Nombre, COUNT(invitaciones.ID_Invitado) as cantidad " +
																		"FROM eventos, invitaciones, invitados WHERE eventos.ID_Evento = invitaciones.ID_Evento " +
																		"AND invitados.ID_Invitado=invitaciones.ID_Invitado AND invitados.sexo='Femenino'" +
																		"AND invitaciones.Asistencia='Si' GROUP BY eventos.ID_Evento,eventos.Nombre;");
			ResultSet rs = ps.executeQuery();
			PreparedStatement ps2 = Conexion.getConexion().prepareStatement("SELECT eventos.ID_Evento,eventos.Nombre, COUNT(invitaciones.ID_Invitado) as cantidad " +
																		"FROM eventos, invitaciones, invitados WHERE eventos.ID_Evento = invitaciones.ID_Evento " +
																		"AND invitados.ID_Invitado=invitaciones.ID_Invitado AND invitados.sexo='Masculino'" +
																		"AND invitaciones.Asistencia='Si' GROUP BY eventos.ID_Evento,eventos.Nombre;");
			ResultSet rs2 = ps2.executeQuery();
			modelo.setRowCount(0);//esto vacia el modelo para que no se repitan las tablas
			int hombres = 0;
			int mujeres = 0;
			boolean ultimo_h = false;
			boolean ultimo_m = false;
			while((ultimo_m=rs.next()) | (ultimo_h=rs2.next())){
				hombres = (!ultimo_h) ? 0 : rs2.getInt("cantidad");
				mujeres = (!ultimo_m) ? 0 : rs.getInt("cantidad");
				if(hombres>mujeres){
					modelo.addRow(new Object[]{rs.getString("Nombre"),hombres});
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getStackTrace(), "Error",JOptionPane.ERROR_MESSAGE);// el getStracktrace tira el mismo error del la bd.
		}
		finally {
			Conexion.meDesconecto();
		}
	}
	
	

	public static void getEventosDiarios(DefaultTableModel modelo) {
		try {
			HashMap traductor = new HashMap();
			traductor.put("Sunday", "Domingo");
			traductor.put("Monday", "Lunes");
			traductor.put("Tuesday", "Martes");
			traductor.put("Wednesday", "Miercoles");
			traductor.put("Thursday", "Jueves");
			traductor.put("Friday", "Viernes");
			traductor.put("Saturday", "Sabado");
			Conexion.meConecto();
			PreparedStatement ps = Conexion.getConexion().prepareStatement("select DATE_FORMAT(eventos.Fecha, \"%W\") as Dia, count(invitaciones.ID_Invitado) as cantidad " +
																		"FROM eventos, invitaciones " +
																		"WHERE eventos.ID_Evento=invitaciones.ID_Evento " +
																		"AND invitaciones.Asistencia='Si' " +
																		"GROUP BY DATE_FORMAT(eventos.Fecha, \"%W\") " +
																		"ORDER BY COUNT(invitaciones.ID_Invitado) DESC ");
			ResultSet rs = ps.executeQuery();
			modelo.setRowCount(0);//esto vacia el modelo para que no se repitan las tablas
			while(rs.next()){
				modelo.addRow(new Object[]{traductor.get(rs.getString("Dia")),rs.getInt("cantidad")});
				//System.out.println(traductor.get(rs.getString("Dia"))+" | "+rs.getInt("cantidad"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getStackTrace(), "Error",JOptionPane.ERROR_MESSAGE);// el getStracktrace tira el mismo error del la bd.
		}
		finally {
			Conexion.meDesconecto();
		}
		
	}

}
