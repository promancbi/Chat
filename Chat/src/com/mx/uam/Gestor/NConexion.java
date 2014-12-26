package com.mx.uam.Gestor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JOptionPane;

public class NConexion extends Thread{

	private DataInputStream dis= null;
	private DataOutputStream dos = null;
	
	
	public NConexion(Socket socket) {
		try {
			dis = new DataInputStream(socket.getInputStream());
			dos = new DataOutputStream(socket.getOutputStream());
			start();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error Conexion");
		}
	}
	@Override
	public void run(){
		
		while(true){
			try {
				String mensaje = dis.readUTF();
				GestorConexiones.getInstance().enviarM(mensaje);

			} catch (IOException e) {
			}
			
		}
	}
	
	public void enviarM(String mensaje){
		try {
			dos.writeUTF(mensaje);
		} catch (Exception e) {
		
		}
	}
}
