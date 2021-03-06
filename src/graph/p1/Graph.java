package graph.p1;

import java.io.IOException;
import java.util.List;

/**
 * A estrutura gerencia a conexao e integridade entre vertices e arestas. Por
 * ser um grafo nao-orientado nao teremos vertice raiz. Arestas carregam consigo
 * o atributo de peso.
 * 
 * O controle de vertices e arestas sera dado por duas listas: uma de vertices e
 * outra de arestas. Para preservar a integridade, todas as arestas sao
 * adicionadas na respectiva lista antes de conectarem os vertices.
 */
public interface Graph<T> {

	boolean addVertex(Vertex<T> vertex);

	int getVertexNumber();

	boolean addEdge(Vertex<T> from, Vertex<T> to, double weight);

	int getEdgeNumber();

	List<Vertex<T>> getVertices();

	/**
	 * @return grau medio
	 */
	double getMeanEdge();

	/**
	 * Representacao de grafos. A biblioteca deve ser capaz de representar grafos
	 * utilizando tanto uma matriz de adjacencia (type = 'AM'), quanto uma lista de
	 * adjacencia (type = 'AL'). O usuario podera escolher a representacao a ser
	 * utilizada.
	 * 
	 * @param graph
	 * @param type
	 * @return
	 */
	double[][] graphRepresentation(String type);

	/**
	 * Busca em grafos: largura e profundidade. A biblioteca deve ser capaz de
	 * percorrer o grafo utilizando busca em largura e busca em profundidade. O
	 * vertice inicial sera fornecido pelo usuario da biblioteca. A respectiva
	 * arvore de busca deve ser gerada assim como o nivel de cada vertice na arvore
	 * (nivel da raiz eh zero). Para descrever a arvore gerada, basta informar o pai
	 * de cada vertice e seu nivel na String de saida.
	 * 
	 * @param graph
	 * @param vertice
	 * @return
	 */
	String BFS(String graph, Integer vertice);

	/**
	 * Busca em grafos: largura e profundidade. A biblioteca deve ser capaz de
	 * percorrer o grafo utilizando busca em largura e busca em profundidade. O
	 * vertice inicial sera fornecido pelo usuario da biblioteca. A respectiva
	 * arvore de busca deve ser gerada assim como o nivel de cada vertice na arvore
	 * (nivel da raiz eh zero). Para descrever a arvore gerada, basta informar o pai
	 * de cada vertice e seu nivel na String de saida.
	 * 
	 * @param graph
	 * @param vertice
	 * @return
	 */
	String DFS(String graph, Integer vertice);

	/**
	 * Componentes fortemente conectados. A biblioteca deve ser capaz descobrir os
	 * componentes fortemente conexos de um grafo. Saida: cada linha contem a lista
	 * de vertices pertencentes a um componente. Os componentes devem estar listados
	 * em ordem decrescente de tamanho (listar primeiro o componente com o maior
	 * numero de vertices, etc).
	 * 
	 * @param graph
	 * @return
	 */
	boolean SCC(String graph);

	/**
	 * Caminho minimo. A biblioteca deve ser capaz de encontrar o caminho mais curto
	 * entre dois vertices.
	 * 
	 * @param v1
	 * @param v2
	 * @return
	 */
	String shortestPath(Vertex<T> from, Vertex<T> to);

	/**
	 * Arvore geradora minima. A biblioteca deve ser capaz de encontrar uma arvore
	 * geradora minima de um grafo. Voce deve escolher um algoritmo apropriado para
	 * este problema. Para descrever a arvore gerada, basta informar o pai de cada
	 * vertice e seu nivel na String de saida (semelhante ao metodo BFS(graph, v)).
	 */
	String mst(String graph);
	
	/**
	 * A biblioteca deve ler um grafo a partir de um arquivo de texto. O grafo sera
	 * descrito segundo o seguinte formato: a primeira linha informa o numero de
	 * vertices do grafo. Cada linha subsequente informa as arestas do mesmo.
	 * 
	 * @throws IOException
	 */
	void readGraph(String path) throws IOException;

	/**
	 * Grafos com pesos. A biblioteca deve ser capaz de representar e manipular
	 * grafos nao-direcionados que possuam pesos nas arestas. Os pesos, que serao
	 * representados por valores reais, devem estar associados as arestas. O arquivo
	 * de entrada agora tera uma terceira coluna, que representa o peso da aresta.
	 * 
	 * @throws IOException
	 */
	void readWeightedGraph(String path) throws IOException;

}
