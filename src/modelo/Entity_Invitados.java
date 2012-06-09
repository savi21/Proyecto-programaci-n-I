package modelo;

public class Entity_Invitados {
	
	private int ID_invitado;
	private String nombre;
	private String apellido;
	private String sexo;
	private String direccion;
	private String telefono;
	
	
		public int getID_invitado() {
			return ID_invitado;
		}
		
		
		public String getNombre() {
			return nombre;
		}
		
		
		public String getApellido() {
			return apellido;
		}
		
		
		public String getSexo() {
			return sexo;
		}
		
		
		public String getDireccion() {
			return direccion;
		}
		
		
		public String getTelefono() {
			return telefono;
		}
		
		
		public void setID_invitado(int iD_invitado) {
			ID_invitado = iD_invitado;
		}
		
		
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		
		
		public void setApellido(String apellido) {
			this.apellido = apellido;
		}
		
		
		public void setSexo(String sexo) {
			this.sexo = sexo;
		}
		
		
		public void setDireccion(String direccion) {
			this.direccion = direccion;
		}
		
		
		public void setTelefono(String telefono) {
			this.telefono = telefono;
		}
		
		
		public String toString() {
			return getNombre()+" "+getApellido(); 
		}
		
		@Override
		public boolean equals(Object obj) {
			try{
				return getID_invitado()==((Entity_Invitados)obj).getID_invitado();
			}
			catch(Exception e){
				return false;
			}
		}
	
	
}
