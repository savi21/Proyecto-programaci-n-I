package modelo;

import java.sql.Date;

public class EntityEvento {

	private String nombre_evento;
	private String ubicacion;
	private Date fecha;
	private int Id;
	
	public void setId(int id) {
		Id = id;
	}
	public int getId() {
		return Id;
	}
	public String getNombre_evento() {
		return nombre_evento;
	}
	public void setNombre_evento(String nombre_evento) {
		this.nombre_evento = nombre_evento;
	}
	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	
	
	
	
	
	
	
}
