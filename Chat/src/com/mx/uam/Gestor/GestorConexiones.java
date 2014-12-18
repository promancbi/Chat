package com.mx.uam.Gestor;

import java.util.ArrayList;

public class GestorConexiones {
	
	private static GestorConexiones singleton = new GestorConexiones();
	private ArrayList<NConexion> conexiones = new ArrayList<NConexion>();
	
	public static GestorConexiones getInstance(){
		return singleton;
	}
	
	
	public void enviarM(String mensaje) {
		for (NConexion c : conexiones) {
			c.enviarM(mensaje);
		}
	}
	
	public void conexionNueva(NConexion nuevo){
		conexiones.add(nuevo);
	}

}
