package controller;

import structure.*;
import java.io.*;
import visual.*;
import algorithm.*;

/*
	Classe que recebe um arquivo e lê o grafo nele.
	Observações:
		0 null //implica que o vértice existe, mas não possui arestas saindo dele
		delimiter = " " // [DEFAULT]

*/


public class Loader implements GraphController{
	private String path;
	private Graph graph; //MODEL
	private String delimiter;

	public Loader(){
		this.graph = new Graph();
		this.delimiter = " "; //Observe se seu arquivo separa os vértices de forma adequada.
		this.path = EntryBox.display("Path?");
		//IMPLEMENTAR EXCEÇÃO
	}


	public void start(){

		BufferedReader load = null;
		String line = "";
		String[] arrLine;

		try{
			load = new BufferedReader(new FileReader(path));
			while((line = load.readLine()) != null){
				arrLine = line.split(delimiter);

				if(arrLine[1].equals("null")) graph.addVertex(Integer.parseInt(arrLine[0]));
				else
					graph.addEdge(Integer.valueOf(arrLine[0]), Integer.valueOf(arrLine[1]));
				
			}


		}catch (IOException e){
			e.printStackTrace();
		}finally{
			try{
				if(load != null) load.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}

	public void setObserver(ConcreteScatterView view){
		if(graph!=null) graph.setObserver(view);
	}

	public Graph getGraph(){
		return graph;
	}

}