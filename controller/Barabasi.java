package controller;

import structure.*;
import java.util.*;
import visual.*;

/*
	
	Controller Barabasi gera uma rede livre de escala
	ou seja, uma  rede que  segue uma lei da potencia
	esse algoritmo é inspirado no modelo  de  geração
	de  grafo  de Price. Enfim, primeiro, criamos  um 
	grafo não direcionado com um conjunto inicial  de
	vértices.

	Iterativamente, iremos adicionando novos vértices
	temos a  variável out degree ( DEFAULT = 3 ), ela 
	indica o número de arestas saindo de um novo vér-
	tice.

	Para gerar uma rede livre de escala,  devemos no-
	tar que a probabilidade de um vertice receber uma
	nova  aresta deve ser  proporcional ao  número de  
	arestas que ele ja possui. Dessa forma, vértices 
	com muitas arestas tem maior probabilidade de re-
	ceber novas arestas.

	Isso vai ser feito da seguinte forma:
		Geramos um valor p, tal que 0 < p < 1.
		Se p < 1/2:
			Escolhemos um vértice qualquer do grafo.
		Senão:
			Escolhemos um vértice de uma lista.

	Essa lista é gerada de tal forma que todos os vétices
	iniciais estão nela e sempre que escolhemos o vértice
	ele é  adicionado na lista novamente.

	Observe, Um vértice que recebe muitas arestas aparece
	varias vezes nessa lista, daí, a probabilidade dele
	ser escolhido novamente é maior na lista. Além disso,
	um vértice qualquer ser escolhido no grafo é feito
	de forma uniforme.

*/
public class Barabasi implements GraphController{

	private Graph graph;	//MODEL.
	private Random random;
	private LinkedList<Integer> targets; //Lista
	private int out_degree;
	private int number_vertex;
	private int initial_vertex;

	public Barabasi(){
		graph 	= new Graph();
		random 	= new Random();
		targets = new LinkedList<>();
		
		 
		this.initial_vertex = random.nextInt(9); //Quantidade inicial de vértices, podemos ter até 10 ...
		this.initial_vertex++;
		
		this.number_vertex = Integer.parseInt(EntryBox.display("Starting with " + 
			initial_vertex + " vertex.Number of vertex to add?"));
		//IMPLEMENTAR EXCEÇÃO

		this.out_degree = 3; //[DEFAULT]

		for (int i = 0; i < initial_vertex; i++) {
			graph.addVertex(i);
			targets.add(i);
		}
		
	}

	public void start(){ //Vamos adicionar os novos vértices ...
		for (int i = initial_vertex; i < number_vertex + initial_vertex; i++) {
			this.addVertex(i);
		}
	}
	

	public void addVertex(int u){
		int k = 0;
		
		while(k < out_degree){
			int v;
			if(random.nextDouble() < 1/2){ 
				v = targets.get(random.nextInt(targets.size()));

			}else{
				List<Integer> keys = new ArrayList<Integer>(graph.getVertexs());
				v = keys.get(random.nextInt(keys.size()));	
			}
			k++;
			graph.addEdge(u,v);
			graph.addEdge(v,u);
			targets.add(v);
		}
	}


	public Graph getGraph(){
		return graph;
	}

	public void setObserver(ConcreteScatterView view){
		graph.setObserver(view);
	}	

}