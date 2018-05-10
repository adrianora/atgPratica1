package grafos_p1;

import java.util.ArrayList;
import java.util.List;

public class VertexImpl<T extends Comparable<T>> implements Vertex<T>, Comparable<VertexImpl<T>>{

	private T data;

	private List<Edge<T>> edges;

	public VertexImpl() {
		this.edges = new ArrayList<>();
	}

	@Override
	public T getData() {
		return this.data;
	}

	@Override
	public void setData(T data) {
		this.data = data;
	}
	
	public List<Edge<T>> getEdges(){
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
	public boolean isEmpty() {
		return this.edges.isEmpty();
	}

	@Override
	public int getNumberOfEdges() {
		return this.edges.size();
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VertexImpl<T> other = (VertexImpl<T>) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		return true;
	}
	
	/** CompareTo vai ser usado para o metodo grapRepresentation, o qual organiza
	 * os vertices em ordem crscente
	 */
	@Override
	public int compareTo(VertexImpl<T> otherVertex) {
	
		return this.data.compareTo(otherVertex.getData());		
	}
}
