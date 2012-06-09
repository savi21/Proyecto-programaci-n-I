package modelo;

public class Entity_Invitaciones {
	private Integer ID_Invitado;
	private Integer ID_Evento;
	private String asistencia="No";
	
	
	public Integer getID_Invitado() {
		return ID_Invitado;
	}
	
	public Integer getID_Evento() {
		return ID_Evento;
	}
	
	public String getAsistencia() {
		return asistencia;
	}
	
	public void setID_Invitado(Integer iD_Invitado) {
		ID_Invitado = iD_Invitado;
	}
	
	public void setID_Evento(Integer iD_Evento) {
		ID_Evento = iD_Evento;
	}
	
	public void setAsistencia(String asistencia) {
		this.asistencia = asistencia;
	}
	
}
