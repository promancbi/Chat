package com.mx.uam.Thread;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;


import javax.swing.JOptionPane;

import com.mx.uam.Vista.VistaCliente;

public class NCliente extends Thread {
	private String address = null;
	private int port = 0;
	private VistaCliente ventana = null;
	private Socket socket = null;
	
	public NCliente(VistaCliente ventana ,String address,int port){
		this.ventana = ventana;
		this.address = address;
		this.port = port;
	}
	
	@Override
	public void run(){
		
		try {
			socket = new Socket(address, port);
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			//true = Esta conectado.
			while(true){
				String mensaje = dis.readUTF();
				ventana.mensajeR(mensaje);
			}
			//JOptionPane.showMessageDialog(null, "Se ha creado conexión.");
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Host no encontrado.");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Error Puerto.");
		}

	}
	
	public void enviarMensaje(String mensaje) {

			
		try {
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			dos.writeUTF(mensaje);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No se puede enviar el mensaje.");
		}
	}
}
