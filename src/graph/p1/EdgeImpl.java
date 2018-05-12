package graph.p1;

public class EdgeImpl<T> implements Edge<T> {

	private Vertex<T> to;

	private double weight;

	public EdgeImpl() {
	}

	public EdgeImpl(Vertex<T> to, double weight) {
		this.to = to;
		this.weight = weight;
	}

	@Override
	public void setTo(Vertex<T> vertex) {
		this.to = vertex;
	}

	@Override
	public Vertex<T> getTo() {
		return this.to;
	}

	@Override
	public void setWeight(double weight) {
		this.weight = weight;
	}

	@Override
	public double getWeight() {
		return this.weight;
	}

	@Override
	public int compareTo(Edge<T> edgeToCompare) {
		if (to.getData() > edgeToCompare.getTo().getData())
			return 1;
		if (to.getData() < edgeToCompare.getTo().getData())
			return -1;
		else
			return 0;
	}

}
