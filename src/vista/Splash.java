package vista;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JProgressBar;

import controlador.HiloBarrap;

import java.awt.Font;
import java.awt.Cursor;
import java.awt.SystemColor;

public class Splash extends JFrame {

	private static final long serialVersionUID = 1L;
    private  JProgressBar barra;
    private HiloBarrap hilo;
 

	public Splash(){
		
		setUndecorated(true);
		splashVisual();;
		hilo=new HiloBarrap(barra);
		hilo.start();
		this.setLocation(350,250);
		hilo=null;
		setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
		getContentPane().setBackground(new Color(255, 255, 255));
			
	}

	public JProgressBar getBarra() {
		return barra;
	}

	public void splashVisual(){
		
		setTitle("Indigo Events");
		setSize(522,266);
		setVisible(true);
		setLocation(300, 400);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("\u00A9 All Reservated Rigths");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_1.setForeground(Color.DARK_GRAY);
		lblNewLabel_1.setBounds(372, 230, 127, 14);
		getContentPane().add(lblNewLabel_1);
		
	    barra = new JProgressBar();
	    barra.setForeground(SystemColor.activeCaptionText);
	    barra.setStringPainted(true);		
		barra.setBounds(179, 202, 168, 17);
		getContentPane().add(barra);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Splash.class.getResource("/Vista/imagenes/splash.png")));
		lblNewLabel.setBounds(0, 0, 522, 266);
		getContentPane().add(lblNewLabel);
		
	}

}
