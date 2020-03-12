package controller;

import structure.*;
import visual.*;
import javafx.event.*;
import javafx.scene.control.Button;


public class Tratador implements EventHandler<ActionEvent>{
	FactoryController factory;

	public Tratador(){factory = new FactoryController();}

	public void handle(ActionEvent e){

		if(((Button)e.getSource()).getText().equals("Load")){
			new ConcreteScatterView(factory.getLoadController());
			
		}

		if(((Button)e.getSource()).getText().equals("Barabasi")){
			new ConcreteScatterView(factory.getBarabasiController());
			
		}

		if(((Button)e.getSource()).getText().equals("Random")){
			new ConcreteScatterView(factory.getRandomController());
			
		}

		if(((Button)e.getSource()).getText().equals("Quit")){
			System.exit(0);
		}
	}
}