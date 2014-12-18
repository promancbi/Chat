package com.mx.uam.Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import com.mx.uam.Thread.NServidor;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class VistaServidor extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private NServidor servidor = null;
	private VistaServidor ventanaServidor = null;
	
	public VistaServidor() {
			
		setTitle("Servidor");
		ventanaServidor = this;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 250, 250);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel label = new JLabel("Servidor");
		label.setFont(new Font("Serif", Font.BOLD, 20));
		label.setBounds(12, 12, 110, 48);
		contentPane.add(label);
		
		JLabel lblPuerto = new JLabel("Puerto :");
		lblPuerto.setBounds(12, 72, 70, 15);
		contentPane.add(lblPuerto);
		
		textField = new JTextField();
		textField.setText("7878");
		textField.setBounds(100, 72, 114, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnConectar = new JButton("Conectar");
		btnConectar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(servidor == null){
					int port = Integer.parseInt(textField.getText());
					servidor = new NServidor(ventanaServidor, port);
					servidor.start();
				}
			}
		});
		btnConectar.setBounds(100, 136, 117, 25);
		contentPane.add(btnConectar);
		
	
	}

}
