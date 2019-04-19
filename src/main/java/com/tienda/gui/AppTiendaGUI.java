package com.tienda.gui;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.ChoiceBox;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;


import com.tienda.bean.*;
import com.tienda.dao.*;

public class AppTiendaGUI extends Application{
	 DAOImpClienteBD busqueda = new DAOImpClienteBD ();
	 DAOImpCompraBD busqueda2 = new DAOImpCompraBD();
	 Compra compra = new Compra();
	 Cliente cliente = new Cliente();
	 BuscaFactura b = new BuscaFactura();
	@Override
	public void start(Stage primaryStage) {
		try {
			
			Scene sceneInicial; 
			Button buscar = new Button ("_Buscar");
			
			Button comprar = new Button ("_Comprar");
			Button inicio = new Button ("_Inicio");
			
			
		
			
			HBox botonera= new HBox(buscar , comprar,inicio);
			botonera.setTranslateX(300);
			botonera.setTranslateY(300);
			botonera.setSpacing(15);
			
			VBox rootInicial = new VBox (botonera);
		
			sceneInicial = new Scene (rootInicial,800,800);
		
			inicio.setOnAction(e -> {
					
					botonera.setTranslateY(300);
					rootInicial.getChildren().clear();
					rootInicial.getChildren().add(botonera);
					
			}
					);			
			buscar.setOnAction(e -> 
			{
			rootInicial.getChildren().clear();
			rootInicial.getChildren().add(botonera);
			botonera.setTranslateY(0);
			
			rootInicial.getChildren().add(b.box());
			
			}
			);
			

			

			
		


			rootInicial.setStyle(
					""
							+ "-fx-background-image:url(https://factoryfy.es/wp-content/uploads/logotipo-tienda-fruteria-frutas-verduras.jpg);"+
						    "-fx-background-size: 900 506;"+
						    "-fx-background-position: center center;"
					);
		

			primaryStage.setScene(sceneInicial);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}