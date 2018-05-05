package grafos_p1;

public class EdgeImpl<T> implements Edge<T> {

	private Vertex<T> from;

	private Vertex<T> to;

	private T weight;

	@Override
	public void setFrom(Vertex<T> vertex) {
		
		this.from = vertex;
	}

	@Override
	public Vertex<T> getFrom() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setTo(Vertex<T> vertex) {
		
		this.to = vertex;
	}

	@Override
	public Vertex<T> getTo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setWeight(T weight) {
		
		this.weight = weight;
	}

	@Override
	public T getWeight() {
		// TODO Auto-generated method stub
		return null;
	}

}
