package com.mx.uam.Vista;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import com.mx.uam.Thread.NCliente;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextArea;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class VistaCliente extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private NCliente cliente = null;
	private VistaCliente ventanaCliente = null;
	private JTextField textField_2;
	private JTextArea textArea;
	
	public VistaCliente() {
		
		setTitle("Cliente");
		ventanaCliente = this;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 450);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblCliente = new JLabel("Cliente");
		lblCliente.setFont(new Font("Serif", Font.BOLD, 20));
		lblCliente.setBounds(12, 12, 89, 48);
		contentPane.add(lblCliente);
		
		JLabel lblPuerto = new JLabel("Puerto :");
		lblPuerto.setBounds(22, 77, 70, 15);
		contentPane.add(lblPuerto);
		
		textField = new JTextField();
		textField.setText("7878");
		textField.setBounds(106, 75, 114, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblUrl = new JLabel("URL :");
		lblUrl.setBounds(22, 115, 70, 15);
		contentPane.add(lblUrl);
		
		textField_1 = new JTextField();
		textField_1.setText("127.0.0.1");
		textField_1.setBounds(106, 113, 114, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnConectar = new JButton("Conectar");
		btnConectar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int port = Integer.parseInt(textField.getText());
				String address = textField_1.getText();
				if(cliente == null){
					cliente = new NCliente(ventanaCliente,address, port);
					cliente.start();
				}
			}
		});
		btnConectar.setBounds(106, 164, 117, 25);
		contentPane.add(btnConectar);
		
		textArea = new JTextArea();
		textArea.setBounds(22, 212, 402, 162);
		contentPane.add(textArea);
		
		textField_2 = new JTextField();
		textField_2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == 10){
					cliente.enviarMensaje(textField_2.getText());
					textField_2.setText("");
				}
			}
		});
		textField_2.setBounds(22, 394, 402, 19);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
	}
	
	public void mensajeR(String mensaje){
		textArea.append(mensaje+"\n");
	}
}
