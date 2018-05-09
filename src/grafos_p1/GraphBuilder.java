package grafos_p1;

import java.io.IOException;

/**
 * O GraphBuilder sera tratado como um tipo especifico de grafo, mais robusto
 * que consegue fazer leitura de grafos a partir de arquivos de texto.
 */
public interface GraphBuilder<T> extends Graph<T> {

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
