package model;

import java.util.ArrayList;
import java.util.Collections;
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
	
	public void generatorEdge(){// las lineas 36,37,42,43 las meti para hacer el grafo bidireccional
		Edge lane;
		List<Vertex> vertexes = this.graph.getVertexes();
		Collections.shuffle(vertexes);
		Vertex firstVertex = vertexes.get(0); 
		Vertex lastVertex = vertexes.get(0);
		for (int indexEdge = 0; indexEdge < vertexes.size()-1; indexEdge++) {
			int weigth = (int)Math.floor(Math.random()*(50)+50);
			lane = new Edge(vertexes.get(indexEdge), vertexes.get(indexEdge+1), weigth);
			this.edges.add(lane);
			lane = new Edge(vertexes.get(indexEdge+1), vertexes.get(indexEdge), weigth);
			this.edges.add(lane);
			lastVertex = vertexes.get(indexEdge+1);
		}
		int weigth = (int)Math.floor(Math.random()*(50)+50);
		lane = new Edge(lastVertex, firstVertex, weigth);
		this.edges.add(lane);
		lane = new Edge(firstVertex, lastVertex, weigth);
		this.edges.add(lane);
	}

	public Graph getGraph() {
		return graph;
	}

	public List<Vertex> getNodes() {
		return nodes;
	}

	public List<Edge> getEdges() {
		return edges;
	}
	
	
}
