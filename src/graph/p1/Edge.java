package graph.p1;

/**
 * Arestas conectam vertices de acordo com seu peso de conexao, caso nao
 * especificado o peso sera zero. Arestas sao iguais quando destino e origem sao
 * iguais; a regra nao eh comutativa.
 */
public interface Edge<T> extends Comparable<Edge<T>> {

	void setTo(Vertex<T> vertex);

	Vertex<T> getTo();

	void setWeight(double weight);

	double getWeight();

}
