/**
 * 
 */
package ds.graph;

import org.junit.Test;

/**
 * @author Pawankumar Kulkarni
 *
 */
public class ShortestPathDijkstraTest {
	
	@Test 
    public void testShortestPath1() {
		Graph graph = new Graph(6);
		graph.addEdge(0, 1, 2);
		graph.addEdge(0, 2, 4);
		graph.addEdge(1, 2, 1);
		graph.addEdge(1, 3, 7);
		graph.addEdge(2, 4, 3);
		graph.addEdge(3, 5, 1);
		graph.addEdge(4, 3, 2);
		graph.addEdge(4, 5, 5);
		
		ShortestPathDijkstra dijkstra = new ShortestPathDijkstra(graph);
		System.out.println(dijkstra.shortestPath(0));
		dijkstra.printDistance();	
	}

}
