package algorithm;
import structure.*;
import java.io.*;
import java.util.*;

/*
	Cria um arquivo na pasta /datasets/ com o nome desejado
*/
	
public class MakeFile{
	private Graph graph;
	public MakeFile(Graph graph){
		this.graph = graph;
	}

	public void make(String name){
		PrintWriter pw = null;
		try{
			pw = new PrintWriter("./datasets/" + name);
			Map<Integer, LinkedList<Integer>> adj_list = graph.getAdjList();
			for (Map.Entry<Integer,LinkedList<Integer>> iterator : adj_list.entrySet()) {
				Integer u = iterator.getKey();
				LinkedList<Integer> adj_u = iterator.getValue();
				if(adj_u.size()==0) pw.println(u + " null");
				for(Integer v : adj_u){
					pw.println(u + " " + v);
				}
	 		}
 		}catch(Exception e){System.out.println("file");}
 		finally{
 			if(pw != null ) pw.close();
 		}
	}
}