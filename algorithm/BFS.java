package algorithm;
import structure.*;
import java.util.*;
public class BFS{

	private Map<Integer,Integer> dist;
	public BFS(int s, Graph graph){
		dist  = new HashMap<>();
		Map<Integer,String>  color = new HashMap<>();

		for (Integer u : graph.getVertexs()) {
			dist.put(u,-1);
			color.put(u,"White");
		}

		LinkedList<Integer> q = new LinkedList<>();
		dist.put(s,0);
		color.put(s,"Gray");
		q.push(s);

		while(!q.isEmpty()){
			Integer u = q.removeLast();
			for(Integer v : graph.getAdj(u)){
				if(color.get(v).equals("White")){
					color.put(v,"Gray");
					dist.put(v, dist.get(u) + 1);
					q.push(v);
				}
			}
			color.put(u,"Black");
		}

	}

	public Integer getMax(){
		return Collections.max(dist.values());
	}

	public Map<Integer,Integer> get(){
		return dist;
	}
}