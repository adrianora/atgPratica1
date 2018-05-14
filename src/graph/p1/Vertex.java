package graph.p1;

import java.util.List;

/**
 * Todo vertice carrega consigo uma lista de arestas com suas coneccoes em
 * relacao aos demais vertices.
 */
public interface Vertex<T> extends Comparable<Vertex<T>> {
	
	boolean isMarked();
	
	void setTrueMark();
	
	void setFalseMark();

	int getData();

	void setData(int data);
	
	List<Edge<T>> getEdges();

	boolean addEdge(Edge<T> edge);

	boolean removeEdge(Edge<T> edge);

	boolean hasEdge(Edge<T> edge);
	
	Edge<T> haveVertex(Vertex<T> vertex);

	int getNumberOfEdges();

	boolean isEmpty();

	boolean equals(Object obj);

}