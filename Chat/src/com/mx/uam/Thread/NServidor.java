package com.mx.uam.Thread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.mx.uam.Gestor.GestorConexiones;
import com.mx.uam.Gestor.NConexion;
import com.mx.uam.Vista.VistaServidor;

public class NServidor extends Thread {

	int port = 0;
	VistaServidor ventana = null;

	public NServidor(VistaServidor ventana , int port){
		this.ventana = ventana;
		this.port = port;
	}
	
	@Override
	public void run(){
		
		ServerSocket ss = null;
		
		try {
			 ss = new ServerSocket(port);
	
			while (true){
				Socket socket = ss.accept();
				GestorConexiones.getInstance().conexionNueva(new NConexion(socket));
			}
			//JOptionPane.showMessageDialog(null, "Conexión Creada.");
		} catch (IOException e1) {
			JOptionPane.showMessageDialog(null, "Error en la Conexión.");
		}	
		
		try {
			ss.close();
		} catch (IOException e1) {
			JOptionPane.showMessageDialog(null, "Se ha cerrado la conexión.");
		}

	}
}

