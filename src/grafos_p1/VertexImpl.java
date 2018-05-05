package grafos_p1;

import java.util.ArrayList;
import java.util.List;

public class VertexImpl<T> implements Vertex<T> {

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

	@Override
	public boolean addEdge(Edge<T> edge) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeEdge(Edge<T> edge) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasEdge(Edge<T> edge) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Vertex<T> getVertex(int indexEdge) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

}
