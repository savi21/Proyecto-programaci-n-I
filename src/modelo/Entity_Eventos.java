package modelo;

import java.sql.Date;

public class Entity_Eventos {

	private int ID_Eventos;
	private String nombre;
	private String ubicacion;
	private java.util.Date fecha;
	
		
		public int getID_Eventos() {
			return ID_Eventos;
		}
		
		public String getNombre() {
			return nombre;
		}
		
		public String getUbicacion() {
			return ubicacion;
		}
		
		public java.util.Date getFecha() {
			return fecha;
		}
		
		public void setID_Eventos(int iD_Eventos) {
			ID_Eventos = iD_Eventos;
		}
		
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		
		public void setUbicacion(String ubicacion) {
			this.ubicacion = ubicacion;
		}
		
		public void setFecha(java.util.Date date) {
			this.fecha = date;
		}

		public String toString() {
			return getNombre(); 
		}	
		
		@Override
		public boolean equals(Object obj) {
			try{
				return getID_Eventos()==((Entity_Eventos)obj).getID_Eventos();
			}
			catch(Exception e){
				return false;
			}
		}
	
	
	
	
	
	
	
}
