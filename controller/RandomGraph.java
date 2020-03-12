package controller;

import structure.*;
import visual.*;

import java.util.*;

/*
	Controller RandomGraph gera um grafo aleatório
	de Erdos. Foi durante anos a principal forma
	de gerar e estudar grafos.

	Ele funciona de forma bem intuitiva, temos um
	conjunto de vétices [FIXO] e um número de aresta
	e escolhemos u, v de forma aleatória e adicionamos
	a aresta. Assim como barabasi, também temos um
	grafo não direcionado.

*/


public class RandomGraph implements GraphController{

	private Graph graph; //MODEL.
	private Random random;
	private Integer number_vertex;
	private Integer number_edge;

	public RandomGraph(){
		graph = new Graph();
		random = new Random();
		this.number_vertex = Integer.parseInt(EntryBox.display("Number of vertex ?"));
		//IMPLEMENTAR EXCEÇÃO
		this.number_edge = Integer.parseInt(EntryBox.display("Number of edges ?"));
		//IMPLEMENTAR EXCEÇÃO

	}	

	public void start(){
		for (int i = 0; i < number_vertex; i++) {
			graph.addVertex(i);
		}
		int v,u;
		for (int i = 0; i < number_edge; i++) {
			u = graph.get(random.nextInt(graph.getLargest()+1));
			v = graph.get(random.nextInt(graph.getLargest()+1));	
			graph.addEdge(u,v);
			graph.addEdge(v,u);
		}
	}

	public void setObserver(ConcreteScatterView view){
		if(graph!=null) graph.setObserver(view);
	}

	public Graph getGraph(){
		return graph;
	}


}