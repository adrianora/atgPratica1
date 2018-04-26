package grafos_p1;

/**
 * Todo vertice carrega consigo uma lista de arestas com suas coneccoes em
 * relacao aos demais vertices.
 */
public interface Vertex<T> {

	T getData();

	void setData(T data);

	boolean addEdge(Edge<T> edge);

	boolean removeEdge(Edge<T> edge);

	boolean hasEdge(Edge<T> edge);

	/**
	 * Retorna um vertice conectado dado o indice de sua aresta. Se o vertice nao
	 * tiver conectado deve retornar null.
	 */
	Vertex<T> getVertex(int indexEdge);

	boolean isEmpty();

}