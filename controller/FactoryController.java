package controller;

public class FactoryController{
	public FactoryController(){}

	public GraphController getBarabasiController(){
		return new Barabasi();
	}

	public GraphController getLoadController(){
		return new Loader();
	}

	public GraphController getRandomController(){
		return new RandomGraph();
	}


}