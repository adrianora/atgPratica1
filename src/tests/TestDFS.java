package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import auxiliares.DSF;
import graph.p1.DFS;
import graph.p1.Graph;
import graph.p1.GraphImpl;
import graph.p1.Vertex;

public class TestDFS<T> {
	
	Graph<Integer> graph;
	DSF dsf;
	Vertex<T> root;
	
	String path = "src/tests/entradaText.txt";

	
	@Before
	public void setUp() throws IOException {
		defaultConstructors();
		graph.readWeightedGraph(path);
		dsf = new DSF(graph.getVertices());
		
		root = (Vertex<T>) this.graph.getVertices().get(0);
		this.dsf.depthSearch(root);
	}

	private void defaultConstructors() {
		graph = new GraphImpl<>();
	}
	
	@Test
	public void testFather() {
		
		int matriz[][] = this.dsf.getMatriz();
		
		assertEquals(0, matriz[0][0]);
		assertEquals(1, matriz[1][0]);
		assertEquals(5, matriz[2][0]);
		assertEquals(5, matriz[3][0]);
		assertEquals(2, matriz[4][0]);
	}
	
	@Test
	public void testLevel() {
		
		int matriz[][] = this.dsf.getMatriz();
		
		assertEquals(0, matriz[0][1]);
		assertEquals(1, matriz[1][1]);
		assertEquals(3, matriz[2][1]);
		assertEquals(3, matriz[3][1]);
		assertEquals(2, matriz[4][1]);
	}
	
	@Test
	public void generatingTreeRepresentation() {
		
		this.dsf.printGeneratingTree();
	}
}
