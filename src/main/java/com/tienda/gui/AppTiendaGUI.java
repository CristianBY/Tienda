package com.tienda.gui;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ChoiceBox;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;


import com.tienda.bean.*;
import com.tienda.dao.*;

public class AppTiendaGUI extends Application{

	private Label messageLbl = new Label("");
	private Label respuesta = new Label("");
	private ListView<Producto> productos = new ListView<Producto>();
	
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage){

		String conexion = "jdbc:sqlite:datos/tienda.db";
		DAOProducto dao2 = new DAOImpProductoBD(conexion);
			
		List<Producto> albaran= dao2.leerTodos();
		dao2.cerrar();
		//ObservableList<Producto> observableList = FXCollections.observableList(albaran);
		//productos.setItems(observableList);
		
		ChoiceBox<Producto> cb = new ChoiceBox(FXCollections.observableArrayList(albaran));
		cb.setOnAction(event ->{
			printMessage(cb.getValue().toString());
		});

		//productos.setPrefWidth(200);
		//productos.setPrefHeight(70);

		VBox root = new VBox();
		root.getChildren().addAll(btn1,messageLbl,productos,cb,respuesta);
		root.setMinSize(350, 250);
		root.setStyle("-fx-padding: 10;" +
				"-fx-border-style: solid inside;" +
				"-fx-border-width: 2;" +
				"-fx-border-insets: 5;" +
				"-fx-border-radius: 5;" +
				"-fx-border-color: blue;");
         
		// Create the Scene
		Scene scene = new Scene(root);
		// Add the scene to the Stage
		stage.setScene(scene);
		// Set the title of the Stage
		stage.setTitle("Fruteria");
		// Display the Stage
		stage.show();
	}
    public void printMessage(String message){
		respuesta.setText(message);
	} 
}