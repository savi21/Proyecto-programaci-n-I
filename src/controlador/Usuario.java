package controlador;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;
import modelo.Entity_Eventos;
import modelo.Entity_VisitaImp;
import modelo.Mantenimiento_Portero;
import modelo.Mantenimiento_Usuarios;
import vista.Administrador;
import vista.Inicio_sesion;
import vista.Portero;


public abstract class Usuario {
	
	
	private Portero p;
	private Administrador a;
	private Inicio_sesion ini;
	private Entity_Eventos ee;
	private Entity_VisitaImp ei;
	private Mantenimiento_Portero m=new Mantenimiento_Portero();
	private  String[] field1;
	private String g;
	private int idE;
	private Mantenimiento_Usuarios mu;
	
	

	public Portero getP() {
		return p;
	}

	public void setP(Portero p) {
		this.p = p;
	}

	public Administrador getA() {
		return a;
	}

	public void setA(Administrador a) {
		this.a = a;
	}

	public Inicio_sesion getIni() {
		return ini;
	}

	public void setIni(Inicio_sesion ini) {
		this.ini = ini;
	}

	public Entity_Eventos getEe() {
		return ee;
	}

	public void setEe(Entity_Eventos ee) {
		this.ee = ee;
	}

	public Entity_VisitaImp getEi() {
		return ei;
	}

	public void setEi(Entity_VisitaImp ei) {
		this.ei = ei;
	}

	public Mantenimiento_Portero getM() {
		return m;
	}

	public void setM(Mantenimiento_Portero m) {
		this.m = m;
	}

	public String[] getField1() {
		return field1;
	}

	public void setField1(String[] field1) {
		this.field1 = field1;
	}

	public String getG() {
		return g;
	}

	public void setG(String g) {
		this.g = g;
	}

	public int getIdE() {
		return idE;
	}

	public void setIdE(int idE) {
		this.idE = idE;
	}

	public Mantenimiento_Usuarios getMu() {
		return mu;
	}

	public void setMu(Mantenimiento_Usuarios mu) {
		this.mu = mu;
	}
	
	public abstract void Mode();
	
	
//Lee lo que seleccionas en la tabla
	
class SelectListener extends MouseAdapter{
	
	 private JTable tab;
	 private Object Id=new Object();
	 private Object As=new Object();

	 
	 public SelectListener(JTable tb){
		 this.tab=tb;
	 }
 

   public void mousePressed(MouseEvent met){
       select();
   }
   
   public Object select(){
   	int fila=tab.getSelectedRow();
   	Id = "";
      
           Id=tab.getValueAt(fila, 0);
			return Id;
       
   }
   public Object select1(){
   	int row=tab.getSelectedRow();
   	As = "";
      
           As=tab.getComponent(row);
			return As;
       
   }
}
}
