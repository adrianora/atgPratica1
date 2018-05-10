package grafos_p1;

import java.io.IOException;
import java.util.List;
import java.io.FileReader;
import java.io.BufferedReader;

public class GraphBuilderImpl<T> extends GraphImpl<T> implements GraphBuilder<T> {

	@Override
	public void readGraph(String path) throws IOException {
		this.reader(path, false);
	}

	@Override
	public void readWeightedGraph(String path) throws IOException {
		this.reader(path, true);
	}

	private void reader(String path, boolean temPeso) throws IOException {

		FileReader file = new FileReader(path);
		BufferedReader buffRead = new BufferedReader(file);
		String line = buffRead.readLine();

		int cont = 1;

		while (line != null) {

			if (cont != 1) {

				String[] lineArray = line.split(" ");

				T data1 = (T) lineArray[0];
				T data2 = (T) lineArray[1];

				Vertex<T> vertex1 = getVertex(data1, this.getVertices());
				Vertex<T> vertex2 = getVertex(data2, this.getVertices());

				if (vertex1 == null) {

					vertex1 = new VertexImpl<>();
					vertex1.setData(data1);
				}
				if (vertex2 == null) {

					vertex2 = new VertexImpl<>();
					vertex2.setData(data2);
				}

				Edge<T> edge = new EdgeImpl<>();

				edge.setTo(vertex2);

				if (temPeso) {

					T weight = (T) lineArray[2];
					float weightFloat = Float.parseFloat((String)weight);
					edge.setWeight(weightFloat);
				}
				vertex1.addEdge(edge);

				if (!this.getVertices().contains(vertex1)) {
					this.getVertices().add(vertex1);
				}
				if (!this.getVertices().contains(vertex2)) {
					this.getVertices().add(vertex2);
				}
			}

			line = buffRead.readLine();
			cont++;
		}
		file.close();

	}

	private Vertex<T> getVertex(T data, List<Vertex<T>> vertexs) {

		for (Vertex<T> vertex : vertexs) {

			if (vertex.getData() != null) {

				if (vertex.getData().equals(data)) {

					return vertex;
				}
			}
		}
		return null;
	}

}
