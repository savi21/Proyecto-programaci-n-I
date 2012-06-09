package controlador;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import vista.Splash;



public class Ejecuta {
	
	private static Splash sp;
	
	public static void main(String[] args) {
		
		sp=new Splash();
		sp.getBarra().addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				
			if (sp.getBarra().getValue() ==100){
				sp.dispose();
	            new Controles();
		     }
			}
			});
			
		
	}

}

