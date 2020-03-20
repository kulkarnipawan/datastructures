/**
 * 
 */
package ds.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Pawankumar Kulkarni
 *
 */
public class ShortestPathDijkstra {
	
	private int[] dist;
	private Graph graph;
	
	public ShortestPathDijkstra(Graph graph) {
		this.graph = graph;
		dist = new int[graph.getVertices().size()];
	}
	
	public List<Integer> shortestPath(int start) {
		//List of vertices visited in path
		List<Integer> path = new ArrayList<>(dist.length);
		
		if(start>graph.getVertices().size()) 
			return path;
		
		//Add start vertex to path
		path.add(start);
		
		//Initialize the dist array using edges of starting vertex
		Map<Integer, Integer> edges = graph.getEdges(start);
		for(int i=0;i<dist.length;i++) {
			if(edges.get(i) != null) {
				dist[i] = edges.get(i);
			} else {
				dist[i] = Integer.MAX_VALUE;
			}
		}
		dist[start] = 0;
		int next, cost;
		
		while(path.size()<dist.length) {
			//Select next nearest vertex
			next = selectVertex(path);
			edges = graph.getEdges(next);
			
			//Relax vertices adjacent to next
			for(Integer key : edges.keySet()) {
				if(!path.contains(key)) {
					cost = dist[next] + edges.get(key);
					if(cost < dist[key]) 
						dist[key] = cost;
				}
			}
			
			path.add(next);
		}
		
		return path;		
	}
	
	private int selectVertex(List<Integer> path) {
		int min=-1;
		
		for(int i=0;i<dist.length;i++) {
			if(!path.contains(i)) {
				if(min == -1 || dist[i]<dist[min]) 
					min = i;
			}
		}
		
		return min;
	}
	
	public void printDistance() {
		System.out.println("------------------------------------------");
		for(int i=0;i<dist.length;i++) {
			System.out.print(dist[i] + "\t");
		}
		System.out.println("\n------------------------------------------");
	}

}
