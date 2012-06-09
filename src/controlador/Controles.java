package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import modelo.Ini_se;
import modelo.Sesion;

import vista.Inicio_sesion;
import vista.Splash;

public class Controles {
	
	private Inicio_sesion ini;
	private Sesion se=new Sesion();
	
	
	public Controles(){
		
	
					
					ini=new Inicio_sesion();
					ini.setVisible(true);
					ini.getBtnAceptar().addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent arg0) {
								
								
								Ini_se i=new Ini_se();
								i.setNombre(ini.getUsr().getText());
								String password = new String(ini.getPassword().getPassword());
								i.setContra(password);
								i.setPerfil(ini.getTip_usr().getSelectedItem().toString());
								Ini_se iN= se.buscaUsr(i);
								if(iN.getComo()){
								
								if (ini.getTip_usr().getSelectedItem().toString().equalsIgnoreCase("Portero")){	
									ini.dispose();
									Porter p=new Porter();
								    p.setVarSesion(i.getNombre());
								   
									implementa(p);
					             }
								
								else if(ini.getTip_usr().getSelectedItem().toString().equalsIgnoreCase("Administrador")){
								    ini.dispose();
									Admin ad=new Admin();
								    ad.setVarSesion(i.getNombre());
								    
									implementa(ad);
									
								}
					          }
								else{
									ini.getUsr().setText("");
									ini.getPassword().setText("");
									ini.getTip_usr().setSelectedIndex(0);
								}
							}
						});
					 ini.getBtnCancelar().addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							ini.dispose();
							
						}
					});
			}


	
	public void implementa(Usuario us){
		us.Mode();
	}
}
