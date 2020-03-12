package controller;
import visual.*;
import structure.*;

public interface GraphController{
	void start();
	void setObserver(ConcreteScatterView view);
	Graph getGraph();
}