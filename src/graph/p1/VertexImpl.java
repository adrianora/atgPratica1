package graph.p1;

import java.util.ArrayList;
import java.util.List;

public class VertexImpl<T> implements Vertex<T> {
	
	private Integer data;

	private boolean mark;

	private List<Edge<T>> edges;

	public VertexImpl() {
		this.edges = new ArrayList<>();
	}

	@Override
	public boolean isMarked() {
		if (mark)
			return true;
		else
			return false;
	}

	@Override
	public void setTrueMark() {
		this.mark = true;
	}
	
	@Override
	public void setFalseMark() {
		this.mark = false;
	}

	@Override
	public int getData() {
		return this.data;
	}

	@Override
	public void setData(int data) {
		this.data = data;
	}

	public List<Edge<T>> getEdges() {
		return this.edges;
	}

	@Override
	public boolean addEdge(Edge<T> edge) {
		return this.edges.add(edge);
	}

	@Override
	public boolean removeEdge(Edge<T> edge) {
		return this.edges.remove(edge);
	}

	@Override
	public boolean hasEdge(Edge<T> edge) {
		return this.edges.contains(edge);
	}

	@Override
	public boolean haveVertex(Vertex<T> vertex) {
		for (int i = 0; i < getEdges().size(); i++) {
			if (getEdges().get(i).getTo().equals(vertex))
				return true;
		}
		return false;
	}

	@Override
	public boolean isEmpty() {
		return this.edges.isEmpty();
	}

	@Override
	public int getNumberOfEdges() {
		return this.edges.size();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VertexImpl other = (VertexImpl) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		return true;
	}

	/**
	 * CompareTo vai ser usado para o metodo grapRepresentation, o qual organiza os
	 * vertices em ordem crscente
	 */
	@Override
	public int compareTo(Vertex<T> otherVertex) {
		if (getData() > otherVertex.getData())
			return 1;
		else if (getData() < otherVertex.getData())
			return -1;
		else
			return 0;
	}
	
}
