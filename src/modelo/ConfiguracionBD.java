package modelo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ConfiguracionBD {
	
	private String servidor, puerto, usuario, clave, bd;

	public ConfiguracionBD(){
		try {
			FileReader fr = new FileReader("config.cfg");
			BufferedReader br = new BufferedReader(fr);
			
			servidor = getValor(br.readLine());
			puerto = getValor(br.readLine());
			usuario = getValor(br.readLine());
			clave = getValor(br.readLine());
			bd = getValor(br.readLine());
		} catch (FileNotFoundException fnfe){
			fnfe.printStackTrace();
		} catch (IOException ioe){
			ioe.printStackTrace();
		}
	}
	
	public String getValor(String linea){
		if(linea.split(":").length>1)
			return linea.split(":")[1];
		else
			return "";
	}
	
	public String getServidor() {
		return servidor;
	}

	public String getPuerto() {
		return puerto;
	}

	public String getUsuario() {
		return usuario;
	}

	public String getClave() {
		return clave;
	}

	public String getBd() {
		return bd;
	}
	
}
