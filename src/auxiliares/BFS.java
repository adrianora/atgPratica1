package auxiliares;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import graph.p1.Edge;
import graph.p1.Vertex;

public class BFS<T> {

	private List<Vertex<T>> vertices;
	int matriz[][];
	int size;

	public BFS(List<Vertex<T>> newVertices) {

		this.vertices = newVertices;
		size = this.vertices.size();
		matriz = new int[size][2];
	}

	public int[][] getMatriz() {

		return this.matriz;
	}

	public String printGeneratingTree() {

		String result = "";

		for (int i = 0; i < this.size; i++) {

			int father = this.matriz[i][0];
			int level = this.matriz[i][1];

			if (father == 0) {

				result += ((i + 1) + " - " + level + " -" + "\n");
			} else {

				result += ((i + 1) + " - " + level + " " + father + "\n");

			}
		}

		return result;
	}

	public void breadthSearch(Vertex<T> vertice) {
		Queue<Vertex<T>> queue = new LinkedList<Vertex<T>>();
		vertice.setTrueMark();
		queue.add(vertice);
		
		this.matriz[vertice.getData() - 1][0] = 0;
		this.matriz[vertice.getData() - 1][1] = 0;
		while (!queue.isEmpty()) {

			Vertex<T> auxiliar = queue.remove();
		
			List<Vertex<T>> adjacentes = adjacentes(auxiliar);
			
			for (Vertex<T> vertex : adjacentes) {
				if (!(vertex.isMarked())) {
					vertex.setTrueMark();
					queue.add(vertex);
					this.matriz[vertex.getData() - 1][0] = auxiliar.getData();
					this.matriz[vertex.getData() - 1][1] = (matriz[auxiliar.getData() - 1][1]) + 1;
				}
			}
		}
		System.out.println();
	}

	private List<Vertex<T>> adjacentes(Vertex<T> vertice) {
		List<Vertex<T>> adjacentes = new ArrayList<Vertex<T>>();

		for (Edge<T> edge : vertice.getEdges()) {
			adjacentes.add(edge.getTo());
		}

		return adjacentes;

	}

	private List<Vertex<T>> getVertices() {
		return this.vertices;
	}

}