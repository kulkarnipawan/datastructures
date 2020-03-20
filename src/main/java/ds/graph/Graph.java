/**
 * 
 */
package ds.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Pawankumar Kulkarni
 *
 */
public class Graph {
	
	private List<Integer> vertices;
	private Map<Integer,Integer>[] edges;
	
	public Graph(int size) {
		vertices = new ArrayList<>(size);
		for(int i=0;i<size;i++) vertices.add(i);
		edges = new Map[size];
		for(int i=0;i<size;i++) {
			edges[i]=new HashMap<>(size);
		}
	}

	/**
	 * @return the vertices
	 */
	public List<Integer> getVertices() {
		return vertices;
	}

	/**
	 * @return the edges
	 */
	public Map<Integer,Integer>[] getAllEdges() {
		return edges;
	}
	
	/**
	 * @return the edges
	 */
	public Map<Integer,Integer> getEdges(int vertex) {
		if(vertex<edges.length)
			return edges[vertex];
		
		return null;
	}
	
	public boolean addEdge(int src, int dest, int weight) {
		if(src >= 0 && src < vertices.size()
			&& dest >= 0 && dest < vertices.size()
			&& src != dest) {
			edges[src].put(dest, weight);
			edges[dest].put(src, weight);
		}
		return false;
	}

}
