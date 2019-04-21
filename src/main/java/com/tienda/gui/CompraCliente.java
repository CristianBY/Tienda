package com.tienda.gui;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import com.tienda.bean.*;
import com.tienda.dao.*;

public class CompraCliente extends Application{

	@Override
	public void start(Stage clienteStage) throws Exception {
		// TODO Auto-generated method stub
		
	}
	public VBox grabarCliente(String dniCliente){
		DAOCliente daoCliente = new DAOImpClienteBD();
		RealizarCompra realizarCompra = new RealizarCompra();
		Label nombre = new Label("Nombre");
		TextField textNombre = new TextField();
		Label direccion = new Label("Direccion");
		TextField textDireccion = new TextField();
		Button b1 = new Button("_Compra");
		b1.setStyle("-fx-text-fill: white;"
    				+"-fx-font-weight: bold;"
    				+"-fx-background-color: linear-gradient(#61a2b1, #2A5058);"
    				+"-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );");
		
		
		VBox box = new VBox(nombre,textNombre,direccion,textDireccion,b1);

		b1.setOnAction(e -> {
			box.getChildren().clear();
			Cliente cliente = new Cliente(textNombre.getText(),dniCliente,textDireccion.getText());
			daoCliente.grabar(cliente);
			daoCliente.cerrar();
			box.getChildren().add(realizarCompra.box(cliente));
		});

		return box;

	}

	public VBox box() {	
		
		RealizarCompra realizarCompra = new RealizarCompra(); 
		DAOCliente daoCliente = new DAOImpClienteBD();
		Label dni = new Label("DNI");
		TextField textDni = new TextField();
		textDni.setMaxWidth(150);
		Button b1 = new Button("_Compra");
		b1.setStyle("-fx-text-fill: white;"
    				+"-fx-font-weight: bold;"
    				+"-fx-background-color: linear-gradient(#61a2b1, #2A5058);"
    				+"-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );");
	
		VBox rootCliente = new VBox(dni,textDni,b1);
		rootCliente.setMaxSize(250, 250);
		 
		b1.setOnAction(e -> {
			rootCliente.getChildren().clear();
			Cliente cliente = daoCliente.leer(textDni.getText());
			daoCliente.cerrar();
			if (cliente != null) {
				rootCliente.getChildren().add(realizarCompra.box(cliente));
			} else {
           		rootCliente.getChildren().add(grabarCliente(textDni.getText()));
           	}
	
		
		});
	
		return rootCliente;
		
	}
}