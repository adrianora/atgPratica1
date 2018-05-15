package tests;

import org.junit.Before;
import org.junit.Test;

import graph.p1.Graph;
import graph.p1.GraphImpl;
import graph.p1.Vertex;
import graph.p1.VertexImpl;

import static org.junit.Assert.*;

import java.io.IOException;

public class GraphTest<T> {

	Graph<Integer> graph;
	Graph<Integer> graphEmpty;

	@Before
	public void setUp() throws IOException {
		defaultConstructors();
		buildNewGraphTest();
	}

	private void defaultConstructors() {
		graph = new GraphImpl<>();
		graphEmpty = new GraphImpl<>();
	}
	
	@Test
	public void vertexInsertTest() {
		Vertex<Integer> newVertex = new VertexImpl<>();
		newVertex.setData(1);
		this.graphEmpty.addVertex(newVertex);
		
		assertEquals(1, this.graphEmpty.getVertices().size(), 0);
		assertEquals(1, this.graphEmpty.getVertexNumber(), 0);
		assertEquals(newVertex, this.graphEmpty.getVertices().get(0));
		assertEquals(newVertex.getData(), this.graphEmpty.getVertices().get(0).getData());
		
		newVertex.setData(2);
		this.graphEmpty.addVertex(newVertex);
		
		assertEquals(2, this.graphEmpty.getVertices().size(), 0);
		assertEquals(2, this.graphEmpty.getVertexNumber(), 0);
		assertEquals(newVertex, this.graphEmpty.getVertices().get(1));
		assertEquals(newVertex.getData(), this.graphEmpty.getVertices().get(1).getData());
	}
	
	@Test
	public void isEmptyTest() {
		assertEquals(0, this.graphEmpty.getVertices().size(), 0);
	}
	
	private void buildNewGraphTest() {
		addVertices();
		addEdges();
	}
	
	private void addVertices() {
		for (int i = 0; i < 5; i++) {
			Vertex<Integer> dummyVertex = new VertexImpl<>();
			dummyVertex.setData(i + 1);
			this.graph.addVertex(dummyVertex);
		}
		
		assertEquals(5, this.graph.getVertexNumber(), 0);
	}
	
	private void addEdges() {
		// edge 1 -> 2 weight 0.1
		addSingleEdge(this.graph.getVertices().get(0), this.graph.getVertices().get(1), 0.1);
		// edge 1 -> 5 weight 1
		addSingleEdge(this.graph.getVertices().get(0), this.graph.getVertices().get(4), 1);
		// edge 2 -> 5 weight 0.2
		addSingleEdge(this.graph.getVertices().get(1), this.graph.getVertices().get(4), 0.2);
		// edge 3 -> 5 weight 5
		addSingleEdge(this.graph.getVertices().get(2), this.graph.getVertices().get(4), 5);
		// edge 4 -> 5 weight 2.3
		addSingleEdge(this.graph.getVertices().get(2), this.graph.getVertices().get(4), 2.3);
		
		assertEquals(5, this.graph.getEdgeNumber(), 0);
		assertEquals(1.72, this.graph.getMeanEdge(), 0);
	}
	
	private void addSingleEdge(Vertex<Integer> fromVertex, Vertex<Integer> toVertex, double weight) {
		this.graph.addEdge(fromVertex, toVertex, weight);
	}
	
	@Test
	public void vertexExceptionTest() {
		Vertex<Integer> toVertex = new VertexImpl<>();
		toVertex.setData(-1);
		addSingleEdge(this.graph.getVertices().get(0), toVertex, 0);
		
		assertEquals(5, this.graph.getEdgeNumber(), 0);
	}
	
}