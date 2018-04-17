package model;

import java.util.List;

/**
 *
 * @author Dani
 */
public class Graph {
    private final List<Vertex> vertexes;
    private final List<Edge> edges;

    public Graph(List<Vertex> vertexes, List<Edge> edges) {
        this.vertexes = vertexes;
        this.edges = edges;
    }

    public List<Vertex> getVertexes() {
        return vertexes;
    }

    public List<Edge> getEdges() {
        return edges;
    }
    
    public Vertex getVertexById(String pId, List<Vertex> pVertices)
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
    
    public void addLane(String source, String destination, int duration) {
        Edge lane = new Edge(getVertexById(source, this.vertexes), getVertexById(destination, this.vertexes), duration );
        edges.add(lane);
    }
}
