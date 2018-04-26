package grafos_p1;

/**
 * Arestas conectam vertices de acordo com seu peso de conexao, caso nao
 * especificado o peso sera zero. Arestas sao iguais quando destino e origem sao
 * iguais; a regra nao eh comutativa.
 */
public interface Edge<T> {

	void setFrom(Vertex<T> vertex);

	Vertex<T> getFrom();

	void setTo(Vertex<T> vertex);

	Vertex<T> getTo();

	void setWeight(T weight);

	T getWeight();

}
