package com.mx.uam.Vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VistaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane = null;
	
	
	public VistaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 150, 150);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JButton btnCliente = new JButton("Cliente");
		btnCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				(new VistaCliente()).setVisible(true);
			}
		});
		btnCliente.setBounds(12, 12, 117, 25);
		contentPane.add(btnCliente);
		
		JButton btnServidor = new JButton("Servidor");
		btnServidor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	
				(new VistaServidor()).setVisible(true);
			}
		});
		btnServidor.setBounds(12, 60, 117, 25);
		contentPane.add(btnServidor);
	}
}
