package graph.p1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import graph.p1.exceptions.VertexDoesNotExistException;

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
	public boolean addEdge(Vertex<T> from, Vertex<T> to, double weight) {
		try {
			validateVertices(from, to);
			return addEdgeToVertex(from, to, weight);
		} catch (VertexDoesNotExistException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	private boolean addEdgeToVertex(Vertex<T> from, Vertex<T> to, double weight) {
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

		return result / 2;
	}

	@Override
	public double getMeanEdge() {
		double result = 0;

		for (int i = 0; i < this.vertices.size(); i++) {
			for (int j = 0; j < this.vertices.get(i).getEdges().size(); j++)
				result += this.vertices.get(i).getEdges().get(j).getWeight();
		}

		result = result / 2;

		return result / getEdgeNumber();
	}

	@Override
	public int[][] graphRepresentation(String type) {
		if (type.equals("AM"))
			return grapRepresentationAm();
		else if (type.equals("AL"))
			return grapRepresentationAl();
		else
			return null;
	}

	private int[][] grapRepresentationAm() {
		int size = vertices.size();
		int matrix[][] = new int[size][size];
		ArrayList<Vertex<T>> orderedArray = copyOrderedVerticesArray();

		buildingRelationships(orderedArray, matrix);
		printFirstLineOfVertices(orderedArray);
		printColumnsOfVertices(orderedArray, matrix);

		return matrix;
	}

	private void buildingRelationships(ArrayList<Vertex<T>> array, int[][] matrix) {
		for (int i = 0; i < array.size(); i++) {
			for (int j = 0; j < array.size(); j++) {
				if (array.get(i).haveVertex(array.get(j)))
					matrix[i][j] += 1;
				else
					matrix[i][j] = 0;
			}
		}
	}

	private void printFirstLineOfVertices(ArrayList<Vertex<T>> array) {
		System.out.print(" ");
		for (int i = 0; i < array.size(); i++)
			System.out.print(" " + array.get(i).getData());
		System.out.println();
	}

	private void printColumnsOfVertices(ArrayList<Vertex<T>> array, int[][] matrix) {
		for (int i = 0; i < array.size(); i++) {
			System.out.print(i + 1);
			for (int j = 0; j < array.size(); j++)
				System.out.print(" " + matrix[i][j]);
			System.out.println();
		}
	}

	private ArrayList<Vertex<T>> copyOrderedVerticesArray() {
		ArrayList<Vertex<T>> newArray = new ArrayList<>();
		newArray.addAll(this.vertices);
		Collections.sort(newArray);
		return newArray;
	}

	private int[][] grapRepresentationAl() {
		int size = vertices.size();
		int matrix[][] = new int[size][size];
		ArrayList<Vertex<T>> array = copyOrderedVerticesArray();

		buildingConnections(array, matrix);
		edgesOrdered(array);
		printAdjacencyList(array, matrix);

		return matrix;
	}

	private void buildingConnections(ArrayList<Vertex<T>> array, int[][] matrix) {
		for (int i = 0; i < array.size(); i++) {
			for (int j = 0; j < array.get(i).getEdges().size(); j++)
				matrix[i][j] = array.get(i).getEdges().get(j).getTo().getData();
		}
	}

	private void edgesOrdered(ArrayList<Vertex<T>> array) {
		for (int i = 0; i < array.size(); i++) {
			for (int j = 0; j < array.get(i).getEdges().size(); j++)
				Collections.sort(array.get(i).getEdges());
		}
	}

	private void printAdjacencyList(ArrayList<Vertex<T>> array, int[][] matrix) {
		for (int i = 0; i < array.size(); i++) {
			System.out.print(array.get(i).getData() + " -");
			for (int j = 0; j < array.get(i).getEdges().size(); j++) {
				matrix[i][j] = array.get(i).getEdges().get(j).getTo().getData();
				System.out.print(" " + matrix[i][j]);
			}
			System.out.println();
		}
		System.out.println();
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
	public String shortestPath(Vertex<T> from, Vertex<T> to) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private void cleanAllMarks() {
		for (int i = 0; i < this.vertices.size(); i++) {
			this.vertices.get(i).setFalseMark();;
		}
	}

	@Override
	public String mst(String graph) {
		// TODO Auto-generated method stub
		return null;
	}

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

				Integer data1 = Integer.parseInt(lineArray[0]);
				Integer data2 = Integer.parseInt(lineArray[1]);

				Vertex<T> vertex1 = getVertex(data1, this.getVertices());
				Vertex<T> vertex2 = getVertex(data2, this.getVertices());

				if (vertex1 == null) {
					vertex1 = new VertexImpl();
					vertex1.setData(data1);
				}
				if (vertex2 == null) {
					vertex2 = new VertexImpl();
					vertex2.setData(data2);
				}

				Edge<T> edge = new EdgeImpl<>();

				if (!this.getVertices().contains(vertex1)) {
					this.getVertices().add(vertex1);
				}
				if (!this.getVertices().contains(vertex2)) {
					this.getVertices().add(vertex2);
				}

				if (temPeso) {
					T weight = (T) lineArray[2];
					double weightFloat = Double.parseDouble((String) weight);
					this.addEdge(vertex1, vertex2, weightFloat);
				} else {

					this.addEdge(vertex1, vertex2, 0);
				}

			}

			line = buffRead.readLine();
			cont++;
		}
		file.close();

	}

	private Vertex<T> getVertex(Integer data, List<Vertex<T>> vertexs) {
		for (Vertex<T> vertex : vertexs) {
			if (vertex.getData() == data) {
				return vertex;
			}
		}
		return null;
	}

}
