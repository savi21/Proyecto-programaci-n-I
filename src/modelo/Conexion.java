package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {
	static Connection cone;

	public static void meConecto() {

		try {

			Class.forName("com.mysql.jdbc.Driver");
			ConfiguracionBD config = new ConfiguracionBD();
			cone = DriverManager.getConnection("jdbc:mysql://"+config.getServidor()+":"+config.getPuerto()+"/"+config.getBd(), config.getUsuario(), config.getClave());

		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,
					"Error al conectar con la base de datos", "Error",
					JOptionPane.ERROR_MESSAGE);

		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null,
					"Error al conectar con la base de datos", "Error",
					JOptionPane.ERROR_MESSAGE);
		}

	}

	public static void meDesconecto() {
		try {
			cone.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public static Connection getConexion() {
		return cone;
	}

	public static void setCone(Connection cone) {
		Conexion.cone = cone; // Revisar si esta parte esta correcta.
	}

	public static Connection getCone() {
		// este metod fue agregado por la maquina porque todo daba error
		return cone;
	}

}
