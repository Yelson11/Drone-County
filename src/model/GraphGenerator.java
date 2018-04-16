package model;

import java.util.ArrayList;
import java.util.List;

public class GraphGenerator {
	private Graph graph;
    private final List<Vertex> nodes;
    private final List<Edge> edges;
	
	public GraphGenerator() {
		this.nodes = new ArrayList<Vertex>();
        this.edges = new ArrayList<Edge>();
		this.graph = new Graph(nodes, edges);
	}
	
	public void generatorVertex(int quantityVertex){
		Vertex newVertix;
		for (int indexVertex = 0; indexVertex < quantityVertex; indexVertex++) {
			newVertix = new Vertex(String.valueOf(indexVertex));
			this.nodes.add(newVertix);
		}
	}
	
	public void generatorEdge(int quantityEdges){
		
	}
	
}
