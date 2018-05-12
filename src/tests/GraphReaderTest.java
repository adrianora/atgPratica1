package tests;

import org.junit.Before;
import org.junit.Test;

import graph.p1.Graph;
import graph.p1.GraphImpl;

import static org.junit.Assert.*;

import java.io.IOException;

public class GraphReaderTest<T> {

	Graph<Integer> reader;

	String path = "src/tests/entradaText.txt";

	@Before
	public void setUp() throws IOException {
		defaultConstructors();
		reader.readWeightedGraph(path);
	}

	private void defaultConstructors() {
		reader = new GraphImpl<>();
	}

	@Test
	public void verticesNumberTest() {
		assertEquals(this.reader.getVertexNumber(), 5);
	}
	
	@Test
	public void verticesDoubleBondTest() {
		assertEquals(1, reader.getVertices().get(0).getData(), 0);
		assertEquals(2, reader.getVertices().get(1).getData(), 0);
		assertEquals(5, reader.getVertices().get(2).getData(), 0);
		assertEquals(3, reader.getVertices().get(3).getData(), 0);
		assertEquals(4, reader.getVertices().get(4).getData(), 0);
	}
	
	@Test
	public void edgeWeightTest() {
		// edge 1 = {2,5}
		assertEquals(0.1, reader.getVertices().get(0).getEdges().get(0).getWeight(), 0);
		assertEquals(1, reader.getVertices().get(0).getEdges().get(1).getWeight(), 0);
		// edge 2 = {1,2}
		assertEquals(0.1, reader.getVertices().get(1).getEdges().get(0).getWeight(), 0);
		assertEquals(0.2, reader.getVertices().get(1).getEdges().get(1).getWeight(), 0);
		// edge 5 = {2,3,4,1}
		assertEquals(0.2, reader.getVertices().get(2).getEdges().get(0).getWeight(), 0);
		assertEquals(5, reader.getVertices().get(2).getEdges().get(1).getWeight(), 0);
		assertEquals(2.3, reader.getVertices().get(2).getEdges().get(2).getWeight(), 0);
		assertEquals(1, reader.getVertices().get(2).getEdges().get(3).getWeight(), 0);
		// edge 3 = {5}
		assertEquals(5, reader.getVertices().get(3).getEdges().get(0).getWeight(), 0);
		// edge 4 = {2,3,4,1}
		assertEquals(2.3, reader.getVertices().get(4).getEdges().get(0).getWeight(), 0);
	}
	
	@Test
	public void graphRepresentationTest() {		
		this.reader.graphRepresentation("AM");
		System.out.println();
		this.reader.graphRepresentation("AL");
	}
	
}