package grafos_p1;

public class EdgeImpl<T> implements Edge<T> {

	private Vertex<T> to;

	private float weight;

	public EdgeImpl() {
	}

	public EdgeImpl(Vertex<T> to, float weight) {
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
	public void setWeight(float weight) {
		this.weight = weight;
	}

	@Override
	public float getWeight() {
		return this.weight;
	}

}
