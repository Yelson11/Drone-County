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

        addLane("Edge_0", "0", "2", 1);
        addLane("Edge_1", "0", "3", 2);
        addLane("Edge_2", "1", "5", 3);
        addLane("Edge_3", "1", "2", 2);
        addLane("Edge_4", "2", "1", 2);
        addLane("Edge_5", "2", "4", 3);
        addLane("Edge_6", "2", "3", 1);
        addLane("Edge_7", "2", "0", 1);
        addLane("Edge_8", "3", "2", 1);
        addLane("Edge_9", "3", "6", 1);
        addLane("Edge_10", "3", "0", 2);
        addLane("Edge_11", "4", "5", 2);
        addLane("Edge_12", "4", "2", 3);
        addLane("Edge_13", "5", "6", 1);
        addLane("Edge_14", "5", "4", 2);
        addLane("Edge_15", "5", "1", 3);
        addLane("Edge_16", "6", "5", 1);
        addLane("Edge_17", "6", "3", 1);

        // Lets check from location Loc_1 to Loc_10
        Graph graph = new Graph(nodes, edges);
        DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(graph);
        dijkstra.execute(getVertexById("0", nodes));
        LinkedList<Vertex> path = dijkstra.getPath(getVertexById("5", nodes));

        assertNotNull(path);
        assertTrue(path.size() > 0);

        for (Vertex vertex : path) {
            System.out.println(vertex);
        }
                

    }

    private Vertex getVertexById(String pId, List<Vertex> pVertices)
    {
        for(Vertex vertex : pVertices)
        {
            if(vertex.getId().equals(pId))
            {
                return vertex;
            }
        }
        return null;
    }
    
    private void addLane(String laneId, String source, String destination, int duration) {
        Edge lane = new Edge(laneId,getVertexById(source, nodes), getVertexById(destination, nodes), duration );
        edges.add(lane);
    }
    
    public static void main(String[] args)
    {
        TestDijkstraAlgorithm test = new TestDijkstraAlgorithm();
        test.testExcute();
    }
}
