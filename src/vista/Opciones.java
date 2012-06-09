package vista;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextPane;
import java.awt.Insets;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import java.awt.Cursor;

public class Opciones extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblInfo;
	private JLabel lblCerrarSesion;
	private JTextPane txtpnIndigoEventsEs;
	private JLabel img;
	private JButton btnCancelar ;
	private JLabel lblNewLabel;
	private JButton btnVolverAtrs;
	
	
	public JButton getBtnVolverAtrs() {
		return btnVolverAtrs;
	}


	public JLabel getLblInfo() {
		return lblInfo;
	}


	public JLabel getLblCerrarSesion() {
		return lblCerrarSesion;
	}


	public JTextPane getTxtpnIndigoEventsEs() {
		return txtpnIndigoEventsEs;
	}


	public JLabel getImg() {
		return img;
	}


	public JButton getBtnCancelar() {
		return btnCancelar;
	}


	public JLabel getLblNewLabel() {
		return lblNewLabel;
	}


	public Opciones() {
		
		
		setResizable(false);
		setTitle("Opciones");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 351, 303);
		getContentPane().setLayout(null);
		
		btnVolverAtrs = new JButton("Volver atr\u00E1s");
		btnVolverAtrs.setVisible(false);
		
	    btnCancelar = new JButton("Cancelar");
	    btnCancelar.setIcon(new ImageIcon(Opciones.class.getResource("/vista/imagenes/Action-cancel-icon (1).png")));
	    btnCancelar.setBounds(189, 215, 145, 33);
	    getContentPane().add(btnCancelar);
		
		lblInfo = new JLabel("Info");
		lblInfo.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		lblInfo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblInfo.setIcon(new ImageIcon(Opciones.class.getResource("/vista/imagenes/Button-info-48.png")));
		lblInfo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblInfo.setBounds(21, 35, 313, 60);
		getContentPane().add(lblInfo);
		
	    lblCerrarSesion = new JLabel("Cerrar sesion");
	    lblCerrarSesion.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		lblCerrarSesion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblCerrarSesion.setIcon(new ImageIcon(Opciones.class.getResource("/vista/imagenes/Button-logoff-48.png")));
		lblCerrarSesion.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCerrarSesion.setBounds(21, 123, 313, 60);
		getContentPane().add(lblCerrarSesion);
		btnVolverAtrs.setIcon(new ImageIcon(Opciones.class.getResource("/vista/imagenes/Actions-edit-undo-icon.png")));
		btnVolverAtrs.setBounds(104, 227, 138, 33);
		getContentPane().add(btnVolverAtrs);
		
		txtpnIndigoEventsEs = new JTextPane();
		txtpnIndigoEventsEs.setVisible(false);
		txtpnIndigoEventsEs.setEditable(false);
		txtpnIndigoEventsEs.setOpaque(false);
		txtpnIndigoEventsEs.setBackground(UIManager.getColor("Table.focusCellBackground"));
		txtpnIndigoEventsEs.setAlignmentX(2.0f);
		txtpnIndigoEventsEs.setMargin(new Insets(7, 7, 3, 3));
		txtpnIndigoEventsEs.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Acerca de Indigo Events", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(133, 140, 158)));
		txtpnIndigoEventsEs.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtpnIndigoEventsEs.setText("Indigo Events es un software destinado para el gestionamiento de eventos, y asi brindarles al usuario final la facilidad de manejar sus invitados e invitaciones.\r\n\r\nEsta una versi\u00F3n gratuita del software para uso personal, identificada como tal, para ser utilizado s\u00F3lo para proyectos sin fines de lucro. La versi\u00F3n gratuita es completamente funcional, sin restricciones de ning\u00FAn tipo.\r\n\t\t");
		txtpnIndigoEventsEs.setBounds(31, 11, 285, 205);
		getContentPane().add(txtpnIndigoEventsEs);
		
		img = new JLabel("");
		img.setOpaque(true);
		img.setIcon(new ImageIcon(Opciones.class.getResource("/vista/imagenes/contenedor  menu.png")));
		img.setFocusCycleRoot(true);
		img.setBounds(-16, 0, 366, 276);
		getContentPane().add(img);
		
	    lblNewLabel = new JLabel("");
		lblNewLabel.setVisible(false);
		lblNewLabel.setIcon(new ImageIcon(Opciones.class.getResource("/vista/imagenes/contenedor  menu.png")));
		lblNewLabel.setBounds(-16, -95, 464, 398);
		getContentPane().add(lblNewLabel);
		setVisible(true);
		setLocation(380, 200);
	}
}
