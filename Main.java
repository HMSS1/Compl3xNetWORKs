import structure.*;
import visual.*;
import controller.*;

import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;

/****************************************
*****************************************
*	Trabalho de Redes Complexas			*
*	Nome: Helio Matheus Sales Silva		*
*	Matricula: 400800					*
*****************************************
****************************************/

/**************************************************************************************

***	Esse projeto visa analisar redes complexas livres de escala.
***	Criando grafos passados como arquivo.
***	Criando grafos usando o modelo de Barabasi.
***	Criando grafos aleatórios de Erdos.
***	Mostrando estatisticas a respeito deles, como o Diametro e medidas de Centralidade.
***	Também eh possivel armazenar o grafo criado em um arquivo, caso desejado.
***
***
***	Padrões de Projeto:
***		+MVC
***		+Factory Pattern	[FactoryController]
***		+Decorator Pattern	[ScatterView/ConcreteScatterView/DecoratorScatterView/StatisticsScatterView]

****************************************************************************************/

public class Main extends Application{

	public static void main(String[] args) {
		launch(args);
	}


	public void start(Stage primaryStage) throws Exception{
		

		Tratador controller = new Tratador();

		/********************************************************************
		*** Esse tratador define as funcoes dos botões dessa visão,
		***	Ele possui uma fábrica de controladores
		***	Dependendo do botão, temos um controlador diferente.
		***	Dentre as opções de GraphController, temos: 
		***		+Barabasi
		***		+RandomGraph
		***		+Loader
		***	E criamos uma concrete scatter view. 
		*********************************************************************/

		Stage window = primaryStage;
		window.setTitle("Menu");

		Label label 			= new Label("Choose  your option");
		Button loadButton		= new Button("Load");
		Button barabasiButton 	= new Button("Barabasi");
		Button randomButton		= new Button("Random");
		Button quitButton 		= new Button("Quit");

		loadButton.setOnAction(controller);
		barabasiButton.setOnAction(controller);
		randomButton.setOnAction(controller);
		quitButton.setOnAction(controller);

		VBox layout = new VBox(10);
		layout.setAlignment(Pos.CENTER);
		layout.getChildren().addAll(label, loadButton, barabasiButton, randomButton, quitButton);

		Scene scene = new Scene(layout, 300,400);
		window.setScene(scene);
		window.show();

	}
}