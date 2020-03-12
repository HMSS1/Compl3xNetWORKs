package structure;
	
import java.util.*; 
import visual.*;
import algorithm.*;


public class Graph{
	protected Map<Integer,LinkedList<Integer>> adj_list;
	protected LinkedList<ConcreteScatterView> observers;
	protected Integer largest_Vertex;
	protected Integer number_vertex;
	protected Integer number_edges;
	private Map<Integer,Map<Integer,Integer>> dist;

	public Graph(){
		adj_list = new HashMap<>();
		observers = new LinkedList<>();
		dist = new HashMap<>();
		number_edges = 0;
		number_vertex = 0;
		largest_Vertex = -1;
	}

	public void execute(){
		/* Calcula menor caminho entre cada vértice, usando um BFS para cada um*/
		for (Integer u : adj_list.keySet()) {
			BFS bfs = new BFS(u,this);
			dist.put(u, bfs.get());
		}
	}

	public void addVertex(int u){
		if(!adj_list.containsKey(u)){
			if(u > largest_Vertex) largest_Vertex = u;
			adj_list.put(u,new LinkedList<>());
			number_vertex++;
		}

	}

	public Integer getLargest(){
		return largest_Vertex;
	}


	public Integer getDiameter(){
		/* Apos o execute() verifica a maior distancia */
		int diameter = 0;
		for(Map.Entry<Integer,Map<Integer,Integer>> it : dist.entrySet()){
			Map<Integer,Integer> mapit = it.getValue();
			for (Map.Entry<Integer,Integer> it2 : mapit.entrySet()) {
				if(it2.getValue() > diameter) diameter = it2.getValue();
			}
		}
		return diameter;
	}

	public Double getMeanDistance(){
		/* Apos o execute() 

			li 	:: média das distancias do vértice i = (sum(dist(i,j)))/n;
			l 	:: média dos li.

			l = (sum(li))/n = sum(sum(dist(i,j)))/(n*n)

			 
		*/
		double isum = 0;
		LinkedList<Double> sum = new LinkedList<>();
		for(Map.Entry<Integer,Map<Integer,Integer>> it : dist.entrySet()){
			Map<Integer,Integer> mapit = it.getValue();
			for (Map.Entry<Integer,Integer> it2 : mapit.entrySet()) {
				if(it2.getValue()!=-1) isum+= (it2.getValue());
			}
		}
		return isum/(number_vertex*number_vertex);
	}

	public void addEdge(Integer u, Integer v){
		this.addVertex(u);
		this.addVertex(v);
		
		adj_list.get(u).add(v);
		number_edges++;

		this.notifyObservers(u,v);
	}

	public LinkedList<Integer> getAdj(int u){
		return adj_list.get(u);
	}

	public Map<Integer,LinkedList<Integer>> getAdjList(){
		return adj_list;
	}

	public Integer getDegree(int u){
		return adj_list.get(u).size();
	}

	public Set<Integer> getVertexs(){
		return adj_list.keySet();
	}

	public Integer getNumberVertex(){
		return number_vertex;
	}

	public Integer getNumberEdge(){
		return number_edges;
	}

	public String toString(){
		StringBuffer r = new StringBuffer();
		for (Map.Entry<Integer,LinkedList<Integer>> it : adj_list.entrySet()) {
			r.append(it.getKey()).append(" -> ").append(it.getValue()).append("\n");
		}
		return r.toString();
	}


	public Integer get(int number){
		int i = 0;
		for(Integer it : adj_list.keySet()){
			if(i == number) return it;
			i++;
		}
		return 0;
	}

	

	public void setObserver(ConcreteScatterView view){
		observers.add(view);
	}

	public void notifyObservers(Integer u,Integer v){
		for (ConcreteScatterView view_it : observers) {
			view_it.update(u,v);
		}
	}
	

}