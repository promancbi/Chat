package com.mx.uam.App;

import com.mx.uam.Vista.VistaPrincipal;

public class App {
	VistaPrincipal ventana;

	public static void main(String[] args) {
	
		App app = new App();
		app.init();
	}
	
	public void init(){
		ventana = new VistaPrincipal();
		ventana.setTitle("Cliente/Servidor");
		ventana.setVisible(true);
	}

}
