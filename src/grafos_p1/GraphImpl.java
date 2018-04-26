package grafos_p1;

import java.util.ArrayList;
import java.util.List;

public class GraphImpl<T> implements Graph<T> {

	private List<Vertex<T>> vertices;

	private List<Edge<T>> arestas;

	public GraphImpl() {
		vertices = new ArrayList<>();
		arestas = new ArrayList<>();
	}

	@Override
	public void addVertex(Vertex<T> from, Vertex<T> to) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getVertexNumber() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void addEdge(Vertex<T> from, Vertex<T> to) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getEdgeNumber() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getMeanEdge() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String graphRepresentation(String graph, String type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String BFS(String graph, String vertice) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String DFS(String graph, String vertice) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String SCC(String graph) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String shortestPath(String v1, String v2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String mst(String graph) {
		// TODO Auto-generated method stub
		return null;
	}

}
