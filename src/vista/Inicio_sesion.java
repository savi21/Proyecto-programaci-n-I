package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.JPasswordField;
import java.awt.Point;

public class Inicio_sesion extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JComboBox tip_usr;
	private JButton btnAceptar;
	private JButton btnCancelar;
	
	private JTextField usr;
	public JTextField getUsr() {
		return usr;
	}
	private JLabel lblUsuario;
	private JLabel lblNewLabel;
	private JPasswordField password;

	public JPasswordField getPassword() {
		return password;
	}

	public JButton getBtnAceptar() {
		return btnAceptar;
	}
	
	public Inicio_sesion() {
		setResizable(false);
		
		setTitle("Bienvenidos!!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 658, 307);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	    
	    password = new JPasswordField();
	    password.setBounds(435, 172, 190, 25);
	    contentPane.add(password);
	    
	    btnCancelar = new JButton("Cancelar");
	    btnCancelar.setIcon(new ImageIcon(Inicio_sesion.class.getResource("/vista/imagenes/Action-cancel-icon (1).png")));
	    btnCancelar.setBounds(501, 217, 121, 28);
	    contentPane.add(btnCancelar);
	    
	    JLabel lblContrasea = new JLabel("Contrase\u00F1a");
	    lblContrasea.setForeground(Color.BLACK);
	    lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 15));
	    lblContrasea.setBounds(346, 175, 79, 22);
	    contentPane.add(lblContrasea);
		
	    tip_usr = new JComboBox();
		tip_usr.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tip_usr.setModel(new DefaultComboBoxModel(new String[] {"Portero", "Administrador"}));
		tip_usr.setBounds(134, 218, 190, 27);
		contentPane.add(tip_usr);
		
		JLabel lblTipoDeUsuario = new JLabel("Tipo de usuario");
		lblTipoDeUsuario.setForeground(SystemColor.windowBorder);
		lblTipoDeUsuario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTipoDeUsuario.setBounds(21, 223, 114, 22);
		contentPane.add(lblTipoDeUsuario);
		
	    btnAceptar = new JButton("Aceptar");
	    btnAceptar.setIcon(new ImageIcon(Inicio_sesion.class.getResource("/vista/imagenes/Action-ok-icon.png")));
		btnAceptar.setBounds(346, 217, 121, 28);
		contentPane.add(btnAceptar);
		
		usr = new JTextField();
		usr.setBounds(134, 174, 190, 23);
		contentPane.add(usr);
		usr.setColumns(10);
		
		lblUsuario = new JLabel("Usuario");
		lblUsuario.setForeground(SystemColor.windowBorder);
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUsuario.setBounds(74, 183, 59, 14);
		contentPane.add(lblUsuario);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Inicio_sesion.class.getResource("/vista/imagenes/ini.png")));
		lblNewLabel.setBounds(0, 0, 650, 340);
		contentPane.add(lblNewLabel);
		setLocation(new Point(290, 190));
	}
	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public JComboBox getTip_usr() {
		return tip_usr;
	}
}
