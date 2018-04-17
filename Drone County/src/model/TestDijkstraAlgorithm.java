package model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 *
 * @author Dani
 */
public class TestDijkstraAlgorithm {
    private List<Vertex> nodes;
    private List<Edge> edges;

    public TestDijkstraAlgorithm() {
    }        

    
    public void testExcute() {
    	nodes = new ArrayList<Vertex>();
        edges = new ArrayList<Edge>();
                
        Vertex N0 = new Vertex("0");
        Vertex N1 = new Vertex("1");
        Vertex N2 = new Vertex("2");
        Vertex N3 = new Vertex("3");
        Vertex N4 = new Vertex("4");
        Vertex N5 = new Vertex("5");
        Vertex N6 = new Vertex("6");
        
        nodes.add(N0);
        nodes.add(N1);
        nodes.add(N2);
        nodes.add(N3);
        nodes.add(N4);
        nodes.add(N5);
        nodes.add(N6);

        Graph graph = new Graph(nodes, edges);
        graph.addLane("0", "2", 1);
        graph.addLane("0", "3", 2);
        graph.addLane("1", "5", 3);
        graph.addLane("1", "2", 2);
        graph.addLane("2", "1", 2);
        graph.addLane("2", "4", 3);
        graph.addLane("2", "3", 1);
        graph.addLane("2", "0", 1);
        graph.addLane("3", "2", 1);
        graph.addLane("3", "6", 1);
        graph.addLane("3", "0", 2);
        graph.addLane("4", "5", 2);
        graph.addLane("4", "2", 3);
        graph.addLane("5", "6", 1);
        graph.addLane("5", "4", 2);
        graph.addLane("5", "1", 3);
        graph.addLane("6", "5", 1);
        graph.addLane("6", "3", 1);

        //Lets check from location Loc_1 to Loc_10
        
        DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(graph);
        dijkstra.execute(graph.getVertexById("3", nodes));
        LinkedList<Vertex> path = dijkstra.getPath(graph.getVertexById("5", nodes));
        assertNotNull(path);
        assertTrue(path.size() > 0);

        for (Vertex vertex : path) {
            System.out.println(vertex);
        }
                

    }
    
    public static void main(String[] args)
    {
        TestDijkstraAlgorithm test = new TestDijkstraAlgorithm();
        test.testExcute();
    }
}