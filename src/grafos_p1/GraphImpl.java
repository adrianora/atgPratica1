package grafos_p1;

import java.util.ArrayList;
import java.util.List;

import grafos_p1_exceptions.VertexDoesNotExistException;

public class GraphImpl<T> implements Graph<T> {

	private List<Vertex<T>> vertices;

	public GraphImpl() {
		vertices = new ArrayList<>();
	}

	@Override
	public List<Vertex<T>> getVertices() {
		return this.vertices;
	}

	@Override
	public boolean addVertex(Vertex<T> vertex) {
		return this.vertices.add(vertex);
	}

	@Override
	public int getVertexNumber() {
		return this.vertices.size();
	}

	@Override
	public boolean addEdge(Vertex<T> from, Vertex<T> to, float weight) {
		tryCatchValidateVertices(from, to);
		return addEdgeToVertex(from, to, weight);
	}

	/**
	 * Pelo fato do grafo nao ser direcionado entao a ligacao deve ser dupla, se o
	 * vertice X tem ligacao direta com Y, necessariamente deve ser possivel partir
	 * do vertice Y e chegar em X.
	 */
	private boolean addEdgeToVertex(Vertex<T> from, Vertex<T> to, float weight) {
		Vertex<T> vertexFrom = getObjectVertexOnList(from);
		Vertex<T> vertexTo = getObjectVertexOnList(to);

		Edge<T> edgeFromTo = new EdgeImpl<T>(vertexTo, weight);
		Edge<T> edgeToFrom = new EdgeImpl<T>(vertexFrom, weight);

		vertexFrom.addEdge(edgeFromTo);
		vertexTo.addEdge(edgeToFrom);

		return vertexFrom.hasEdge(edgeFromTo) && vertexTo.hasEdge(edgeToFrom);
	}

	private boolean validateVertices(Vertex<T> from, Vertex<T> to) throws VertexDoesNotExistException {
		if (this.vertices.contains(from) && this.vertices.contains(to))
			return true;

		throw new VertexDoesNotExistException();
	}

	private void tryCatchValidateVertices(Vertex<T> from, Vertex<T> to) {
		try {
			validateVertices(from, to);
		} catch (VertexDoesNotExistException e) {
			e.getMessage();
		}
	}

	/**
	 * Retorna o objeto vertice da lista de vertices do grafo. A validacao eh
	 * necessaria para garantir mesmo hashcode dos vertices em futuras operacoes
	 */
	private Vertex<T> getObjectVertexOnList(Vertex<T> vertex) {
		Vertex<T> result = null;
		if (this.vertices.contains(vertex)) {
			int indexOfVertex = this.vertices.indexOf(vertex);
			if (indexOfVertex != -1)
				result = this.vertices.get(indexOfVertex);
		}
		return result;
	}

	@Override
	public int getEdgeNumber() {
		int result = 0;

		for (int i = 0; i < this.vertices.size(); i++)
			result += this.vertices.get(i).getNumberOfEdges();

		return result - this.vertices.size();
	}

	@Override
	public float getMeanEdge() {
		int result = 0;

		for (int i = 0; i < this.vertices.size(); i++)
			result += this.vertices.get(i).getNumberOfEdges();

		return result / getEdgeNumber();
	}

	@Override
	public String graphRepresentation(String graph, String type) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private String grapRepresentationAM(){
		
		return null;
	}

	@Override
	public String BFS(String graph, String vertice) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String DFS(String graph, String vertice) {
		int branco = 0;
		int cinza = 1;
		int preto = 2;

		return null;
	}

	@Override
	public String SCC(String graph) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String shortestPath(String v1, String v2) {
		if (v1 == v2) {
			return v1;
		}
		return null;
	}

	@Override
	public String mst(String graph) {
		// TODO Auto-generated method stub
		return null;
	}

}
